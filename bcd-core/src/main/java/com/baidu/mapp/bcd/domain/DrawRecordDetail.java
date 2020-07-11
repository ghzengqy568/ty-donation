package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

@Schema(name = "DrawRecordDetail", description = "领取分配记录")
public class DrawRecordDetail implements Serializable {

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
     * column-name:activity_plan_id
     * 活动计划ID
     */
    @Schema(description = "活动计划ID")
    private Long activityPlanId;

    /**
     * column-name:allocation_id
     * 拨款记录ID
     */
    @Schema(description = "拨款记录ID")
    private Long allocationId;

    /**
     * column-name:used
     * 用量
     */
    @Schema(description = "用量")
    private Long used;

    /**
     * column-name:donatory_id
     * 受赠人ID
     */
    @Schema(description = "受赠人ID")
    private Long donatoryId;

    /**
     * 领取分配记录
     */
    public DrawRecordDetail() {
        
    }

    /**
     * 领取分配记录
     */
    private DrawRecordDetail(XBuilder builder) {
        this.id = builder.id;
        this.activityId = builder.activityId;
        this.activityPlanId = builder.activityPlanId;
        this.allocationId = builder.allocationId;
        this.used = builder.used;
        this.donatoryId = builder.donatoryId;
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
     * 拨款记录ID
     */
    public Long getAllocationId() {
        return allocationId;
    }

    /**
     * 拨款记录ID
     */
    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
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

    public DrawRecordDetail copyFrom(DrawRecordDetail other) {
        this.id = other.id;
        this.activityId = other.activityId;
        this.activityPlanId = other.activityPlanId;
        this.allocationId = other.allocationId;
        this.used = other.used;
        this.donatoryId = other.donatoryId;
        return this;
    }

    public static <T extends DrawRecordDetail> T copyFrom(DrawRecordDetail from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setActivityId(from.activityId);
        to.setActivityPlanId(from.activityPlanId);
        to.setAllocationId(from.allocationId);
        to.setUsed(from.used);
        to.setDonatoryId(from.donatoryId);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            activityId: '',
            activityPlanId: '',
            allocationId: '',
            used: '',
            donatoryId: ''
        }
        */
        
        return "{\"id\": \"\",\"activityId\": \"\",\"activityPlanId\": \"\",\"allocationId\": \"\",\"used\": \"\",\"donatoryId\": \"\"}" ;
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
        sb.append(", allocationId=").append(allocationId);
        sb.append(", used=").append(used);
        sb.append(", donatoryId=").append(donatoryId);
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
         * 活动计划ID
         */
        private Long activityPlanId;

        /**
         * 拨款记录ID
         */
        private Long allocationId;

        /**
         * 用量
         */
        private Long used;

        /**
         * 受赠人ID
         */
        private Long donatoryId;

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
         * 活动计划ID
         */
        public XBuilder activityPlanId(Long activityPlanId) {
            this.activityPlanId = activityPlanId;
            return this;
        }

        /**
         * 拨款记录ID
         */
        public XBuilder allocationId(Long allocationId) {
            this.allocationId = allocationId;
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
         * 受赠人ID
         */
        public XBuilder donatoryId(Long donatoryId) {
            this.donatoryId = donatoryId;
            return this;
        }

        public DrawRecordDetail build() {
            return new DrawRecordDetail(this);
        }
    }
}