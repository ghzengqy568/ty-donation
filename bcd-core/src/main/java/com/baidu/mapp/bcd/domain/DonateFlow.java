package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "DonateFlow", description = "捐赠流水")
public class DonateFlow implements Serializable {

    /**
     * column-name:id
     * 捐赠流水ID
     */
    @Schema(description = "捐赠流水ID")
    private Long id;

    /**
     * column-name:uuid
     * 多链ID身份
     */
    @Schema(description = "多链ID身份")
    private String uuid;

    /**
     * column-name:donor_uuid
     * 捐赠人ID
     */
    @Schema(description = "捐赠人ID")
    private String donorUuid;

    /**
     * column-name:donate_time
     * 捐赠时间
     */
    @Schema(description = "捐赠时间")
    private Date donateTime;

    /**
     * column-name:cert_code
     * 证书编码
     */
    @Schema(description = "证书编码")
    private String certCode;

    /**
     * column-name:sign
     * 存证签名
     */
    @Schema(description = "存证签名")
    private String sign;

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
     * 捐赠流水
     */
    public DonateFlow() {
        
    }

    /**
     * 捐赠流水
     */
    private DonateFlow(XBuilder builder) {
        this.id = builder.id;
        this.uuid = builder.uuid;
        this.donorUuid = builder.donorUuid;
        this.donateTime = builder.donateTime;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 捐赠流水ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 捐赠流水ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 多链ID身份
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 多链ID身份
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * 捐赠人ID
     */
    public String getDonorUuid() {
        return donorUuid;
    }

    /**
     * 捐赠人ID
     */
    public void setDonorUuid(String donorUuid) {
        this.donorUuid = donorUuid == null ? null : donorUuid.trim();
    }

    /**
     * 捐赠时间
     */
    public Date getDonateTime() {
        return donateTime;
    }

    /**
     * 捐赠时间
     */
    public void setDonateTime(Date donateTime) {
        this.donateTime = donateTime;
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
     * 存证签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 存证签名
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
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

    public DonateFlow copyFrom(DonateFlow other) {
        this.id = other.id;
        this.uuid = other.uuid;
        this.donorUuid = other.donorUuid;
        this.donateTime = other.donateTime;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends DonateFlow> T copyFrom(DonateFlow from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setUuid(from.uuid);
        to.setDonorUuid(from.donorUuid);
        to.setDonateTime(from.donateTime);
        to.setCertCode(from.certCode);
        to.setSign(from.sign);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            uuid: '',
            donorUuid: '',
            donateTime: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"uuid\": \"\",\"donorUuid\": \"\",\"donateTime\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", donorUuid=").append(donorUuid);
        sb.append(", donateTime=").append(donateTime);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 捐赠流水ID
         */
        private Long id;

        /**
         * 多链ID身份
         */
        private String uuid;

        /**
         * 捐赠人ID
         */
        private String donorUuid;

        /**
         * 捐赠时间
         */
        private Date donateTime;

        /**
         * 证书编码
         */
        private String certCode;

        /**
         * 存证签名
         */
        private String sign;

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
         * 捐赠流水ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 多链ID身份
         */
        public XBuilder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * 捐赠人ID
         */
        public XBuilder donorUuid(String donorUuid) {
            this.donorUuid = donorUuid;
            return this;
        }

        /**
         * 捐赠时间
         */
        public XBuilder donateTime(Date donateTime) {
            this.donateTime = donateTime;
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
         * 存证签名
         */
        public XBuilder sign(String sign) {
            this.sign = sign;
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

        public DonateFlow build() {
            return new DonateFlow(this);
        }
    }
}