package com.baidu.mapp.bcd.domain;

import java.io.Serializable;
import java.util.Date;

public class Assign implements Serializable {

    /**
     * column-name:id
     * 领取和捐赠明细关系ID
     */
    private Long id;

    /**
     * column-name:activity_id
     * 活动ID
     */
    private Long activityId;

    /**
     * column-name:activity_plan_id
     * 活动计划ID
     */
    private Long activityPlanId;

    /**
     * column-name:donatory_id
     * 受赠人ID
     */
    private Long donatoryId;

    /**
     * column-name:config_id
     * 计划配置ID
     */
    private Long configId;

    /**
     * column-name:donatory_level
     * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
     */
    private Byte donatoryLevel;

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
     * 指派关系表
     */
    public Assign() {
        
    }

    /**
     * 指派关系表
     */
    private Assign(XBuilder builder) {
        this.id = builder.id;
        this.activityId = builder.activityId;
        this.activityPlanId = builder.activityPlanId;
        this.donatoryId = builder.donatoryId;
        this.configId = builder.configId;
        this.donatoryLevel = builder.donatoryLevel;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 领取和捐赠明细关系ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 领取和捐赠明细关系ID
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
     * 计划配置ID
     */
    public Long getConfigId() {
        return configId;
    }

    /**
     * 计划配置ID
     */
    public void setConfigId(Long configId) {
        this.configId = configId;
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

    public Assign copyFrom(Assign other) {
        this.id = other.id;
        this.activityId = other.activityId;
        this.activityPlanId = other.activityPlanId;
        this.donatoryId = other.donatoryId;
        this.configId = other.configId;
        this.donatoryLevel = other.donatoryLevel;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends Assign> T copyFrom(Assign from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setActivityId(from.activityId);
        to.setActivityPlanId(from.activityPlanId);
        to.setDonatoryId(from.donatoryId);
        to.setConfigId(from.configId);
        to.setDonatoryLevel(from.donatoryLevel);
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
            donatoryId: '',
            configId: '',
            donatoryLevel: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"activityId\": \"\",\"activityPlanId\": \"\",\"donatoryId\": \"\",\"configId\": \"\",\"donatoryLevel\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
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
        sb.append(", donatoryId=").append(donatoryId);
        sb.append(", configId=").append(configId);
        sb.append(", donatoryLevel=").append(donatoryLevel);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 领取和捐赠明细关系ID
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
         * 受赠人ID
         */
        private Long donatoryId;

        /**
         * 计划配置ID
         */
        private Long configId;

        /**
         * 受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入
         */
        private Byte donatoryLevel;

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
         * 领取和捐赠明细关系ID
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
         * 受赠人ID
         */
        public XBuilder donatoryId(Long donatoryId) {
            this.donatoryId = donatoryId;
            return this;
        }

        /**
         * 计划配置ID
         */
        public XBuilder configId(Long configId) {
            this.configId = configId;
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

        public Assign build() {
            return new Assign(this);
        }
    }
}