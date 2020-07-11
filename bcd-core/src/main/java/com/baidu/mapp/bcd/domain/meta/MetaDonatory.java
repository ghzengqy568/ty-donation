package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "donatoryUserName", column = "donatory_user_name", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "donatoryPwd", column = "donatory_pwd", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "donatoryName", column = "donatory_name", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "idcard", column = "idcard", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "mobile", column = "mobile", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "donatoryCard", column = "donatory_card", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "province", column = "province", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "city", column = "city", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "address", column = "address", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "donatoryLevel", column = "donatory_level", javaType = java.lang.Byte.class, jdbcType = JdbcType.TINYINT),
       @Result(property = "certCode", column = "cert_code", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "sign", column = "sign", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaDonatory {

    /**
     * 受赠人
     */
    public static final String TABLE_NAME = "`t_donatory`";

    /**
     * 受赠人ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 受赠人用户ID
     */
    public static final String DONATORYUSERNAME = "donatoryUserName";

    public static final String COLUMN_NAME_DONATORYUSERNAME = "`donatory_user_name`";

    public static final String JAVA_TYPE_DONATORYUSERNAME = "java.lang.String";

    public static final String JDBC_TYPE_DONATORYUSERNAME = "VARCHAR";

    public static final String IS_KEY_DONATORYUSERNAME = "false";

    /**
     * 受赠人密码
     */
    public static final String DONATORYPWD = "donatoryPwd";

    public static final String COLUMN_NAME_DONATORYPWD = "`donatory_pwd`";

    public static final String JAVA_TYPE_DONATORYPWD = "java.lang.String";

    public static final String JDBC_TYPE_DONATORYPWD = "VARCHAR";

    public static final String IS_KEY_DONATORYPWD = "false";

    /**
     * 受赠人名称
     */
    public static final String DONATORYNAME = "donatoryName";

    public static final String COLUMN_NAME_DONATORYNAME = "`donatory_name`";

    public static final String JAVA_TYPE_DONATORYNAME = "java.lang.String";

    public static final String JDBC_TYPE_DONATORYNAME = "VARCHAR";

    public static final String IS_KEY_DONATORYNAME = "false";

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
     * 受赠人社保卡，加密存储
     */
    public static final String DONATORYCARD = "donatoryCard";

    public static final String COLUMN_NAME_DONATORYCARD = "`donatory_card`";

    public static final String JAVA_TYPE_DONATORYCARD = "java.lang.String";

    public static final String JDBC_TYPE_DONATORYCARD = "VARCHAR";

    public static final String IS_KEY_DONATORYCARD = "false";

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
     * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
     */
    public static final String DONATORYLEVEL = "donatoryLevel";

    public static final String COLUMN_NAME_DONATORYLEVEL = "`donatory_level`";

    public static final String JAVA_TYPE_DONATORYLEVEL = "java.lang.Byte";

    public static final String JDBC_TYPE_DONATORYLEVEL = "TINYINT";

    public static final String IS_KEY_DONATORYLEVEL = "false";

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
        if (columnName.equals(COLUMN_NAME_DONATORYUSERNAME)) {
            return DONATORYUSERNAME;
        }
        if (columnName.equals(COLUMN_NAME_DONATORYPWD)) {
            return DONATORYPWD;
        }
        if (columnName.equals(COLUMN_NAME_DONATORYNAME)) {
            return DONATORYNAME;
        }
        if (columnName.equals(COLUMN_NAME_IDCARD)) {
            return IDCARD;
        }
        if (columnName.equals(COLUMN_NAME_MOBILE)) {
            return MOBILE;
        }
        if (columnName.equals(COLUMN_NAME_DONATORYCARD)) {
            return DONATORYCARD;
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
        if (columnName.equals(COLUMN_NAME_DONATORYLEVEL)) {
            return DONATORYLEVEL;
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
        if (fieldName.equals(DONATORYUSERNAME)) {
            return COLUMN_NAME_DONATORYUSERNAME;
        }
        if (fieldName.equals(DONATORYPWD)) {
            return COLUMN_NAME_DONATORYPWD;
        }
        if (fieldName.equals(DONATORYNAME)) {
            return COLUMN_NAME_DONATORYNAME;
        }
        if (fieldName.equals(IDCARD)) {
            return COLUMN_NAME_IDCARD;
        }
        if (fieldName.equals(MOBILE)) {
            return COLUMN_NAME_MOBILE;
        }
        if (fieldName.equals(DONATORYCARD)) {
            return COLUMN_NAME_DONATORYCARD;
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
        if (fieldName.equals(DONATORYLEVEL)) {
            return COLUMN_NAME_DONATORYLEVEL;
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
        if (fieldName.equals(DONATORYUSERNAME)) {
            return COLUMN_NAME_DONATORYUSERNAME.replace("`", "");
        }
        if (fieldName.equals(DONATORYPWD)) {
            return COLUMN_NAME_DONATORYPWD.replace("`", "");
        }
        if (fieldName.equals(DONATORYNAME)) {
            return COLUMN_NAME_DONATORYNAME.replace("`", "");
        }
        if (fieldName.equals(IDCARD)) {
            return COLUMN_NAME_IDCARD.replace("`", "");
        }
        if (fieldName.equals(MOBILE)) {
            return COLUMN_NAME_MOBILE.replace("`", "");
        }
        if (fieldName.equals(DONATORYCARD)) {
            return COLUMN_NAME_DONATORYCARD.replace("`", "");
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
        if (fieldName.equals(DONATORYLEVEL)) {
            return COLUMN_NAME_DONATORYLEVEL.replace("`", "");
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