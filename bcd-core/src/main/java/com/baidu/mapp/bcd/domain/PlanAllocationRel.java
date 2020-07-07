package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "PlanAllocationRel", description = "活动计划与拨款记录关系表")
public class PlanAllocationRel implements Serializable {

    /**
     * column-name:id
     * 活动计划与拨款记录关系ID
     */
    @Schema(description = "活动计划与拨款记录关系ID")
    private Long id;

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
     * 活动计划与拨款记录关系表
     */
    public PlanAllocationRel() {
        
    }

    /**
     * 活动计划与拨款记录关系表
     */
    private PlanAllocationRel(XBuilder builder) {
        this.id = builder.id;
        this.activityPlanId = builder.activityPlanId;
        this.allocationId = builder.allocationId;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 活动计划与拨款记录关系ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 活动计划与拨款记录关系ID
     */
    public void setId(Long id) {
        this.id = id;
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

    public PlanAllocationRel copyFrom(PlanAllocationRel other) {
        this.id = other.id;
        this.activityPlanId = other.activityPlanId;
        this.allocationId = other.allocationId;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends PlanAllocationRel> T copyFrom(PlanAllocationRel from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setActivityPlanId(from.activityPlanId);
        to.setAllocationId(from.allocationId);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            activityPlanId: '',
            allocationId: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"activityPlanId\": \"\",\"allocationId\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityPlanId=").append(activityPlanId);
        sb.append(", allocationId=").append(allocationId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 活动计划与拨款记录关系ID
         */
        private Long id;

        /**
         * 活动计划ID
         */
        private Long activityPlanId;

        /**
         * 拨款记录ID
         */
        private Long allocationId;

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
         * 活动计划与拨款记录关系ID
         */
        public XBuilder id(Long id) {
            this.id = id;
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

        public PlanAllocationRel build() {
            return new PlanAllocationRel(this);
        }
    }
}