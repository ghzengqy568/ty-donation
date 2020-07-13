package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "donatoryId", column = "donatory_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "activityId", column = "activity_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "drawTime", column = "draw_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "certCode", column = "cert_code", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "sign", column = "sign", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaDrawRecordFlow {

    /**
     * 领取记录流水
     */
    public static final String TABLE_NAME = "`t_draw_record_flow`";

    /**
     * 领取记录流水ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 受赠人ID
     */
    public static final String DONATORYID = "donatoryId";

    public static final String COLUMN_NAME_DONATORYID = "`donatory_id`";

    public static final String JAVA_TYPE_DONATORYID = "java.lang.Long";

    public static final String JDBC_TYPE_DONATORYID = "BIGINT";

    public static final String IS_KEY_DONATORYID = "false";

    /**
     * 活动ID
     */
    public static final String ACTIVITYID = "activityId";

    public static final String COLUMN_NAME_ACTIVITYID = "`activity_id`";

    public static final String JAVA_TYPE_ACTIVITYID = "java.lang.Long";

    public static final String JDBC_TYPE_ACTIVITYID = "BIGINT";

    public static final String IS_KEY_ACTIVITYID = "false";

    /**
     * 领取时间
     */
    public static final String DRAWTIME = "drawTime";

    public static final String COLUMN_NAME_DRAWTIME = "`draw_time`";

    public static final String JAVA_TYPE_DRAWTIME = "java.util.Date";

    public static final String JDBC_TYPE_DRAWTIME = "TIMESTAMP";

    public static final String IS_KEY_DRAWTIME = "false";

    /**
     * 证书编码
     */
    public static final String CERTCODE = "certCode";

    public static final String COLUMN_NAME_CERTCODE = "`cert_code`";

    public static final String JAVA_TYPE_CERTCODE = "java.lang.String";

    public static final String JDBC_TYPE_CERTCODE = "VARCHAR";

    public static final String IS_KEY_CERTCODE = "false";

    /**
     * 存证签名
     */
    public static final String SIGN = "sign";

    public static final String COLUMN_NAME_SIGN = "`sign`";

    public static final String JAVA_TYPE_SIGN = "java.lang.String";

    public static final String JDBC_TYPE_SIGN = "VARCHAR";

    public static final String IS_KEY_SIGN = "false";

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
        if (columnName.equals(COLUMN_NAME_DONATORYID)) {
            return DONATORYID;
        }
        if (columnName.equals(COLUMN_NAME_ACTIVITYID)) {
            return ACTIVITYID;
        }
        if (columnName.equals(COLUMN_NAME_DRAWTIME)) {
            return DRAWTIME;
        }
        if (columnName.equals(COLUMN_NAME_CERTCODE)) {
            return CERTCODE;
        }
        if (columnName.equals(COLUMN_NAME_SIGN)) {
            return SIGN;
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
        if (fieldName.equals(DONATORYID)) {
            return COLUMN_NAME_DONATORYID;
        }
        if (fieldName.equals(ACTIVITYID)) {
            return COLUMN_NAME_ACTIVITYID;
        }
        if (fieldName.equals(DRAWTIME)) {
            return COLUMN_NAME_DRAWTIME;
        }
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE;
        }
        if (fieldName.equals(SIGN)) {
            return COLUMN_NAME_SIGN;
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
        if (fieldName.equals(DONATORYID)) {
            return COLUMN_NAME_DONATORYID.replace("`", "");
        }
        if (fieldName.equals(ACTIVITYID)) {
            return COLUMN_NAME_ACTIVITYID.replace("`", "");
        }
        if (fieldName.equals(DRAWTIME)) {
            return COLUMN_NAME_DRAWTIME.replace("`", "");
        }
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE.replace("`", "");
        }
        if (fieldName.equals(SIGN)) {
            return COLUMN_NAME_SIGN.replace("`", "");
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