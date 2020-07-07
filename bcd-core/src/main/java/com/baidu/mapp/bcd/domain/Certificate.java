package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "Certificate", description = "链上证书记录")
public class Certificate implements Serializable {

    /**
     * column-name:id
     * 存证ID
     */
    @Schema(description = "存证ID")
    private Long id;

    /**
     * column-name:cert_code
     * 证书编码
     */
    @Schema(description = "证书编码")
    private String certCode;

    /**
     * column-name:cert_time
     * 证书日期
     */
    @Schema(description = "证书日期")
    private Date certTime;

    /**
     * column-name:source_table
     * 存证来源表名
     */
    @Schema(description = "存证来源表名")
    private String sourceTable;

    /**
     * column-name:source_id
     * 存证来源表ID
     */
    @Schema(description = "存证来源表ID")
    private Long sourceId;

    /**
     * column-name:create_time
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * column-name:last_modify_time
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Date lastModifyTime;

    /**
     * 链上证书记录
     */
    public Certificate() {
        
    }

    /**
     * 链上证书记录
     */
    private Certificate(XBuilder builder) {
        this.id = builder.id;
        this.certCode = builder.certCode;
        this.certTime = builder.certTime;
        this.sourceTable = builder.sourceTable;
        this.sourceId = builder.sourceId;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 存证ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 存证ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 证书编码
     */
    public String getCertCode() {
        return certCode;
    }

    /**
     * 证书编码
     */
    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    /**
     * 证书日期
     */
    public Date getCertTime() {
        return certTime;
    }

    /**
     * 证书日期
     */
    public void setCertTime(Date certTime) {
        this.certTime = certTime;
    }

    /**
     * 存证来源表名
     */
    public String getSourceTable() {
        return sourceTable;
    }

    /**
     * 存证来源表名
     */
    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable == null ? null : sourceTable.trim();
    }

    /**
     * 存证来源表ID
     */
    public Long getSourceId() {
        return sourceId;
    }

    /**
     * 存证来源表ID
     */
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 更新时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Certificate copyFrom(Certificate other) {
        this.id = other.id;
        this.certCode = other.certCode;
        this.certTime = other.certTime;
        this.sourceTable = other.sourceTable;
        this.sourceId = other.sourceId;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends Certificate> T copyFrom(Certificate from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setCertCode(from.certCode);
        to.setCertTime(from.certTime);
        to.setSourceTable(from.sourceTable);
        to.setSourceId(from.sourceId);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            certCode: '',
            certTime: '',
            sourceTable: '',
            sourceId: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"certCode\": \"\",\"certTime\": \"\",\"sourceTable\": \"\",\"sourceId\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", certCode=").append(certCode);
        sb.append(", certTime=").append(certTime);
        sb.append(", sourceTable=").append(sourceTable);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 存证ID
         */
        private Long id;

        /**
         * 证书编码
         */
        private String certCode;

        /**
         * 证书日期
         */
        private Date certTime;

        /**
         * 存证来源表名
         */
        private String sourceTable;

        /**
         * 存证来源表ID
         */
        private Long sourceId;

        /**
         * 创建时间
         */
        private Date createTime;

        /**
         * 更新时间
         */
        private Date lastModifyTime;

        private XBuilder() {
            
        }

        /**
         * 存证ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 证书编码
         */
        public XBuilder certCode(String certCode) {
            this.certCode = certCode;
            return this;
        }

        /**
         * 证书日期
         */
        public XBuilder certTime(Date certTime) {
            this.certTime = certTime;
            return this;
        }

        /**
         * 存证来源表名
         */
        public XBuilder sourceTable(String sourceTable) {
            this.sourceTable = sourceTable;
            return this;
        }

        /**
         * 存证来源表ID
         */
        public XBuilder sourceId(Long sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        /**
         * 创建时间
         */
        public XBuilder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        /**
         * 更新时间
         */
        public XBuilder lastModifyTime(Date lastModifyTime) {
            this.lastModifyTime = lastModifyTime;
            return this;
        }

        public Certificate build() {
            return new Certificate(this);
        }
    }
}