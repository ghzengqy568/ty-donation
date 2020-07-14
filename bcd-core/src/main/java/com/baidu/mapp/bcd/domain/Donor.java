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
     * column-name:idcard
     * 身份证号码，加密存储
     */
    @Schema(description = "身份证号码，加密存储")
    private String idcard;

    /**
     * column-name:mobile
     * 手机号，加密存储
     */
    @Schema(description = "手机号，加密存储")
    private String mobile;

    /**
     * column-name:province
     * 省份
     */
    @Schema(description = "省份")
    private String province;

    /**
     * column-name:city
     * 城市
     */
    @Schema(description = "城市")
    private String city;

    /**
     * column-name:address
     * 地址
     */
    @Schema(description = "地址")
    private String address;

    /**
     * column-name:login_token
     * 登录token
     */
    @Schema(description = "登录token")
    private String loginToken;

    /**
     * column-name:last_login_time
     * 最后一次登录时间
     */
    @Schema(description = "最后一次登录时间")
    private Date lastLoginTime;

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
        this.idcard = builder.idcard;
        this.mobile = builder.mobile;
        this.province = builder.province;
        this.city = builder.city;
        this.address = builder.address;
        this.loginToken = builder.loginToken;
        this.lastLoginTime = builder.lastLoginTime;
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
     * 身份证号码，加密存储
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证号码，加密存储
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 手机号，加密存储
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号，加密存储
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 登录token
     */
    public String getLoginToken() {
        return loginToken;
    }

    /**
     * 登录token
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken == null ? null : loginToken.trim();
    }

    /**
     * 最后一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
        this.idcard = other.idcard;
        this.mobile = other.mobile;
        this.province = other.province;
        this.city = other.city;
        this.address = other.address;
        this.loginToken = other.loginToken;
        this.lastLoginTime = other.lastLoginTime;
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
        to.setIdcard(from.idcard);
        to.setMobile(from.mobile);
        to.setProvince(from.province);
        to.setCity(from.city);
        to.setAddress(from.address);
        to.setLoginToken(from.loginToken);
        to.setLastLoginTime(from.lastLoginTime);
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
            idcard: '',
            mobile: '',
            province: '',
            city: '',
            address: '',
            loginToken: '',
            lastLoginTime: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"donorUserName\": \"\",\"donorPwd\": \"\",\"donorName\": \"\",\"certCode\": \"\",\"sign\": \"\",\"idcard\": \"\",\"mobile\": \"\",\"province\": \"\",\"city\": \"\",\"address\": \"\",\"loginToken\": \"\",\"lastLoginTime\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
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
        sb.append(", idcard=").append(idcard);
        sb.append(", mobile=").append(mobile);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", address=").append(address);
        sb.append(", loginToken=").append(loginToken);
        sb.append(", lastLoginTime=").append(lastLoginTime);
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
         * 身份证号码，加密存储
         */
        private String idcard;

        /**
         * 手机号，加密存储
         */
        private String mobile;

        /**
         * 省份
         */
        private String province;

        /**
         * 城市
         */
        private String city;

        /**
         * 地址
         */
        private String address;

        /**
         * 登录token
         */
        private String loginToken;

        /**
         * 最后一次登录时间
         */
        private Date lastLoginTime;

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
         * 身份证号码，加密存储
         */
        public XBuilder idcard(String idcard) {
            this.idcard = idcard;
            return this;
        }

        /**
         * 手机号，加密存储
         */
        public XBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        /**
         * 省份
         */
        public XBuilder province(String province) {
            this.province = province;
            return this;
        }

        /**
         * 城市
         */
        public XBuilder city(String city) {
            this.city = city;
            return this;
        }

        /**
         * 地址
         */
        public XBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * 登录token
         */
        public XBuilder loginToken(String loginToken) {
            this.loginToken = loginToken;
            return this;
        }

        /**
         * 最后一次登录时间
         */
        public XBuilder lastLoginTime(Date lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
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