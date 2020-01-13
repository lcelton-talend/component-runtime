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
package org.talend.sdk.component.api.component;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.sdk.component.api.meta.Documentation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Documentation("Associate an icon to a component, "
        + "only supported on components - `@PartitionMapper`, `@Processor`, `@Emitter` - and "
        + "configurations - `@DataStore` and `@DataSet` - classes.")
@Target({ TYPE, PACKAGE, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface Icon {

    /**
     * @return the icon to associate to the component.
     */
    IconType value() default IconType.CUSTOM;

    /**
     * @return the custom icon key (not in {@link IconType}) to use if {@link Icon#value()} is {@link IconType#CUSTOM}.
     */
    String custom() default "";

    /**
     * Icons from http://talend.surge.sh/icons/.
     * It is recommended for custom components to use vendor specific icons and not reuse Talend built-in icons.
     */
    @RequiredArgsConstructor
    enum IconType {
        @Deprecated
        ACTIVEMQ("activemq"),
        @Deprecated
        ACTIVITY("activity"),
        @Deprecated
        AGGREGATE("aggregate"),
        @Deprecated
        APACHE("apache"),
        @Deprecated
        API_DESIGNER_COLORED("api-designer-colored"),
        @Deprecated
        API_DESIGNER_NEGATIVE("api-designer-negative"),
        @Deprecated
        API_DESIGNER_POSITIVE("api-designer-positive"),
        @Deprecated
        API_TESTER_COLORED("api-tester-colored"),
        @Deprecated
        API_TESTER_NEGATIVE("api-tester-negative"),
        @Deprecated
        API_TESTER_POSITIVE("api-tester-positive"),
        @Deprecated
        ARROW_LEFT("arrow-left"),
        @Deprecated
        ARROW_RIGHT("arrow-right"),
        @Deprecated
        AWS_KINESIS("aws-kinesis"),
        @Deprecated
        AZURE_EVENT_HUBS("azure-event-hubs"),
        @Deprecated
        BADGE("badge"),
        @Deprecated
        BADGE_OUTLINE("badge-outline"),
        @Deprecated
        BEAM("beam"),
        @Deprecated
        BELL("bell"),
        @Deprecated
        BELL_NOTIFICATION("bell-notification"),
        @Deprecated
        BIGQUERY("bigquery"),
        @Deprecated
        BLOCK("block"),
        @Deprecated
        BOARD("board"),
        @Deprecated
        BUBBLES("bubbles"),
        @Deprecated
        BURGER("burger"),
        @Deprecated
        CALENDAR_MOVE("calendar-move"),
        @Deprecated
        CAMPAIGNS("campaigns"),
        @Deprecated
        CARET_DOWN("caret-down"),
        @Deprecated
        CARRIAGE_RETURN("carriage-return"),
        @Deprecated
        CASSANDRA("cassandra"),
        @Deprecated
        CHAIN("chain"),
        @Deprecated
        CHARACTER("character"),
        @Deprecated
        CHARTS("charts"),
        @Deprecated
        CHECK("check"),
        @Deprecated
        CHECK_CIRCLE("check-circle"),
        @Deprecated
        CHECK_PLUS("check-plus"),
        @Deprecated
        CHEVRON_END("chevron-end"),
        @Deprecated
        CHEVRON_LEFT("chevron-left"),
        @Deprecated
        CLOCK("clock"),
        @Deprecated
        CLOUD_ENGINE("cloud-engine"),
        @Deprecated
        CLOUD_UPGRADE("cloud-upgrade"),
        @Deprecated
        CLUSTER("cluster"),
        @Deprecated
        COG("cog"),
        @Deprecated
        COLUMN_CHOOSER("column-chooser"),
        @Deprecated
        COMPONENT_KIT_NEGATIVE("component-kit-negative"),
        @Deprecated
        COMPONENT_KIT_POSITIVE("component-kit-positive"),
        @Deprecated
        COMPONENT_NEGATIVE("component-negative"),
        @Deprecated
        COMPONENT_POSITIVE("component-positive"),
        @Deprecated
        CONNECTIONS("connections"),
        @Deprecated
        CONTAINS("contains"),
        @Deprecated
        COUCHBASE("couchbase"),
        @Deprecated
        CREDITS_ENGINE("credits-engine"),
        @Deprecated
        CROSS("cross"),
        @Deprecated
        CROSSHAIRS("crosshairs"),
        @Deprecated
        DATAGRID("datagrid"),
        @Deprecated
        DATAPREP("dataprep"),
        @Deprecated
        DATASETS("datasets"),
        @Deprecated
        DATASTORE("datastore"),
        @Deprecated
        DATASTREAMS_COLORED("datastreams-colored"),
        @Deprecated
        DATASTREAMS_NEGATIVE("datastreams-negative"),
        @Deprecated
        DATASTREAMS_POSITIVE("datastreams-positive"),
        @Deprecated
        DATA_FABRIC_COLORED("data-fabric-colored"),
        @Deprecated
        DATA_MODELS("data-models"),
        @Deprecated
        DB_INPUT("db-input"),
        @Deprecated
        DOWNLOAD("download"),
        @Deprecated
        DRAG("drag"),
        @Deprecated
        DRAG_AND_DROP("drag-and-drop"),
        @Deprecated
        DROPPER("dropper"),
        @Deprecated
        ELASTIC("elastic"),
        @Deprecated
        ELLIPSIS("ellipsis"),
        @Deprecated
        EMPTY_CALENDAR("empty-calendar"),
        @Deprecated
        EMPTY_CELL("empty-cell"),
        @Deprecated
        EMPTY_CHAR("empty-char"),
        @Deprecated
        EMPTY_SPACE("empty-space"),
        @Deprecated
        ENVIRONMENT("environment"),
        @Deprecated
        EQUAL("equal"),
        @Deprecated
        EXPANDED("expanded"),
        @Deprecated
        EXPORT_HISTORY("export-history"),
        @Deprecated
        EYE("eye"),
        @Deprecated
        EYE_SLASH("eye-slash"),
        @Deprecated
        FIELDGLASS("fieldglass"),
        @Deprecated
        FIELD_SELECTOR("field-selector"),
        @Deprecated
        FILES_O("files-o"),
        @Deprecated
        FILE_COG("file-cog"),
        @Deprecated
        FILE_COMPRESSED("file-compressed"),
        @Deprecated
        FILE_CONNECT_O("file-connect-o"),
        @Deprecated
        FILE_CSV_O("file-csv-o"),
        @Deprecated
        FILE_DATABASE_O("file-database-o"),
        @Deprecated
        FILE_HDFS_O("file-hdfs-o"),
        @Deprecated
        FILE_JOB_O("file-job-o"),
        @Deprecated
        FILE_JSON_O("file-json-o"),
        @Deprecated
        FILE_MOVE("file-move"),
        @Deprecated
        FILE_O("file-o"),
        @Deprecated
        FILE_S3_O("file-s3-o"),
        @Deprecated
        FILE_SALESFORCE("file-salesforce"),
        @Deprecated
        FILE_TXT_O("file-txt-o"),
        @Deprecated
        FILE_XLSX_O("file-xlsx-o"),
        @Deprecated
        FILE_XLS_O("file-xls-o"),
        @Deprecated
        FILE_XML_O("file-xml-o"),
        @Deprecated
        FILTER("filter"),
        @Deprecated
        FILTER_COLUMN("filter-column"),
        @Deprecated
        FILTER_ROW("filter-row"),
        @Deprecated
        FLINK("flink"),
        @Deprecated
        FLINK_O("flink-o"),
        @Deprecated
        FLOW("flow"),
        @Deprecated
        FLOW_O("flow-o"),
        @Deprecated
        FLOW_SOURCE_O("flow-source-o"),
        @Deprecated
        FLOW_STEP_O("flow-step-o"),
        @Deprecated
        FLOW_TARGET_O("flow-target-o"),
        @Deprecated
        FLOW_UNDER_PLAN("flow-under-plan"),
        @Deprecated
        FLOW_UNFINISHED("flow-unfinished"),
        @Deprecated
        FOLDER("folder"),
        @Deprecated
        FOLDER_CLOSED("folder-closed"),
        @Deprecated
        FOLDER_SHARED("folder-shared"),
        @Deprecated
        FOLDER_SHARED_OWNER("folder-shared-owner"),
        @Deprecated
        FOLDER_SHARED_USER("folder-shared-user"),
        @Deprecated
        FULLSCREEN("fullscreen"),
        @Deprecated
        GOOGLE_DATAFLOW("google-dataflow"),
        @Deprecated
        GROUP_CIRCLE("group-circle"),
        @Deprecated
        HADOOP("hadoop"),
        @Deprecated
        HAND_POINTER("hand-pointer"),
        @Deprecated
        HIERARCHICAL_VIEW("hierarchical-view"),
        @Deprecated
        HOME("home"),
        @Deprecated
        INFO_CIRCLE("info-circle"),
        @Deprecated
        JMS("jms"),
        @Deprecated
        KAFKA("kafka"),
        @Deprecated
        LAUNCH("launch"),
        @Deprecated
        LAUNCHER("launcher"),
        @Deprecated
        LESS_THAN("less-than"),
        @Deprecated
        LESS_THAN_EQUAL("less-than-equal"),
        @Deprecated
        LICENSE("license"),
        @Deprecated
        LINK("link"),
        @Deprecated
        LOCAL_STORAGE("local-storage"),
        @Deprecated
        LOCK("lock"),
        @Deprecated
        LOCKED("locked"),
        @Deprecated
        LOGO("logo"),
        @Deprecated
        LOGO_COLORED("logo-colored"),
        @Deprecated
        LOGO_SQUARE("logo-square"),
        @Deprecated
        MARKETO("marketo"),
        @Deprecated
        MDM_COLORED("mdm-colored"),
        @Deprecated
        MDM_NEGATIVE("mdm-negative"),
        @Deprecated
        MDM_POSITIVE("mdm-positive"),
        @Deprecated
        MINUS_CIRCLE("minus-circle"),
        @Deprecated
        MONGODB("mongodb"),
        @Deprecated
        MORE_THAN("more-than"),
        @Deprecated
        MORE_THAN_EQUAL("more-than-equal"),
        @Deprecated
        MOST_TRUSTED("most-trusted"),
        @Deprecated
        NETSUITE("netsuite"),
        @Deprecated
        NETWORK("network"),
        @Deprecated
        NORMALIZE("normalize"),
        @Deprecated
        NOTE("note"),
        @Deprecated
        NOT_EQUAL("not-equal"),
        @Deprecated
        OPENER("opener"),
        @Deprecated
        OVERVIEW("overview"),
        @Deprecated
        PANEL_OPENER_BOTTOM("panel-opener-bottom"),
        @Deprecated
        PANEL_OPENER_RIGHT("panel-opener-right"),
        @Deprecated
        PENCIL("pencil"),
        @Deprecated
        PHONE("phone"),
        @Deprecated
        PIE_CHARTS("pie-charts"),
        @Deprecated
        PIN("pin"),
        @Deprecated
        PLACEHOLDER("placeholder"),
        @Deprecated
        PLAY("play"),
        @Deprecated
        PLUS("plus"),
        @Deprecated
        PLUS_CIRCLE("plus-circle"),
        @Deprecated
        POSTGRESQL("postgresql"),
        @Deprecated
        POWER_OFF("power-off"),
        @Deprecated
        PROJECTS("projects"),
        @Deprecated
        PROMOTION_PIPELINES("promotion-pipelines"),
        @Deprecated
        PUBSUB("pubsub"),
        @Deprecated
        PYTHON("python"),
        @Deprecated
        QUESTION_CIRCLE("question-circle"),
        @Deprecated
        QUOTES("quotes"),
        @Deprecated
        RAW_DATA("raw-data"),
        @Deprecated
        REDO("redo"),
        @Deprecated
        REFRESH("refresh"),
        @Deprecated
        REMOTE_ENGINE("remote-engine"),
        @Deprecated
        REPLICATE("replicate"),
        @Deprecated
        REST("rest"),
        @Deprecated
        ROLES("roles"),
        @Deprecated
        SAMPLE("sample"),
        @Deprecated
        SCHEDULER("scheduler"),
        @Deprecated
        SEARCH("search"),
        @Deprecated
        SEMANTIC("semantic"),
        @Deprecated
        SEND("send"),
        @Deprecated
        SHARE_ALT("share-alt"),
        @Deprecated
        SHARING_DEFAULT("sharing-default"),
        @Deprecated
        SHARING_OWNER("sharing-owner"),
        @Deprecated
        SHARING_USER("sharing-user"),
        @Deprecated
        SHIELD("shield"),
        @Deprecated
        SHIELD_FULL("shield-full"),
        @Deprecated
        SHIELD_FULL_CHECK("shield-full-check"),
        @Deprecated
        SHOW_UNASSIGNED_TASKS("show_unassigned_tasks"),
        @Deprecated
        SLIDERS("sliders"),
        @Deprecated
        SMILEY_ANGRY("smiley-angry"),
        @Deprecated
        SMILEY_ENTHUSIAST("smiley-enthusiast"),
        @Deprecated
        SMILEY_NEUTRAL("smiley-neutral"),
        @Deprecated
        SMILEY_SATISFIED("smiley-satisfied"),
        @Deprecated
        SMILEY_SLEEP("smiley-sleep"),
        @Deprecated
        SMILEY_UNHAPPY("smiley-unhappy"),
        @Deprecated
        SORT("sort"),
        @Deprecated
        SORT_19("sort-19"),
        @Deprecated
        SORT_91("sort-91"),
        @Deprecated
        SORT_ASC("sort-asc"),
        @Deprecated
        SORT_AZ("sort-az"),
        @Deprecated
        SORT_DESC("sort-desc"),
        @Deprecated
        SORT_ZA("sort-za"),
        @Deprecated
        SPARK("spark"),

        STAR("star"), // used by the starter and not really vendor specific so ok to keep

        @Deprecated
        STOP("stop"),
        @Deprecated
        STREAMS("streams"),
        @Deprecated
        TABLE("table"),
        @Deprecated
        TAGS("tags"),
        @Deprecated
        TASKS("tasks"),
        @Deprecated
        TDC_COLORED("tdc-colored"),
        @Deprecated
        TDC_NEGATIVE("tdc-negative"),
        @Deprecated
        TDC_POSITIVE("tdc-positive"),
        @Deprecated
        TDP_COLORED("tdp-colored"),
        @Deprecated
        TDP_NEGATIVE("tdp-negative"),
        @Deprecated
        TDP_POSITIVE("tdp-positive"),
        @Deprecated
        TDS_COLORED("tds-colored"),
        @Deprecated
        TDS_NEGATIVE("tds-negative"),
        @Deprecated
        TDS_POSITIVE("tds-positive"),
        @Deprecated
        TIC_COLORED("tic-colored"),
        @Deprecated
        TIC_NEGATIVE("tic-negative"),
        @Deprecated
        TIC_POSITIVE("tic-positive"),
        @Deprecated
        TILES("tiles"),
        @Deprecated
        TMC_COLORED("tmc-colored"),
        @Deprecated
        TMC_NEGATIVE("tmc-negative"),
        @Deprecated
        TMC_POSITIVE("tmc-positive"),
        @Deprecated
        TRANSFORMER_WINDOW("transformer-window"),
        @Deprecated
        TRASH("trash"),
        @Deprecated
        TYPE_CONVERTER("type-converter"),
        @Deprecated
        UNDO("undo"),
        @Deprecated
        UNION("union"),
        @Deprecated
        UNLOCKED("unlocked"),
        @Deprecated
        UPLOAD("upload"),
        @Deprecated
        USER_CIRCLE("user-circle"),
        @Deprecated
        VERSIONING("versioning"),
        @Deprecated
        WARNING("warning"),
        @Deprecated
        WEBHOOK("webhook"),
        @Deprecated
        WINDOW("window"),
        @Deprecated
        WORD("word"),
        @Deprecated
        WORKSPACES("workspaces"),
        @Deprecated
        WORLD("world"),
        @Deprecated
        ZOOMIN("zoomin"),
        @Deprecated
        ZOOMOUT("zoomout"),

        CUSTOM("custom"), // default and only recommended mode now

        @Deprecated // use a specific icon as much as possible
        DEFAULT("default");

        @Getter
        private final String key;
    }
}
