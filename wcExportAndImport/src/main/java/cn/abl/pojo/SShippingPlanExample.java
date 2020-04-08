package cn.abl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SShippingPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SShippingPlanExample() {
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

        public Criteria andBusinessNumberIsNull() {
            addCriterion("business_number is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberIsNotNull() {
            addCriterion("business_number is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberEqualTo(String value) {
            addCriterion("business_number =", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberNotEqualTo(String value) {
            addCriterion("business_number <>", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberGreaterThan(String value) {
            addCriterion("business_number >", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberGreaterThanOrEqualTo(String value) {
            addCriterion("business_number >=", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberLessThan(String value) {
            addCriterion("business_number <", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberLessThanOrEqualTo(String value) {
            addCriterion("business_number <=", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberLike(String value) {
            addCriterion("business_number like", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberNotLike(String value) {
            addCriterion("business_number not like", value, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberIn(List<String> values) {
            addCriterion("business_number in", values, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberNotIn(List<String> values) {
            addCriterion("business_number not in", values, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberBetween(String value1, String value2) {
            addCriterion("business_number between", value1, value2, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessNumberNotBetween(String value1, String value2) {
            addCriterion("business_number not between", value1, value2, "businessNumber");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeIsNull() {
            addCriterion("salesperson_code is null");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeIsNotNull() {
            addCriterion("salesperson_code is not null");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeEqualTo(String value) {
            addCriterion("salesperson_code =", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeNotEqualTo(String value) {
            addCriterion("salesperson_code <>", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeGreaterThan(String value) {
            addCriterion("salesperson_code >", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeGreaterThanOrEqualTo(String value) {
            addCriterion("salesperson_code >=", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeLessThan(String value) {
            addCriterion("salesperson_code <", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeLessThanOrEqualTo(String value) {
            addCriterion("salesperson_code <=", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeLike(String value) {
            addCriterion("salesperson_code like", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeNotLike(String value) {
            addCriterion("salesperson_code not like", value, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeIn(List<String> values) {
            addCriterion("salesperson_code in", values, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeNotIn(List<String> values) {
            addCriterion("salesperson_code not in", values, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeBetween(String value1, String value2) {
            addCriterion("salesperson_code between", value1, value2, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andSalespersonCodeNotBetween(String value1, String value2) {
            addCriterion("salesperson_code not between", value1, value2, "salespersonCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(Date value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(Date value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(Date value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(Date value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<Date> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<Date> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryIsNull() {
            addCriterion("destination_country is null");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryIsNotNull() {
            addCriterion("destination_country is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryEqualTo(String value) {
            addCriterion("destination_country =", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryNotEqualTo(String value) {
            addCriterion("destination_country <>", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryGreaterThan(String value) {
            addCriterion("destination_country >", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryGreaterThanOrEqualTo(String value) {
            addCriterion("destination_country >=", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryLessThan(String value) {
            addCriterion("destination_country <", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryLessThanOrEqualTo(String value) {
            addCriterion("destination_country <=", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryLike(String value) {
            addCriterion("destination_country like", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryNotLike(String value) {
            addCriterion("destination_country not like", value, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryIn(List<String> values) {
            addCriterion("destination_country in", values, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryNotIn(List<String> values) {
            addCriterion("destination_country not in", values, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryBetween(String value1, String value2) {
            addCriterion("destination_country between", value1, value2, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationCountryNotBetween(String value1, String value2) {
            addCriterion("destination_country not between", value1, value2, "destinationCountry");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportIsNull() {
            addCriterion("mode_of_transport is null");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportIsNotNull() {
            addCriterion("mode_of_transport is not null");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportEqualTo(String value) {
            addCriterion("mode_of_transport =", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportNotEqualTo(String value) {
            addCriterion("mode_of_transport <>", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportGreaterThan(String value) {
            addCriterion("mode_of_transport >", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportGreaterThanOrEqualTo(String value) {
            addCriterion("mode_of_transport >=", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportLessThan(String value) {
            addCriterion("mode_of_transport <", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportLessThanOrEqualTo(String value) {
            addCriterion("mode_of_transport <=", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportLike(String value) {
            addCriterion("mode_of_transport like", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportNotLike(String value) {
            addCriterion("mode_of_transport not like", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportIn(List<String> values) {
            addCriterion("mode_of_transport in", values, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportNotIn(List<String> values) {
            addCriterion("mode_of_transport not in", values, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportBetween(String value1, String value2) {
            addCriterion("mode_of_transport between", value1, value2, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportNotBetween(String value1, String value2) {
            addCriterion("mode_of_transport not between", value1, value2, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andExportPortsIsNull() {
            addCriterion("export_ports is null");
            return (Criteria) this;
        }

        public Criteria andExportPortsIsNotNull() {
            addCriterion("export_ports is not null");
            return (Criteria) this;
        }

        public Criteria andExportPortsEqualTo(String value) {
            addCriterion("export_ports =", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsNotEqualTo(String value) {
            addCriterion("export_ports <>", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsGreaterThan(String value) {
            addCriterion("export_ports >", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsGreaterThanOrEqualTo(String value) {
            addCriterion("export_ports >=", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsLessThan(String value) {
            addCriterion("export_ports <", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsLessThanOrEqualTo(String value) {
            addCriterion("export_ports <=", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsLike(String value) {
            addCriterion("export_ports like", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsNotLike(String value) {
            addCriterion("export_ports not like", value, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsIn(List<String> values) {
            addCriterion("export_ports in", values, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsNotIn(List<String> values) {
            addCriterion("export_ports not in", values, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsBetween(String value1, String value2) {
            addCriterion("export_ports between", value1, value2, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andExportPortsNotBetween(String value1, String value2) {
            addCriterion("export_ports not between", value1, value2, "exportPorts");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberIsNull() {
            addCriterion("main_waybill_number is null");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberIsNotNull() {
            addCriterion("main_waybill_number is not null");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberEqualTo(String value) {
            addCriterion("main_waybill_number =", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberNotEqualTo(String value) {
            addCriterion("main_waybill_number <>", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberGreaterThan(String value) {
            addCriterion("main_waybill_number >", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberGreaterThanOrEqualTo(String value) {
            addCriterion("main_waybill_number >=", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberLessThan(String value) {
            addCriterion("main_waybill_number <", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberLessThanOrEqualTo(String value) {
            addCriterion("main_waybill_number <=", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberLike(String value) {
            addCriterion("main_waybill_number like", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberNotLike(String value) {
            addCriterion("main_waybill_number not like", value, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberIn(List<String> values) {
            addCriterion("main_waybill_number in", values, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberNotIn(List<String> values) {
            addCriterion("main_waybill_number not in", values, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberBetween(String value1, String value2) {
            addCriterion("main_waybill_number between", value1, value2, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andMainWaybillNumberNotBetween(String value1, String value2) {
            addCriterion("main_waybill_number not between", value1, value2, "mainWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberIsNull() {
            addCriterion("distribution_order_number is null");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberIsNotNull() {
            addCriterion("distribution_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberEqualTo(String value) {
            addCriterion("distribution_order_number =", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberNotEqualTo(String value) {
            addCriterion("distribution_order_number <>", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberGreaterThan(String value) {
            addCriterion("distribution_order_number >", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("distribution_order_number >=", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberLessThan(String value) {
            addCriterion("distribution_order_number <", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("distribution_order_number <=", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberLike(String value) {
            addCriterion("distribution_order_number like", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberNotLike(String value) {
            addCriterion("distribution_order_number not like", value, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberIn(List<String> values) {
            addCriterion("distribution_order_number in", values, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberNotIn(List<String> values) {
            addCriterion("distribution_order_number not in", values, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberBetween(String value1, String value2) {
            addCriterion("distribution_order_number between", value1, value2, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andDistributionOrderNumberNotBetween(String value1, String value2) {
            addCriterion("distribution_order_number not between", value1, value2, "distributionOrderNumber");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeIsNull() {
            addCriterion("overseas_consignee is null");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeIsNotNull() {
            addCriterion("overseas_consignee is not null");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeEqualTo(String value) {
            addCriterion("overseas_consignee =", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeNotEqualTo(String value) {
            addCriterion("overseas_consignee <>", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeGreaterThan(String value) {
            addCriterion("overseas_consignee >", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeGreaterThanOrEqualTo(String value) {
            addCriterion("overseas_consignee >=", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeLessThan(String value) {
            addCriterion("overseas_consignee <", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeLessThanOrEqualTo(String value) {
            addCriterion("overseas_consignee <=", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeLike(String value) {
            addCriterion("overseas_consignee like", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeNotLike(String value) {
            addCriterion("overseas_consignee not like", value, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeIn(List<String> values) {
            addCriterion("overseas_consignee in", values, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeNotIn(List<String> values) {
            addCriterion("overseas_consignee not in", values, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeBetween(String value1, String value2) {
            addCriterion("overseas_consignee between", value1, value2, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andOverseasConsigneeNotBetween(String value1, String value2) {
            addCriterion("overseas_consignee not between", value1, value2, "overseasConsignee");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperIsNull() {
            addCriterion("domestic_shipper is null");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperIsNotNull() {
            addCriterion("domestic_shipper is not null");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperEqualTo(String value) {
            addCriterion("domestic_shipper =", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperNotEqualTo(String value) {
            addCriterion("domestic_shipper <>", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperGreaterThan(String value) {
            addCriterion("domestic_shipper >", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperGreaterThanOrEqualTo(String value) {
            addCriterion("domestic_shipper >=", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperLessThan(String value) {
            addCriterion("domestic_shipper <", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperLessThanOrEqualTo(String value) {
            addCriterion("domestic_shipper <=", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperLike(String value) {
            addCriterion("domestic_shipper like", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperNotLike(String value) {
            addCriterion("domestic_shipper not like", value, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperIn(List<String> values) {
            addCriterion("domestic_shipper in", values, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperNotIn(List<String> values) {
            addCriterion("domestic_shipper not in", values, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperBetween(String value1, String value2) {
            addCriterion("domestic_shipper between", value1, value2, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andDomesticShipperNotBetween(String value1, String value2) {
            addCriterion("domestic_shipper not between", value1, value2, "domesticShipper");
            return (Criteria) this;
        }

        public Criteria andProductionUnitIsNull() {
            addCriterion("production_unit is null");
            return (Criteria) this;
        }

        public Criteria andProductionUnitIsNotNull() {
            addCriterion("production_unit is not null");
            return (Criteria) this;
        }

        public Criteria andProductionUnitEqualTo(String value) {
            addCriterion("production_unit =", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitNotEqualTo(String value) {
            addCriterion("production_unit <>", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitGreaterThan(String value) {
            addCriterion("production_unit >", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitGreaterThanOrEqualTo(String value) {
            addCriterion("production_unit >=", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitLessThan(String value) {
            addCriterion("production_unit <", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitLessThanOrEqualTo(String value) {
            addCriterion("production_unit <=", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitLike(String value) {
            addCriterion("production_unit like", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitNotLike(String value) {
            addCriterion("production_unit not like", value, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitIn(List<String> values) {
            addCriterion("production_unit in", values, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitNotIn(List<String> values) {
            addCriterion("production_unit not in", values, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitBetween(String value1, String value2) {
            addCriterion("production_unit between", value1, value2, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andProductionUnitNotBetween(String value1, String value2) {
            addCriterion("production_unit not between", value1, value2, "productionUnit");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNull() {
            addCriterion("total_number is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIsNotNull() {
            addCriterion("total_number is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumberEqualTo(Integer value) {
            addCriterion("total_number =", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotEqualTo(Integer value) {
            addCriterion("total_number <>", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThan(Integer value) {
            addCriterion("total_number >", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_number >=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThan(Integer value) {
            addCriterion("total_number <", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberLessThanOrEqualTo(Integer value) {
            addCriterion("total_number <=", value, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberIn(List<Integer> values) {
            addCriterion("total_number in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotIn(List<Integer> values) {
            addCriterion("total_number not in", values, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberBetween(Integer value1, Integer value2) {
            addCriterion("total_number between", value1, value2, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("total_number not between", value1, value2, "totalNumber");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightIsNull() {
            addCriterion("total_Gross_weight is null");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightIsNotNull() {
            addCriterion("total_Gross_weight is not null");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightEqualTo(String value) {
            addCriterion("total_Gross_weight =", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightNotEqualTo(String value) {
            addCriterion("total_Gross_weight <>", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightGreaterThan(String value) {
            addCriterion("total_Gross_weight >", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightGreaterThanOrEqualTo(String value) {
            addCriterion("total_Gross_weight >=", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightLessThan(String value) {
            addCriterion("total_Gross_weight <", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightLessThanOrEqualTo(String value) {
            addCriterion("total_Gross_weight <=", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightLike(String value) {
            addCriterion("total_Gross_weight like", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightNotLike(String value) {
            addCriterion("total_Gross_weight not like", value, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightIn(List<String> values) {
            addCriterion("total_Gross_weight in", values, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightNotIn(List<String> values) {
            addCriterion("total_Gross_weight not in", values, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightBetween(String value1, String value2) {
            addCriterion("total_Gross_weight between", value1, value2, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalGrossWeightNotBetween(String value1, String value2) {
            addCriterion("total_Gross_weight not between", value1, value2, "totalGrossWeight");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityIsNull() {
            addCriterion("total_capacity is null");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityIsNotNull() {
            addCriterion("total_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityEqualTo(String value) {
            addCriterion("total_capacity =", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityNotEqualTo(String value) {
            addCriterion("total_capacity <>", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityGreaterThan(String value) {
            addCriterion("total_capacity >", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("total_capacity >=", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityLessThan(String value) {
            addCriterion("total_capacity <", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityLessThanOrEqualTo(String value) {
            addCriterion("total_capacity <=", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityLike(String value) {
            addCriterion("total_capacity like", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityNotLike(String value) {
            addCriterion("total_capacity not like", value, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityIn(List<String> values) {
            addCriterion("total_capacity in", values, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityNotIn(List<String> values) {
            addCriterion("total_capacity not in", values, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityBetween(String value1, String value2) {
            addCriterion("total_capacity between", value1, value2, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andTotalCapacityNotBetween(String value1, String value2) {
            addCriterion("total_capacity not between", value1, value2, "totalCapacity");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIsNull() {
            addCriterion("packing_type is null");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIsNotNull() {
            addCriterion("packing_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackingTypeEqualTo(Integer value) {
            addCriterion("packing_type =", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotEqualTo(Integer value) {
            addCriterion("packing_type <>", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeGreaterThan(Integer value) {
            addCriterion("packing_type >", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("packing_type >=", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLessThan(Integer value) {
            addCriterion("packing_type <", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeLessThanOrEqualTo(Integer value) {
            addCriterion("packing_type <=", value, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeIn(List<Integer> values) {
            addCriterion("packing_type in", values, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotIn(List<Integer> values) {
            addCriterion("packing_type not in", values, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeBetween(Integer value1, Integer value2) {
            addCriterion("packing_type between", value1, value2, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackingTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("packing_type not between", value1, value2, "packingType");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsIsNull() {
            addCriterion("package_dimensions is null");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsIsNotNull() {
            addCriterion("package_dimensions is not null");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsEqualTo(String value) {
            addCriterion("package_dimensions =", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsNotEqualTo(String value) {
            addCriterion("package_dimensions <>", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsGreaterThan(String value) {
            addCriterion("package_dimensions >", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsGreaterThanOrEqualTo(String value) {
            addCriterion("package_dimensions >=", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsLessThan(String value) {
            addCriterion("package_dimensions <", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsLessThanOrEqualTo(String value) {
            addCriterion("package_dimensions <=", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsLike(String value) {
            addCriterion("package_dimensions like", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsNotLike(String value) {
            addCriterion("package_dimensions not like", value, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsIn(List<String> values) {
            addCriterion("package_dimensions in", values, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsNotIn(List<String> values) {
            addCriterion("package_dimensions not in", values, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsBetween(String value1, String value2) {
            addCriterion("package_dimensions between", value1, value2, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andPackageDimensionsNotBetween(String value1, String value2) {
            addCriterion("package_dimensions not between", value1, value2, "packageDimensions");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeIsNull() {
            addCriterion("supervision_type is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeIsNotNull() {
            addCriterion("supervision_type is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeEqualTo(Integer value) {
            addCriterion("supervision_type =", value, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeNotEqualTo(Integer value) {
            addCriterion("supervision_type <>", value, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeGreaterThan(Integer value) {
            addCriterion("supervision_type >", value, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("supervision_type >=", value, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeLessThan(Integer value) {
            addCriterion("supervision_type <", value, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("supervision_type <=", value, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeIn(List<Integer> values) {
            addCriterion("supervision_type in", values, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeNotIn(List<Integer> values) {
            addCriterion("supervision_type not in", values, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeBetween(Integer value1, Integer value2) {
            addCriterion("supervision_type between", value1, value2, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andSupervisionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("supervision_type not between", value1, value2, "supervisionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepIsNull() {
            addCriterion("transaction_tyep is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepIsNotNull() {
            addCriterion("transaction_tyep is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepEqualTo(Integer value) {
            addCriterion("transaction_tyep =", value, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepNotEqualTo(Integer value) {
            addCriterion("transaction_tyep <>", value, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepGreaterThan(Integer value) {
            addCriterion("transaction_tyep >", value, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_tyep >=", value, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepLessThan(Integer value) {
            addCriterion("transaction_tyep <", value, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_tyep <=", value, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepIn(List<Integer> values) {
            addCriterion("transaction_tyep in", values, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepNotIn(List<Integer> values) {
            addCriterion("transaction_tyep not in", values, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepBetween(Integer value1, Integer value2) {
            addCriterion("transaction_tyep between", value1, value2, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andTransactionTyepNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_tyep not between", value1, value2, "transactionTyep");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(String value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(String value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(String value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(String value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(String value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(String value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLike(String value) {
            addCriterion("freight like", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotLike(String value) {
            addCriterion("freight not like", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<String> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<String> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(String value1, String value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(String value1, String value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andPremiumIsNull() {
            addCriterion("premium is null");
            return (Criteria) this;
        }

        public Criteria andPremiumIsNotNull() {
            addCriterion("premium is not null");
            return (Criteria) this;
        }

        public Criteria andPremiumEqualTo(String value) {
            addCriterion("premium =", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotEqualTo(String value) {
            addCriterion("premium <>", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumGreaterThan(String value) {
            addCriterion("premium >", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumGreaterThanOrEqualTo(String value) {
            addCriterion("premium >=", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLessThan(String value) {
            addCriterion("premium <", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLessThanOrEqualTo(String value) {
            addCriterion("premium <=", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLike(String value) {
            addCriterion("premium like", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotLike(String value) {
            addCriterion("premium not like", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumIn(List<String> values) {
            addCriterion("premium in", values, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotIn(List<String> values) {
            addCriterion("premium not in", values, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumBetween(String value1, String value2) {
            addCriterion("premium between", value1, value2, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotBetween(String value1, String value2) {
            addCriterion("premium not between", value1, value2, "premium");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNull() {
            addCriterion("invoice is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIsNotNull() {
            addCriterion("invoice is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEqualTo(String value) {
            addCriterion("invoice =", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotEqualTo(String value) {
            addCriterion("invoice <>", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThan(String value) {
            addCriterion("invoice >", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("invoice >=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThan(String value) {
            addCriterion("invoice <", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLessThanOrEqualTo(String value) {
            addCriterion("invoice <=", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceLike(String value) {
            addCriterion("invoice like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotLike(String value) {
            addCriterion("invoice not like", value, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceIn(List<String> values) {
            addCriterion("invoice in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotIn(List<String> values) {
            addCriterion("invoice not in", values, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceBetween(String value1, String value2) {
            addCriterion("invoice between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andInvoiceNotBetween(String value1, String value2) {
            addCriterion("invoice not between", value1, value2, "invoice");
            return (Criteria) this;
        }

        public Criteria andPackingListIsNull() {
            addCriterion("packing_list is null");
            return (Criteria) this;
        }

        public Criteria andPackingListIsNotNull() {
            addCriterion("packing_list is not null");
            return (Criteria) this;
        }

        public Criteria andPackingListEqualTo(String value) {
            addCriterion("packing_list =", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotEqualTo(String value) {
            addCriterion("packing_list <>", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListGreaterThan(String value) {
            addCriterion("packing_list >", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListGreaterThanOrEqualTo(String value) {
            addCriterion("packing_list >=", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLessThan(String value) {
            addCriterion("packing_list <", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLessThanOrEqualTo(String value) {
            addCriterion("packing_list <=", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListLike(String value) {
            addCriterion("packing_list like", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotLike(String value) {
            addCriterion("packing_list not like", value, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListIn(List<String> values) {
            addCriterion("packing_list in", values, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotIn(List<String> values) {
            addCriterion("packing_list not in", values, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListBetween(String value1, String value2) {
            addCriterion("packing_list between", value1, value2, "packingList");
            return (Criteria) this;
        }

        public Criteria andPackingListNotBetween(String value1, String value2) {
            addCriterion("packing_list not between", value1, value2, "packingList");
            return (Criteria) this;
        }

        public Criteria andContractIsNull() {
            addCriterion("contract is null");
            return (Criteria) this;
        }

        public Criteria andContractIsNotNull() {
            addCriterion("contract is not null");
            return (Criteria) this;
        }

        public Criteria andContractEqualTo(String value) {
            addCriterion("contract =", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotEqualTo(String value) {
            addCriterion("contract <>", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThan(String value) {
            addCriterion("contract >", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThanOrEqualTo(String value) {
            addCriterion("contract >=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThan(String value) {
            addCriterion("contract <", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThanOrEqualTo(String value) {
            addCriterion("contract <=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLike(String value) {
            addCriterion("contract like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotLike(String value) {
            addCriterion("contract not like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractIn(List<String> values) {
            addCriterion("contract in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotIn(List<String> values) {
            addCriterion("contract not in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractBetween(String value1, String value2) {
            addCriterion("contract between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotBetween(String value1, String value2) {
            addCriterion("contract not between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andCpoaIsNull() {
            addCriterion("cpoa is null");
            return (Criteria) this;
        }

        public Criteria andCpoaIsNotNull() {
            addCriterion("cpoa is not null");
            return (Criteria) this;
        }

        public Criteria andCpoaEqualTo(String value) {
            addCriterion("cpoa =", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaNotEqualTo(String value) {
            addCriterion("cpoa <>", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaGreaterThan(String value) {
            addCriterion("cpoa >", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaGreaterThanOrEqualTo(String value) {
            addCriterion("cpoa >=", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaLessThan(String value) {
            addCriterion("cpoa <", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaLessThanOrEqualTo(String value) {
            addCriterion("cpoa <=", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaLike(String value) {
            addCriterion("cpoa like", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaNotLike(String value) {
            addCriterion("cpoa not like", value, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaIn(List<String> values) {
            addCriterion("cpoa in", values, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaNotIn(List<String> values) {
            addCriterion("cpoa not in", values, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaBetween(String value1, String value2) {
            addCriterion("cpoa between", value1, value2, "cpoa");
            return (Criteria) this;
        }

        public Criteria andCpoaNotBetween(String value1, String value2) {
            addCriterion("cpoa not between", value1, value2, "cpoa");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsIsNull() {
            addCriterion("packing_details is null");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsIsNotNull() {
            addCriterion("packing_details is not null");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsEqualTo(String value) {
            addCriterion("packing_details =", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotEqualTo(String value) {
            addCriterion("packing_details <>", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsGreaterThan(String value) {
            addCriterion("packing_details >", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("packing_details >=", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsLessThan(String value) {
            addCriterion("packing_details <", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsLessThanOrEqualTo(String value) {
            addCriterion("packing_details <=", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsLike(String value) {
            addCriterion("packing_details like", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotLike(String value) {
            addCriterion("packing_details not like", value, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsIn(List<String> values) {
            addCriterion("packing_details in", values, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotIn(List<String> values) {
            addCriterion("packing_details not in", values, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsBetween(String value1, String value2) {
            addCriterion("packing_details between", value1, value2, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andPackingDetailsNotBetween(String value1, String value2) {
            addCriterion("packing_details not between", value1, value2, "packingDetails");
            return (Criteria) this;
        }

        public Criteria andOther1IsNull() {
            addCriterion("other1 is null");
            return (Criteria) this;
        }

        public Criteria andOther1IsNotNull() {
            addCriterion("other1 is not null");
            return (Criteria) this;
        }

        public Criteria andOther1EqualTo(String value) {
            addCriterion("other1 =", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotEqualTo(String value) {
            addCriterion("other1 <>", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThan(String value) {
            addCriterion("other1 >", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThanOrEqualTo(String value) {
            addCriterion("other1 >=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThan(String value) {
            addCriterion("other1 <", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThanOrEqualTo(String value) {
            addCriterion("other1 <=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Like(String value) {
            addCriterion("other1 like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotLike(String value) {
            addCriterion("other1 not like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1In(List<String> values) {
            addCriterion("other1 in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotIn(List<String> values) {
            addCriterion("other1 not in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Between(String value1, String value2) {
            addCriterion("other1 between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotBetween(String value1, String value2) {
            addCriterion("other1 not between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther2IsNull() {
            addCriterion("other2 is null");
            return (Criteria) this;
        }

        public Criteria andOther2IsNotNull() {
            addCriterion("other2 is not null");
            return (Criteria) this;
        }

        public Criteria andOther2EqualTo(String value) {
            addCriterion("other2 =", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotEqualTo(String value) {
            addCriterion("other2 <>", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThan(String value) {
            addCriterion("other2 >", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThanOrEqualTo(String value) {
            addCriterion("other2 >=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThan(String value) {
            addCriterion("other2 <", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThanOrEqualTo(String value) {
            addCriterion("other2 <=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Like(String value) {
            addCriterion("other2 like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotLike(String value) {
            addCriterion("other2 not like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2In(List<String> values) {
            addCriterion("other2 in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotIn(List<String> values) {
            addCriterion("other2 not in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Between(String value1, String value2) {
            addCriterion("other2 between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotBetween(String value1, String value2) {
            addCriterion("other2 not between", value1, value2, "other2");
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

        public Criteria andCreateUseridIsNull() {
            addCriterion("create_userid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNotNull() {
            addCriterion("create_userid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridEqualTo(String value) {
            addCriterion("create_userid =", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotEqualTo(String value) {
            addCriterion("create_userid <>", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThan(String value) {
            addCriterion("create_userid >", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThanOrEqualTo(String value) {
            addCriterion("create_userid >=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThan(String value) {
            addCriterion("create_userid <", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThanOrEqualTo(String value) {
            addCriterion("create_userid <=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLike(String value) {
            addCriterion("create_userid like", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotLike(String value) {
            addCriterion("create_userid not like", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIn(List<String> values) {
            addCriterion("create_userid in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotIn(List<String> values) {
            addCriterion("create_userid not in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridBetween(String value1, String value2) {
            addCriterion("create_userid between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotBetween(String value1, String value2) {
            addCriterion("create_userid not between", value1, value2, "createUserid");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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