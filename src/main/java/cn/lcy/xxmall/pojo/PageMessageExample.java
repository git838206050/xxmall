package cn.lcy.xxmall.pojo;

import java.util.ArrayList;
import java.util.List;

public class PageMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PageMessageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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
        Criteria criteria = new Criteria();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMessagekeyIsNull() {
            addCriterion("messageKey is null");
            return (Criteria) this;
        }

        public Criteria andMessagekeyIsNotNull() {
            addCriterion("messageKey is not null");
            return (Criteria) this;
        }

        public Criteria andMessagekeyEqualTo(String value) {
            addCriterion("messageKey =", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyNotEqualTo(String value) {
            addCriterion("messageKey <>", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyGreaterThan(String value) {
            addCriterion("messageKey >", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyGreaterThanOrEqualTo(String value) {
            addCriterion("messageKey >=", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyLessThan(String value) {
            addCriterion("messageKey <", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyLessThanOrEqualTo(String value) {
            addCriterion("messageKey <=", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyLike(String value) {
            addCriterion("messageKey like", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyNotLike(String value) {
            addCriterion("messageKey not like", value, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyIn(List<String> values) {
            addCriterion("messageKey in", values, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyNotIn(List<String> values) {
            addCriterion("messageKey not in", values, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyBetween(String value1, String value2) {
            addCriterion("messageKey between", value1, value2, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagekeyNotBetween(String value1, String value2) {
            addCriterion("messageKey not between", value1, value2, "messagekey");
            return (Criteria) this;
        }

        public Criteria andMessagevalueIsNull() {
            addCriterion("messageValue is null");
            return (Criteria) this;
        }

        public Criteria andMessagevalueIsNotNull() {
            addCriterion("messageValue is not null");
            return (Criteria) this;
        }

        public Criteria andMessagevalueEqualTo(String value) {
            addCriterion("messageValue =", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueNotEqualTo(String value) {
            addCriterion("messageValue <>", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueGreaterThan(String value) {
            addCriterion("messageValue >", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueGreaterThanOrEqualTo(String value) {
            addCriterion("messageValue >=", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueLessThan(String value) {
            addCriterion("messageValue <", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueLessThanOrEqualTo(String value) {
            addCriterion("messageValue <=", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueLike(String value) {
            addCriterion("messageValue like", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueNotLike(String value) {
            addCriterion("messageValue not like", value, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueIn(List<String> values) {
            addCriterion("messageValue in", values, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueNotIn(List<String> values) {
            addCriterion("messageValue not in", values, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueBetween(String value1, String value2) {
            addCriterion("messageValue between", value1, value2, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andMessagevalueNotBetween(String value1, String value2) {
            addCriterion("messageValue not between", value1, value2, "messagevalue");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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
            if (value instanceof List<?>) {
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
}