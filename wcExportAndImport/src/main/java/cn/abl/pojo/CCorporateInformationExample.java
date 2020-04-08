package cn.abl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CCorporateInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CCorporateInformationExample() {
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

        public Criteria andCompanyChNameIsNull() {
            addCriterion("company_ch_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameIsNotNull() {
            addCriterion("company_ch_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameEqualTo(String value) {
            addCriterion("company_ch_name =", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameNotEqualTo(String value) {
            addCriterion("company_ch_name <>", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameGreaterThan(String value) {
            addCriterion("company_ch_name >", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_ch_name >=", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameLessThan(String value) {
            addCriterion("company_ch_name <", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameLessThanOrEqualTo(String value) {
            addCriterion("company_ch_name <=", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameLike(String value) {
            addCriterion("company_ch_name like", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameNotLike(String value) {
            addCriterion("company_ch_name not like", value, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameIn(List<String> values) {
            addCriterion("company_ch_name in", values, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameNotIn(List<String> values) {
            addCriterion("company_ch_name not in", values, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameBetween(String value1, String value2) {
            addCriterion("company_ch_name between", value1, value2, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyChNameNotBetween(String value1, String value2) {
            addCriterion("company_ch_name not between", value1, value2, "companyChName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameIsNull() {
            addCriterion("company_en_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameIsNotNull() {
            addCriterion("company_en_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameEqualTo(String value) {
            addCriterion("company_en_name =", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameNotEqualTo(String value) {
            addCriterion("company_en_name <>", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameGreaterThan(String value) {
            addCriterion("company_en_name >", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_en_name >=", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameLessThan(String value) {
            addCriterion("company_en_name <", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameLessThanOrEqualTo(String value) {
            addCriterion("company_en_name <=", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameLike(String value) {
            addCriterion("company_en_name like", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameNotLike(String value) {
            addCriterion("company_en_name not like", value, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameIn(List<String> values) {
            addCriterion("company_en_name in", values, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameNotIn(List<String> values) {
            addCriterion("company_en_name not in", values, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameBetween(String value1, String value2) {
            addCriterion("company_en_name between", value1, value2, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andCompanyEnNameNotBetween(String value1, String value2) {
            addCriterion("company_en_name not between", value1, value2, "companyEnName");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andEnAddressIsNull() {
            addCriterion("en_address is null");
            return (Criteria) this;
        }

        public Criteria andEnAddressIsNotNull() {
            addCriterion("en_address is not null");
            return (Criteria) this;
        }

        public Criteria andEnAddressEqualTo(String value) {
            addCriterion("en_address =", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressNotEqualTo(String value) {
            addCriterion("en_address <>", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressGreaterThan(String value) {
            addCriterion("en_address >", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressGreaterThanOrEqualTo(String value) {
            addCriterion("en_address >=", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressLessThan(String value) {
            addCriterion("en_address <", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressLessThanOrEqualTo(String value) {
            addCriterion("en_address <=", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressLike(String value) {
            addCriterion("en_address like", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressNotLike(String value) {
            addCriterion("en_address not like", value, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressIn(List<String> values) {
            addCriterion("en_address in", values, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressNotIn(List<String> values) {
            addCriterion("en_address not in", values, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressBetween(String value1, String value2) {
            addCriterion("en_address between", value1, value2, "enAddress");
            return (Criteria) this;
        }

        public Criteria andEnAddressNotBetween(String value1, String value2) {
            addCriterion("en_address not between", value1, value2, "enAddress");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeIsNull() {
            addCriterion("taxpayer_type is null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeIsNotNull() {
            addCriterion("taxpayer_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeEqualTo(Integer value) {
            addCriterion("taxpayer_type =", value, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeNotEqualTo(Integer value) {
            addCriterion("taxpayer_type <>", value, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeGreaterThan(Integer value) {
            addCriterion("taxpayer_type >", value, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("taxpayer_type >=", value, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeLessThan(Integer value) {
            addCriterion("taxpayer_type <", value, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("taxpayer_type <=", value, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeIn(List<Integer> values) {
            addCriterion("taxpayer_type in", values, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeNotIn(List<Integer> values) {
            addCriterion("taxpayer_type not in", values, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeBetween(Integer value1, Integer value2) {
            addCriterion("taxpayer_type between", value1, value2, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andTaxpayerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("taxpayer_type not between", value1, value2, "taxpayerType");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeIsNull() {
            addCriterion("customs_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeIsNotNull() {
            addCriterion("customs_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeEqualTo(String value) {
            addCriterion("customs_code =", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotEqualTo(String value) {
            addCriterion("customs_code <>", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeGreaterThan(String value) {
            addCriterion("customs_code >", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("customs_code >=", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeLessThan(String value) {
            addCriterion("customs_code <", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeLessThanOrEqualTo(String value) {
            addCriterion("customs_code <=", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeLike(String value) {
            addCriterion("customs_code like", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotLike(String value) {
            addCriterion("customs_code not like", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeIn(List<String> values) {
            addCriterion("customs_code in", values, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotIn(List<String> values) {
            addCriterion("customs_code not in", values, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeBetween(String value1, String value2) {
            addCriterion("customs_code between", value1, value2, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotBetween(String value1, String value2) {
            addCriterion("customs_code not between", value1, value2, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberIsNull() {
            addCriterion("commodity_number is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberIsNotNull() {
            addCriterion("commodity_number is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberEqualTo(String value) {
            addCriterion("commodity_number =", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberNotEqualTo(String value) {
            addCriterion("commodity_number <>", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberGreaterThan(String value) {
            addCriterion("commodity_number >", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_number >=", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberLessThan(String value) {
            addCriterion("commodity_number <", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberLessThanOrEqualTo(String value) {
            addCriterion("commodity_number <=", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberLike(String value) {
            addCriterion("commodity_number like", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberNotLike(String value) {
            addCriterion("commodity_number not like", value, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberIn(List<String> values) {
            addCriterion("commodity_number in", values, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberNotIn(List<String> values) {
            addCriterion("commodity_number not in", values, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberBetween(String value1, String value2) {
            addCriterion("commodity_number between", value1, value2, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andCommodityNumberNotBetween(String value1, String value2) {
            addCriterion("commodity_number not between", value1, value2, "commodityNumber");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIsNull() {
            addCriterion("registered_capital is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIsNotNull() {
            addCriterion("registered_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalEqualTo(String value) {
            addCriterion("registered_capital =", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotEqualTo(String value) {
            addCriterion("registered_capital <>", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalGreaterThan(String value) {
            addCriterion("registered_capital >", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalGreaterThanOrEqualTo(String value) {
            addCriterion("registered_capital >=", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLessThan(String value) {
            addCriterion("registered_capital <", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLessThanOrEqualTo(String value) {
            addCriterion("registered_capital <=", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLike(String value) {
            addCriterion("registered_capital like", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotLike(String value) {
            addCriterion("registered_capital not like", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIn(List<String> values) {
            addCriterion("registered_capital in", values, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotIn(List<String> values) {
            addCriterion("registered_capital not in", values, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalBetween(String value1, String value2) {
            addCriterion("registered_capital between", value1, value2, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotBetween(String value1, String value2) {
            addCriterion("registered_capital not between", value1, value2, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andCorporateIsNull() {
            addCriterion("corporate is null");
            return (Criteria) this;
        }

        public Criteria andCorporateIsNotNull() {
            addCriterion("corporate is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateEqualTo(String value) {
            addCriterion("corporate =", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotEqualTo(String value) {
            addCriterion("corporate <>", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateGreaterThan(String value) {
            addCriterion("corporate >", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateGreaterThanOrEqualTo(String value) {
            addCriterion("corporate >=", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateLessThan(String value) {
            addCriterion("corporate <", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateLessThanOrEqualTo(String value) {
            addCriterion("corporate <=", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateLike(String value) {
            addCriterion("corporate like", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotLike(String value) {
            addCriterion("corporate not like", value, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateIn(List<String> values) {
            addCriterion("corporate in", values, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotIn(List<String> values) {
            addCriterion("corporate not in", values, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateBetween(String value1, String value2) {
            addCriterion("corporate between", value1, value2, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateNotBetween(String value1, String value2) {
            addCriterion("corporate not between", value1, value2, "corporate");
            return (Criteria) this;
        }

        public Criteria andCorporateContactIsNull() {
            addCriterion("corporate_contact is null");
            return (Criteria) this;
        }

        public Criteria andCorporateContactIsNotNull() {
            addCriterion("corporate_contact is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateContactEqualTo(String value) {
            addCriterion("corporate_contact =", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactNotEqualTo(String value) {
            addCriterion("corporate_contact <>", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactGreaterThan(String value) {
            addCriterion("corporate_contact >", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactGreaterThanOrEqualTo(String value) {
            addCriterion("corporate_contact >=", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactLessThan(String value) {
            addCriterion("corporate_contact <", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactLessThanOrEqualTo(String value) {
            addCriterion("corporate_contact <=", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactLike(String value) {
            addCriterion("corporate_contact like", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactNotLike(String value) {
            addCriterion("corporate_contact not like", value, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactIn(List<String> values) {
            addCriterion("corporate_contact in", values, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactNotIn(List<String> values) {
            addCriterion("corporate_contact not in", values, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactBetween(String value1, String value2) {
            addCriterion("corporate_contact between", value1, value2, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andCorporateContactNotBetween(String value1, String value2) {
            addCriterion("corporate_contact not between", value1, value2, "corporateContact");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneIsNull() {
            addCriterion("fixed_telephone is null");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneIsNotNull() {
            addCriterion("fixed_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneEqualTo(String value) {
            addCriterion("fixed_telephone =", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotEqualTo(String value) {
            addCriterion("fixed_telephone <>", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneGreaterThan(String value) {
            addCriterion("fixed_telephone >", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_telephone >=", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneLessThan(String value) {
            addCriterion("fixed_telephone <", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneLessThanOrEqualTo(String value) {
            addCriterion("fixed_telephone <=", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneLike(String value) {
            addCriterion("fixed_telephone like", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotLike(String value) {
            addCriterion("fixed_telephone not like", value, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneIn(List<String> values) {
            addCriterion("fixed_telephone in", values, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotIn(List<String> values) {
            addCriterion("fixed_telephone not in", values, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneBetween(String value1, String value2) {
            addCriterion("fixed_telephone between", value1, value2, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andFixedTelephoneNotBetween(String value1, String value2) {
            addCriterion("fixed_telephone not between", value1, value2, "fixedTelephone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxIsNull() {
            addCriterion("business_mailbox is null");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxIsNotNull() {
            addCriterion("business_mailbox is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxEqualTo(String value) {
            addCriterion("business_mailbox =", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxNotEqualTo(String value) {
            addCriterion("business_mailbox <>", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxGreaterThan(String value) {
            addCriterion("business_mailbox >", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxGreaterThanOrEqualTo(String value) {
            addCriterion("business_mailbox >=", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxLessThan(String value) {
            addCriterion("business_mailbox <", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxLessThanOrEqualTo(String value) {
            addCriterion("business_mailbox <=", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxLike(String value) {
            addCriterion("business_mailbox like", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxNotLike(String value) {
            addCriterion("business_mailbox not like", value, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxIn(List<String> values) {
            addCriterion("business_mailbox in", values, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxNotIn(List<String> values) {
            addCriterion("business_mailbox not in", values, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxBetween(String value1, String value2) {
            addCriterion("business_mailbox between", value1, value2, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessMailboxNotBetween(String value1, String value2) {
            addCriterion("business_mailbox not between", value1, value2, "businessMailbox");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionIsNull() {
            addCriterion("is_institution is null");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionIsNotNull() {
            addCriterion("is_institution is not null");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionEqualTo(Integer value) {
            addCriterion("is_institution =", value, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionNotEqualTo(Integer value) {
            addCriterion("is_institution <>", value, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionGreaterThan(Integer value) {
            addCriterion("is_institution >", value, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_institution >=", value, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionLessThan(Integer value) {
            addCriterion("is_institution <", value, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionLessThanOrEqualTo(Integer value) {
            addCriterion("is_institution <=", value, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionIn(List<Integer> values) {
            addCriterion("is_institution in", values, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionNotIn(List<Integer> values) {
            addCriterion("is_institution not in", values, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionBetween(Integer value1, Integer value2) {
            addCriterion("is_institution between", value1, value2, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsInstitutionNotBetween(Integer value1, Integer value2) {
            addCriterion("is_institution not between", value1, value2, "isInstitution");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingIsNull() {
            addCriterion("is_freight_forwarding is null");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingIsNotNull() {
            addCriterion("is_freight_forwarding is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingEqualTo(Integer value) {
            addCriterion("is_freight_forwarding =", value, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingNotEqualTo(Integer value) {
            addCriterion("is_freight_forwarding <>", value, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingGreaterThan(Integer value) {
            addCriterion("is_freight_forwarding >", value, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_freight_forwarding >=", value, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingLessThan(Integer value) {
            addCriterion("is_freight_forwarding <", value, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingLessThanOrEqualTo(Integer value) {
            addCriterion("is_freight_forwarding <=", value, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingIn(List<Integer> values) {
            addCriterion("is_freight_forwarding in", values, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingNotIn(List<Integer> values) {
            addCriterion("is_freight_forwarding not in", values, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingBetween(Integer value1, Integer value2) {
            addCriterion("is_freight_forwarding between", value1, value2, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsFreightForwardingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_freight_forwarding not between", value1, value2, "isFreightForwarding");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportIsNull() {
            addCriterion("is_import_and_export is null");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportIsNotNull() {
            addCriterion("is_import_and_export is not null");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportEqualTo(Integer value) {
            addCriterion("is_import_and_export =", value, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportNotEqualTo(Integer value) {
            addCriterion("is_import_and_export <>", value, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportGreaterThan(Integer value) {
            addCriterion("is_import_and_export >", value, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_import_and_export >=", value, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportLessThan(Integer value) {
            addCriterion("is_import_and_export <", value, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportLessThanOrEqualTo(Integer value) {
            addCriterion("is_import_and_export <=", value, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportIn(List<Integer> values) {
            addCriterion("is_import_and_export in", values, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportNotIn(List<Integer> values) {
            addCriterion("is_import_and_export not in", values, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportBetween(Integer value1, Integer value2) {
            addCriterion("is_import_and_export between", value1, value2, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsImportAndExportNotBetween(Integer value1, Integer value2) {
            addCriterion("is_import_and_export not between", value1, value2, "isImportAndExport");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerIsNull() {
            addCriterion("is_manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerIsNotNull() {
            addCriterion("is_manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerEqualTo(Integer value) {
            addCriterion("is_manufacturer =", value, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerNotEqualTo(Integer value) {
            addCriterion("is_manufacturer <>", value, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerGreaterThan(Integer value) {
            addCriterion("is_manufacturer >", value, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_manufacturer >=", value, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerLessThan(Integer value) {
            addCriterion("is_manufacturer <", value, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerLessThanOrEqualTo(Integer value) {
            addCriterion("is_manufacturer <=", value, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerIn(List<Integer> values) {
            addCriterion("is_manufacturer in", values, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerNotIn(List<Integer> values) {
            addCriterion("is_manufacturer not in", values, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerBetween(Integer value1, Integer value2) {
            addCriterion("is_manufacturer between", value1, value2, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andIsManufacturerNotBetween(Integer value1, Integer value2) {
            addCriterion("is_manufacturer not between", value1, value2, "isManufacturer");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNull() {
            addCriterion("entity_type is null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNotNull() {
            addCriterion("entity_type is not null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeEqualTo(Integer value) {
            addCriterion("entity_type =", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotEqualTo(Integer value) {
            addCriterion("entity_type <>", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThan(Integer value) {
            addCriterion("entity_type >", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("entity_type >=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThan(Integer value) {
            addCriterion("entity_type <", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("entity_type <=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIn(List<Integer> values) {
            addCriterion("entity_type in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotIn(List<Integer> values) {
            addCriterion("entity_type not in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeBetween(Integer value1, Integer value2) {
            addCriterion("entity_type between", value1, value2, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("entity_type not between", value1, value2, "entityType");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andForeignTradeIsNull() {
            addCriterion("foreign_trade is null");
            return (Criteria) this;
        }

        public Criteria andForeignTradeIsNotNull() {
            addCriterion("foreign_trade is not null");
            return (Criteria) this;
        }

        public Criteria andForeignTradeEqualTo(String value) {
            addCriterion("foreign_trade =", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeNotEqualTo(String value) {
            addCriterion("foreign_trade <>", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeGreaterThan(String value) {
            addCriterion("foreign_trade >", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeGreaterThanOrEqualTo(String value) {
            addCriterion("foreign_trade >=", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeLessThan(String value) {
            addCriterion("foreign_trade <", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeLessThanOrEqualTo(String value) {
            addCriterion("foreign_trade <=", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeLike(String value) {
            addCriterion("foreign_trade like", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeNotLike(String value) {
            addCriterion("foreign_trade not like", value, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeIn(List<String> values) {
            addCriterion("foreign_trade in", values, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeNotIn(List<String> values) {
            addCriterion("foreign_trade not in", values, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeBetween(String value1, String value2) {
            addCriterion("foreign_trade between", value1, value2, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andForeignTradeNotBetween(String value1, String value2) {
            addCriterion("foreign_trade not between", value1, value2, "foreignTrade");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationIsNull() {
            addCriterion("customs_registration is null");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationIsNotNull() {
            addCriterion("customs_registration is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationEqualTo(String value) {
            addCriterion("customs_registration =", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationNotEqualTo(String value) {
            addCriterion("customs_registration <>", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationGreaterThan(String value) {
            addCriterion("customs_registration >", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationGreaterThanOrEqualTo(String value) {
            addCriterion("customs_registration >=", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationLessThan(String value) {
            addCriterion("customs_registration <", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationLessThanOrEqualTo(String value) {
            addCriterion("customs_registration <=", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationLike(String value) {
            addCriterion("customs_registration like", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationNotLike(String value) {
            addCriterion("customs_registration not like", value, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationIn(List<String> values) {
            addCriterion("customs_registration in", values, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationNotIn(List<String> values) {
            addCriterion("customs_registration not in", values, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationBetween(String value1, String value2) {
            addCriterion("customs_registration between", value1, value2, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andCustomsRegistrationNotBetween(String value1, String value2) {
            addCriterion("customs_registration not between", value1, value2, "customsRegistration");
            return (Criteria) this;
        }

        public Criteria andUsccIsNull() {
            addCriterion("uscc is null");
            return (Criteria) this;
        }

        public Criteria andUsccIsNotNull() {
            addCriterion("uscc is not null");
            return (Criteria) this;
        }

        public Criteria andUsccEqualTo(String value) {
            addCriterion("uscc =", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccNotEqualTo(String value) {
            addCriterion("uscc <>", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccGreaterThan(String value) {
            addCriterion("uscc >", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccGreaterThanOrEqualTo(String value) {
            addCriterion("uscc >=", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccLessThan(String value) {
            addCriterion("uscc <", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccLessThanOrEqualTo(String value) {
            addCriterion("uscc <=", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccLike(String value) {
            addCriterion("uscc like", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccNotLike(String value) {
            addCriterion("uscc not like", value, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccIn(List<String> values) {
            addCriterion("uscc in", values, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccNotIn(List<String> values) {
            addCriterion("uscc not in", values, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccBetween(String value1, String value2) {
            addCriterion("uscc between", value1, value2, "uscc");
            return (Criteria) this;
        }

        public Criteria andUsccNotBetween(String value1, String value2) {
            addCriterion("uscc not between", value1, value2, "uscc");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNull() {
            addCriterion("create_userid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNotNull() {
            addCriterion("create_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridEqualTo(Integer value) {
            addCriterion("create_userid =", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotEqualTo(Integer value) {
            addCriterion("create_userid <>", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThan(Integer value) {
            addCriterion("create_userid >", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_userid >=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThan(Integer value) {
            addCriterion("create_userid <", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("create_userid <=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIn(List<Integer> values) {
            addCriterion("create_userid in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotIn(List<Integer> values) {
            addCriterion("create_userid not in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridBetween(Integer value1, Integer value2) {
            addCriterion("create_userid between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("create_userid not between", value1, value2, "createUserid");
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

        public Criteria andAnnualInspectionTimeIsNull() {
            addCriterion("annual_inspection_time is null");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeIsNotNull() {
            addCriterion("annual_inspection_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeEqualTo(Date value) {
            addCriterion("annual_inspection_time =", value, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeNotEqualTo(Date value) {
            addCriterion("annual_inspection_time <>", value, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeGreaterThan(Date value) {
            addCriterion("annual_inspection_time >", value, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("annual_inspection_time >=", value, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeLessThan(Date value) {
            addCriterion("annual_inspection_time <", value, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeLessThanOrEqualTo(Date value) {
            addCriterion("annual_inspection_time <=", value, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeIn(List<Date> values) {
            addCriterion("annual_inspection_time in", values, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeNotIn(List<Date> values) {
            addCriterion("annual_inspection_time not in", values, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeBetween(Date value1, Date value2) {
            addCriterion("annual_inspection_time between", value1, value2, "annualInspectionTime");
            return (Criteria) this;
        }

        public Criteria andAnnualInspectionTimeNotBetween(Date value1, Date value2) {
            addCriterion("annual_inspection_time not between", value1, value2, "annualInspectionTime");
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