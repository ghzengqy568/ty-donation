package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "DonateDetail", description = "捐赠明细")
public class DonateDetail implements Serializable {

    /**
     * column-name:id
     * 捐赠明细ID
     */
    @Schema(description = "捐赠明细ID")
    private Long id;

    /**
     * column-name:flow_id
     * 捐赠流水ID
     */
    @Schema(description = "捐赠流水ID")
    private Long flowId;

    /**
     * column-name:type
     * 捐赠类别, 1-钱，2-物
     */
    @Schema(description = "捐赠类别, 1-钱，2-物")
    private Byte type;

    /**
     * column-name:unit
     * 单位
     */
    @Schema(description = "单位")
    private String unit;

    /**
     * column-name:quantity
     * 数量
     */
    @Schema(description = "数量")
    private Long quantity;

    /**
     * column-name:name
     * 物资名称
     */
    @Schema(description = "物资名称")
    private String name;

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
     * column-name:balance
     * 余额
     */
    @Schema(description = "余额")
    private Long balance;

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
     * 捐赠明细
     */
    public DonateDetail() {
        
    }

    /**
     * 捐赠明细
     */
    private DonateDetail(XBuilder builder) {
        this.id = builder.id;
        this.flowId = builder.flowId;
        this.type = builder.type;
        this.unit = builder.unit;
        this.quantity = builder.quantity;
        this.name = builder.name;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.balance = builder.balance;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 捐赠明细ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 捐赠明细ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 捐赠流水ID
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * 捐赠流水ID
     */
    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    /**
     * 捐赠类别, 1-钱，2-物
     */
    public Byte getType() {
        return type;
    }

    /**
     * 捐赠类别, 1-钱，2-物
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 数量
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * 数量
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * 物资名称
     */
    public String getName() {
        return name;
    }

    /**
     * 物资名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public DonateDetail copyFrom(DonateDetail other) {
        this.id = other.id;
        this.flowId = other.flowId;
        this.type = other.type;
        this.unit = other.unit;
        this.quantity = other.quantity;
        this.name = other.name;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.balance = other.balance;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends DonateDetail> T copyFrom(DonateDetail from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setFlowId(from.flowId);
        to.setType(from.type);
        to.setUnit(from.unit);
        to.setQuantity(from.quantity);
        to.setName(from.name);
        to.setCertCode(from.certCode);
        to.setSign(from.sign);
        to.setBalance(from.balance);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            flowId: '',
            type: '',
            unit: '',
            quantity: '',
            name: '',
            certCode: '',
            sign: '',
            balance: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"flowId\": \"\",\"type\": \"\",\"unit\": \"\",\"quantity\": \"\",\"name\": \"\",\"certCode\": \"\",\"sign\": \"\",\"balance\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", flowId=").append(flowId);
        sb.append(", type=").append(type);
        sb.append(", unit=").append(unit);
        sb.append(", quantity=").append(quantity);
        sb.append(", name=").append(name);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", balance=").append(balance);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 捐赠明细ID
         */
        private Long id;

        /**
         * 捐赠流水ID
         */
        private Long flowId;

        /**
         * 捐赠类别, 1-钱，2-物
         */
        private Byte type;

        /**
         * 单位
         */
        private String unit;

        /**
         * 数量
         */
        private Long quantity;

        /**
         * 物资名称
         */
        private String name;

        /**
         * 证书编码
         */
        private String certCode;

        /**
         * 存证签名
         */
        private String sign;

        /**
         * 余额
         */
        private Long balance;

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
         * 捐赠明细ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 捐赠流水ID
         */
        public XBuilder flowId(Long flowId) {
            this.flowId = flowId;
            return this;
        }

        /**
         * 捐赠类别, 1-钱，2-物
         */
        public XBuilder type(Byte type) {
            this.type = type;
            return this;
        }

        /**
         * 单位
         */
        public XBuilder unit(String unit) {
            this.unit = unit;
            return this;
        }

        /**
         * 数量
         */
        public XBuilder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * 物资名称
         */
        public XBuilder name(String name) {
            this.name = name;
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
         * 余额
         */
        public XBuilder balance(Long balance) {
            this.balance = balance;
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

        public DonateDetail build() {
            return new DonateDetail(this);
        }
    }
}