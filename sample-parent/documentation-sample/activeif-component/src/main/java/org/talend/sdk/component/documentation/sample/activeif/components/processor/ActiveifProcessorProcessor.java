/**
 * Copyright (C) 2006-2020 Talend Inc. - www.talend.com
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
package org.talend.sdk.component.documentation.sample.activeif.components.processor;

import java.io.Serializable;

import org.talend.sdk.component.api.component.Icon;
import org.talend.sdk.component.api.component.Version;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.meta.Documentation;
import org.talend.sdk.component.api.processor.ElementListener;
import org.talend.sdk.component.api.processor.Input;
import org.talend.sdk.component.api.processor.Output;
import org.talend.sdk.component.api.processor.OutputEmitter;
import org.talend.sdk.component.api.processor.Processor;
import org.talend.sdk.component.api.record.Record;

@Version
@Icon(Icon.IconType.STAR)
@Processor(name = "activeifProcessor")
@Documentation("TODO fill the documentation for this processor")
public class ActiveifProcessorProcessor implements Serializable {

    private final ActiveifProcessorProcessorConfiguration configuration;

    public ActiveifProcessorProcessor(
            @Option("configuration") final ActiveifProcessorProcessorConfiguration configuration) {
        this.configuration = configuration;
    }

    @ElementListener
    public void onNext(@Input final Record defaultInput, @Output final OutputEmitter<Record> defaultOutput) {
        // no-op
    }
}