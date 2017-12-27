package cn.lcy.xxmall.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserDetailedInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDetailedInfoExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andRemainingfundIsNull() {
            addCriterion("remainingFund is null");
            return (Criteria) this;
        }

        public Criteria andRemainingfundIsNotNull() {
            addCriterion("remainingFund is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingfundEqualTo(BigDecimal value) {
            addCriterion("remainingFund =", value, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundNotEqualTo(BigDecimal value) {
            addCriterion("remainingFund <>", value, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundGreaterThan(BigDecimal value) {
            addCriterion("remainingFund >", value, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("remainingFund >=", value, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundLessThan(BigDecimal value) {
            addCriterion("remainingFund <", value, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("remainingFund <=", value, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundIn(List<BigDecimal> values) {
            addCriterion("remainingFund in", values, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundNotIn(List<BigDecimal> values) {
            addCriterion("remainingFund not in", values, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remainingFund between", value1, value2, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andRemainingfundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remainingFund not between", value1, value2, "remainingfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundIsNull() {
            addCriterion("consumptionFund is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundIsNotNull() {
            addCriterion("consumptionFund is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundEqualTo(BigDecimal value) {
            addCriterion("consumptionFund =", value, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundNotEqualTo(BigDecimal value) {
            addCriterion("consumptionFund <>", value, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundGreaterThan(BigDecimal value) {
            addCriterion("consumptionFund >", value, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consumptionFund >=", value, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundLessThan(BigDecimal value) {
            addCriterion("consumptionFund <", value, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consumptionFund <=", value, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundIn(List<BigDecimal> values) {
            addCriterion("consumptionFund in", values, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundNotIn(List<BigDecimal> values) {
            addCriterion("consumptionFund not in", values, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumptionFund between", value1, value2, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andConsumptionfundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumptionFund not between", value1, value2, "consumptionfund");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressIsNull() {
            addCriterion("defaultAddress is null");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressIsNotNull() {
            addCriterion("defaultAddress is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressEqualTo(String value) {
            addCriterion("defaultAddress =", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressNotEqualTo(String value) {
            addCriterion("defaultAddress <>", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressGreaterThan(String value) {
            addCriterion("defaultAddress >", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressGreaterThanOrEqualTo(String value) {
            addCriterion("defaultAddress >=", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressLessThan(String value) {
            addCriterion("defaultAddress <", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressLessThanOrEqualTo(String value) {
            addCriterion("defaultAddress <=", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressLike(String value) {
            addCriterion("defaultAddress like", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressNotLike(String value) {
            addCriterion("defaultAddress not like", value, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressIn(List<String> values) {
            addCriterion("defaultAddress in", values, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressNotIn(List<String> values) {
            addCriterion("defaultAddress not in", values, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressBetween(String value1, String value2) {
            addCriterion("defaultAddress between", value1, value2, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andDefaultaddressNotBetween(String value1, String value2) {
            addCriterion("defaultAddress not between", value1, value2, "defaultaddress");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
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