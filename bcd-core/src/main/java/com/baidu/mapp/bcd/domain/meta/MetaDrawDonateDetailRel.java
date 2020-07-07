package com.baidu.mapp.bcd.domain.meta;

/*
@Results({
       @Result(property = "id", column = "id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT, id = true),
       @Result(property = "drawRecordId", column = "draw_record_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "donateDetailId", column = "donate_detail_id", javaType = java.lang.Long.class, jdbcType = JdbcType.BIGINT),
       @Result(property = "createTime", column = "create_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP),
       @Result(property = "lastModifyTime", column = "last_modify_time", javaType = java.util.Date.class, jdbcType = JdbcType.TIMESTAMP)
})
*/
public final class MetaDrawDonateDetailRel {

    /**
     * 领取和捐赠明细关系表
     */
    public static final String TABLE_NAME = "`t_draw_donate_detail_rel`";

    /**
     * 领取和捐赠明细关系ID
     */
    public static final String ID = "id";

    public static final String COLUMN_NAME_ID = "`id`";

    public static final String JAVA_TYPE_ID = "java.lang.Long";

    public static final String JDBC_TYPE_ID = "BIGINT";

    public static final String IS_KEY_ID = "true";

    /**
     * 领取记录ID
     */
    public static final String DRAWRECORDID = "drawRecordId";

    public static final String COLUMN_NAME_DRAWRECORDID = "`draw_record_id`";

    public static final String JAVA_TYPE_DRAWRECORDID = "java.lang.Long";

    public static final String JDBC_TYPE_DRAWRECORDID = "BIGINT";

    public static final String IS_KEY_DRAWRECORDID = "false";

    /**
     * 捐赠明细ID
     */
    public static final String DONATEDETAILID = "donateDetailId";

    public static final String COLUMN_NAME_DONATEDETAILID = "`donate_detail_id`";

    public static final String JAVA_TYPE_DONATEDETAILID = "java.lang.Long";

    public static final String JDBC_TYPE_DONATEDETAILID = "BIGINT";

    public static final String IS_KEY_DONATEDETAILID = "false";

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
        if (columnName.equals(COLUMN_NAME_DRAWRECORDID)) {
            return DRAWRECORDID;
        }
        if (columnName.equals(COLUMN_NAME_DONATEDETAILID)) {
            return DONATEDETAILID;
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
        if (fieldName.equals(DRAWRECORDID)) {
            return COLUMN_NAME_DRAWRECORDID;
        }
        if (fieldName.equals(DONATEDETAILID)) {
            return COLUMN_NAME_DONATEDETAILID;
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
        if (fieldName.equals(DRAWRECORDID)) {
            return COLUMN_NAME_DRAWRECORDID.replace("`", "");
        }
        if (fieldName.equals(DONATEDETAILID)) {
            return COLUMN_NAME_DONATEDETAILID.replace("`", "");
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