package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "donorId", column = "donor_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "donateTime", column = "donate_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "isAnonymous", column = "is_anonymous", javaType = java.lang.Byte.class, jdbcType = JdbcType.TINYINT),
       @Result(property = "anonymity", column = "anonymity", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "certCode", column = "cert_code", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "sign", column = "sign", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaDonateFlow {

    /**
     * 捐赠流水
     */
    public static final String TABLE_NAME = "`t_donate_flow`";

    /**
     * 捐赠流水ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 捐赠人ID
     */
    public static final String DONORID = "donorId";

    public static final String COLUMN_NAME_DONORID = "`donor_id`";

    public static final String JAVA_TYPE_DONORID = "java.lang.Long";

    public static final String JDBC_TYPE_DONORID = "BIGINT";

    public static final String IS_KEY_DONORID = "false";

    /**
     * 捐赠时间
     */
    public static final String DONATETIME = "donateTime";

    public static final String COLUMN_NAME_DONATETIME = "`donate_time`";

    public static final String JAVA_TYPE_DONATETIME = "java.util.Date";

    public static final String JDBC_TYPE_DONATETIME = "TIMESTAMP";

    public static final String IS_KEY_DONATETIME = "false";

    /**
     * 是否需要匿名捐赠,1-是,0-否
     */
    public static final String ISANONYMOUS = "isAnonymous";

    public static final String COLUMN_NAME_ISANONYMOUS = "`is_anonymous`";

    public static final String JAVA_TYPE_ISANONYMOUS = "java.lang.Byte";

    public static final String JDBC_TYPE_ISANONYMOUS = "TINYINT";

    public static final String IS_KEY_ISANONYMOUS = "false";

    /**
     * 捐赠人隐匿名称
     */
    public static final String ANONYMITY = "anonymity";

    public static final String COLUMN_NAME_ANONYMITY = "`anonymity`";

    public static final String JAVA_TYPE_ANONYMITY = "java.lang.String";

    public static final String JDBC_TYPE_ANONYMITY = "VARCHAR";

    public static final String IS_KEY_ANONYMITY = "false";

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
        if (columnName.equals(COLUMN_NAME_DONORID)) {
            return DONORID;
        }
        if (columnName.equals(COLUMN_NAME_DONATETIME)) {
            return DONATETIME;
        }
        if (columnName.equals(COLUMN_NAME_ISANONYMOUS)) {
            return ISANONYMOUS;
        }
        if (columnName.equals(COLUMN_NAME_ANONYMITY)) {
            return ANONYMITY;
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
        if (fieldName.equals(DONORID)) {
            return COLUMN_NAME_DONORID;
        }
        if (fieldName.equals(DONATETIME)) {
            return COLUMN_NAME_DONATETIME;
        }
        if (fieldName.equals(ISANONYMOUS)) {
            return COLUMN_NAME_ISANONYMOUS;
        }
        if (fieldName.equals(ANONYMITY)) {
            return COLUMN_NAME_ANONYMITY;
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
        if (fieldName.equals(DONORID)) {
            return COLUMN_NAME_DONORID.replace("`", "");
        }
        if (fieldName.equals(DONATETIME)) {
            return COLUMN_NAME_DONATETIME.replace("`", "");
        }
        if (fieldName.equals(ISANONYMOUS)) {
            return COLUMN_NAME_ISANONYMOUS.replace("`", "");
        }
        if (fieldName.equals(ANONYMITY)) {
            return COLUMN_NAME_ANONYMITY.replace("`", "");
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