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
     * column-name:activity_plan_uuid
     * 活动计划ID
     */
    @Schema(description = "活动计划ID")
    private String activityPlanUuid;

    /**
     * column-name:allocation_uuid
     * 拨款记录ID
     */
    @Schema(description = "拨款记录ID")
    private String allocationUuid;

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
        this.activityPlanUuid = builder.activityPlanUuid;
        this.allocationUuid = builder.allocationUuid;
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
    public String getActivityPlanUuid() {
        return activityPlanUuid;
    }

    /**
     * 活动计划ID
     */
    public void setActivityPlanUuid(String activityPlanUuid) {
        this.activityPlanUuid = activityPlanUuid == null ? null : activityPlanUuid.trim();
    }

    /**
     * 拨款记录ID
     */
    public String getAllocationUuid() {
        return allocationUuid;
    }

    /**
     * 拨款记录ID
     */
    public void setAllocationUuid(String allocationUuid) {
        this.allocationUuid = allocationUuid == null ? null : allocationUuid.trim();
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
        this.activityPlanUuid = other.activityPlanUuid;
        this.allocationUuid = other.allocationUuid;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends PlanAllocationRel> T copyFrom(PlanAllocationRel from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setActivityPlanUuid(from.activityPlanUuid);
        to.setAllocationUuid(from.allocationUuid);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            activityPlanUuid: '',
            allocationUuid: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"activityPlanUuid\": \"\",\"allocationUuid\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityPlanUuid=").append(activityPlanUuid);
        sb.append(", allocationUuid=").append(allocationUuid);
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
        private String activityPlanUuid;

        /**
         * 拨款记录ID
         */
        private String allocationUuid;

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
        public XBuilder activityPlanUuid(String activityPlanUuid) {
            this.activityPlanUuid = activityPlanUuid;
            return this;
        }

        /**
         * 拨款记录ID
         */
        public XBuilder allocationUuid(String allocationUuid) {
            this.allocationUuid = allocationUuid;
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