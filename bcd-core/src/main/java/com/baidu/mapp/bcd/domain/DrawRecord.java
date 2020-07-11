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
     * column-name:uuid
     * 多链ID身份
     */
    @Schema(description = "多链ID身份")
    private String uuid;

    /**
     * column-name:activity_uuid
     * 活动ID
     */
    @Schema(description = "活动ID")
    private String activityUuid;

    /**
     * column-name:donatory_uuid
     * 受赠人ID
     */
    @Schema(description = "受赠人ID")
    private String donatoryUuid;

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
        this.uuid = builder.uuid;
        this.activityUuid = builder.activityUuid;
        this.donatoryUuid = builder.donatoryUuid;
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
     * 活动ID
     */
    public String getActivityUuid() {
        return activityUuid;
    }

    /**
     * 活动ID
     */
    public void setActivityUuid(String activityUuid) {
        this.activityUuid = activityUuid == null ? null : activityUuid.trim();
    }

    /**
     * 受赠人ID
     */
    public String getDonatoryUuid() {
        return donatoryUuid;
    }

    /**
     * 受赠人ID
     */
    public void setDonatoryUuid(String donatoryUuid) {
        this.donatoryUuid = donatoryUuid == null ? null : donatoryUuid.trim();
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
        this.uuid = other.uuid;
        this.activityUuid = other.activityUuid;
        this.donatoryUuid = other.donatoryUuid;
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
        to.setUuid(from.uuid);
        to.setActivityUuid(from.activityUuid);
        to.setDonatoryUuid(from.donatoryUuid);
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
            uuid: '',
            activityUuid: '',
            donatoryUuid: '',
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
        
        return "{\"id\": \"\",\"uuid\": \"\",\"activityUuid\": \"\",\"donatoryUuid\": \"\",\"type\": \"\",\"unit\": \"\",\"quantity\": \"\",\"name\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", activityUuid=").append(activityUuid);
        sb.append(", donatoryUuid=").append(donatoryUuid);
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
         * 多链ID身份
         */
        private String uuid;

        /**
         * 活动ID
         */
        private String activityUuid;

        /**
         * 受赠人ID
         */
        private String donatoryUuid;

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
         * 多链ID身份
         */
        public XBuilder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        /**
         * 活动ID
         */
        public XBuilder activityUuid(String activityUuid) {
            this.activityUuid = activityUuid;
            return this;
        }

        /**
         * 受赠人ID
         */
        public XBuilder donatoryUuid(String donatoryUuid) {
            this.donatoryUuid = donatoryUuid;
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