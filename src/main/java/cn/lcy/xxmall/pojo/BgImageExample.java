package cn.lcy.xxmall.pojo;

import java.util.ArrayList;
import java.util.List;

public class BgImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BgImageExample() {
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

        public Criteria andImageurlIsNull() {
            addCriterion("imageUrl is null");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNotNull() {
            addCriterion("imageUrl is not null");
            return (Criteria) this;
        }

        public Criteria andImageurlEqualTo(String value) {
            addCriterion("imageUrl =", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotEqualTo(String value) {
            addCriterion("imageUrl <>", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThan(String value) {
            addCriterion("imageUrl >", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("imageUrl >=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThan(String value) {
            addCriterion("imageUrl <", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThanOrEqualTo(String value) {
            addCriterion("imageUrl <=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLike(String value) {
            addCriterion("imageUrl like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotLike(String value) {
            addCriterion("imageUrl not like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIn(List<String> values) {
            addCriterion("imageUrl in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotIn(List<String> values) {
            addCriterion("imageUrl not in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlBetween(String value1, String value2) {
            addCriterion("imageUrl between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotBetween(String value1, String value2) {
            addCriterion("imageUrl not between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageencryptIsNull() {
            addCriterion("imageEncrypt is null");
            return (Criteria) this;
        }

        public Criteria andImageencryptIsNotNull() {
            addCriterion("imageEncrypt is not null");
            return (Criteria) this;
        }

        public Criteria andImageencryptEqualTo(String value) {
            addCriterion("imageEncrypt =", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptNotEqualTo(String value) {
            addCriterion("imageEncrypt <>", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptGreaterThan(String value) {
            addCriterion("imageEncrypt >", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptGreaterThanOrEqualTo(String value) {
            addCriterion("imageEncrypt >=", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptLessThan(String value) {
            addCriterion("imageEncrypt <", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptLessThanOrEqualTo(String value) {
            addCriterion("imageEncrypt <=", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptLike(String value) {
            addCriterion("imageEncrypt like", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptNotLike(String value) {
            addCriterion("imageEncrypt not like", value, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptIn(List<String> values) {
            addCriterion("imageEncrypt in", values, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptNotIn(List<String> values) {
            addCriterion("imageEncrypt not in", values, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptBetween(String value1, String value2) {
            addCriterion("imageEncrypt between", value1, value2, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andImageencryptNotBetween(String value1, String value2) {
            addCriterion("imageEncrypt not between", value1, value2, "imageencrypt");
            return (Criteria) this;
        }

        public Criteria andUsenumIsNull() {
            addCriterion("useNum is null");
            return (Criteria) this;
        }

        public Criteria andUsenumIsNotNull() {
            addCriterion("useNum is not null");
            return (Criteria) this;
        }

        public Criteria andUsenumEqualTo(Integer value) {
            addCriterion("useNum =", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumNotEqualTo(Integer value) {
            addCriterion("useNum <>", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumGreaterThan(Integer value) {
            addCriterion("useNum >", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("useNum >=", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumLessThan(Integer value) {
            addCriterion("useNum <", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumLessThanOrEqualTo(Integer value) {
            addCriterion("useNum <=", value, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumIn(List<Integer> values) {
            addCriterion("useNum in", values, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumNotIn(List<Integer> values) {
            addCriterion("useNum not in", values, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumBetween(Integer value1, Integer value2) {
            addCriterion("useNum between", value1, value2, "usenum");
            return (Criteria) this;
        }

        public Criteria andUsenumNotBetween(Integer value1, Integer value2) {
            addCriterion("useNum not between", value1, value2, "usenum");
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