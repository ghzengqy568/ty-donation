package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "activityPlanId", column = "activity_plan_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "allocationId", column = "allocation_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "balance", column = "balance", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "used", column = "used", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
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
    public static final String ACTIVITYPLANID = "activityPlanId";

    public static final String COLUMN_NAME_ACTIVITYPLANID = "`activity_plan_id`";

    public static final String JAVA_TYPE_ACTIVITYPLANID = "java.lang.Long";

    public static final String JDBC_TYPE_ACTIVITYPLANID = "BIGINT";

    public static final String IS_KEY_ACTIVITYPLANID = "false";

    /**
     * 拨款记录ID
     */
    public static final String ALLOCATIONID = "allocationId";

    public static final String COLUMN_NAME_ALLOCATIONID = "`allocation_id`";

    public static final String JAVA_TYPE_ALLOCATIONID = "java.lang.Long";

    public static final String JDBC_TYPE_ALLOCATIONID = "BIGINT";

    public static final String IS_KEY_ALLOCATIONID = "false";

    /**
     * 分配后余额
     */
    public static final String BALANCE = "balance";

    public static final String COLUMN_NAME_BALANCE = "`balance`";

    public static final String JAVA_TYPE_BALANCE = "java.lang.Long";

    public static final String JDBC_TYPE_BALANCE = "BIGINT";

    public static final String IS_KEY_BALANCE = "false";

    /**
     * 使用量
     */
    public static final String USED = "used";

    public static final String COLUMN_NAME_USED = "`used`";

    public static final String JAVA_TYPE_USED = "java.lang.Long";

    public static final String JDBC_TYPE_USED = "BIGINT";

    public static final String IS_KEY_USED = "false";

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
        if (columnName.equals(COLUMN_NAME_ALLOCATIONID)) {
            return ALLOCATIONID;
        }
        if (columnName.equals(COLUMN_NAME_BALANCE)) {
            return BALANCE;
        }
        if (columnName.equals(COLUMN_NAME_USED)) {
            return USED;
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
        if (fieldName.equals(ALLOCATIONID)) {
            return COLUMN_NAME_ALLOCATIONID;
        }
        if (fieldName.equals(BALANCE)) {
            return COLUMN_NAME_BALANCE;
        }
        if (fieldName.equals(USED)) {
            return COLUMN_NAME_USED;
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
        if (fieldName.equals(ALLOCATIONID)) {
            return COLUMN_NAME_ALLOCATIONID.replace("`", "");
        }
        if (fieldName.equals(BALANCE)) {
            return COLUMN_NAME_BALANCE.replace("`", "");
        }
        if (fieldName.equals(USED)) {
            return COLUMN_NAME_USED.replace("`", "");
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