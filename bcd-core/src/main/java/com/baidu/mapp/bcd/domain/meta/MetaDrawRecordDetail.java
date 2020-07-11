package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "activityId", column = "activity_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "activityPlanId", column = "activity_plan_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "allocationId", column = "allocation_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "used", column = "used", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "donatoryId", column = "donatory_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT)
})
*/
public final class MetaDrawRecordDetail {

    /**
     * 领取分配记录
     */
    public static final String TABLE_NAME = "`t_draw_record_detail`";

    /**
     * 领取记录ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 活动ID
     */
    public static final String ACTIVITYID = "activityId";

    public static final String COLUMN_NAME_ACTIVITYID = "`activity_id`";

    public static final String JAVA_TYPE_ACTIVITYID = "java.lang.Long";

    public static final String JDBC_TYPE_ACTIVITYID = "BIGINT";

    public static final String IS_KEY_ACTIVITYID = "false";

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
     * 用量
     */
    public static final String USED = "used";

    public static final String COLUMN_NAME_USED = "`used`";

    public static final String JAVA_TYPE_USED = "java.lang.Long";

    public static final String JDBC_TYPE_USED = "BIGINT";

    public static final String IS_KEY_USED = "false";

    /**
     * 受赠人ID
     */
    public static final String DONATORYID = "donatoryId";

    public static final String COLUMN_NAME_DONATORYID = "`donatory_id`";

    public static final String JAVA_TYPE_DONATORYID = "java.lang.Long";

    public static final String JDBC_TYPE_DONATORYID = "BIGINT";

    public static final String IS_KEY_DONATORYID = "false";

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
        if (columnName.equals(COLUMN_NAME_ACTIVITYID)) {
            return ACTIVITYID;
        }
        if (columnName.equals(COLUMN_NAME_ACTIVITYPLANID)) {
            return ACTIVITYPLANID;
        }
        if (columnName.equals(COLUMN_NAME_ALLOCATIONID)) {
            return ALLOCATIONID;
        }
        if (columnName.equals(COLUMN_NAME_USED)) {
            return USED;
        }
        if (columnName.equals(COLUMN_NAME_DONATORYID)) {
            return DONATORYID;
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
        if (fieldName.equals(ACTIVITYID)) {
            return COLUMN_NAME_ACTIVITYID;
        }
        if (fieldName.equals(ACTIVITYPLANID)) {
            return COLUMN_NAME_ACTIVITYPLANID;
        }
        if (fieldName.equals(ALLOCATIONID)) {
            return COLUMN_NAME_ALLOCATIONID;
        }
        if (fieldName.equals(USED)) {
            return COLUMN_NAME_USED;
        }
        if (fieldName.equals(DONATORYID)) {
            return COLUMN_NAME_DONATORYID;
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
        if (fieldName.equals(ACTIVITYID)) {
            return COLUMN_NAME_ACTIVITYID.replace("`", "");
        }
        if (fieldName.equals(ACTIVITYPLANID)) {
            return COLUMN_NAME_ACTIVITYPLANID.replace("`", "");
        }
        if (fieldName.equals(ALLOCATIONID)) {
            return COLUMN_NAME_ALLOCATIONID.replace("`", "");
        }
        if (fieldName.equals(USED)) {
            return COLUMN_NAME_USED.replace("`", "");
        }
        if (fieldName.equals(DONATORYID)) {
            return COLUMN_NAME_DONATORYID.replace("`", "");
        }
        return "";
    }
}