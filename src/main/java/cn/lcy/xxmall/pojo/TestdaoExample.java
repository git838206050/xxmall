package cn.lcy.xxmall.pojo;

import java.util.ArrayList;
import java.util.List;

public class TestdaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestdaoExample() {
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

        public Criteria andTestnameIsNull() {
            addCriterion("testName is null");
            return (Criteria) this;
        }

        public Criteria andTestnameIsNotNull() {
            addCriterion("testName is not null");
            return (Criteria) this;
        }

        public Criteria andTestnameEqualTo(String value) {
            addCriterion("testName =", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotEqualTo(String value) {
            addCriterion("testName <>", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameGreaterThan(String value) {
            addCriterion("testName >", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameGreaterThanOrEqualTo(String value) {
            addCriterion("testName >=", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLessThan(String value) {
            addCriterion("testName <", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLessThanOrEqualTo(String value) {
            addCriterion("testName <=", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLike(String value) {
            addCriterion("testName like", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotLike(String value) {
            addCriterion("testName not like", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameIn(List<String> values) {
            addCriterion("testName in", values, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotIn(List<String> values) {
            addCriterion("testName not in", values, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameBetween(String value1, String value2) {
            addCriterion("testName between", value1, value2, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotBetween(String value1, String value2) {
            addCriterion("testName not between", value1, value2, "testname");
            return (Criteria) this;
        }

        public Criteria andTesttypeIsNull() {
            addCriterion("testType is null");
            return (Criteria) this;
        }

        public Criteria andTesttypeIsNotNull() {
            addCriterion("testType is not null");
            return (Criteria) this;
        }

        public Criteria andTesttypeEqualTo(Integer value) {
            addCriterion("testType =", value, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeNotEqualTo(Integer value) {
            addCriterion("testType <>", value, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeGreaterThan(Integer value) {
            addCriterion("testType >", value, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("testType >=", value, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeLessThan(Integer value) {
            addCriterion("testType <", value, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeLessThanOrEqualTo(Integer value) {
            addCriterion("testType <=", value, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeIn(List<Integer> values) {
            addCriterion("testType in", values, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeNotIn(List<Integer> values) {
            addCriterion("testType not in", values, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeBetween(Integer value1, Integer value2) {
            addCriterion("testType between", value1, value2, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("testType not between", value1, value2, "testtype");
            return (Criteria) this;
        }

        public Criteria andTesttype2IsNull() {
            addCriterion("testType2 is null");
            return (Criteria) this;
        }

        public Criteria andTesttype2IsNotNull() {
            addCriterion("testType2 is not null");
            return (Criteria) this;
        }

        public Criteria andTesttype2EqualTo(Integer value) {
            addCriterion("testType2 =", value, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2NotEqualTo(Integer value) {
            addCriterion("testType2 <>", value, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2GreaterThan(Integer value) {
            addCriterion("testType2 >", value, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2GreaterThanOrEqualTo(Integer value) {
            addCriterion("testType2 >=", value, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2LessThan(Integer value) {
            addCriterion("testType2 <", value, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2LessThanOrEqualTo(Integer value) {
            addCriterion("testType2 <=", value, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2In(List<Integer> values) {
            addCriterion("testType2 in", values, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2NotIn(List<Integer> values) {
            addCriterion("testType2 not in", values, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2Between(Integer value1, Integer value2) {
            addCriterion("testType2 between", value1, value2, "testtype2");
            return (Criteria) this;
        }

        public Criteria andTesttype2NotBetween(Integer value1, Integer value2) {
            addCriterion("testType2 not between", value1, value2, "testtype2");
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