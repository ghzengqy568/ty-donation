package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "DrawRecord", description = "领取记录")
public class DrawRecord implements Serializable {

    /**
     * column-name:id
     * 领取记录ID
     */
    @Schema(description = "领取记录ID")
    private Long id;

    /**
     * column-name:activity_id
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long activityId;

    /**
     * column-name:donatory_id
     * 受赠人ID
     */
    @Schema(description = "受赠人ID")
    private Long donatoryId;

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
     * 领取记录
     */
    public DrawRecord() {
        
    }

    /**
     * 领取记录
     */
    private DrawRecord(XBuilder builder) {
        this.id = builder.id;
        this.activityId = builder.activityId;
        this.donatoryId = builder.donatoryId;
        this.type = builder.type;
        this.unit = builder.unit;
        this.quantity = builder.quantity;
        this.name = builder.name;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 领取记录ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 领取记录ID
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
     * 受赠人ID
     */
    public Long getDonatoryId() {
        return donatoryId;
    }

    /**
     * 受赠人ID
     */
    public void setDonatoryId(Long donatoryId) {
        this.donatoryId = donatoryId;
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

    public DrawRecord copyFrom(DrawRecord other) {
        this.id = other.id;
        this.activityId = other.activityId;
        this.donatoryId = other.donatoryId;
        this.type = other.type;
        this.unit = other.unit;
        this.quantity = other.quantity;
        this.name = other.name;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends DrawRecord> T copyFrom(DrawRecord from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setActivityId(from.activityId);
        to.setDonatoryId(from.donatoryId);
        to.setType(from.type);
        to.setUnit(from.unit);
        to.setQuantity(from.quantity);
        to.setName(from.name);
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
            donatoryId: '',
            type: '',
            unit: '',
            quantity: '',
            name: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"activityId\": \"\",\"donatoryId\": \"\",\"type\": \"\",\"unit\": \"\",\"quantity\": \"\",\"name\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", donatoryId=").append(donatoryId);
        sb.append(", type=").append(type);
        sb.append(", unit=").append(unit);
        sb.append(", quantity=").append(quantity);
        sb.append(", name=").append(name);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 领取记录ID
         */
        private Long id;

        /**
         * 活动ID
         */
        private Long activityId;

        /**
         * 受赠人ID
         */
        private Long donatoryId;

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
         * 领取记录ID
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
         * 受赠人ID
         */
        public XBuilder donatoryId(Long donatoryId) {
            this.donatoryId = donatoryId;
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

        public DrawRecord build() {
            return new DrawRecord(this);
        }
    }
}