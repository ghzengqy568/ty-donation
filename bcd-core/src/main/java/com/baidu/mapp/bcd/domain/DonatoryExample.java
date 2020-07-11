package com.baidu.mapp.bcd.domain;

import com.baidu.mapp.bcd.domain.base.BaseExample;
import com.baidu.mapp.bcd.domain.base.BaseExampleBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DonatoryExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    private DonatoryExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * 受赠人
     */
    private DonatoryExample(Builder builder) {
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

        public Criteria andDonatoryUserNameIsNull() {
            addCriterion("donatory_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameIsNotNull() {
            addCriterion("donatory_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameEqualTo(String value) {
            return andDonatoryUserNameEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name =", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameNotEqualTo(String value) {
            return andDonatoryUserNameNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name <>", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameGreaterThan(String value) {
            return andDonatoryUserNameGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name >", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameGreaterThanOrEqualTo(String value) {
            return andDonatoryUserNameGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name >=", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameLessThan(String value) {
            return andDonatoryUserNameLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name <", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameLessThanOrEqualTo(String value) {
            return andDonatoryUserNameLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name <=", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameLike(String value) {
            return andDonatoryUserNameLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameLikeLeft(String value) {
            return andDonatoryUserNameLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_user_name like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameLikeRight(String value) {
            return andDonatoryUserNameLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_user_name like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameLikeBoth(String value) {
            return andDonatoryUserNameLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_user_name like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameNotLike(String value) {
            return andDonatoryUserNameNotLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_user_name not like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameNotLikeLeft(String value) {
            return andDonatoryUserNameNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_user_name not like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameNotLikeRight(String value) {
            return andDonatoryUserNameNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_user_name not like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameNotLikeBoth(String value) {
            return andDonatoryUserNameNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryUserNameNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_user_name not like", value, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameIn(Collection<String> values) {
            addCriterion("donatory_user_name in", values, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameNotIn(Collection<String> values) {
            addCriterion("donatory_user_name not in", values, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameBetween(String value1, String value2) {
            addCriterion("donatory_user_name between", value1, value2, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryUserNameNotBetween(String value1, String value2) {
            addCriterion("donatory_user_name not between", value1, value2, "donatoryUserName");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdIsNull() {
            addCriterion("donatory_pwd is null");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdIsNotNull() {
            addCriterion("donatory_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdEqualTo(String value) {
            return andDonatoryPwdEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd =", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdNotEqualTo(String value) {
            return andDonatoryPwdNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd <>", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdGreaterThan(String value) {
            return andDonatoryPwdGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd >", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdGreaterThanOrEqualTo(String value) {
            return andDonatoryPwdGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd >=", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdLessThan(String value) {
            return andDonatoryPwdLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd <", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdLessThanOrEqualTo(String value) {
            return andDonatoryPwdLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd <=", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdLike(String value) {
            return andDonatoryPwdLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdLikeLeft(String value) {
            return andDonatoryPwdLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_pwd like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdLikeRight(String value) {
            return andDonatoryPwdLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_pwd like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdLikeBoth(String value) {
            return andDonatoryPwdLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_pwd like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdNotLike(String value) {
            return andDonatoryPwdNotLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_pwd not like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdNotLikeLeft(String value) {
            return andDonatoryPwdNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_pwd not like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdNotLikeRight(String value) {
            return andDonatoryPwdNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_pwd not like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdNotLikeBoth(String value) {
            return andDonatoryPwdNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryPwdNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_pwd not like", value, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdIn(Collection<String> values) {
            addCriterion("donatory_pwd in", values, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdNotIn(Collection<String> values) {
            addCriterion("donatory_pwd not in", values, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdBetween(String value1, String value2) {
            addCriterion("donatory_pwd between", value1, value2, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryPwdNotBetween(String value1, String value2) {
            addCriterion("donatory_pwd not between", value1, value2, "donatoryPwd");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameIsNull() {
            addCriterion("donatory_name is null");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameIsNotNull() {
            addCriterion("donatory_name is not null");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameEqualTo(String value) {
            return andDonatoryNameEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name =", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameNotEqualTo(String value) {
            return andDonatoryNameNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name <>", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameGreaterThan(String value) {
            return andDonatoryNameGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name >", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameGreaterThanOrEqualTo(String value) {
            return andDonatoryNameGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name >=", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameLessThan(String value) {
            return andDonatoryNameLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name <", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameLessThanOrEqualTo(String value) {
            return andDonatoryNameLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name <=", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameLike(String value) {
            return andDonatoryNameLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameLikeLeft(String value) {
            return andDonatoryNameLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_name like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameLikeRight(String value) {
            return andDonatoryNameLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_name like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameLikeBoth(String value) {
            return andDonatoryNameLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_name like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameNotLike(String value) {
            return andDonatoryNameNotLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_name not like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameNotLikeLeft(String value) {
            return andDonatoryNameNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_name not like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameNotLikeRight(String value) {
            return andDonatoryNameNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_name not like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameNotLikeBoth(String value) {
            return andDonatoryNameNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryNameNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_name not like", value, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameIn(Collection<String> values) {
            addCriterion("donatory_name in", values, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameNotIn(Collection<String> values) {
            addCriterion("donatory_name not in", values, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameBetween(String value1, String value2) {
            addCriterion("donatory_name between", value1, value2, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andDonatoryNameNotBetween(String value1, String value2) {
            addCriterion("donatory_name not between", value1, value2, "donatoryName");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            return andIdcardEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdcardEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            return andIdcardNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdcardNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            return andIdcardGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andIdcardGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            return andIdcardGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            return andIdcardLessThan(value, Boolean.TRUE);
        }

        public Criteria andIdcardLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            return andIdcardLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andIdcardLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            return andIdcardLike(value, Boolean.TRUE);
        }

        public Criteria andIdcardLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLikeLeft(String value) {
            return andIdcardLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andIdcardLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLikeRight(String value) {
            return andIdcardLikeRight(value, Boolean.TRUE);
        }

        public Criteria andIdcardLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLikeBoth(String value) {
            return andIdcardLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andIdcardLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            return andIdcardNotLike(value, Boolean.TRUE);
        }

        public Criteria andIdcardNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLikeLeft(String value) {
            return andIdcardNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andIdcardNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLikeRight(String value) {
            return andIdcardNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andIdcardNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLikeBoth(String value) {
            return andIdcardNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andIdcardNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(Collection<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(Collection<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            return andMobileEqualTo(value, Boolean.TRUE);
        }

        public Criteria andMobileEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            return andMobileNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andMobileNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            return andMobileGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andMobileGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            return andMobileGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            return andMobileLessThan(value, Boolean.TRUE);
        }

        public Criteria andMobileLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            return andMobileLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andMobileLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            return andMobileLike(value, Boolean.TRUE);
        }

        public Criteria andMobileLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLikeLeft(String value) {
            return andMobileLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andMobileLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLikeRight(String value) {
            return andMobileLikeRight(value, Boolean.TRUE);
        }

        public Criteria andMobileLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLikeBoth(String value) {
            return andMobileLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andMobileLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            return andMobileNotLike(value, Boolean.TRUE);
        }

        public Criteria andMobileNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLikeLeft(String value) {
            return andMobileNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andMobileNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLikeRight(String value) {
            return andMobileNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andMobileNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLikeBoth(String value) {
            return andMobileNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andMobileNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(Collection<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(Collection<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardIsNull() {
            addCriterion("donatory_card is null");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardIsNotNull() {
            addCriterion("donatory_card is not null");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardEqualTo(String value) {
            return andDonatoryCardEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card =", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardNotEqualTo(String value) {
            return andDonatoryCardNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card <>", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardGreaterThan(String value) {
            return andDonatoryCardGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card >", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardGreaterThanOrEqualTo(String value) {
            return andDonatoryCardGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card >=", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardLessThan(String value) {
            return andDonatoryCardLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card <", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardLessThanOrEqualTo(String value) {
            return andDonatoryCardLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card <=", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardLike(String value) {
            return andDonatoryCardLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardLikeLeft(String value) {
            return andDonatoryCardLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_card like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardLikeRight(String value) {
            return andDonatoryCardLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_card like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardLikeBoth(String value) {
            return andDonatoryCardLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_card like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardNotLike(String value) {
            return andDonatoryCardNotLike(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_card not like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardNotLikeLeft(String value) {
            return andDonatoryCardNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donatory_card not like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardNotLikeRight(String value) {
            return andDonatoryCardNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_card not like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardNotLikeBoth(String value) {
            return andDonatoryCardNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonatoryCardNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donatory_card not like", value, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardIn(Collection<String> values) {
            addCriterion("donatory_card in", values, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardNotIn(Collection<String> values) {
            addCriterion("donatory_card not in", values, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardBetween(String value1, String value2) {
            addCriterion("donatory_card between", value1, value2, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andDonatoryCardNotBetween(String value1, String value2) {
            addCriterion("donatory_card not between", value1, value2, "donatoryCard");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            return andProvinceEqualTo(value, Boolean.TRUE);
        }

        public Criteria andProvinceEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            return andProvinceNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andProvinceNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            return andProvinceGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andProvinceGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            return andProvinceGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            return andProvinceLessThan(value, Boolean.TRUE);
        }

        public Criteria andProvinceLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            return andProvinceLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andProvinceLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            return andProvinceLike(value, Boolean.TRUE);
        }

        public Criteria andProvinceLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLikeLeft(String value) {
            return andProvinceLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andProvinceLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLikeRight(String value) {
            return andProvinceLikeRight(value, Boolean.TRUE);
        }

        public Criteria andProvinceLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLikeBoth(String value) {
            return andProvinceLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andProvinceLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            return andProvinceNotLike(value, Boolean.TRUE);
        }

        public Criteria andProvinceNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLikeLeft(String value) {
            return andProvinceNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andProvinceNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLikeRight(String value) {
            return andProvinceNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andProvinceNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLikeBoth(String value) {
            return andProvinceNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andProvinceNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(Collection<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(Collection<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            return andCityEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCityEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            return andCityNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCityNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            return andCityGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andCityGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            return andCityGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCityGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            return andCityLessThan(value, Boolean.TRUE);
        }

        public Criteria andCityLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            return andCityLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCityLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            return andCityLike(value, Boolean.TRUE);
        }

        public Criteria andCityLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLikeLeft(String value) {
            return andCityLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andCityLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLikeRight(String value) {
            return andCityLikeRight(value, Boolean.TRUE);
        }

        public Criteria andCityLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLikeBoth(String value) {
            return andCityLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andCityLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            return andCityNotLike(value, Boolean.TRUE);
        }

        public Criteria andCityNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLikeLeft(String value) {
            return andCityNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andCityNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLikeRight(String value) {
            return andCityNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andCityNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLikeBoth(String value) {
            return andCityNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andCityNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(Collection<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(Collection<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            return andAddressEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAddressEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            return andAddressNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAddressNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            return andAddressGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andAddressGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            return andAddressGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            return andAddressLessThan(value, Boolean.TRUE);
        }

        public Criteria andAddressLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            return andAddressLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andAddressLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            return andAddressLike(value, Boolean.TRUE);
        }

        public Criteria andAddressLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLikeLeft(String value) {
            return andAddressLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andAddressLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLikeRight(String value) {
            return andAddressLikeRight(value, Boolean.TRUE);
        }

        public Criteria andAddressLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLikeBoth(String value) {
            return andAddressLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andAddressLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            return andAddressNotLike(value, Boolean.TRUE);
        }

        public Criteria andAddressNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLikeLeft(String value) {
            return andAddressNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andAddressNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLikeRight(String value) {
            return andAddressNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andAddressNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLikeBoth(String value) {
            return andAddressNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andAddressNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(Collection<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(Collection<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelIsNull() {
            addCriterion("donatory_level is null");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelIsNotNull() {
            addCriterion("donatory_level is not null");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelEqualTo(Byte value) {
            return andDonatoryLevelEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryLevelEqualTo(Byte value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_level =", value, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelNotEqualTo(Byte value) {
            return andDonatoryLevelNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryLevelNotEqualTo(Byte value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_level <>", value, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelGreaterThan(Byte value) {
            return andDonatoryLevelGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryLevelGreaterThan(Byte value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_level >", value, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelGreaterThanOrEqualTo(Byte value) {
            return andDonatoryLevelGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryLevelGreaterThanOrEqualTo(Byte value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_level >=", value, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelLessThan(Byte value) {
            return andDonatoryLevelLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonatoryLevelLessThan(Byte value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_level <", value, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelLessThanOrEqualTo(Byte value) {
            return andDonatoryLevelLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonatoryLevelLessThanOrEqualTo(Byte value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donatory_level <=", value, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelIn(Collection<Byte> values) {
            addCriterion("donatory_level in", values, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelNotIn(Collection<Byte> values) {
            addCriterion("donatory_level not in", values, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelBetween(Byte value1, Byte value2) {
            addCriterion("donatory_level between", value1, value2, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andDonatoryLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("donatory_level not between", value1, value2, "donatoryLevel");
            return (Criteria) this;
        }

        public Criteria andCertCodeIsNull() {
            addCriterion("cert_code is null");
            return (Criteria) this;
        }

        public Criteria andCertCodeIsNotNull() {
            addCriterion("cert_code is not null");
            return (Criteria) this;
        }

        public Criteria andCertCodeEqualTo(String value) {
            return andCertCodeEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCertCodeEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code =", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeNotEqualTo(String value) {
            return andCertCodeNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCertCodeNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code <>", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeGreaterThan(String value) {
            return andCertCodeGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andCertCodeGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code >", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeGreaterThanOrEqualTo(String value) {
            return andCertCodeGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCertCodeGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code >=", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeLessThan(String value) {
            return andCertCodeLessThan(value, Boolean.TRUE);
        }

        public Criteria andCertCodeLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code <", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeLessThanOrEqualTo(String value) {
            return andCertCodeLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andCertCodeLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code <=", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeLike(String value) {
            return andCertCodeLike(value, Boolean.TRUE);
        }

        public Criteria andCertCodeLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeLikeLeft(String value) {
            return andCertCodeLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andCertCodeLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("cert_code like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeLikeRight(String value) {
            return andCertCodeLikeRight(value, Boolean.TRUE);
        }

        public Criteria andCertCodeLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("cert_code like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeLikeBoth(String value) {
            return andCertCodeLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andCertCodeLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("cert_code like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeNotLike(String value) {
            return andCertCodeNotLike(value, Boolean.TRUE);
        }

        public Criteria andCertCodeNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("cert_code not like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeNotLikeLeft(String value) {
            return andCertCodeNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andCertCodeNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("cert_code not like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeNotLikeRight(String value) {
            return andCertCodeNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andCertCodeNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("cert_code not like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeNotLikeBoth(String value) {
            return andCertCodeNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andCertCodeNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("cert_code not like", value, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeIn(Collection<String> values) {
            addCriterion("cert_code in", values, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeNotIn(Collection<String> values) {
            addCriterion("cert_code not in", values, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeBetween(String value1, String value2) {
            addCriterion("cert_code between", value1, value2, "certCode");
            return (Criteria) this;
        }

        public Criteria andCertCodeNotBetween(String value1, String value2) {
            addCriterion("cert_code not between", value1, value2, "certCode");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            return andSignEqualTo(value, Boolean.TRUE);
        }

        public Criteria andSignEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            return andSignNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andSignNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            return andSignGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andSignGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            return andSignGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andSignGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            return andSignLessThan(value, Boolean.TRUE);
        }

        public Criteria andSignLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            return andSignLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andSignLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            return andSignLike(value, Boolean.TRUE);
        }

        public Criteria andSignLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLikeLeft(String value) {
            return andSignLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andSignLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLikeRight(String value) {
            return andSignLikeRight(value, Boolean.TRUE);
        }

        public Criteria andSignLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLikeBoth(String value) {
            return andSignLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andSignLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            return andSignNotLike(value, Boolean.TRUE);
        }

        public Criteria andSignNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLikeLeft(String value) {
            return andSignNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andSignNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLikeRight(String value) {
            return andSignNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andSignNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLikeBoth(String value) {
            return andSignNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andSignNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(Collection<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(Collection<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
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

        private DonatoryExample example;

        protected Criteria(DonatoryExample example) {
            super();
            this.example = example;
        }

        public DonatoryExample toExample() {
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

    public static final class Builder extends BaseExampleBuilder<Builder, DonatoryExample> {

        protected List<Criteria> oredCriteria;

        private Builder() {
            
        }

        public Builder oredCriteria(List<Criteria> oredCriteria) {
            this.oredCriteria = oredCriteria;
            return this;
        }

        @Override
        public DonatoryExample build() {
            return new DonatoryExample(this);
        }
    }
}