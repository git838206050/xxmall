package cn.lcy.xxmall.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PdOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PdOrderExample() {
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

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(Byte value) {
            addCriterion("orderStatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(Byte value) {
            addCriterion("orderStatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(Byte value) {
            addCriterion("orderStatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("orderStatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(Byte value) {
            addCriterion("orderStatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(Byte value) {
            addCriterion("orderStatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<Byte> values) {
            addCriterion("orderStatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<Byte> values) {
            addCriterion("orderStatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(Byte value1, Byte value2) {
            addCriterion("orderStatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("orderStatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressIsNull() {
            addCriterion("deliverAddress is null");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressIsNotNull() {
            addCriterion("deliverAddress is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressEqualTo(String value) {
            addCriterion("deliverAddress =", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressNotEqualTo(String value) {
            addCriterion("deliverAddress <>", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressGreaterThan(String value) {
            addCriterion("deliverAddress >", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressGreaterThanOrEqualTo(String value) {
            addCriterion("deliverAddress >=", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressLessThan(String value) {
            addCriterion("deliverAddress <", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressLessThanOrEqualTo(String value) {
            addCriterion("deliverAddress <=", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressLike(String value) {
            addCriterion("deliverAddress like", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressNotLike(String value) {
            addCriterion("deliverAddress not like", value, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressIn(List<String> values) {
            addCriterion("deliverAddress in", values, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressNotIn(List<String> values) {
            addCriterion("deliverAddress not in", values, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressBetween(String value1, String value2) {
            addCriterion("deliverAddress between", value1, value2, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andDeliveraddressNotBetween(String value1, String value2) {
            addCriterion("deliverAddress not between", value1, value2, "deliveraddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressIsNull() {
            addCriterion("sendAddress is null");
            return (Criteria) this;
        }

        public Criteria andSendaddressIsNotNull() {
            addCriterion("sendAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSendaddressEqualTo(String value) {
            addCriterion("sendAddress =", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotEqualTo(String value) {
            addCriterion("sendAddress <>", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressGreaterThan(String value) {
            addCriterion("sendAddress >", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressGreaterThanOrEqualTo(String value) {
            addCriterion("sendAddress >=", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressLessThan(String value) {
            addCriterion("sendAddress <", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressLessThanOrEqualTo(String value) {
            addCriterion("sendAddress <=", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressLike(String value) {
            addCriterion("sendAddress like", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotLike(String value) {
            addCriterion("sendAddress not like", value, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressIn(List<String> values) {
            addCriterion("sendAddress in", values, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotIn(List<String> values) {
            addCriterion("sendAddress not in", values, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressBetween(String value1, String value2) {
            addCriterion("sendAddress between", value1, value2, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andSendaddressNotBetween(String value1, String value2) {
            addCriterion("sendAddress not between", value1, value2, "sendaddress");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andExpressnoIsNull() {
            addCriterion("expressNo is null");
            return (Criteria) this;
        }

        public Criteria andExpressnoIsNotNull() {
            addCriterion("expressNo is not null");
            return (Criteria) this;
        }

        public Criteria andExpressnoEqualTo(String value) {
            addCriterion("expressNo =", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoNotEqualTo(String value) {
            addCriterion("expressNo <>", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoGreaterThan(String value) {
            addCriterion("expressNo >", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoGreaterThanOrEqualTo(String value) {
            addCriterion("expressNo >=", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoLessThan(String value) {
            addCriterion("expressNo <", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoLessThanOrEqualTo(String value) {
            addCriterion("expressNo <=", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoLike(String value) {
            addCriterion("expressNo like", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoNotLike(String value) {
            addCriterion("expressNo not like", value, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoIn(List<String> values) {
            addCriterion("expressNo in", values, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoNotIn(List<String> values) {
            addCriterion("expressNo not in", values, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoBetween(String value1, String value2) {
            addCriterion("expressNo between", value1, value2, "expressno");
            return (Criteria) this;
        }

        public Criteria andExpressnoNotBetween(String value1, String value2) {
            addCriterion("expressNo not between", value1, value2, "expressno");
            return (Criteria) this;
        }

        public Criteria andIsclosedIsNull() {
            addCriterion("isClosed is null");
            return (Criteria) this;
        }

        public Criteria andIsclosedIsNotNull() {
            addCriterion("isClosed is not null");
            return (Criteria) this;
        }

        public Criteria andIsclosedEqualTo(Byte value) {
            addCriterion("isClosed =", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedNotEqualTo(Byte value) {
            addCriterion("isClosed <>", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedGreaterThan(Byte value) {
            addCriterion("isClosed >", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedGreaterThanOrEqualTo(Byte value) {
            addCriterion("isClosed >=", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedLessThan(Byte value) {
            addCriterion("isClosed <", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedLessThanOrEqualTo(Byte value) {
            addCriterion("isClosed <=", value, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedIn(List<Byte> values) {
            addCriterion("isClosed in", values, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedNotIn(List<Byte> values) {
            addCriterion("isClosed not in", values, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedBetween(Byte value1, Byte value2) {
            addCriterion("isClosed between", value1, value2, "isclosed");
            return (Criteria) this;
        }

        public Criteria andIsclosedNotBetween(Byte value1, Byte value2) {
            addCriterion("isClosed not between", value1, value2, "isclosed");
            return (Criteria) this;
        }

        public Criteria andExpressnameIsNull() {
            addCriterion("expressName is null");
            return (Criteria) this;
        }

        public Criteria andExpressnameIsNotNull() {
            addCriterion("expressName is not null");
            return (Criteria) this;
        }

        public Criteria andExpressnameEqualTo(String value) {
            addCriterion("expressName =", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotEqualTo(String value) {
            addCriterion("expressName <>", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameGreaterThan(String value) {
            addCriterion("expressName >", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameGreaterThanOrEqualTo(String value) {
            addCriterion("expressName >=", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameLessThan(String value) {
            addCriterion("expressName <", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameLessThanOrEqualTo(String value) {
            addCriterion("expressName <=", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameLike(String value) {
            addCriterion("expressName like", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotLike(String value) {
            addCriterion("expressName not like", value, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameIn(List<String> values) {
            addCriterion("expressName in", values, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotIn(List<String> values) {
            addCriterion("expressName not in", values, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameBetween(String value1, String value2) {
            addCriterion("expressName between", value1, value2, "expressname");
            return (Criteria) this;
        }

        public Criteria andExpressnameNotBetween(String value1, String value2) {
            addCriterion("expressName not between", value1, value2, "expressname");
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