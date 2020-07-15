package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "adminUserName", column = "admin_user_name", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "adminPwd", column = "admin_pwd", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "adminName", column = "admin_name", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "loginToken", column = "login_token", javaType = java.lang.String.class, jdbcType = JdbcType.VARCHAR),
       @Result(property = "lastLoginTime", column = "last_login_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaAdmin {

    /**
     * 管理员
     */
    public static final String TABLE_NAME = "`t_admin`";

    /**
     * 管理员ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 管理员用户ID
     */
    public static final String ADMINUSERNAME = "adminUserName";

    public static final String COLUMN_NAME_ADMINUSERNAME = "`admin_user_name`";

    public static final String JAVA_TYPE_ADMINUSERNAME = "java.lang.String";

    public static final String JDBC_TYPE_ADMINUSERNAME = "VARCHAR";

    public static final String IS_KEY_ADMINUSERNAME = "false";

    /**
     * 管理员密码
     */
    public static final String ADMINPWD = "adminPwd";

    public static final String COLUMN_NAME_ADMINPWD = "`admin_pwd`";

    public static final String JAVA_TYPE_ADMINPWD = "java.lang.String";

    public static final String JDBC_TYPE_ADMINPWD = "VARCHAR";

    public static final String IS_KEY_ADMINPWD = "false";

    /**
     * 管理员名称
     */
    public static final String ADMINNAME = "adminName";

    public static final String COLUMN_NAME_ADMINNAME = "`admin_name`";

    public static final String JAVA_TYPE_ADMINNAME = "java.lang.String";

    public static final String JDBC_TYPE_ADMINNAME = "VARCHAR";

    public static final String IS_KEY_ADMINNAME = "false";

    /**
     * 登录token
     */
    public static final String LOGINTOKEN = "loginToken";

    public static final String COLUMN_NAME_LOGINTOKEN = "`login_token`";

    public static final String JAVA_TYPE_LOGINTOKEN = "java.lang.String";

    public static final String JDBC_TYPE_LOGINTOKEN = "VARCHAR";

    public static final String IS_KEY_LOGINTOKEN = "false";

    /**
     * 最后一次登录时间
     */
    public static final String LASTLOGINTIME = "lastLoginTime";

    public static final String COLUMN_NAME_LASTLOGINTIME = "`last_login_time`";

    public static final String JAVA_TYPE_LASTLOGINTIME = "java.util.Date";

    public static final String JDBC_TYPE_LASTLOGINTIME = "TIMESTAMP";

    public static final String IS_KEY_LASTLOGINTIME = "false";

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
        if (columnName.equals(COLUMN_NAME_ADMINUSERNAME)) {
            return ADMINUSERNAME;
        }
        if (columnName.equals(COLUMN_NAME_ADMINPWD)) {
            return ADMINPWD;
        }
        if (columnName.equals(COLUMN_NAME_ADMINNAME)) {
            return ADMINNAME;
        }
        if (columnName.equals(COLUMN_NAME_LOGINTOKEN)) {
            return LOGINTOKEN;
        }
        if (columnName.equals(COLUMN_NAME_LASTLOGINTIME)) {
            return LASTLOGINTIME;
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
        if (fieldName.equals(ADMINUSERNAME)) {
            return COLUMN_NAME_ADMINUSERNAME;
        }
        if (fieldName.equals(ADMINPWD)) {
            return COLUMN_NAME_ADMINPWD;
        }
        if (fieldName.equals(ADMINNAME)) {
            return COLUMN_NAME_ADMINNAME;
        }
        if (fieldName.equals(LOGINTOKEN)) {
            return COLUMN_NAME_LOGINTOKEN;
        }
        if (fieldName.equals(LASTLOGINTIME)) {
            return COLUMN_NAME_LASTLOGINTIME;
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
        if (fieldName.equals(ADMINUSERNAME)) {
            return COLUMN_NAME_ADMINUSERNAME.replace("`", "");
        }
        if (fieldName.equals(ADMINPWD)) {
            return COLUMN_NAME_ADMINPWD.replace("`", "");
        }
        if (fieldName.equals(ADMINNAME)) {
            return COLUMN_NAME_ADMINNAME.replace("`", "");
        }
        if (fieldName.equals(LOGINTOKEN)) {
            return COLUMN_NAME_LOGINTOKEN.replace("`", "");
        }
        if (fieldName.equals(LASTLOGINTIME)) {
            return COLUMN_NAME_LASTLOGINTIME.replace("`", "");
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