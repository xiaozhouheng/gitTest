package cn.abl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FFinanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FFinanceExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeIsNull() {
            addCriterion("inspection_fee is null");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeIsNotNull() {
            addCriterion("inspection_fee is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeEqualTo(String value) {
            addCriterion("inspection_fee =", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeNotEqualTo(String value) {
            addCriterion("inspection_fee <>", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeGreaterThan(String value) {
            addCriterion("inspection_fee >", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_fee >=", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeLessThan(String value) {
            addCriterion("inspection_fee <", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeLessThanOrEqualTo(String value) {
            addCriterion("inspection_fee <=", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeLike(String value) {
            addCriterion("inspection_fee like", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeNotLike(String value) {
            addCriterion("inspection_fee not like", value, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeIn(List<String> values) {
            addCriterion("inspection_fee in", values, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeNotIn(List<String> values) {
            addCriterion("inspection_fee not in", values, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeBetween(String value1, String value2) {
            addCriterion("inspection_fee between", value1, value2, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andInspectionFeeNotBetween(String value1, String value2) {
            addCriterion("inspection_fee not between", value1, value2, "inspectionFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeIsNull() {
            addCriterion("storage_fee is null");
            return (Criteria) this;
        }

        public Criteria andStorageFeeIsNotNull() {
            addCriterion("storage_fee is not null");
            return (Criteria) this;
        }

        public Criteria andStorageFeeEqualTo(String value) {
            addCriterion("storage_fee =", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeNotEqualTo(String value) {
            addCriterion("storage_fee <>", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeGreaterThan(String value) {
            addCriterion("storage_fee >", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeGreaterThanOrEqualTo(String value) {
            addCriterion("storage_fee >=", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeLessThan(String value) {
            addCriterion("storage_fee <", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeLessThanOrEqualTo(String value) {
            addCriterion("storage_fee <=", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeLike(String value) {
            addCriterion("storage_fee like", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeNotLike(String value) {
            addCriterion("storage_fee not like", value, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeIn(List<String> values) {
            addCriterion("storage_fee in", values, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeNotIn(List<String> values) {
            addCriterion("storage_fee not in", values, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeBetween(String value1, String value2) {
            addCriterion("storage_fee between", value1, value2, "storageFee");
            return (Criteria) this;
        }

        public Criteria andStorageFeeNotBetween(String value1, String value2) {
            addCriterion("storage_fee not between", value1, value2, "storageFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeIsNull() {
            addCriterion("customs_fee is null");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeIsNotNull() {
            addCriterion("customs_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeEqualTo(String value) {
            addCriterion("customs_fee =", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeNotEqualTo(String value) {
            addCriterion("customs_fee <>", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeGreaterThan(String value) {
            addCriterion("customs_fee >", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeGreaterThanOrEqualTo(String value) {
            addCriterion("customs_fee >=", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeLessThan(String value) {
            addCriterion("customs_fee <", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeLessThanOrEqualTo(String value) {
            addCriterion("customs_fee <=", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeLike(String value) {
            addCriterion("customs_fee like", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeNotLike(String value) {
            addCriterion("customs_fee not like", value, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeIn(List<String> values) {
            addCriterion("customs_fee in", values, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeNotIn(List<String> values) {
            addCriterion("customs_fee not in", values, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeBetween(String value1, String value2) {
            addCriterion("customs_fee between", value1, value2, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCustomsFeeNotBetween(String value1, String value2) {
            addCriterion("customs_fee not between", value1, value2, "customsFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeIsNull() {
            addCriterion("commodity_inspection_fee is null");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeIsNotNull() {
            addCriterion("commodity_inspection_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeEqualTo(String value) {
            addCriterion("commodity_inspection_fee =", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeNotEqualTo(String value) {
            addCriterion("commodity_inspection_fee <>", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeGreaterThan(String value) {
            addCriterion("commodity_inspection_fee >", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_inspection_fee >=", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeLessThan(String value) {
            addCriterion("commodity_inspection_fee <", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeLessThanOrEqualTo(String value) {
            addCriterion("commodity_inspection_fee <=", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeLike(String value) {
            addCriterion("commodity_inspection_fee like", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeNotLike(String value) {
            addCriterion("commodity_inspection_fee not like", value, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeIn(List<String> values) {
            addCriterion("commodity_inspection_fee in", values, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeNotIn(List<String> values) {
            addCriterion("commodity_inspection_fee not in", values, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeBetween(String value1, String value2) {
            addCriterion("commodity_inspection_fee between", value1, value2, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andCommodityInspectionFeeNotBetween(String value1, String value2) {
            addCriterion("commodity_inspection_fee not between", value1, value2, "commodityInspectionFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeIsNull() {
            addCriterion("transit_fee is null");
            return (Criteria) this;
        }

        public Criteria andTransitFeeIsNotNull() {
            addCriterion("transit_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTransitFeeEqualTo(String value) {
            addCriterion("transit_fee =", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeNotEqualTo(String value) {
            addCriterion("transit_fee <>", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeGreaterThan(String value) {
            addCriterion("transit_fee >", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeGreaterThanOrEqualTo(String value) {
            addCriterion("transit_fee >=", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeLessThan(String value) {
            addCriterion("transit_fee <", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeLessThanOrEqualTo(String value) {
            addCriterion("transit_fee <=", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeLike(String value) {
            addCriterion("transit_fee like", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeNotLike(String value) {
            addCriterion("transit_fee not like", value, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeIn(List<String> values) {
            addCriterion("transit_fee in", values, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeNotIn(List<String> values) {
            addCriterion("transit_fee not in", values, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeBetween(String value1, String value2) {
            addCriterion("transit_fee between", value1, value2, "transitFee");
            return (Criteria) this;
        }

        public Criteria andTransitFeeNotBetween(String value1, String value2) {
            addCriterion("transit_fee not between", value1, value2, "transitFee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeIsNull() {
            addCriterion("other1_fee is null");
            return (Criteria) this;
        }

        public Criteria andOther1FeeIsNotNull() {
            addCriterion("other1_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOther1FeeEqualTo(String value) {
            addCriterion("other1_fee =", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeNotEqualTo(String value) {
            addCriterion("other1_fee <>", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeGreaterThan(String value) {
            addCriterion("other1_fee >", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeGreaterThanOrEqualTo(String value) {
            addCriterion("other1_fee >=", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeLessThan(String value) {
            addCriterion("other1_fee <", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeLessThanOrEqualTo(String value) {
            addCriterion("other1_fee <=", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeLike(String value) {
            addCriterion("other1_fee like", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeNotLike(String value) {
            addCriterion("other1_fee not like", value, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeIn(List<String> values) {
            addCriterion("other1_fee in", values, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeNotIn(List<String> values) {
            addCriterion("other1_fee not in", values, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeBetween(String value1, String value2) {
            addCriterion("other1_fee between", value1, value2, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther1FeeNotBetween(String value1, String value2) {
            addCriterion("other1_fee not between", value1, value2, "other1Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeIsNull() {
            addCriterion("other2_fee is null");
            return (Criteria) this;
        }

        public Criteria andOther2FeeIsNotNull() {
            addCriterion("other2_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOther2FeeEqualTo(String value) {
            addCriterion("other2_fee =", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeNotEqualTo(String value) {
            addCriterion("other2_fee <>", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeGreaterThan(String value) {
            addCriterion("other2_fee >", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeGreaterThanOrEqualTo(String value) {
            addCriterion("other2_fee >=", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeLessThan(String value) {
            addCriterion("other2_fee <", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeLessThanOrEqualTo(String value) {
            addCriterion("other2_fee <=", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeLike(String value) {
            addCriterion("other2_fee like", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeNotLike(String value) {
            addCriterion("other2_fee not like", value, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeIn(List<String> values) {
            addCriterion("other2_fee in", values, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeNotIn(List<String> values) {
            addCriterion("other2_fee not in", values, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeBetween(String value1, String value2) {
            addCriterion("other2_fee between", value1, value2, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andOther2FeeNotBetween(String value1, String value2) {
            addCriterion("other2_fee not between", value1, value2, "other2Fee");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaIsNull() {
            addCriterion("calculation_formula is null");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaIsNotNull() {
            addCriterion("calculation_formula is not null");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaEqualTo(String value) {
            addCriterion("calculation_formula =", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotEqualTo(String value) {
            addCriterion("calculation_formula <>", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaGreaterThan(String value) {
            addCriterion("calculation_formula >", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("calculation_formula >=", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaLessThan(String value) {
            addCriterion("calculation_formula <", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaLessThanOrEqualTo(String value) {
            addCriterion("calculation_formula <=", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaLike(String value) {
            addCriterion("calculation_formula like", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotLike(String value) {
            addCriterion("calculation_formula not like", value, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaIn(List<String> values) {
            addCriterion("calculation_formula in", values, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotIn(List<String> values) {
            addCriterion("calculation_formula not in", values, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaBetween(String value1, String value2) {
            addCriterion("calculation_formula between", value1, value2, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andCalculationFormulaNotBetween(String value1, String value2) {
            addCriterion("calculation_formula not between", value1, value2, "calculationFormula");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(String value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(String value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(String value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(String value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(String value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(String value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLike(String value) {
            addCriterion("total_amount like", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotLike(String value) {
            addCriterion("total_amount not like", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<String> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<String> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(String value1, String value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(String value1, String value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureIsNull() {
            addCriterion("revenue_and_expenditure is null");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureIsNotNull() {
            addCriterion("revenue_and_expenditure is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureEqualTo(Integer value) {
            addCriterion("revenue_and_expenditure =", value, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureNotEqualTo(Integer value) {
            addCriterion("revenue_and_expenditure <>", value, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureGreaterThan(Integer value) {
            addCriterion("revenue_and_expenditure >", value, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureGreaterThanOrEqualTo(Integer value) {
            addCriterion("revenue_and_expenditure >=", value, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureLessThan(Integer value) {
            addCriterion("revenue_and_expenditure <", value, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureLessThanOrEqualTo(Integer value) {
            addCriterion("revenue_and_expenditure <=", value, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureIn(List<Integer> values) {
            addCriterion("revenue_and_expenditure in", values, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureNotIn(List<Integer> values) {
            addCriterion("revenue_and_expenditure not in", values, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureBetween(Integer value1, Integer value2) {
            addCriterion("revenue_and_expenditure between", value1, value2, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andRevenueAndExpenditureNotBetween(Integer value1, Integer value2) {
            addCriterion("revenue_and_expenditure not between", value1, value2, "revenueAndExpenditure");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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