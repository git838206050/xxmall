package cn.lcy.xxmall.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProducttypeidIsNull() {
            addCriterion("productTypeId is null");
            return (Criteria) this;
        }

        public Criteria andProducttypeidIsNotNull() {
            addCriterion("productTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andProducttypeidEqualTo(Integer value) {
            addCriterion("productTypeId =", value, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidNotEqualTo(Integer value) {
            addCriterion("productTypeId <>", value, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidGreaterThan(Integer value) {
            addCriterion("productTypeId >", value, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productTypeId >=", value, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidLessThan(Integer value) {
            addCriterion("productTypeId <", value, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidLessThanOrEqualTo(Integer value) {
            addCriterion("productTypeId <=", value, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidIn(List<Integer> values) {
            addCriterion("productTypeId in", values, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidNotIn(List<Integer> values) {
            addCriterion("productTypeId not in", values, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidBetween(Integer value1, Integer value2) {
            addCriterion("productTypeId between", value1, value2, "producttypeid");
            return (Criteria) this;
        }

        public Criteria andProducttypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("productTypeId not between", value1, value2, "producttypeid");
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

        public Criteria andUploaduseridIsNull() {
            addCriterion("uploadUserId is null");
            return (Criteria) this;
        }

        public Criteria andUploaduseridIsNotNull() {
            addCriterion("uploadUserId is not null");
            return (Criteria) this;
        }

        public Criteria andUploaduseridEqualTo(Integer value) {
            addCriterion("uploadUserId =", value, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridNotEqualTo(Integer value) {
            addCriterion("uploadUserId <>", value, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridGreaterThan(Integer value) {
            addCriterion("uploadUserId >", value, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("uploadUserId >=", value, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridLessThan(Integer value) {
            addCriterion("uploadUserId <", value, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridLessThanOrEqualTo(Integer value) {
            addCriterion("uploadUserId <=", value, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridIn(List<Integer> values) {
            addCriterion("uploadUserId in", values, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridNotIn(List<Integer> values) {
            addCriterion("uploadUserId not in", values, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridBetween(Integer value1, Integer value2) {
            addCriterion("uploadUserId between", value1, value2, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andUploaduseridNotBetween(Integer value1, Integer value2) {
            addCriterion("uploadUserId not between", value1, value2, "uploaduserid");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("productName =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("productName >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("productName <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("productName like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("productName not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("productName in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productname");
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

        public Criteria andProductstateIsNull() {
            addCriterion("productState is null");
            return (Criteria) this;
        }

        public Criteria andProductstateIsNotNull() {
            addCriterion("productState is not null");
            return (Criteria) this;
        }

        public Criteria andProductstateEqualTo(Byte value) {
            addCriterion("productState =", value, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateNotEqualTo(Byte value) {
            addCriterion("productState <>", value, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateGreaterThan(Byte value) {
            addCriterion("productState >", value, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateGreaterThanOrEqualTo(Byte value) {
            addCriterion("productState >=", value, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateLessThan(Byte value) {
            addCriterion("productState <", value, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateLessThanOrEqualTo(Byte value) {
            addCriterion("productState <=", value, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateIn(List<Byte> values) {
            addCriterion("productState in", values, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateNotIn(List<Byte> values) {
            addCriterion("productState not in", values, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateBetween(Byte value1, Byte value2) {
            addCriterion("productState between", value1, value2, "productstate");
            return (Criteria) this;
        }

        public Criteria andProductstateNotBetween(Byte value1, Byte value2) {
            addCriterion("productState not between", value1, value2, "productstate");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveIsNull() {
            addCriterion("originalPrive is null");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveIsNotNull() {
            addCriterion("originalPrive is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveEqualTo(BigDecimal value) {
            addCriterion("originalPrive =", value, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveNotEqualTo(BigDecimal value) {
            addCriterion("originalPrive <>", value, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveGreaterThan(BigDecimal value) {
            addCriterion("originalPrive >", value, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("originalPrive >=", value, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveLessThan(BigDecimal value) {
            addCriterion("originalPrive <", value, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("originalPrive <=", value, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveIn(List<BigDecimal> values) {
            addCriterion("originalPrive in", values, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveNotIn(List<BigDecimal> values) {
            addCriterion("originalPrive not in", values, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalPrive between", value1, value2, "originalprive");
            return (Criteria) this;
        }

        public Criteria andOriginalpriveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("originalPrive not between", value1, value2, "originalprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveIsNull() {
            addCriterion("discountPrive is null");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveIsNotNull() {
            addCriterion("discountPrive is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveEqualTo(BigDecimal value) {
            addCriterion("discountPrive =", value, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveNotEqualTo(BigDecimal value) {
            addCriterion("discountPrive <>", value, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveGreaterThan(BigDecimal value) {
            addCriterion("discountPrive >", value, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discountPrive >=", value, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveLessThan(BigDecimal value) {
            addCriterion("discountPrive <", value, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discountPrive <=", value, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveIn(List<BigDecimal> values) {
            addCriterion("discountPrive in", values, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveNotIn(List<BigDecimal> values) {
            addCriterion("discountPrive not in", values, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discountPrive between", value1, value2, "discountprive");
            return (Criteria) this;
        }

        public Criteria andDiscountpriveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discountPrive not between", value1, value2, "discountprive");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andDescribingIsNull() {
            addCriterion("describing is null");
            return (Criteria) this;
        }

        public Criteria andDescribingIsNotNull() {
            addCriterion("describing is not null");
            return (Criteria) this;
        }

        public Criteria andDescribingEqualTo(String value) {
            addCriterion("describing =", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingNotEqualTo(String value) {
            addCriterion("describing <>", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingGreaterThan(String value) {
            addCriterion("describing >", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingGreaterThanOrEqualTo(String value) {
            addCriterion("describing >=", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingLessThan(String value) {
            addCriterion("describing <", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingLessThanOrEqualTo(String value) {
            addCriterion("describing <=", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingLike(String value) {
            addCriterion("describing like", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingNotLike(String value) {
            addCriterion("describing not like", value, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingIn(List<String> values) {
            addCriterion("describing in", values, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingNotIn(List<String> values) {
            addCriterion("describing not in", values, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingBetween(String value1, String value2) {
            addCriterion("describing between", value1, value2, "describing");
            return (Criteria) this;
        }

        public Criteria andDescribingNotBetween(String value1, String value2) {
            addCriterion("describing not between", value1, value2, "describing");
            return (Criteria) this;
        }

        public Criteria andMainimageurlIsNull() {
            addCriterion("mainImageUrl is null");
            return (Criteria) this;
        }

        public Criteria andMainimageurlIsNotNull() {
            addCriterion("mainImageUrl is not null");
            return (Criteria) this;
        }

        public Criteria andMainimageurlEqualTo(String value) {
            addCriterion("mainImageUrl =", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlNotEqualTo(String value) {
            addCriterion("mainImageUrl <>", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlGreaterThan(String value) {
            addCriterion("mainImageUrl >", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("mainImageUrl >=", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlLessThan(String value) {
            addCriterion("mainImageUrl <", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlLessThanOrEqualTo(String value) {
            addCriterion("mainImageUrl <=", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlLike(String value) {
            addCriterion("mainImageUrl like", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlNotLike(String value) {
            addCriterion("mainImageUrl not like", value, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlIn(List<String> values) {
            addCriterion("mainImageUrl in", values, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlNotIn(List<String> values) {
            addCriterion("mainImageUrl not in", values, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlBetween(String value1, String value2) {
            addCriterion("mainImageUrl between", value1, value2, "mainimageurl");
            return (Criteria) this;
        }

        public Criteria andMainimageurlNotBetween(String value1, String value2) {
            addCriterion("mainImageUrl not between", value1, value2, "mainimageurl");
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