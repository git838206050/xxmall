package cn.lcy.xxmall.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductSkuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductSkuExample() {
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

        public Criteria andProductidIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Integer value) {
            addCriterion("productId =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Integer value) {
            addCriterion("productId <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Integer value) {
            addCriterion("productId >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productId >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Integer value) {
            addCriterion("productId <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Integer value) {
            addCriterion("productId <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Integer> values) {
            addCriterion("productId in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Integer> values) {
            addCriterion("productId not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Integer value1, Integer value2) {
            addCriterion("productId between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Integer value1, Integer value2) {
            addCriterion("productId not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andPropertykeyIsNull() {
            addCriterion("propertyKey is null");
            return (Criteria) this;
        }

        public Criteria andPropertykeyIsNotNull() {
            addCriterion("propertyKey is not null");
            return (Criteria) this;
        }

        public Criteria andPropertykeyEqualTo(String value) {
            addCriterion("propertyKey =", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyNotEqualTo(String value) {
            addCriterion("propertyKey <>", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyGreaterThan(String value) {
            addCriterion("propertyKey >", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyGreaterThanOrEqualTo(String value) {
            addCriterion("propertyKey >=", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyLessThan(String value) {
            addCriterion("propertyKey <", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyLessThanOrEqualTo(String value) {
            addCriterion("propertyKey <=", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyLike(String value) {
            addCriterion("propertyKey like", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyNotLike(String value) {
            addCriterion("propertyKey not like", value, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyIn(List<String> values) {
            addCriterion("propertyKey in", values, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyNotIn(List<String> values) {
            addCriterion("propertyKey not in", values, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyBetween(String value1, String value2) {
            addCriterion("propertyKey between", value1, value2, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertykeyNotBetween(String value1, String value2) {
            addCriterion("propertyKey not between", value1, value2, "propertykey");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupIsNull() {
            addCriterion("propertyValueGroup is null");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupIsNotNull() {
            addCriterion("propertyValueGroup is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupEqualTo(String value) {
            addCriterion("propertyValueGroup =", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupNotEqualTo(String value) {
            addCriterion("propertyValueGroup <>", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupGreaterThan(String value) {
            addCriterion("propertyValueGroup >", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupGreaterThanOrEqualTo(String value) {
            addCriterion("propertyValueGroup >=", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupLessThan(String value) {
            addCriterion("propertyValueGroup <", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupLessThanOrEqualTo(String value) {
            addCriterion("propertyValueGroup <=", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupLike(String value) {
            addCriterion("propertyValueGroup like", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupNotLike(String value) {
            addCriterion("propertyValueGroup not like", value, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupIn(List<String> values) {
            addCriterion("propertyValueGroup in", values, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupNotIn(List<String> values) {
            addCriterion("propertyValueGroup not in", values, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupBetween(String value1, String value2) {
            addCriterion("propertyValueGroup between", value1, value2, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andPropertyvaluegroupNotBetween(String value1, String value2) {
            addCriterion("propertyValueGroup not between", value1, value2, "propertyvaluegroup");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTime not between", value1, value2, "creattime");
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