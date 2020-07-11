package com.baidu.mapp.bcd.domain;

import com.baidu.mapp.bcd.domain.base.BaseExample;
import com.baidu.mapp.bcd.domain.base.BaseExampleBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CertificateHashExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    private CertificateHashExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * 多链映射记录
     */
    private CertificateHashExample(Builder builder) {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            return andUuidEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUuidEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            return andUuidNotEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUuidNotEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            return andUuidGreaterThan(value, Boolean.TRUE);
        }

        public Criteria andUuidGreaterThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            return andUuidGreaterThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            return andUuidLessThan(value, Boolean.TRUE);
        }

        public Criteria andUuidLessThan(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            return andUuidLessThanOrEqualTo(value, Boolean.TRUE);
        }

        public Criteria andUuidLessThanOrEqualTo(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            return andUuidLike(value, Boolean.TRUE);
        }

        public Criteria andUuidLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLikeLeft(String value) {
            return andUuidLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andUuidLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLikeRight(String value) {
            return andUuidLikeRight(value, Boolean.TRUE);
        }

        public Criteria andUuidLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLikeBoth(String value) {
            return andUuidLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andUuidLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            return andUuidNotLike(value, Boolean.TRUE);
        }

        public Criteria andUuidNotLike(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLikeLeft(String value) {
            return andUuidNotLikeLeft(value, Boolean.TRUE);
        }

        public Criteria andUuidNotLikeLeft(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLikeRight(String value) {
            return andUuidNotLikeRight(value, Boolean.TRUE);
        }

        public Criteria andUuidNotLikeRight(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLikeBoth(String value) {
            return andUuidNotLikeBoth(value, Boolean.TRUE);
        }

        public Criteria andUuidNotLikeBoth(String value, Boolean condition) {
            if (condition == null || !condition){
                return (Criteria) this;
            }
            if (value != null && !value.startsWith("%")) {
                value = "%".concat(value);
            }
            if (value != null && !value.endsWith("%")) {
                value = value.concat("%");
            }
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(Collection<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(Collection<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        private CertificateHashExample example;

        protected Criteria(CertificateHashExample example) {
            super();
            this.example = example;
        }

        public CertificateHashExample toExample() {
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

    public static final class Builder extends BaseExampleBuilder<Builder, CertificateHashExample> {

        protected List<Criteria> oredCriteria;

        private Builder() {
            
        }

        public Builder oredCriteria(List<Criteria> oredCriteria) {
            this.oredCriteria = oredCriteria;
            return this;
        }

        @Override
        public CertificateHashExample build() {
            return new CertificateHashExample(this);
        }
    }
}