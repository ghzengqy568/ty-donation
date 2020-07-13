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
     * column-name:balance
     * 分配后余额
     */
    @Schema(description = "分配后余额")
    private Long balance;

    /**
     * column-name:used
     * 使用量
     */
    @Schema(description = "使用量")
    private Long used;

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
        this.balance = builder.balance;
        this.used = builder.used;
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
     * 分配后余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 分配后余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 使用量
     */
    public Long getUsed() {
        return used;
    }

    /**
     * 使用量
     */
    public void setUsed(Long used) {
        this.used = used;
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
        this.balance = other.balance;
        this.used = other.used;
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
        to.setBalance(from.balance);
        to.setUsed(from.used);
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
            balance: '',
            used: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"activityPlanId\": \"\",\"allocationId\": \"\",\"balance\": \"\",\"used\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
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
        sb.append(", balance=").append(balance);
        sb.append(", used=").append(used);
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
         * 分配后余额
         */
        private Long balance;

        /**
         * 使用量
         */
        private Long used;

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
         * 分配后余额
         */
        public XBuilder balance(Long balance) {
            this.balance = balance;
            return this;
        }

        /**
         * 使用量
         */
        public XBuilder used(Long used) {
            this.used = used;
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