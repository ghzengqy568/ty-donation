package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "Allocation", description = "拨款记录")
public class Allocation implements Serializable {

    /**
     * column-name:id
     * 拨款记录ID
     */
    @Schema(description = "拨款记录ID")
    private Long id;

    /**
     * column-name:uuid
     * 多链ID身份
     */
    @Schema(description = "多链ID身份")
    private String uuid;

    /**
     * column-name:donate_detail_uuid
     * 捐款明细ID
     */
    @Schema(description = "捐款明细ID")
    private String donateDetailUuid;

    /**
     * column-name:used
     * 用量
     */
    @Schema(description = "用量")
    private Long used;

    /**
     * column-name:balance
     * 余额
     */
    @Schema(description = "余额")
    private Long balance;

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
     * 拨款记录
     */
    public Allocation() {
        
    }

    /**
     * 拨款记录
     */
    private Allocation(XBuilder builder) {
        this.id = builder.id;
        this.uuid = builder.uuid;
        this.donateDetailUuid = builder.donateDetailUuid;
        this.used = builder.used;
        this.balance = builder.balance;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 拨款记录ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 拨款记录ID
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
     * 捐款明细ID
     */
    public String getDonateDetailUuid() {
        return donateDetailUuid;
    }

    /**
     * 捐款明细ID
     */
    public void setDonateDetailUuid(String donateDetailUuid) {
        this.donateDetailUuid = donateDetailUuid == null ? null : donateDetailUuid.trim();
    }

    /**
     * 用量
     */
    public Long getUsed() {
        return used;
    }

    /**
     * 用量
     */
    public void setUsed(Long used) {
        this.used = used;
    }

    /**
     * 余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
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

    public Allocation copyFrom(Allocation other) {
        this.id = other.id;
        this.uuid = other.uuid;
        this.donateDetailUuid = other.donateDetailUuid;
        this.used = other.used;
        this.balance = other.balance;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends Allocation> T copyFrom(Allocation from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setUuid(from.uuid);
        to.setDonateDetailUuid(from.donateDetailUuid);
        to.setUsed(from.used);
        to.setBalance(from.balance);
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
            donateDetailUuid: '',
            used: '',
            balance: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"uuid\": \"\",\"donateDetailUuid\": \"\",\"used\": \"\",\"balance\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", donateDetailUuid=").append(donateDetailUuid);
        sb.append(", used=").append(used);
        sb.append(", balance=").append(balance);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 拨款记录ID
         */
        private Long id;

        /**
         * 多链ID身份
         */
        private String uuid;

        /**
         * 捐款明细ID
         */
        private String donateDetailUuid;

        /**
         * 用量
         */
        private Long used;

        /**
         * 余额
         */
        private Long balance;

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
         * 拨款记录ID
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
         * 捐款明细ID
         */
        public XBuilder donateDetailUuid(String donateDetailUuid) {
            this.donateDetailUuid = donateDetailUuid;
            return this;
        }

        /**
         * 用量
         */
        public XBuilder used(Long used) {
            this.used = used;
            return this;
        }

        /**
         * 余额
         */
        public XBuilder balance(Long balance) {
            this.balance = balance;
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

        public Allocation build() {
            return new Allocation(this);
        }
    }
}