package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "ActivityPlan", description = "活动计划")
public class ActivityPlan implements Serializable {

    /**
     * column-name:id
     * 计划ID
     */
    @Schema(description = "计划ID")
    private Long id;

    /**
     * column-name:activity_id
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long activityId;

    /**
     * column-name:description
     * 计划描述
     */
    @Schema(description = "计划描述")
    private String description;

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
     * column-name:amount
     * 总价
     */
    @Schema(description = "总价")
    private Long amount;

    /**
     * column-name:need_purchase
     * 是否需要采购
     */
    @Schema(description = "是否需要采购")
    private Byte needPurchase;

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
     * 活动计划
     */
    public ActivityPlan() {
        
    }

    /**
     * 活动计划
     */
    private ActivityPlan(XBuilder builder) {
        this.id = builder.id;
        this.activityId = builder.activityId;
        this.description = builder.description;
        this.type = builder.type;
        this.unit = builder.unit;
        this.quantity = builder.quantity;
        this.name = builder.name;
        this.amount = builder.amount;
        this.needPurchase = builder.needPurchase;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 计划ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 计划ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 活动ID
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * 活动ID
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 计划描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 计划描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * 总价
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 总价
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 是否需要采购
     */
    public Byte getNeedPurchase() {
        return needPurchase;
    }

    /**
     * 是否需要采购
     */
    public void setNeedPurchase(Byte needPurchase) {
        this.needPurchase = needPurchase;
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

    public ActivityPlan copyFrom(ActivityPlan other) {
        this.id = other.id;
        this.activityId = other.activityId;
        this.description = other.description;
        this.type = other.type;
        this.unit = other.unit;
        this.quantity = other.quantity;
        this.name = other.name;
        this.amount = other.amount;
        this.needPurchase = other.needPurchase;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends ActivityPlan> T copyFrom(ActivityPlan from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setActivityId(from.activityId);
        to.setDescription(from.description);
        to.setType(from.type);
        to.setUnit(from.unit);
        to.setQuantity(from.quantity);
        to.setName(from.name);
        to.setAmount(from.amount);
        to.setNeedPurchase(from.needPurchase);
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
            activityId: '',
            description: '',
            type: '',
            unit: '',
            quantity: '',
            name: '',
            amount: '',
            needPurchase: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"activityId\": \"\",\"description\": \"\",\"type\": \"\",\"unit\": \"\",\"quantity\": \"\",\"name\": \"\",\"amount\": \"\",\"needPurchase\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", description=").append(description);
        sb.append(", type=").append(type);
        sb.append(", unit=").append(unit);
        sb.append(", quantity=").append(quantity);
        sb.append(", name=").append(name);
        sb.append(", amount=").append(amount);
        sb.append(", needPurchase=").append(needPurchase);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 计划ID
         */
        private Long id;

        /**
         * 活动ID
         */
        private Long activityId;

        /**
         * 计划描述
         */
        private String description;

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
         * 总价
         */
        private Long amount;

        /**
         * 是否需要采购
         */
        private Byte needPurchase;

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
         * 计划ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 活动ID
         */
        public XBuilder activityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }

        /**
         * 计划描述
         */
        public XBuilder description(String description) {
            this.description = description;
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
         * 总价
         */
        public XBuilder amount(Long amount) {
            this.amount = amount;
            return this;
        }

        /**
         * 是否需要采购
         */
        public XBuilder needPurchase(Byte needPurchase) {
            this.needPurchase = needPurchase;
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

        public ActivityPlan build() {
            return new ActivityPlan(this);
        }
    }
}