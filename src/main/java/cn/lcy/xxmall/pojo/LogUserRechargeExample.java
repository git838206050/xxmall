package cn.lcy.xxmall.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogUserRechargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogUserRechargeExample() {
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

        public Criteria andRechargenumberIsNull() {
            addCriterion("rechargeNumber is null");
            return (Criteria) this;
        }

        public Criteria andRechargenumberIsNotNull() {
            addCriterion("rechargeNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRechargenumberEqualTo(Long value) {
            addCriterion("rechargeNumber =", value, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberNotEqualTo(Long value) {
            addCriterion("rechargeNumber <>", value, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberGreaterThan(Long value) {
            addCriterion("rechargeNumber >", value, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberGreaterThanOrEqualTo(Long value) {
            addCriterion("rechargeNumber >=", value, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberLessThan(Long value) {
            addCriterion("rechargeNumber <", value, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberLessThanOrEqualTo(Long value) {
            addCriterion("rechargeNumber <=", value, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberIn(List<Long> values) {
            addCriterion("rechargeNumber in", values, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberNotIn(List<Long> values) {
            addCriterion("rechargeNumber not in", values, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberBetween(Long value1, Long value2) {
            addCriterion("rechargeNumber between", value1, value2, "rechargenumber");
            return (Criteria) this;
        }

        public Criteria andRechargenumberNotBetween(Long value1, Long value2) {
            addCriterion("rechargeNumber not between", value1, value2, "rechargenumber");
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

        public Criteria andRechargestateIsNull() {
            addCriterion("rechargeState is null");
            return (Criteria) this;
        }

        public Criteria andRechargestateIsNotNull() {
            addCriterion("rechargeState is not null");
            return (Criteria) this;
        }

        public Criteria andRechargestateEqualTo(String value) {
            addCriterion("rechargeState =", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotEqualTo(String value) {
            addCriterion("rechargeState <>", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateGreaterThan(String value) {
            addCriterion("rechargeState >", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateGreaterThanOrEqualTo(String value) {
            addCriterion("rechargeState >=", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateLessThan(String value) {
            addCriterion("rechargeState <", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateLessThanOrEqualTo(String value) {
            addCriterion("rechargeState <=", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateLike(String value) {
            addCriterion("rechargeState like", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotLike(String value) {
            addCriterion("rechargeState not like", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateIn(List<String> values) {
            addCriterion("rechargeState in", values, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotIn(List<String> values) {
            addCriterion("rechargeState not in", values, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateBetween(String value1, String value2) {
            addCriterion("rechargeState between", value1, value2, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotBetween(String value1, String value2) {
            addCriterion("rechargeState not between", value1, value2, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andUseripIsNull() {
            addCriterion("userIp is null");
            return (Criteria) this;
        }

        public Criteria andUseripIsNotNull() {
            addCriterion("userIp is not null");
            return (Criteria) this;
        }

        public Criteria andUseripEqualTo(String value) {
            addCriterion("userIp =", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotEqualTo(String value) {
            addCriterion("userIp <>", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThan(String value) {
            addCriterion("userIp >", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThanOrEqualTo(String value) {
            addCriterion("userIp >=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThan(String value) {
            addCriterion("userIp <", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThanOrEqualTo(String value) {
            addCriterion("userIp <=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLike(String value) {
            addCriterion("userIp like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotLike(String value) {
            addCriterion("userIp not like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripIn(List<String> values) {
            addCriterion("userIp in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotIn(List<String> values) {
            addCriterion("userIp not in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripBetween(String value1, String value2) {
            addCriterion("userIp between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotBetween(String value1, String value2) {
            addCriterion("userIp not between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherIsNull() {
            addCriterion("paymentVoucher is null");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherIsNotNull() {
            addCriterion("paymentVoucher is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherEqualTo(String value) {
            addCriterion("paymentVoucher =", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherNotEqualTo(String value) {
            addCriterion("paymentVoucher <>", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherGreaterThan(String value) {
            addCriterion("paymentVoucher >", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherGreaterThanOrEqualTo(String value) {
            addCriterion("paymentVoucher >=", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherLessThan(String value) {
            addCriterion("paymentVoucher <", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherLessThanOrEqualTo(String value) {
            addCriterion("paymentVoucher <=", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherLike(String value) {
            addCriterion("paymentVoucher like", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherNotLike(String value) {
            addCriterion("paymentVoucher not like", value, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherIn(List<String> values) {
            addCriterion("paymentVoucher in", values, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherNotIn(List<String> values) {
            addCriterion("paymentVoucher not in", values, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherBetween(String value1, String value2) {
            addCriterion("paymentVoucher between", value1, value2, "paymentvoucher");
            return (Criteria) this;
        }

        public Criteria andPaymentvoucherNotBetween(String value1, String value2) {
            addCriterion("paymentVoucher not between", value1, value2, "paymentvoucher");
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