package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "certCode", column = "cert_code", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "certTime", column = "cert_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "sourceTable", column = "source_table", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "uuid", column = "uuid", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "sourceId", column = "source_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaCertificate {

    /**
     * 链上证书记录
     */
    public static final String TABLE_NAME = "`t_certificate`";

    /**
     * 存证ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 证书编码
     */
    public static final String CERTCODE = "certCode";

    public static final String COLUMN_NAME_CERTCODE = "`cert_code`";

    public static final String JAVA_TYPE_CERTCODE = "java.lang.String";

    public static final String JDBC_TYPE_CERTCODE = "VARCHAR";

    public static final String IS_KEY_CERTCODE = "false";

    /**
     * 证书日期
     */
    public static final String CERTTIME = "certTime";

    public static final String COLUMN_NAME_CERTTIME = "`cert_time`";

    public static final String JAVA_TYPE_CERTTIME = "java.util.Date";

    public static final String JDBC_TYPE_CERTTIME = "TIMESTAMP";

    public static final String IS_KEY_CERTTIME = "false";

    /**
     * 存证来源表名
     */
    public static final String SOURCETABLE = "sourceTable";

    public static final String COLUMN_NAME_SOURCETABLE = "`source_table`";

    public static final String JAVA_TYPE_SOURCETABLE = "java.lang.String";

    public static final String JDBC_TYPE_SOURCETABLE = "VARCHAR";

    public static final String IS_KEY_SOURCETABLE = "false";

    /**
     * 多链ID身份
     */
    public static final String UUID = "uuid";

    public static final String COLUMN_NAME_UUID = "`uuid`";

    public static final String JAVA_TYPE_UUID = "java.lang.String";

    public static final String JDBC_TYPE_UUID = "VARCHAR";

    public static final String IS_KEY_UUID = "false";

    /**
     * 存证来源表ID
     */
    public static final String SOURCEID = "sourceId";

    public static final String COLUMN_NAME_SOURCEID = "`source_id`";

    public static final String JAVA_TYPE_SOURCEID = "java.lang.Long";

    public static final String JDBC_TYPE_SOURCEID = "BIGINT";

    public static final String IS_KEY_SOURCEID = "false";

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
        if (columnName.equals(COLUMN_NAME_CERTCODE)) {
            return CERTCODE;
        }
        if (columnName.equals(COLUMN_NAME_CERTTIME)) {
            return CERTTIME;
        }
        if (columnName.equals(COLUMN_NAME_SOURCETABLE)) {
            return SOURCETABLE;
        }
        if (columnName.equals(COLUMN_NAME_UUID)) {
            return UUID;
        }
        if (columnName.equals(COLUMN_NAME_SOURCEID)) {
            return SOURCEID;
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
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE;
        }
        if (fieldName.equals(CERTTIME)) {
            return COLUMN_NAME_CERTTIME;
        }
        if (fieldName.equals(SOURCETABLE)) {
            return COLUMN_NAME_SOURCETABLE;
        }
        if (fieldName.equals(UUID)) {
            return COLUMN_NAME_UUID;
        }
        if (fieldName.equals(SOURCEID)) {
            return COLUMN_NAME_SOURCEID;
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
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE.replace("`", "");
        }
        if (fieldName.equals(CERTTIME)) {
            return COLUMN_NAME_CERTTIME.replace("`", "");
        }
        if (fieldName.equals(SOURCETABLE)) {
            return COLUMN_NAME_SOURCETABLE.replace("`", "");
        }
        if (fieldName.equals(UUID)) {
            return COLUMN_NAME_UUID.replace("`", "");
        }
        if (fieldName.equals(SOURCEID)) {
            return COLUMN_NAME_SOURCEID.replace("`", "");
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