package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "activityPlanId", column = "activity_plan_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "donatoryId", column = "donatory_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "configId", column = "config_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "donatoryLevel", column = "donatory_level", javaType = java.lang.Byte.class, jdbcType = JdbcType.TINYINT),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaAssign {

    /**
     * 指派关系表
     */
    public static final String TABLE_NAME = "`t_assign`";

    /**
     * 领取和捐赠明细关系ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 活动计划ID
     */
    public static final String ACTIVITYPLANID = "activityPlanId";

    public static final String COLUMN_NAME_ACTIVITYPLANID = "`activity_plan_id`";

    public static final String JAVA_TYPE_ACTIVITYPLANID = "java.lang.Long";

    public static final String JDBC_TYPE_ACTIVITYPLANID = "BIGINT";

    public static final String IS_KEY_ACTIVITYPLANID = "false";

    /**
     * 受赠人ID
     */
    public static final String DONATORYID = "donatoryId";

    public static final String COLUMN_NAME_DONATORYID = "`donatory_id`";

    public static final String JAVA_TYPE_DONATORYID = "java.lang.Long";

    public static final String JDBC_TYPE_DONATORYID = "BIGINT";

    public static final String IS_KEY_DONATORYID = "false";

    /**
     * 计划配置ID
     */
    public static final String CONFIGID = "configId";

    public static final String COLUMN_NAME_CONFIGID = "`config_id`";

    public static final String JAVA_TYPE_CONFIGID = "java.lang.Long";

    public static final String JDBC_TYPE_CONFIGID = "BIGINT";

    public static final String IS_KEY_CONFIGID = "false";

    /**
     * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
     */
    public static final String DONATORYLEVEL = "donatoryLevel";

    public static final String COLUMN_NAME_DONATORYLEVEL = "`donatory_level`";

    public static final String JAVA_TYPE_DONATORYLEVEL = "java.lang.Byte";

    public static final String JDBC_TYPE_DONATORYLEVEL = "TINYINT";

    public static final String IS_KEY_DONATORYLEVEL = "false";

    /**
     * 创建时间
     */
    public static final String CREATETIME = "createTime";

    public static final String COLUMN_NAME_CREATETIME = "`create_time`";

    public static final String JAVA_TYPE_CREATETIME = "java.util.Date";

    public static final String JDBC_TYPE_CREATETIME = "TIMESTAMP";

    public static final String IS_KEY_CREATETIME = "false";

    /**
     * 更新时间
     */
    public static final String LASTMODIFYTIME = "lastModifyTime";

    public static final String COLUMN_NAME_LASTMODIFYTIME = "`last_modify_time`";

    public static final String JAVA_TYPE_LASTMODIFYTIME = "java.util.Date";

    public static final String JDBC_TYPE_LASTMODIFYTIME = "TIMESTAMP";

    public static final String IS_KEY_LASTMODIFYTIME = "false";

    /**
     * 根据数据库字段名返回JAVA对象字段名
     */
    public static String getFieldNameByColumn(String columnName) {
        if (columnName == null) {
            return "";
        }
        columnName = columnName.trim();
        if (columnName.length() <= 0) {
            return "";
        }
        if (!columnName.startsWith("`")) {
            columnName = "`" + columnName + "`";
        }
        if (columnName.equals(COLUMN_NAME_ID)) {
            return ID;
        }
        if (columnName.equals(COLUMN_NAME_ACTIVITYPLANID)) {
            return ACTIVITYPLANID;
        }
        if (columnName.equals(COLUMN_NAME_DONATORYID)) {
            return DONATORYID;
        }
        if (columnName.equals(COLUMN_NAME_CONFIGID)) {
            return CONFIGID;
        }
        if (columnName.equals(COLUMN_NAME_DONATORYLEVEL)) {
            return DONATORYLEVEL;
        }
        if (columnName.equals(COLUMN_NAME_CREATETIME)) {
            return CREATETIME;
        }
        if (columnName.equals(COLUMN_NAME_LASTMODIFYTIME)) {
            return LASTMODIFYTIME;
        }
        return "";
    }

    /**
     * 根据JavaPojo对象字段名返回安全的数据库字段名, eg：`id`
     */
    public static String getSafeColumnNameByField(String fieldName) {
        if (fieldName == null) {
            return "";
        }
        fieldName = fieldName.trim();
        if (fieldName.length() <= 0) {
            return "";
        }
        if (fieldName.equals(ID)) {
            return COLUMN_NAME_ID;
        }
        if (fieldName.equals(ACTIVITYPLANID)) {
            return COLUMN_NAME_ACTIVITYPLANID;
        }
        if (fieldName.equals(DONATORYID)) {
            return COLUMN_NAME_DONATORYID;
        }
        if (fieldName.equals(CONFIGID)) {
            return COLUMN_NAME_CONFIGID;
        }
        if (fieldName.equals(DONATORYLEVEL)) {
            return COLUMN_NAME_DONATORYLEVEL;
        }
        if (fieldName.equals(CREATETIME)) {
            return COLUMN_NAME_CREATETIME;
        }
        if (fieldName.equals(LASTMODIFYTIME)) {
            return COLUMN_NAME_LASTMODIFYTIME;
        }
        return "";
    }

    /**
     * 根据JavaPojo对象字段名返回数据库字段名, eg：id
     */
    public static String getColumnNameByField(String fieldName) {
        if (fieldName == null) {
            return "";
        }
        fieldName = fieldName.trim();
        if (fieldName.length() <= 0) {
            return "";
        }
        if (fieldName.equals(ID)) {
            return COLUMN_NAME_ID.replace("`", "");
        }
        if (fieldName.equals(ACTIVITYPLANID)) {
            return COLUMN_NAME_ACTIVITYPLANID.replace("`", "");
        }
        if (fieldName.equals(DONATORYID)) {
            return COLUMN_NAME_DONATORYID.replace("`", "");
        }
        if (fieldName.equals(CONFIGID)) {
            return COLUMN_NAME_CONFIGID.replace("`", "");
        }
        if (fieldName.equals(DONATORYLEVEL)) {
            return COLUMN_NAME_DONATORYLEVEL.replace("`", "");
        }
        if (fieldName.equals(CREATETIME)) {
            return COLUMN_NAME_CREATETIME.replace("`", "");
        }
        if (fieldName.equals(LASTMODIFYTIME)) {
            return COLUMN_NAME_LASTMODIFYTIME.replace("`", "");
        }
        return "";
    }
}