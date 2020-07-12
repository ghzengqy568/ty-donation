package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "ActivityPlanConfig", description = "项目计划配置表")
public class ActivityPlanConfig implements Serializable {

    /**
     * column-name:id
     * 计划配置ID
     */
    @Schema(description = "计划配置ID")
    private Long id;

    /**
     * column-name:activity_id
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long activityId;

    /**
     * column-name:activity_plan_id
     * 活动计划ID
     */
    @Schema(description = "活动计划ID")
    private Long activityPlanId;

    /**
     * column-name:donatory_level
     * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
     */
    @Schema(description = "受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入")
    private Byte donatoryLevel;

    /**
     * column-name:quantity
     * 同等级受捐人受捐数量
     */
    @Schema(description = "同等级受捐人受捐数量")
    private Long quantity;

    /**
     * column-name:amount
     * 份数
     */
    @Schema(description = "份数")
    private Integer amount;

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
     * 项目计划配置表
     */
    public ActivityPlanConfig() {
        
    }

    /**
     * 项目计划配置表
     */
    private ActivityPlanConfig(XBuilder builder) {
        this.id = builder.id;
        this.activityId = builder.activityId;
        this.activityPlanId = builder.activityPlanId;
        this.donatoryLevel = builder.donatoryLevel;
        this.quantity = builder.quantity;
        this.amount = builder.amount;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 计划配置ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 计划配置ID
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
     * 活动计划ID
     */
    public Long getActivityPlanId() {
        return activityPlanId;
    }

    /**
     * 活动计划ID
     */
    public void setActivityPlanId(Long activityPlanId) {
        this.activityPlanId = activityPlanId;
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
     * 同等级受捐人受捐数量
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * 同等级受捐人受捐数量
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * 份数
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 份数
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public ActivityPlanConfig copyFrom(ActivityPlanConfig other) {
        this.id = other.id;
        this.activityId = other.activityId;
        this.activityPlanId = other.activityPlanId;
        this.donatoryLevel = other.donatoryLevel;
        this.quantity = other.quantity;
        this.amount = other.amount;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends ActivityPlanConfig> T copyFrom(ActivityPlanConfig from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setActivityId(from.activityId);
        to.setActivityPlanId(from.activityPlanId);
        to.setDonatoryLevel(from.donatoryLevel);
        to.setQuantity(from.quantity);
        to.setAmount(from.amount);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            activityId: '',
            activityPlanId: '',
            donatoryLevel: '',
            quantity: '',
            amount: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"activityId\": \"\",\"activityPlanId\": \"\",\"donatoryLevel\": \"\",\"quantity\": \"\",\"amount\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityId=").append(activityId);
        sb.append(", activityPlanId=").append(activityPlanId);
        sb.append(", donatoryLevel=").append(donatoryLevel);
        sb.append(", quantity=").append(quantity);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 计划配置ID
         */
        private Long id;

        /**
         * 活动ID
         */
        private Long activityId;

        /**
         * 活动计划ID
         */
        private Long activityPlanId;

        /**
         * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
         */
        private Byte donatoryLevel;

        /**
         * 同等级受捐人受捐数量
         */
        private Long quantity;

        /**
         * 份数
         */
        private Integer amount;

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
         * 计划配置ID
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
         * 活动计划ID
         */
        public XBuilder activityPlanId(Long activityPlanId) {
            this.activityPlanId = activityPlanId;
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
         * 同等级受捐人受捐数量
         */
        public XBuilder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * 份数
         */
        public XBuilder amount(Integer amount) {
            this.amount = amount;
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

        public ActivityPlanConfig build() {
            return new ActivityPlanConfig(this);
        }
    }
}