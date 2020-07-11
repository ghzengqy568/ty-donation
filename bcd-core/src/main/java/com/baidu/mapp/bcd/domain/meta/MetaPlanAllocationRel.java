package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "activityPlanUuid", column = "activity_plan_uuid", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "allocationUuid", column = "allocation_uuid", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaPlanAllocationRel {

    /**
     * 活动计划与拨款记录关系表
     */
    public static final String TABLE_NAME = "`t_plan_allocation_rel`";

    /**
     * 活动计划与拨款记录关系ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 活动计划ID
     */
    public static final String ACTIVITYPLANUUID = "activityPlanUuid";

    public static final String COLUMN_NAME_ACTIVITYPLANUUID = "`activity_plan_uuid`";

    public static final String JAVA_TYPE_ACTIVITYPLANUUID = "java.lang.String";

    public static final String JDBC_TYPE_ACTIVITYPLANUUID = "VARCHAR";

    public static final String IS_KEY_ACTIVITYPLANUUID = "false";

    /**
     * 拨款记录ID
     */
    public static final String ALLOCATIONUUID = "allocationUuid";

    public static final String COLUMN_NAME_ALLOCATIONUUID = "`allocation_uuid`";

    public static final String JAVA_TYPE_ALLOCATIONUUID = "java.lang.String";

    public static final String JDBC_TYPE_ALLOCATIONUUID = "VARCHAR";

    public static final String IS_KEY_ALLOCATIONUUID = "false";

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
        if (columnName.equals(COLUMN_NAME_ACTIVITYPLANUUID)) {
            return ACTIVITYPLANUUID;
        }
        if (columnName.equals(COLUMN_NAME_ALLOCATIONUUID)) {
            return ALLOCATIONUUID;
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
        if (fieldName.equals(ACTIVITYPLANUUID)) {
            return COLUMN_NAME_ACTIVITYPLANUUID;
        }
        if (fieldName.equals(ALLOCATIONUUID)) {
            return COLUMN_NAME_ALLOCATIONUUID;
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
        if (fieldName.equals(ACTIVITYPLANUUID)) {
            return COLUMN_NAME_ACTIVITYPLANUUID.replace("`", "");
        }
        if (fieldName.equals(ALLOCATIONUUID)) {
            return COLUMN_NAME_ALLOCATIONUUID.replace("`", "");
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