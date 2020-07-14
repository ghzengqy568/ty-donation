package com.baidu.mapp.bcd.domain;

import com.baidu.mapp.bcd.domain.base.BaseExample;
import com.baidu.mapp.bcd.domain.base.BaseExampleBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DonorExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    private DonorExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * 捐赠人
     */
    private DonorExample(Builder builder) {
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

        public Criteria andDonorUserNameIsNull() {
            addCriterion("donor_user_name is null");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameIsNotNull() {
            addCriterion("donor_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameEqualTo(String value) {
            return andDonorUserNameEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name =", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameNotEqualTo(String value) {
            return andDonorUserNameNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name <>", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameGreaterThan(String value) {
            return andDonorUserNameGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name >", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameGreaterThanOrEqualTo(String value) {
            return andDonorUserNameGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name >=", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameLessThan(String value) {
            return andDonorUserNameLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name <", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameLessThanOrEqualTo(String value) {
            return andDonorUserNameLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name <=", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameLike(String value) {
            return andDonorUserNameLike(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameLikeLeft(String value) {
            return andDonorUserNameLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donor_user_name like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameLikeRight(String value) {
            return andDonorUserNameLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_user_name like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameLikeBoth(String value) {
            return andDonorUserNameLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_user_name like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameNotLike(String value) {
            return andDonorUserNameNotLike(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_user_name not like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameNotLikeLeft(String value) {
            return andDonorUserNameNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donor_user_name not like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameNotLikeRight(String value) {
            return andDonorUserNameNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_user_name not like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameNotLikeBoth(String value) {
            return andDonorUserNameNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonorUserNameNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_user_name not like", value, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameIn(Collection<String> values) {
            addCriterion("donor_user_name in", values, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameNotIn(Collection<String> values) {
            addCriterion("donor_user_name not in", values, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameBetween(String value1, String value2) {
            addCriterion("donor_user_name between", value1, value2, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorUserNameNotBetween(String value1, String value2) {
            addCriterion("donor_user_name not between", value1, value2, "donorUserName");
            return (Criteria) this;
        }

        public Criteria andDonorPwdIsNull() {
            addCriterion("donor_pwd is null");
            return (Criteria) this;
        }

        public Criteria andDonorPwdIsNotNull() {
            addCriterion("donor_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andDonorPwdEqualTo(String value) {
            return andDonorPwdEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd =", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdNotEqualTo(String value) {
            return andDonorPwdNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd <>", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdGreaterThan(String value) {
            return andDonorPwdGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd >", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdGreaterThanOrEqualTo(String value) {
            return andDonorPwdGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd >=", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdLessThan(String value) {
            return andDonorPwdLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd <", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdLessThanOrEqualTo(String value) {
            return andDonorPwdLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd <=", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdLike(String value) {
            return andDonorPwdLike(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdLikeLeft(String value) {
            return andDonorPwdLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donor_pwd like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdLikeRight(String value) {
            return andDonorPwdLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_pwd like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdLikeBoth(String value) {
            return andDonorPwdLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_pwd like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdNotLike(String value) {
            return andDonorPwdNotLike(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_pwd not like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdNotLikeLeft(String value) {
            return andDonorPwdNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donor_pwd not like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdNotLikeRight(String value) {
            return andDonorPwdNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_pwd not like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdNotLikeBoth(String value) {
            return andDonorPwdNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonorPwdNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_pwd not like", value, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdIn(Collection<String> values) {
            addCriterion("donor_pwd in", values, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdNotIn(Collection<String> values) {
            addCriterion("donor_pwd not in", values, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdBetween(String value1, String value2) {
            addCriterion("donor_pwd between", value1, value2, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorPwdNotBetween(String value1, String value2) {
            addCriterion("donor_pwd not between", value1, value2, "donorPwd");
            return (Criteria) this;
        }

        public Criteria andDonorNameIsNull() {
            addCriterion("donor_name is null");
            return (Criteria) this;
        }

        public Criteria andDonorNameIsNotNull() {
            addCriterion("donor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDonorNameEqualTo(String value) {
            return andDonorNameEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorNameEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name =", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameNotEqualTo(String value) {
            return andDonorNameNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorNameNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name <>", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameGreaterThan(String value) {
            return andDonorNameGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andDonorNameGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name >", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameGreaterThanOrEqualTo(String value) {
            return andDonorNameGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorNameGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name >=", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameLessThan(String value) {
            return andDonorNameLessThan(value, Boolean.TRUE);
        }

        public Criteria andDonorNameLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name <", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameLessThanOrEqualTo(String value) {
            return andDonorNameLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andDonorNameLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name <=", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameLike(String value) {
            return andDonorNameLike(value, Boolean.TRUE);
        }

        public Criteria andDonorNameLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameLikeLeft(String value) {
            return andDonorNameLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonorNameLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donor_name like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameLikeRight(String value) {
            return andDonorNameLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonorNameLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_name like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameLikeBoth(String value) {
            return andDonorNameLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonorNameLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_name like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameNotLike(String value) {
            return andDonorNameNotLike(value, Boolean.TRUE);
        }

        public Criteria andDonorNameNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("donor_name not like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameNotLikeLeft(String value) {
            return andDonorNameNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andDonorNameNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("donor_name not like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameNotLikeRight(String value) {
            return andDonorNameNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andDonorNameNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_name not like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameNotLikeBoth(String value) {
            return andDonorNameNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andDonorNameNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("donor_name not like", value, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameIn(Collection<String> values) {
            addCriterion("donor_name in", values, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameNotIn(Collection<String> values) {
            addCriterion("donor_name not in", values, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameBetween(String value1, String value2) {
            addCriterion("donor_name between", value1, value2, "donorName");
            return (Criteria) this;
        }

        public Criteria andDonorNameNotBetween(String value1, String value2) {
            addCriterion("donor_name not between", value1, value2, "donorName");
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

        public Criteria andLoginTokenIsNull() {
            addCriterion("login_token is null");
            return (Criteria) this;
        }

        public Criteria andLoginTokenIsNotNull() {
            addCriterion("login_token is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTokenEqualTo(String value) {
            return andLoginTokenEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token =", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotEqualTo(String value) {
            return andLoginTokenNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token <>", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenGreaterThan(String value) {
            return andLoginTokenGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token >", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenGreaterThanOrEqualTo(String value) {
            return andLoginTokenGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token >=", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLessThan(String value) {
            return andLoginTokenLessThan(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token <", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLessThanOrEqualTo(String value) {
            return andLoginTokenLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token <=", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLike(String value) {
            return andLoginTokenLike(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLikeLeft(String value) {
            return andLoginTokenLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("login_token like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLikeRight(String value) {
            return andLoginTokenLikeRight(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("login_token like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenLikeBoth(String value) {
            return andLoginTokenLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("login_token like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotLike(String value) {
            return andLoginTokenNotLike(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("login_token not like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotLikeLeft(String value) {
            return andLoginTokenNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("login_token not like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotLikeRight(String value) {
            return andLoginTokenNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("login_token not like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotLikeBoth(String value) {
            return andLoginTokenNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andLoginTokenNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("login_token not like", value, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenIn(Collection<String> values) {
            addCriterion("login_token in", values, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotIn(Collection<String> values) {
            addCriterion("login_token not in", values, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenBetween(String value1, String value2) {
            addCriterion("login_token between", value1, value2, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLoginTokenNotBetween(String value1, String value2) {
            addCriterion("login_token not between", value1, value2, "loginToken");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            return andLastLoginTimeEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastLoginTimeEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            return andLastLoginTimeNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            return andLastLoginTimeGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andLastLoginTimeGreaterThan(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            return andLastLoginTimeGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            return andLastLoginTimeLessThan(value, Boolean.TRUE);
        }

        public Criteria andLastLoginTimeLessThan(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            return andLastLoginTimeLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(Collection<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(Collection<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
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

        private DonorExample example;

        protected Criteria(DonorExample example) {
            super();
            this.example = example;
        }

        public DonorExample toExample() {
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

    public static final class Builder extends BaseExampleBuilder<Builder, DonorExample> {

        protected List<Criteria> oredCriteria;

        private Builder() {
            
        }

        public Builder oredCriteria(List<Criteria> oredCriteria) {
            this.oredCriteria = oredCriteria;
            return this;
        }

        @Override
        public DonorExample build() {
            return new DonorExample(this);
        }
    }
}