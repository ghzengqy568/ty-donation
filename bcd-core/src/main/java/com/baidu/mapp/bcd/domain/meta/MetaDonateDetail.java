package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "flowId", column = "flow_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "type", column = "type", javaType = java.lang.Byte.class, jdbcType = JdbcType.TINYINT),
       @Result(property = "unit", column = "unit", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "quantity", column = "quantity", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "name", column = "name", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "certCode", column = "cert_code", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "sign", column = "sign", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaDonateDetail {

    /**
     * 捐赠明细
     */
    public static final String TABLE_NAME = "t_donate_detail";

    /**
     * 捐赠明细ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 捐赠流水ID
     */
    public static final String FLOWID = "flowId";

    public static final String COLUMN_NAME_FLOWID = "`flow_id`";

    public static final String JAVA_TYPE_FLOWID = "java.lang.Long";

    public static final String JDBC_TYPE_FLOWID = "BIGINT";

    public static final String IS_KEY_FLOWID = "false";

    /**
     * 捐赠类别, 1-钱，2-物
     */
    public static final String TYPE = "type";

    public static final String COLUMN_NAME_TYPE = "`type`";

    public static final String JAVA_TYPE_TYPE = "java.lang.Byte";

    public static final String JDBC_TYPE_TYPE = "TINYINT";

    public static final String IS_KEY_TYPE = "false";

    /**
     * 单位
     */
    public static final String UNIT = "unit";

    public static final String COLUMN_NAME_UNIT = "`unit`";

    public static final String JAVA_TYPE_UNIT = "java.lang.String";

    public static final String JDBC_TYPE_UNIT = "VARCHAR";

    public static final String IS_KEY_UNIT = "false";

    /**
     * 数量
     */
    public static final String QUANTITY = "quantity";

    public static final String COLUMN_NAME_QUANTITY = "`quantity`";

    public static final String JAVA_TYPE_QUANTITY = "java.lang.Long";

    public static final String JDBC_TYPE_QUANTITY = "BIGINT";

    public static final String IS_KEY_QUANTITY = "false";

    /**
     * 物资名称
     */
    public static final String NAME = "name";

    public static final String COLUMN_NAME_NAME = "`name`";

    public static final String JAVA_TYPE_NAME = "java.lang.String";

    public static final String JDBC_TYPE_NAME = "VARCHAR";

    public static final String IS_KEY_NAME = "false";

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
        if (columnName.equals(COLUMN_NAME_FLOWID)) {
            return FLOWID;
        }
        if (columnName.equals(COLUMN_NAME_TYPE)) {
            return TYPE;
        }
        if (columnName.equals(COLUMN_NAME_UNIT)) {
            return UNIT;
        }
        if (columnName.equals(COLUMN_NAME_QUANTITY)) {
            return QUANTITY;
        }
        if (columnName.equals(COLUMN_NAME_NAME)) {
            return NAME;
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
        if (fieldName.equals(FLOWID)) {
            return COLUMN_NAME_FLOWID;
        }
        if (fieldName.equals(TYPE)) {
            return COLUMN_NAME_TYPE;
        }
        if (fieldName.equals(UNIT)) {
            return COLUMN_NAME_UNIT;
        }
        if (fieldName.equals(QUANTITY)) {
            return COLUMN_NAME_QUANTITY;
        }
        if (fieldName.equals(NAME)) {
            return COLUMN_NAME_NAME;
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
        if (fieldName.equals(FLOWID)) {
            return COLUMN_NAME_FLOWID.replace("`", "");
        }
        if (fieldName.equals(TYPE)) {
            return COLUMN_NAME_TYPE.replace("`", "");
        }
        if (fieldName.equals(UNIT)) {
            return COLUMN_NAME_UNIT.replace("`", "");
        }
        if (fieldName.equals(QUANTITY)) {
            return COLUMN_NAME_QUANTITY.replace("`", "");
        }
        if (fieldName.equals(NAME)) {
            return COLUMN_NAME_NAME.replace("`", "");
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
