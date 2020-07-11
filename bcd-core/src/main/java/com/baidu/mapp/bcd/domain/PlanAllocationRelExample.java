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

        public Criteria andActivityPlanUuidIsNull() {
            addCriterion("activity_plan_uuid is null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidIsNotNull() {
            addCriterion("activity_plan_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidEqualTo(String value) {
            return andActivityPlanUuidEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid =", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidNotEqualTo(String value) {
            return andActivityPlanUuidNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid <>", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidGreaterThan(String value) {
            return andActivityPlanUuidGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid >", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidGreaterThanOrEqualTo(String value) {
            return andActivityPlanUuidGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid >=", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidLessThan(String value) {
            return andActivityPlanUuidLessThan(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid <", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidLessThanOrEqualTo(String value) {
            return andActivityPlanUuidLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid <=", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidLike(String value) {
            return andActivityPlanUuidLike(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidLikeLeft(String value) {
            return andActivityPlanUuidLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("activity_plan_uuid like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidLikeRight(String value) {
            return andActivityPlanUuidLikeRight(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("activity_plan_uuid like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidLikeBoth(String value) {
            return andActivityPlanUuidLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("activity_plan_uuid like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidNotLike(String value) {
            return andActivityPlanUuidNotLike(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("activity_plan_uuid not like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidNotLikeLeft(String value) {
            return andActivityPlanUuidNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("activity_plan_uuid not like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidNotLikeRight(String value) {
            return andActivityPlanUuidNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("activity_plan_uuid not like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidNotLikeBoth(String value) {
            return andActivityPlanUuidNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andActivityPlanUuidNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("activity_plan_uuid not like", value, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidIn(Collection<String> values) {
            addCriterion("activity_plan_uuid in", values, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidNotIn(Collection<String> values) {
            addCriterion("activity_plan_uuid not in", values, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidBetween(String value1, String value2) {
            addCriterion("activity_plan_uuid between", value1, value2, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andActivityPlanUuidNotBetween(String value1, String value2) {
            addCriterion("activity_plan_uuid not between", value1, value2, "activityPlanUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidIsNull() {
            addCriterion("allocation_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidIsNotNull() {
            addCriterion("allocation_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidEqualTo(String value) {
            return andAllocationUuidEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid =", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidNotEqualTo(String value) {
            return andAllocationUuidNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid <>", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidGreaterThan(String value) {
            return andAllocationUuidGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid >", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidGreaterThanOrEqualTo(String value) {
            return andAllocationUuidGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid >=", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidLessThan(String value) {
            return andAllocationUuidLessThan(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid <", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidLessThanOrEqualTo(String value) {
            return andAllocationUuidLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid <=", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidLike(String value) {
            return andAllocationUuidLike(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidLikeLeft(String value) {
            return andAllocationUuidLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("allocation_uuid like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidLikeRight(String value) {
            return andAllocationUuidLikeRight(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("allocation_uuid like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidLikeBoth(String value) {
            return andAllocationUuidLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("allocation_uuid like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidNotLike(String value) {
            return andAllocationUuidNotLike(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("allocation_uuid not like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidNotLikeLeft(String value) {
            return andAllocationUuidNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("allocation_uuid not like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidNotLikeRight(String value) {
            return andAllocationUuidNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("allocation_uuid not like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidNotLikeBoth(String value) {
            return andAllocationUuidNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andAllocationUuidNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("allocation_uuid not like", value, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidIn(Collection<String> values) {
            addCriterion("allocation_uuid in", values, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidNotIn(Collection<String> values) {
            addCriterion("allocation_uuid not in", values, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidBetween(String value1, String value2) {
            addCriterion("allocation_uuid between", value1, value2, "allocationUuid");
            return (Criteria) this;
        }

        public Criteria andAllocationUuidNotBetween(String value1, String value2) {
            addCriterion("allocation_uuid not between", value1, value2, "allocationUuid");
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