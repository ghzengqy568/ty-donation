package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "donorUserName", column = "donor_user_name", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "donorPwd", column = "donor_pwd", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "donorName", column = "donor_name", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "certCode", column = "cert_code", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "sign", column = "sign", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "idcard", column = "idcard", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "mobile", column = "mobile", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "province", column = "province", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "city", column = "city", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "address", column = "address", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaDonor {

    /**
     * 捐赠人
     */
    public static final String TABLE_NAME = "`t_donor`";

    /**
     * 捐赠人ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 捐赠人用户ID
     */
    public static final String DONORUSERNAME = "donorUserName";

    public static final String COLUMN_NAME_DONORUSERNAME = "`donor_user_name`";

    public static final String JAVA_TYPE_DONORUSERNAME = "java.lang.String";

    public static final String JDBC_TYPE_DONORUSERNAME = "VARCHAR";

    public static final String IS_KEY_DONORUSERNAME = "false";

    /**
     * 捐赠人密码
     */
    public static final String DONORPWD = "donorPwd";

    public static final String COLUMN_NAME_DONORPWD = "`donor_pwd`";

    public static final String JAVA_TYPE_DONORPWD = "java.lang.String";

    public static final String JDBC_TYPE_DONORPWD = "VARCHAR";

    public static final String IS_KEY_DONORPWD = "false";

    /**
     * 捐赠人名称
     */
    public static final String DONORNAME = "donorName";

    public static final String COLUMN_NAME_DONORNAME = "`donor_name`";

    public static final String JAVA_TYPE_DONORNAME = "java.lang.String";

    public static final String JDBC_TYPE_DONORNAME = "VARCHAR";

    public static final String IS_KEY_DONORNAME = "false";

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
     * 身份证号码，加密存储
     */
    public static final String IDCARD = "idcard";

    public static final String COLUMN_NAME_IDCARD = "`idcard`";

    public static final String JAVA_TYPE_IDCARD = "java.lang.String";

    public static final String JDBC_TYPE_IDCARD = "VARCHAR";

    public static final String IS_KEY_IDCARD = "false";

    /**
     * 手机号，加密存储
     */
    public static final String MOBILE = "mobile";

    public static final String COLUMN_NAME_MOBILE = "`mobile`";

    public static final String JAVA_TYPE_MOBILE = "java.lang.String";

    public static final String JDBC_TYPE_MOBILE = "VARCHAR";

    public static final String IS_KEY_MOBILE = "false";

    /**
     * 省份
     */
    public static final String PROVINCE = "province";

    public static final String COLUMN_NAME_PROVINCE = "`province`";

    public static final String JAVA_TYPE_PROVINCE = "java.lang.String";

    public static final String JDBC_TYPE_PROVINCE = "VARCHAR";

    public static final String IS_KEY_PROVINCE = "false";

    /**
     * 城市
     */
    public static final String CITY = "city";

    public static final String COLUMN_NAME_CITY = "`city`";

    public static final String JAVA_TYPE_CITY = "java.lang.String";

    public static final String JDBC_TYPE_CITY = "VARCHAR";

    public static final String IS_KEY_CITY = "false";

    /**
     * 地址
     */
    public static final String ADDRESS = "address";

    public static final String COLUMN_NAME_ADDRESS = "`address`";

    public static final String JAVA_TYPE_ADDRESS = "java.lang.String";

    public static final String JDBC_TYPE_ADDRESS = "VARCHAR";

    public static final String IS_KEY_ADDRESS = "false";

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
        if (columnName.equals(COLUMN_NAME_DONORUSERNAME)) {
            return DONORUSERNAME;
        }
        if (columnName.equals(COLUMN_NAME_DONORPWD)) {
            return DONORPWD;
        }
        if (columnName.equals(COLUMN_NAME_DONORNAME)) {
            return DONORNAME;
        }
        if (columnName.equals(COLUMN_NAME_CERTCODE)) {
            return CERTCODE;
        }
        if (columnName.equals(COLUMN_NAME_SIGN)) {
            return SIGN;
        }
        if (columnName.equals(COLUMN_NAME_IDCARD)) {
            return IDCARD;
        }
        if (columnName.equals(COLUMN_NAME_MOBILE)) {
            return MOBILE;
        }
        if (columnName.equals(COLUMN_NAME_PROVINCE)) {
            return PROVINCE;
        }
        if (columnName.equals(COLUMN_NAME_CITY)) {
            return CITY;
        }
        if (columnName.equals(COLUMN_NAME_ADDRESS)) {
            return ADDRESS;
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
        if (fieldName.equals(DONORUSERNAME)) {
            return COLUMN_NAME_DONORUSERNAME;
        }
        if (fieldName.equals(DONORPWD)) {
            return COLUMN_NAME_DONORPWD;
        }
        if (fieldName.equals(DONORNAME)) {
            return COLUMN_NAME_DONORNAME;
        }
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE;
        }
        if (fieldName.equals(SIGN)) {
            return COLUMN_NAME_SIGN;
        }
        if (fieldName.equals(IDCARD)) {
            return COLUMN_NAME_IDCARD;
        }
        if (fieldName.equals(MOBILE)) {
            return COLUMN_NAME_MOBILE;
        }
        if (fieldName.equals(PROVINCE)) {
            return COLUMN_NAME_PROVINCE;
        }
        if (fieldName.equals(CITY)) {
            return COLUMN_NAME_CITY;
        }
        if (fieldName.equals(ADDRESS)) {
            return COLUMN_NAME_ADDRESS;
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
        if (fieldName.equals(DONORUSERNAME)) {
            return COLUMN_NAME_DONORUSERNAME.replace("`", "");
        }
        if (fieldName.equals(DONORPWD)) {
            return COLUMN_NAME_DONORPWD.replace("`", "");
        }
        if (fieldName.equals(DONORNAME)) {
            return COLUMN_NAME_DONORNAME.replace("`", "");
        }
        if (fieldName.equals(CERTCODE)) {
            return COLUMN_NAME_CERTCODE.replace("`", "");
        }
        if (fieldName.equals(SIGN)) {
            return COLUMN_NAME_SIGN.replace("`", "");
        }
        if (fieldName.equals(IDCARD)) {
            return COLUMN_NAME_IDCARD.replace("`", "");
        }
        if (fieldName.equals(MOBILE)) {
            return COLUMN_NAME_MOBILE.replace("`", "");
        }
        if (fieldName.equals(PROVINCE)) {
            return COLUMN_NAME_PROVINCE.replace("`", "");
        }
        if (fieldName.equals(CITY)) {
            return COLUMN_NAME_CITY.replace("`", "");
        }
        if (fieldName.equals(ADDRESS)) {
            return COLUMN_NAME_ADDRESS.replace("`", "");
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