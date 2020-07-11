package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "Donatory", description = "受赠人")
public class Donatory implements Serializable {

    /**
     * column-name:id
     * 受赠人ID
     */
    @Schema(description = "受赠人ID")
    private Long id;

    /**
     * column-name:donatory_user_name
     * 受赠人用户ID
     */
    @Schema(description = "受赠人用户ID")
    private String donatoryUserName;

    /**
     * column-name:donatory_pwd
     * 受赠人密码
     */
    @Schema(description = "受赠人密码")
    private String donatoryPwd;

    /**
     * column-name:donatory_name
     * 受赠人名称
     */
    @Schema(description = "受赠人名称")
    private String donatoryName;

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
     * column-name:donatory_card
     * 受赠人社保卡，加密存储
     */
    @Schema(description = "受赠人社保卡，加密存储")
    private String donatoryCard;

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
     * column-name:donatory_level
     * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
     */
    @Schema(description = "受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入")
    private Byte donatoryLevel;

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
     * 受赠人
     */
    public Donatory() {
        
    }

    /**
     * 受赠人
     */
    private Donatory(XBuilder builder) {
        this.id = builder.id;
        this.donatoryUserName = builder.donatoryUserName;
        this.donatoryPwd = builder.donatoryPwd;
        this.donatoryName = builder.donatoryName;
        this.idcard = builder.idcard;
        this.mobile = builder.mobile;
        this.donatoryCard = builder.donatoryCard;
        this.province = builder.province;
        this.city = builder.city;
        this.address = builder.address;
        this.donatoryLevel = builder.donatoryLevel;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 受赠人ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 受赠人ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 受赠人用户ID
     */
    public String getDonatoryUserName() {
        return donatoryUserName;
    }

    /**
     * 受赠人用户ID
     */
    public void setDonatoryUserName(String donatoryUserName) {
        this.donatoryUserName = donatoryUserName == null ? null : donatoryUserName.trim();
    }

    /**
     * 受赠人密码
     */
    public String getDonatoryPwd() {
        return donatoryPwd;
    }

    /**
     * 受赠人密码
     */
    public void setDonatoryPwd(String donatoryPwd) {
        this.donatoryPwd = donatoryPwd == null ? null : donatoryPwd.trim();
    }

    /**
     * 受赠人名称
     */
    public String getDonatoryName() {
        return donatoryName;
    }

    /**
     * 受赠人名称
     */
    public void setDonatoryName(String donatoryName) {
        this.donatoryName = donatoryName == null ? null : donatoryName.trim();
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
     * 受赠人社保卡，加密存储
     */
    public String getDonatoryCard() {
        return donatoryCard;
    }

    /**
     * 受赠人社保卡，加密存储
     */
    public void setDonatoryCard(String donatoryCard) {
        this.donatoryCard = donatoryCard == null ? null : donatoryCard.trim();
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
     * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
     */
    public Byte getDonatoryLevel() {
        return donatoryLevel;
    }

    /**
     * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
     */
    public void setDonatoryLevel(Byte donatoryLevel) {
        this.donatoryLevel = donatoryLevel;
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

    public Donatory copyFrom(Donatory other) {
        this.id = other.id;
        this.donatoryUserName = other.donatoryUserName;
        this.donatoryPwd = other.donatoryPwd;
        this.donatoryName = other.donatoryName;
        this.idcard = other.idcard;
        this.mobile = other.mobile;
        this.donatoryCard = other.donatoryCard;
        this.province = other.province;
        this.city = other.city;
        this.address = other.address;
        this.donatoryLevel = other.donatoryLevel;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends Donatory> T copyFrom(Donatory from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setDonatoryUserName(from.donatoryUserName);
        to.setDonatoryPwd(from.donatoryPwd);
        to.setDonatoryName(from.donatoryName);
        to.setIdcard(from.idcard);
        to.setMobile(from.mobile);
        to.setDonatoryCard(from.donatoryCard);
        to.setProvince(from.province);
        to.setCity(from.city);
        to.setAddress(from.address);
        to.setDonatoryLevel(from.donatoryLevel);
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
            donatoryUserName: '',
            donatoryPwd: '',
            donatoryName: '',
            idcard: '',
            mobile: '',
            donatoryCard: '',
            province: '',
            city: '',
            address: '',
            donatoryLevel: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"donatoryUserName\": \"\",\"donatoryPwd\": \"\",\"donatoryName\": \"\",\"idcard\": \"\",\"mobile\": \"\",\"donatoryCard\": \"\",\"province\": \"\",\"city\": \"\",\"address\": \"\",\"donatoryLevel\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", donatoryUserName=").append(donatoryUserName);
        sb.append(", donatoryPwd=").append(donatoryPwd);
        sb.append(", donatoryName=").append(donatoryName);
        sb.append(", idcard=").append(idcard);
        sb.append(", mobile=").append(mobile);
        sb.append(", donatoryCard=").append(donatoryCard);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", address=").append(address);
        sb.append(", donatoryLevel=").append(donatoryLevel);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 受赠人ID
         */
        private Long id;

        /**
         * 受赠人用户ID
         */
        private String donatoryUserName;

        /**
         * 受赠人密码
         */
        private String donatoryPwd;

        /**
         * 受赠人名称
         */
        private String donatoryName;

        /**
         * 身份证号码，加密存储
         */
        private String idcard;

        /**
         * 手机号，加密存储
         */
        private String mobile;

        /**
         * 受赠人社保卡，加密存储
         */
        private String donatoryCard;

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
         * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
         */
        private Byte donatoryLevel;

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
         * 受赠人ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 受赠人用户ID
         */
        public XBuilder donatoryUserName(String donatoryUserName) {
            this.donatoryUserName = donatoryUserName;
            return this;
        }

        /**
         * 受赠人密码
         */
        public XBuilder donatoryPwd(String donatoryPwd) {
            this.donatoryPwd = donatoryPwd;
            return this;
        }

        /**
         * 受赠人名称
         */
        public XBuilder donatoryName(String donatoryName) {
            this.donatoryName = donatoryName;
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
         * 受赠人社保卡，加密存储
         */
        public XBuilder donatoryCard(String donatoryCard) {
            this.donatoryCard = donatoryCard;
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
         * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
         */
        public XBuilder donatoryLevel(Byte donatoryLevel) {
            this.donatoryLevel = donatoryLevel;
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

        public Donatory build() {
            return new Donatory(this);
        }
    }
}