package cn.lcy.xxmall.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvertisementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvertisementExample() {
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

        public Criteria andShopidIsNull() {
            addCriterion("shopId is null");
            return (Criteria) this;
        }

        public Criteria andShopidIsNotNull() {
            addCriterion("shopId is not null");
            return (Criteria) this;
        }

        public Criteria andShopidEqualTo(Integer value) {
            addCriterion("shopId =", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotEqualTo(Integer value) {
            addCriterion("shopId <>", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThan(Integer value) {
            addCriterion("shopId >", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopId >=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThan(Integer value) {
            addCriterion("shopId <", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThanOrEqualTo(Integer value) {
            addCriterion("shopId <=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidIn(List<Integer> values) {
            addCriterion("shopId in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotIn(List<Integer> values) {
            addCriterion("shopId not in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidBetween(Integer value1, Integer value2) {
            addCriterion("shopId between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotBetween(Integer value1, Integer value2) {
            addCriterion("shopId not between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andAdvertnameIsNull() {
            addCriterion("advertName is null");
            return (Criteria) this;
        }

        public Criteria andAdvertnameIsNotNull() {
            addCriterion("advertName is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertnameEqualTo(String value) {
            addCriterion("advertName =", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotEqualTo(String value) {
            addCriterion("advertName <>", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameGreaterThan(String value) {
            addCriterion("advertName >", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameGreaterThanOrEqualTo(String value) {
            addCriterion("advertName >=", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameLessThan(String value) {
            addCriterion("advertName <", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameLessThanOrEqualTo(String value) {
            addCriterion("advertName <=", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameLike(String value) {
            addCriterion("advertName like", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotLike(String value) {
            addCriterion("advertName not like", value, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameIn(List<String> values) {
            addCriterion("advertName in", values, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotIn(List<String> values) {
            addCriterion("advertName not in", values, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameBetween(String value1, String value2) {
            addCriterion("advertName between", value1, value2, "advertname");
            return (Criteria) this;
        }

        public Criteria andAdvertnameNotBetween(String value1, String value2) {
            addCriterion("advertName not between", value1, value2, "advertname");
            return (Criteria) this;
        }

        public Criteria andHeaderurlIsNull() {
            addCriterion("headerUrl is null");
            return (Criteria) this;
        }

        public Criteria andHeaderurlIsNotNull() {
            addCriterion("headerUrl is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderurlEqualTo(String value) {
            addCriterion("headerUrl =", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlNotEqualTo(String value) {
            addCriterion("headerUrl <>", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlGreaterThan(String value) {
            addCriterion("headerUrl >", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlGreaterThanOrEqualTo(String value) {
            addCriterion("headerUrl >=", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlLessThan(String value) {
            addCriterion("headerUrl <", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlLessThanOrEqualTo(String value) {
            addCriterion("headerUrl <=", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlLike(String value) {
            addCriterion("headerUrl like", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlNotLike(String value) {
            addCriterion("headerUrl not like", value, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlIn(List<String> values) {
            addCriterion("headerUrl in", values, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlNotIn(List<String> values) {
            addCriterion("headerUrl not in", values, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlBetween(String value1, String value2) {
            addCriterion("headerUrl between", value1, value2, "headerurl");
            return (Criteria) this;
        }

        public Criteria andHeaderurlNotBetween(String value1, String value2) {
            addCriterion("headerUrl not between", value1, value2, "headerurl");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Double value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Double value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Double value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Double value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Double value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Double value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Double> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Double> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Double value1, Double value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Double value1, Double value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Double value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Double value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Double value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Double value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Double value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Double value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Double> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Double> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Double value1, Double value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Double value1, Double value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowIsNull() {
            addCriterion("isFixedShow is null");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowIsNotNull() {
            addCriterion("isFixedShow is not null");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowEqualTo(Byte value) {
            addCriterion("isFixedShow =", value, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowNotEqualTo(Byte value) {
            addCriterion("isFixedShow <>", value, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowGreaterThan(Byte value) {
            addCriterion("isFixedShow >", value, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowGreaterThanOrEqualTo(Byte value) {
            addCriterion("isFixedShow >=", value, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowLessThan(Byte value) {
            addCriterion("isFixedShow <", value, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowLessThanOrEqualTo(Byte value) {
            addCriterion("isFixedShow <=", value, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowIn(List<Byte> values) {
            addCriterion("isFixedShow in", values, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowNotIn(List<Byte> values) {
            addCriterion("isFixedShow not in", values, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowBetween(Byte value1, Byte value2) {
            addCriterion("isFixedShow between", value1, value2, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andIsfixedshowNotBetween(Byte value1, Byte value2) {
            addCriterion("isFixedShow not between", value1, value2, "isfixedshow");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionIsNull() {
            addCriterion("showUrlPosition is null");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionIsNotNull() {
            addCriterion("showUrlPosition is not null");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionEqualTo(String value) {
            addCriterion("showUrlPosition =", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionNotEqualTo(String value) {
            addCriterion("showUrlPosition <>", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionGreaterThan(String value) {
            addCriterion("showUrlPosition >", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionGreaterThanOrEqualTo(String value) {
            addCriterion("showUrlPosition >=", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionLessThan(String value) {
            addCriterion("showUrlPosition <", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionLessThanOrEqualTo(String value) {
            addCriterion("showUrlPosition <=", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionLike(String value) {
            addCriterion("showUrlPosition like", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionNotLike(String value) {
            addCriterion("showUrlPosition not like", value, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionIn(List<String> values) {
            addCriterion("showUrlPosition in", values, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionNotIn(List<String> values) {
            addCriterion("showUrlPosition not in", values, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionBetween(String value1, String value2) {
            addCriterion("showUrlPosition between", value1, value2, "showurlposition");
            return (Criteria) this;
        }

        public Criteria andShowurlpositionNotBetween(String value1, String value2) {
            addCriterion("showUrlPosition not between", value1, value2, "showurlposition");
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

        public Criteria andExpiretimeIsNull() {
            addCriterion("expireTime is null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNotNull() {
            addCriterion("expireTime is not null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeEqualTo(Date value) {
            addCriterion("expireTime =", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotEqualTo(Date value) {
            addCriterion("expireTime <>", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThan(Date value) {
            addCriterion("expireTime >", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expireTime >=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThan(Date value) {
            addCriterion("expireTime <", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThanOrEqualTo(Date value) {
            addCriterion("expireTime <=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIn(List<Date> values) {
            addCriterion("expireTime in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotIn(List<Date> values) {
            addCriterion("expireTime not in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeBetween(Date value1, Date value2) {
            addCriterion("expireTime between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotBetween(Date value1, Date value2) {
            addCriterion("expireTime not between", value1, value2, "expiretime");
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