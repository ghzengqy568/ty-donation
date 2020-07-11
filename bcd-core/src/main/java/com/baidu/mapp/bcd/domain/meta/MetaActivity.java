package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "uuid", column = "uuid", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "theme", column = "theme", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "description", column = "description", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "startTime", column = "start_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "endTime", column = "end_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "certCode", column = "cert_code", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "sign", column = "sign", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "status", column = "status", javaType = java.lang.Byte.class, jdbcType = JdbcType.TINYINT),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaActivity {

    /**
     * 活动
     */
    public static final String TABLE_NAME = "`t_activity`";

    /**
     * 活动ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 多链ID身份
     */
    public static final String UUID = "uuid";

    public static final String COLUMN_NAME_UUID = "`uuid`";

    public static final String JAVA_TYPE_UUID = "java.lang.String";

    public static final String JDBC_TYPE_UUID = "VARCHAR";

    public static final String IS_KEY_UUID = "false";

    /**
     * 活动主题
     */
    public static final String THEME = "theme";

    public static final String COLUMN_NAME_THEME = "`theme`";

    public static final String JAVA_TYPE_THEME = "java.lang.String";

    public static final String JDBC_TYPE_THEME = "VARCHAR";

    public static final String IS_KEY_THEME = "false";

    /**
     * 活动描述
     */
    public static final String DESCRIPTION = "description";

    public static final String COLUMN_NAME_DESCRIPTION = "`description`";

    public static final String JAVA_TYPE_DESCRIPTION = "java.lang.String";

    public static final String JDBC_TYPE_DESCRIPTION = "VARCHAR";

    public static final String IS_KEY_DESCRIPTION = "false";

    /**
     * 活动开始时间
     */
    public static final String STARTTIME = "startTime";

    public static final String COLUMN_NAME_STARTTIME = "`start_time`";

    public static final String JAVA_TYPE_STARTTIME = "java.util.Date";

    public static final String JDBC_TYPE_STARTTIME = "TIMESTAMP";

    public static final String IS_KEY_STARTTIME = "false";

    /**
     * 活动结束时间
     */
    public static final String ENDTIME = "endTime";

    public static final String COLUMN_NAME_ENDTIME = "`end_time`";

    public static final String JAVA_TYPE_ENDTIME = "java.util.Date";

    public static final String JDBC_TYPE_ENDTIME = "TIMESTAMP";

    public static final String IS_KEY_ENDTIME = "false";

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
     * 活动状态， 0-待实施， 1-实施中， 2-实施完成
     */
    public static final String STATUS = "status";

    public static final String COLUMN_NAME_STATUS = "`status`";

    public static final String JAVA_TYPE_STATUS = "java.lang.Byte";

    public static final String JDBC_TYPE_STATUS = "TINYINT";

    public static final String IS_KEY_STATUS = "false";

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
        if (columnName.equals(COLUMN_NAME_UUID)) {
            return UUID;
        }
        if (columnName.equals(COLUMN_NAME_THEME)) {
            return THEME;
        }
        if (columnName.equals(COLUMN_NAME_DESCRIPTION)) {
            return DESCRIPTION;
        }
        if (columnName.equals(COLUMN_NAME_STARTTIME)) {
            return STARTTIME;
        }
        if (columnName.equals(COLUMN_NAME_ENDTIME)) {
            return ENDTIME;
        }
        if (columnName.equals(COLUMN_NAME_CERTCODE)) {
            return CERTCODE;
        }
        if (columnName.equals(COLUMN_NAME_SIGN)) {
            return SIGN;
        }
        if (columnName.equals(COLUMN_NAME_STATUS)) {
            return STATUS;
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
        if (fieldName.equals(UUID)) {
            return COLUMN_NAME_UUID;
        }
        if (fieldName.equals(THEME)) {
            return COLUMN_NAME_THEME;
        }
        if (fieldName.equals(DESCRIPTION)) {
            return COLUMN_NAME_DESCRIPTION;
        }
        if (fieldName.equals(STARTTIME)) {
            return COLUMN_NAME_STARTTIME;
        }
        if (fieldName.equals(ENDTIME)) {
            return COLUMN_NAME_ENDTIME;
        }
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE;
        }
        if (fieldName.equals(SIGN)) {
            return COLUMN_NAME_SIGN;
        }
        if (fieldName.equals(STATUS)) {
            return COLUMN_NAME_STATUS;
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
        if (fieldName.equals(UUID)) {
            return COLUMN_NAME_UUID.replace("`", "");
        }
        if (fieldName.equals(THEME)) {
            return COLUMN_NAME_THEME.replace("`", "");
        }
        if (fieldName.equals(DESCRIPTION)) {
            return COLUMN_NAME_DESCRIPTION.replace("`", "");
        }
        if (fieldName.equals(STARTTIME)) {
            return COLUMN_NAME_STARTTIME.replace("`", "");
        }
        if (fieldName.equals(ENDTIME)) {
            return COLUMN_NAME_ENDTIME.replace("`", "");
        }
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE.replace("`", "");
        }
        if (fieldName.equals(SIGN)) {
            return COLUMN_NAME_SIGN.replace("`", "");
        }
        if (fieldName.equals(STATUS)) {
            return COLUMN_NAME_STATUS.replace("`", "");
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