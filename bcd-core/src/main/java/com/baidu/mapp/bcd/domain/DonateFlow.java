package com.baidu.mapp.bcd.domain;

import java.io.Serializable;
import java.util.Date;

public class DonateFlow implements Serializable {

    /**
     * column-name:id
     * 捐赠流水ID
     */
    private Long id;

    /**
     * column-name:donor_id
     * 捐赠人ID
     */
    private Long donorId;

    /**
     * column-name:donate_time
     * 捐赠时间
     */
    private Date donateTime;

    /**
     * column-name:is_anonymous
     * 是否需要匿名捐赠,1-是,0-否
     */
    private Byte isAnonymous;

    /**
     * column-name:anonymity
     * 捐赠人隐匿名称
     */
    private String anonymity;

    /**
     * column-name:cert_code
     * 证书编码
     */
    private String certCode;

    /**
     * column-name:sign
     * 存证签名
     */
    private String sign;

    /**
     * column-name:create_time
     * 创建时间
     */
    private Date createTime;

    /**
     * column-name:last_modify_time
     * 更新时间
     */
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
        this.donorId = builder.donorId;
        this.donateTime = builder.donateTime;
        this.isAnonymous = builder.isAnonymous;
        this.anonymity = builder.anonymity;
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
     * 捐赠人ID
     */
    public Long getDonorId() {
        return donorId;
    }

    /**
     * 捐赠人ID
     */
    public void setDonorId(Long donorId) {
        this.donorId = donorId;
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
     * 是否需要匿名捐赠,1-是,0-否
     */
    public Byte getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 是否需要匿名捐赠,1-是,0-否
     */
    public void setIsAnonymous(Byte isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 捐赠人隐匿名称
     */
    public String getAnonymity() {
        return anonymity;
    }

    /**
     * 捐赠人隐匿名称
     */
    public void setAnonymity(String anonymity) {
        this.anonymity = anonymity == null ? null : anonymity.trim();
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
        this.donorId = other.donorId;
        this.donateTime = other.donateTime;
        this.isAnonymous = other.isAnonymous;
        this.anonymity = other.anonymity;
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
        to.setDonorId(from.donorId);
        to.setDonateTime(from.donateTime);
        to.setIsAnonymous(from.isAnonymous);
        to.setAnonymity(from.anonymity);
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
            donorId: '',
            donateTime: '',
            isAnonymous: '',
            anonymity: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"donorId\": \"\",\"donateTime\": \"\",\"isAnonymous\": \"\",\"anonymity\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", donorId=").append(donorId);
        sb.append(", donateTime=").append(donateTime);
        sb.append(", isAnonymous=").append(isAnonymous);
        sb.append(", anonymity=").append(anonymity);
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
         * 捐赠人ID
         */
        private Long donorId;

        /**
         * 捐赠时间
         */
        private Date donateTime;

        /**
         * 是否需要匿名捐赠,1-是,0-否
         */
        private Byte isAnonymous;

        /**
         * 捐赠人隐匿名称
         */
        private String anonymity;

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
         * 捐赠人ID
         */
        public XBuilder donorId(Long donorId) {
            this.donorId = donorId;
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
         * 是否需要匿名捐赠,1-是,0-否
         */
        public XBuilder isAnonymous(Byte isAnonymous) {
            this.isAnonymous = isAnonymous;
            return this;
        }

        /**
         * 捐赠人隐匿名称
         */
        public XBuilder anonymity(String anonymity) {
            this.anonymity = anonymity;
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