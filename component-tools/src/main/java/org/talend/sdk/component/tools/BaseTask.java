/**
 * Copyright (C) 2006-2019 Talend Inc. - www.talend.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.talend.sdk.component.tools;

import static java.util.Optional.ofNullable;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.xbean.finder.AnnotationFinder;
import org.apache.xbean.finder.archive.Archive;
import org.apache.xbean.finder.archive.ClasspathArchive;
import org.apache.xbean.finder.archive.CompositeArchive;
import org.talend.sdk.component.api.component.Components;
import org.talend.sdk.component.api.input.Emitter;
import org.talend.sdk.component.api.input.PartitionMapper;
import org.talend.sdk.component.api.processor.Processor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
abstract class BaseTask implements Runnable {

    protected final File[] classes;

    protected Component asComponent(final Annotation a) {
        return Component.class
                .cast(Proxy
                        .newProxyInstance(Thread.currentThread().getContextClassLoader(),
                                new Class<?>[] { Component.class },
                                (proxy, method, args) -> a.annotationType().getMethod(method.getName()).invoke(a)));
    }

    protected Stream<Class<? extends Annotation>> componentMarkers() {
        return Stream.of(PartitionMapper.class, Processor.class, Emitter.class);
    }

    protected AnnotationFinder newFinder() {
        return new AnnotationFinder(new CompositeArchive(Stream.of(classes).map(c -> {
            try {
                return ClasspathArchive.archive(Thread.currentThread().getContextClassLoader(), c.toURI().toURL());
            } catch (final MalformedURLException e) {
                throw new IllegalArgumentException(e);
            }
        }).toArray(Archive[]::new))) {

            private final Map<Class<?>, List<Field>> fieldCache = new HashMap<>();

            private final Map<Class<?>, List<Class<?>>> classCache = new HashMap<>();

            @Override
            public List<Field> findAnnotatedFields(final Class<? extends Annotation> annotation) {
                return fieldCache.computeIfAbsent(annotation, a -> super.findAnnotatedFields(annotation));
            }

            @Override
            public List<Class<?>> findAnnotatedClasses(final Class<? extends Annotation> annotation) {
                return classCache.computeIfAbsent(annotation, a -> super.findAnnotatedClasses(annotation));
            }
        };
    }

    protected Optional<Component> components(final Class<?> component) {
        return componentMarkers()
                .map(component::getAnnotation)
                .filter(Objects::nonNull)
                .findFirst()
                .map(this::asComponent);
    }

    protected String findFamily(final Component c, final Class<?> pckMarker) {
        return ofNullable(c)
                .map(Component::family)
                .filter(name -> !name.isEmpty())
                .orElseGet(() -> findPackageOrFail(pckMarker, apiTester(Components.class), Components.class.getName())
                        .getAnnotation(Components.class)
                        .family());
    }

    protected Predicate<Class<?>> apiTester(final Class<? extends Annotation> api) {
        return a -> a.isAnnotationPresent(api);
    }

    protected Class<?> findPackageOrFail(final Class<?> component, final Predicate<Class<?>> tester, final String api) {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final String pck = component.getPackage() == null ? null : component.getPackage().getName();
        if (pck != null) {
            String currentPackage = pck;
            do {
                try {
                    final Class<?> pckInfo = loader.loadClass(currentPackage + ".package-info");
                    if (tester.test(pckInfo)) {
                        return pckInfo;
                    }
                } catch (final ClassNotFoundException e) {
                    // no-op
                }

                final int endPreviousPackage = currentPackage.lastIndexOf('.');
                if (endPreviousPackage < 0) { // we don't accept default package since it is not specific enough
                    break;
                }

                currentPackage = currentPackage.substring(0, endPreviousPackage);
            } while (true);
        }
        throw new IllegalArgumentException("No @" + api + " for the component " + component
                + ", add it in package-info.java or disable this validation"
                + " (which can have side effects in integrations/designers)");
    }

    protected ResourceBundle findResourceBundle(final Class<?> component) {
        final String baseName = ofNullable(component.getPackage()).map(p -> p.getName() + ".").orElse("") + "Messages";
        try {
            return ResourceBundle.getBundle(baseName, getLocale(), Thread.currentThread().getContextClassLoader());
        } catch (final MissingResourceException mre) {
            return null;
        }
    }

    protected Locale getLocale() {
        return Locale.ROOT;
    }

    public interface Component {

        String family();

        String name();
    }
}
