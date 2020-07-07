package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "Donor", description = "捐赠人")
public class Donor implements Serializable {

    /**
     * column-name:id
     * 捐赠人ID
     */
    @Schema(description = "捐赠人ID")
    private Long id;

    /**
     * column-name:donor_user_name
     * 捐赠人用户ID
     */
    @Schema(description = "捐赠人用户ID")
    private String donorUserName;

    /**
     * column-name:donor_pwd
     * 捐赠人密码
     */
    @Schema(description = "捐赠人密码")
    private String donorPwd;

    /**
     * column-name:donor_name
     * 捐赠人名称
     */
    @Schema(description = "捐赠人名称")
    private String donorName;

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
     * 捐赠人
     */
    public Donor() {
        
    }

    /**
     * 捐赠人
     */
    private Donor(XBuilder builder) {
        this.id = builder.id;
        this.donorUserName = builder.donorUserName;
        this.donorPwd = builder.donorPwd;
        this.donorName = builder.donorName;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 捐赠人ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 捐赠人ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 捐赠人用户ID
     */
    public String getDonorUserName() {
        return donorUserName;
    }

    /**
     * 捐赠人用户ID
     */
    public void setDonorUserName(String donorUserName) {
        this.donorUserName = donorUserName == null ? null : donorUserName.trim();
    }

    /**
     * 捐赠人密码
     */
    public String getDonorPwd() {
        return donorPwd;
    }

    /**
     * 捐赠人密码
     */
    public void setDonorPwd(String donorPwd) {
        this.donorPwd = donorPwd == null ? null : donorPwd.trim();
    }

    /**
     * 捐赠人名称
     */
    public String getDonorName() {
        return donorName;
    }

    /**
     * 捐赠人名称
     */
    public void setDonorName(String donorName) {
        this.donorName = donorName == null ? null : donorName.trim();
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

    public Donor copyFrom(Donor other) {
        this.id = other.id;
        this.donorUserName = other.donorUserName;
        this.donorPwd = other.donorPwd;
        this.donorName = other.donorName;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends Donor> T copyFrom(Donor from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setDonorUserName(from.donorUserName);
        to.setDonorPwd(from.donorPwd);
        to.setDonorName(from.donorName);
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
            donorUserName: '',
            donorPwd: '',
            donorName: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"donorUserName\": \"\",\"donorPwd\": \"\",\"donorName\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", donorUserName=").append(donorUserName);
        sb.append(", donorPwd=").append(donorPwd);
        sb.append(", donorName=").append(donorName);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 捐赠人ID
         */
        private Long id;

        /**
         * 捐赠人用户ID
         */
        private String donorUserName;

        /**
         * 捐赠人密码
         */
        private String donorPwd;

        /**
         * 捐赠人名称
         */
        private String donorName;

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
         * 捐赠人ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 捐赠人用户ID
         */
        public XBuilder donorUserName(String donorUserName) {
            this.donorUserName = donorUserName;
            return this;
        }

        /**
         * 捐赠人密码
         */
        public XBuilder donorPwd(String donorPwd) {
            this.donorPwd = donorPwd;
            return this;
        }

        /**
         * 捐赠人名称
         */
        public XBuilder donorName(String donorName) {
            this.donorName = donorName;
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

        public Donor build() {
            return new Donor(this);
        }
    }
}