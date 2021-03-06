package com.baidu.mapp.bcd.domain;

import com.baidu.mapp.bcd.domain.base.BaseExample;
import com.baidu.mapp.bcd.domain.base.BaseExampleBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PlanAllocationRelExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    private PlanAllocationRelExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * 活动计划与拨款记录关系表
     */
    private PlanAllocationRelExample(Builder builder) {
        this.start = builder.getStart();
        this.limit = builder.getLimit();
        this.orderByClause = builder.getOrderByClause();
        this.distinct = builder.isDistinct();
        this.columns = builder.getColumns();
        this.oredCriteria = new ArrayList<>();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            return andIdEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            return andIdNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdNotEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            return andIdGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andIdGreaterThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            return andIdGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            return andIdLessThan(value, Boolean.TRUE);
        }

        public Criteria andIdLessThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            return andIdLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdLessThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(Collection<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(Collection<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdIsNull() {
            addCriterion("activity_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdIsNotNull() {
            addCriterion("activity_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdEqualTo(Long value) {
            return andActivityPlanIdEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanIdEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_id =", value, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdNotEqualTo(Long value) {
            return andActivityPlanIdNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanIdNotEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_id <>", value, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdGreaterThan(Long value) {
            return andActivityPlanIdGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanIdGreaterThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_id >", value, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdGreaterThanOrEqualTo(Long value) {
            return andActivityPlanIdGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanIdGreaterThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_id >=", value, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdLessThan(Long value) {
            return andActivityPlanIdLessThan(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanIdLessThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_id <", value, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdLessThanOrEqualTo(Long value) {
            return andActivityPlanIdLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanIdLessThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_id <=", value, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdIn(Collection<Long> values) {
            addCriterion("activity_plan_id in", values, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdNotIn(Collection<Long> values) {
            addCriterion("activity_plan_id not in", values, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdBetween(Long value1, Long value2) {
            addCriterion("activity_plan_id between", value1, value2, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andActivityPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_plan_id not between", value1, value2, "activityPlanId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdIsNull() {
            addCriterion("allocation_id is null");
            return (Criteria) this;
        }

        public Criteria andAllocationIdIsNotNull() {
            addCriterion("allocation_id is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationIdEqualTo(Long value) {
            return andAllocationIdEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationIdEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_id =", value, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdNotEqualTo(Long value) {
            return andAllocationIdNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationIdNotEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_id <>", value, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdGreaterThan(Long value) {
            return andAllocationIdGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andAllocationIdGreaterThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_id >", value, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdGreaterThanOrEqualTo(Long value) {
            return andAllocationIdGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationIdGreaterThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_id >=", value, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdLessThan(Long value) {
            return andAllocationIdLessThan(value, Boolean.TRUE);
        }

        public Criteria andAllocationIdLessThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_id <", value, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdLessThanOrEqualTo(Long value) {
            return andAllocationIdLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationIdLessThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_id <=", value, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdIn(Collection<Long> values) {
            addCriterion("allocation_id in", values, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdNotIn(Collection<Long> values) {
            addCriterion("allocation_id not in", values, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdBetween(Long value1, Long value2) {
            addCriterion("allocation_id between", value1, value2, "allocationId");
            return (Criteria) this;
        }

        public Criteria andAllocationIdNotBetween(Long value1, Long value2) {
            addCriterion("allocation_id not between", value1, value2, "allocationId");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Long value) {
            return andBalanceEqualTo(value, Boolean.TRUE);
        }

        public Criteria andBalanceEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Long value) {
            return andBalanceNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andBalanceNotEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Long value) {
            return andBalanceGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andBalanceGreaterThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Long value) {
            return andBalanceGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Long value) {
            return andBalanceLessThan(value, Boolean.TRUE);
        }

        public Criteria andBalanceLessThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Long value) {
            return andBalanceLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andBalanceLessThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(Collection<Long> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(Collection<Long> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Long value1, Long value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Long value1, Long value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("used is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(Long value) {
            return andUsedEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUsedEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("used =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(Long value) {
            return andUsedNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUsedNotEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("used <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(Long value) {
            return andUsedGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andUsedGreaterThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("used >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(Long value) {
            return andUsedGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUsedGreaterThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("used >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(Long value) {
            return andUsedLessThan(value, Boolean.TRUE);
        }

        public Criteria andUsedLessThan(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("used <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(Long value) {
            return andUsedLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUsedLessThanOrEqualTo(Long value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("used <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(Collection<Long> values) {
            addCriterion("used in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(Collection<Long> values) {
            addCriterion("used not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(Long value1, Long value2) {
            addCriterion("used between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(Long value1, Long value2) {
            addCriterion("used not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return andCreateTimeEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCreateTimeEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return andCreateTimeNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCreateTimeNotEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return andCreateTimeGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andCreateTimeGreaterThan(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return andCreateTimeGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return andCreateTimeLessThan(value, Boolean.TRUE);
        }

        public Criteria andCreateTimeLessThan(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return andCreateTimeLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(Collection<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(Collection<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("last_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("last_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            return andLastModifyTimeEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastModifyTimeEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_modify_time =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            return andLastModifyTimeNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            return andLastModifyTimeGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andLastModifyTimeGreaterThan(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_modify_time >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return andLastModifyTimeGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            return andLastModifyTimeLessThan(value, Boolean.TRUE);
        }

        public Criteria andLastModifyTimeLessThan(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_modify_time <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return andLastModifyTimeLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(Collection<Date> values) {
            addCriterion("last_modify_time in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(Collection<Date> values) {
            addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        private PlanAllocationRelExample example;

        protected Criteria(PlanAllocationRelExample example) {
            super();
            this.example = example;
        }

        public PlanAllocationRelExample toExample() {
            return this.example;
        }

        public Criteria addCustomerCriteria(String condition) {
            addCriterion(condition);
            return this;
        }

        public Criteria addCustomerCriteria(String condition, Boolean bCondition) {
            if (bCondition == null || !bCondition){
                return (Criteria) this;
            }
            addCriterion(condition);
            return this;
        }

        /**
         * 举例: exists(select 1 from b where b.aid = a.id and b.id=#{criterion.value})
         */
        public Criteria addCustomerCriteria(String condition, Object value) {
             addCriterion(condition,value,"customerCondition");
            return this;
        }
    }

    public static class Criterion {

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof Collection<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public static final class Builder extends BaseExampleBuilder<Builder, PlanAllocationRelExample> {

        protected List<Criteria> oredCriteria;

        private Builder() {
            
        }

        public Builder oredCriteria(List<Criteria> oredCriteria) {
            this.oredCriteria = oredCriteria;
            return this;
        }

        @Override
        public PlanAllocationRelExample build() {
            return new PlanAllocationRelExample(this);
        }
    }
}