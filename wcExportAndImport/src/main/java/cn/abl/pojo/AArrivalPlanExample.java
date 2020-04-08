package cn.abl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AArrivalPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AArrivalPlanExample() {
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

        public Criteria andImportPortIsNull() {
            addCriterion("import_port is null");
            return (Criteria) this;
        }

        public Criteria andImportPortIsNotNull() {
            addCriterion("import_port is not null");
            return (Criteria) this;
        }

        public Criteria andImportPortEqualTo(String value) {
            addCriterion("import_port =", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortNotEqualTo(String value) {
            addCriterion("import_port <>", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortGreaterThan(String value) {
            addCriterion("import_port >", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortGreaterThanOrEqualTo(String value) {
            addCriterion("import_port >=", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortLessThan(String value) {
            addCriterion("import_port <", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortLessThanOrEqualTo(String value) {
            addCriterion("import_port <=", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortLike(String value) {
            addCriterion("import_port like", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortNotLike(String value) {
            addCriterion("import_port not like", value, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortIn(List<String> values) {
            addCriterion("import_port in", values, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortNotIn(List<String> values) {
            addCriterion("import_port not in", values, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortBetween(String value1, String value2) {
            addCriterion("import_port between", value1, value2, "importPort");
            return (Criteria) this;
        }

        public Criteria andImportPortNotBetween(String value1, String value2) {
            addCriterion("import_port not between", value1, value2, "importPort");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeIsNull() {
            addCriterion("estimated_arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeIsNotNull() {
            addCriterion("estimated_arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeEqualTo(Date value) {
            addCriterion("estimated_arrival_time =", value, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeNotEqualTo(Date value) {
            addCriterion("estimated_arrival_time <>", value, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeGreaterThan(Date value) {
            addCriterion("estimated_arrival_time >", value, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("estimated_arrival_time >=", value, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeLessThan(Date value) {
            addCriterion("estimated_arrival_time <", value, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeLessThanOrEqualTo(Date value) {
            addCriterion("estimated_arrival_time <=", value, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeIn(List<Date> values) {
            addCriterion("estimated_arrival_time in", values, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeNotIn(List<Date> values) {
            addCriterion("estimated_arrival_time not in", values, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeBetween(Date value1, Date value2) {
            addCriterion("estimated_arrival_time between", value1, value2, "estimatedArrivalTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedArrivalTimeNotBetween(Date value1, Date value2) {
            addCriterion("estimated_arrival_time not between", value1, value2, "estimatedArrivalTime");
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

        public Criteria andModeOfTransportEqualTo(Integer value) {
            addCriterion("mode_of_transport =", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportNotEqualTo(Integer value) {
            addCriterion("mode_of_transport <>", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportGreaterThan(Integer value) {
            addCriterion("mode_of_transport >", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportGreaterThanOrEqualTo(Integer value) {
            addCriterion("mode_of_transport >=", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportLessThan(Integer value) {
            addCriterion("mode_of_transport <", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportLessThanOrEqualTo(Integer value) {
            addCriterion("mode_of_transport <=", value, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportIn(List<Integer> values) {
            addCriterion("mode_of_transport in", values, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportNotIn(List<Integer> values) {
            addCriterion("mode_of_transport not in", values, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportBetween(Integer value1, Integer value2) {
            addCriterion("mode_of_transport between", value1, value2, "modeOfTransport");
            return (Criteria) this;
        }

        public Criteria andModeOfTransportNotBetween(Integer value1, Integer value2) {
            addCriterion("mode_of_transport not between", value1, value2, "modeOfTransport");
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

        public Criteria andFenWaybillNumberIsNull() {
            addCriterion("fen_waybill_number is null");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberIsNotNull() {
            addCriterion("fen_waybill_number is not null");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberEqualTo(String value) {
            addCriterion("fen_waybill_number =", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberNotEqualTo(String value) {
            addCriterion("fen_waybill_number <>", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberGreaterThan(String value) {
            addCriterion("fen_waybill_number >", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberGreaterThanOrEqualTo(String value) {
            addCriterion("fen_waybill_number >=", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberLessThan(String value) {
            addCriterion("fen_waybill_number <", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberLessThanOrEqualTo(String value) {
            addCriterion("fen_waybill_number <=", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberLike(String value) {
            addCriterion("fen_waybill_number like", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberNotLike(String value) {
            addCriterion("fen_waybill_number not like", value, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberIn(List<String> values) {
            addCriterion("fen_waybill_number in", values, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberNotIn(List<String> values) {
            addCriterion("fen_waybill_number not in", values, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberBetween(String value1, String value2) {
            addCriterion("fen_waybill_number between", value1, value2, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andFenWaybillNumberNotBetween(String value1, String value2) {
            addCriterion("fen_waybill_number not between", value1, value2, "fenWaybillNumber");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperIsNull() {
            addCriterion("overseas_shipper is null");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperIsNotNull() {
            addCriterion("overseas_shipper is not null");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperEqualTo(String value) {
            addCriterion("overseas_shipper =", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperNotEqualTo(String value) {
            addCriterion("overseas_shipper <>", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperGreaterThan(String value) {
            addCriterion("overseas_shipper >", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperGreaterThanOrEqualTo(String value) {
            addCriterion("overseas_shipper >=", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperLessThan(String value) {
            addCriterion("overseas_shipper <", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperLessThanOrEqualTo(String value) {
            addCriterion("overseas_shipper <=", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperLike(String value) {
            addCriterion("overseas_shipper like", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperNotLike(String value) {
            addCriterion("overseas_shipper not like", value, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperIn(List<String> values) {
            addCriterion("overseas_shipper in", values, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperNotIn(List<String> values) {
            addCriterion("overseas_shipper not in", values, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperBetween(String value1, String value2) {
            addCriterion("overseas_shipper between", value1, value2, "overseasShipper");
            return (Criteria) this;
        }

        public Criteria andOverseasShipperNotBetween(String value1, String value2) {
            addCriterion("overseas_shipper not between", value1, value2, "overseasShipper");
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

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
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

        public Criteria andIppcIsNull() {
            addCriterion("ippc is null");
            return (Criteria) this;
        }

        public Criteria andIppcIsNotNull() {
            addCriterion("ippc is not null");
            return (Criteria) this;
        }

        public Criteria andIppcEqualTo(Integer value) {
            addCriterion("ippc =", value, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcNotEqualTo(Integer value) {
            addCriterion("ippc <>", value, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcGreaterThan(Integer value) {
            addCriterion("ippc >", value, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcGreaterThanOrEqualTo(Integer value) {
            addCriterion("ippc >=", value, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcLessThan(Integer value) {
            addCriterion("ippc <", value, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcLessThanOrEqualTo(Integer value) {
            addCriterion("ippc <=", value, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcIn(List<Integer> values) {
            addCriterion("ippc in", values, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcNotIn(List<Integer> values) {
            addCriterion("ippc not in", values, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcBetween(Integer value1, Integer value2) {
            addCriterion("ippc between", value1, value2, "ippc");
            return (Criteria) this;
        }

        public Criteria andIppcNotBetween(Integer value1, Integer value2) {
            addCriterion("ippc not between", value1, value2, "ippc");
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

        public Criteria andTransactionTypeIsNull() {
            addCriterion("transaction_type is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIsNotNull() {
            addCriterion("transaction_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeEqualTo(Integer value) {
            addCriterion("transaction_type =", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotEqualTo(Integer value) {
            addCriterion("transaction_type <>", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThan(Integer value) {
            addCriterion("transaction_type >", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_type >=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThan(Integer value) {
            addCriterion("transaction_type <", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_type <=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIn(List<Integer> values) {
            addCriterion("transaction_type in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotIn(List<Integer> values) {
            addCriterion("transaction_type not in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeBetween(Integer value1, Integer value2) {
            addCriterion("transaction_type between", value1, value2, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_type not between", value1, value2, "transactionType");
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

        public Criteria andIeFlagIsNull() {
            addCriterion("ie_flag is null");
            return (Criteria) this;
        }

        public Criteria andIeFlagIsNotNull() {
            addCriterion("ie_flag is not null");
            return (Criteria) this;
        }

        public Criteria andIeFlagEqualTo(String value) {
            addCriterion("ie_flag =", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagNotEqualTo(String value) {
            addCriterion("ie_flag <>", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagGreaterThan(String value) {
            addCriterion("ie_flag >", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ie_flag >=", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagLessThan(String value) {
            addCriterion("ie_flag <", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagLessThanOrEqualTo(String value) {
            addCriterion("ie_flag <=", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagLike(String value) {
            addCriterion("ie_flag like", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagNotLike(String value) {
            addCriterion("ie_flag not like", value, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagIn(List<String> values) {
            addCriterion("ie_flag in", values, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagNotIn(List<String> values) {
            addCriterion("ie_flag not in", values, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagBetween(String value1, String value2) {
            addCriterion("ie_flag between", value1, value2, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andIeFlagNotBetween(String value1, String value2) {
            addCriterion("ie_flag not between", value1, value2, "ieFlag");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberIsNull() {
            addCriterion("customs_order_number is null");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberIsNotNull() {
            addCriterion("customs_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberEqualTo(String value) {
            addCriterion("customs_order_number =", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberNotEqualTo(String value) {
            addCriterion("customs_order_number <>", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberGreaterThan(String value) {
            addCriterion("customs_order_number >", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("customs_order_number >=", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberLessThan(String value) {
            addCriterion("customs_order_number <", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("customs_order_number <=", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberLike(String value) {
            addCriterion("customs_order_number like", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberNotLike(String value) {
            addCriterion("customs_order_number not like", value, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberIn(List<String> values) {
            addCriterion("customs_order_number in", values, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberNotIn(List<String> values) {
            addCriterion("customs_order_number not in", values, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberBetween(String value1, String value2) {
            addCriterion("customs_order_number between", value1, value2, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andCustomsOrderNumberNotBetween(String value1, String value2) {
            addCriterion("customs_order_number not between", value1, value2, "customsOrderNumber");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersIsNull() {
            addCriterion("uniform_numbers is null");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersIsNotNull() {
            addCriterion("uniform_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersEqualTo(String value) {
            addCriterion("uniform_numbers =", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersNotEqualTo(String value) {
            addCriterion("uniform_numbers <>", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersGreaterThan(String value) {
            addCriterion("uniform_numbers >", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersGreaterThanOrEqualTo(String value) {
            addCriterion("uniform_numbers >=", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersLessThan(String value) {
            addCriterion("uniform_numbers <", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersLessThanOrEqualTo(String value) {
            addCriterion("uniform_numbers <=", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersLike(String value) {
            addCriterion("uniform_numbers like", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersNotLike(String value) {
            addCriterion("uniform_numbers not like", value, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersIn(List<String> values) {
            addCriterion("uniform_numbers in", values, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersNotIn(List<String> values) {
            addCriterion("uniform_numbers not in", values, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersBetween(String value1, String value2) {
            addCriterion("uniform_numbers between", value1, value2, "uniformNumbers");
            return (Criteria) this;
        }

        public Criteria andUniformNumbersNotBetween(String value1, String value2) {
            addCriterion("uniform_numbers not between", value1, value2, "uniformNumbers");
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

        public Criteria andBillOfLadingIsNull() {
            addCriterion("bill_of_lading is null");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingIsNotNull() {
            addCriterion("bill_of_lading is not null");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingEqualTo(String value) {
            addCriterion("bill_of_lading =", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingNotEqualTo(String value) {
            addCriterion("bill_of_lading <>", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingGreaterThan(String value) {
            addCriterion("bill_of_lading >", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingGreaterThanOrEqualTo(String value) {
            addCriterion("bill_of_lading >=", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingLessThan(String value) {
            addCriterion("bill_of_lading <", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingLessThanOrEqualTo(String value) {
            addCriterion("bill_of_lading <=", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingLike(String value) {
            addCriterion("bill_of_lading like", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingNotLike(String value) {
            addCriterion("bill_of_lading not like", value, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingIn(List<String> values) {
            addCriterion("bill_of_lading in", values, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingNotIn(List<String> values) {
            addCriterion("bill_of_lading not in", values, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingBetween(String value1, String value2) {
            addCriterion("bill_of_lading between", value1, value2, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andBillOfLadingNotBetween(String value1, String value2) {
            addCriterion("bill_of_lading not between", value1, value2, "billOfLading");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeIsNull() {
            addCriterion("arrival_notice is null");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeIsNotNull() {
            addCriterion("arrival_notice is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeEqualTo(String value) {
            addCriterion("arrival_notice =", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeNotEqualTo(String value) {
            addCriterion("arrival_notice <>", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeGreaterThan(String value) {
            addCriterion("arrival_notice >", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("arrival_notice >=", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeLessThan(String value) {
            addCriterion("arrival_notice <", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeLessThanOrEqualTo(String value) {
            addCriterion("arrival_notice <=", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeLike(String value) {
            addCriterion("arrival_notice like", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeNotLike(String value) {
            addCriterion("arrival_notice not like", value, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeIn(List<String> values) {
            addCriterion("arrival_notice in", values, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeNotIn(List<String> values) {
            addCriterion("arrival_notice not in", values, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeBetween(String value1, String value2) {
            addCriterion("arrival_notice between", value1, value2, "arrivalNotice");
            return (Criteria) this;
        }

        public Criteria andArrivalNoticeNotBetween(String value1, String value2) {
            addCriterion("arrival_notice not between", value1, value2, "arrivalNotice");
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

        public Criteria andCertificateOfOriginIsNull() {
            addCriterion("certificate_of_origin is null");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginIsNotNull() {
            addCriterion("certificate_of_origin is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginEqualTo(String value) {
            addCriterion("certificate_of_origin =", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginNotEqualTo(String value) {
            addCriterion("certificate_of_origin <>", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginGreaterThan(String value) {
            addCriterion("certificate_of_origin >", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_of_origin >=", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginLessThan(String value) {
            addCriterion("certificate_of_origin <", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginLessThanOrEqualTo(String value) {
            addCriterion("certificate_of_origin <=", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginLike(String value) {
            addCriterion("certificate_of_origin like", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginNotLike(String value) {
            addCriterion("certificate_of_origin not like", value, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginIn(List<String> values) {
            addCriterion("certificate_of_origin in", values, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginNotIn(List<String> values) {
            addCriterion("certificate_of_origin not in", values, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginBetween(String value1, String value2) {
            addCriterion("certificate_of_origin between", value1, value2, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andCertificateOfOriginNotBetween(String value1, String value2) {
            addCriterion("certificate_of_origin not between", value1, value2, "certificateOfOrigin");
            return (Criteria) this;
        }

        public Criteria andPreRecordedIsNull() {
            addCriterion("pre_recorded is null");
            return (Criteria) this;
        }

        public Criteria andPreRecordedIsNotNull() {
            addCriterion("pre_recorded is not null");
            return (Criteria) this;
        }

        public Criteria andPreRecordedEqualTo(String value) {
            addCriterion("pre_recorded =", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedNotEqualTo(String value) {
            addCriterion("pre_recorded <>", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedGreaterThan(String value) {
            addCriterion("pre_recorded >", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedGreaterThanOrEqualTo(String value) {
            addCriterion("pre_recorded >=", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedLessThan(String value) {
            addCriterion("pre_recorded <", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedLessThanOrEqualTo(String value) {
            addCriterion("pre_recorded <=", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedLike(String value) {
            addCriterion("pre_recorded like", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedNotLike(String value) {
            addCriterion("pre_recorded not like", value, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedIn(List<String> values) {
            addCriterion("pre_recorded in", values, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedNotIn(List<String> values) {
            addCriterion("pre_recorded not in", values, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedBetween(String value1, String value2) {
            addCriterion("pre_recorded between", value1, value2, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andPreRecordedNotBetween(String value1, String value2) {
            addCriterion("pre_recorded not between", value1, value2, "preRecorded");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationIsNull() {
            addCriterion("customs_declaration is null");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationIsNotNull() {
            addCriterion("customs_declaration is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationEqualTo(String value) {
            addCriterion("customs_declaration =", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationNotEqualTo(String value) {
            addCriterion("customs_declaration <>", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationGreaterThan(String value) {
            addCriterion("customs_declaration >", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationGreaterThanOrEqualTo(String value) {
            addCriterion("customs_declaration >=", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationLessThan(String value) {
            addCriterion("customs_declaration <", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationLessThanOrEqualTo(String value) {
            addCriterion("customs_declaration <=", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationLike(String value) {
            addCriterion("customs_declaration like", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationNotLike(String value) {
            addCriterion("customs_declaration not like", value, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationIn(List<String> values) {
            addCriterion("customs_declaration in", values, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationNotIn(List<String> values) {
            addCriterion("customs_declaration not in", values, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationBetween(String value1, String value2) {
            addCriterion("customs_declaration between", value1, value2, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andCustomsDeclarationNotBetween(String value1, String value2) {
            addCriterion("customs_declaration not between", value1, value2, "customsDeclaration");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeIsNull() {
            addCriterion("release_notice is null");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeIsNotNull() {
            addCriterion("release_notice is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeEqualTo(String value) {
            addCriterion("release_notice =", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeNotEqualTo(String value) {
            addCriterion("release_notice <>", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeGreaterThan(String value) {
            addCriterion("release_notice >", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("release_notice >=", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeLessThan(String value) {
            addCriterion("release_notice <", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeLessThanOrEqualTo(String value) {
            addCriterion("release_notice <=", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeLike(String value) {
            addCriterion("release_notice like", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeNotLike(String value) {
            addCriterion("release_notice not like", value, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeIn(List<String> values) {
            addCriterion("release_notice in", values, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeNotIn(List<String> values) {
            addCriterion("release_notice not in", values, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeBetween(String value1, String value2) {
            addCriterion("release_notice between", value1, value2, "releaseNotice");
            return (Criteria) this;
        }

        public Criteria andReleaseNoticeNotBetween(String value1, String value2) {
            addCriterion("release_notice not between", value1, value2, "releaseNotice");
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

        public Criteria andOther3IsNull() {
            addCriterion("other3 is null");
            return (Criteria) this;
        }

        public Criteria andOther3IsNotNull() {
            addCriterion("other3 is not null");
            return (Criteria) this;
        }

        public Criteria andOther3EqualTo(String value) {
            addCriterion("other3 =", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotEqualTo(String value) {
            addCriterion("other3 <>", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThan(String value) {
            addCriterion("other3 >", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThanOrEqualTo(String value) {
            addCriterion("other3 >=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThan(String value) {
            addCriterion("other3 <", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThanOrEqualTo(String value) {
            addCriterion("other3 <=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Like(String value) {
            addCriterion("other3 like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotLike(String value) {
            addCriterion("other3 not like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3In(List<String> values) {
            addCriterion("other3 in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotIn(List<String> values) {
            addCriterion("other3 not in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Between(String value1, String value2) {
            addCriterion("other3 between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotBetween(String value1, String value2) {
            addCriterion("other3 not between", value1, value2, "other3");
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

        public Criteria andParam1IsNull() {
            addCriterion("param1 is null");
            return (Criteria) this;
        }

        public Criteria andParam1IsNotNull() {
            addCriterion("param1 is not null");
            return (Criteria) this;
        }

        public Criteria andParam1EqualTo(String value) {
            addCriterion("param1 =", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotEqualTo(String value) {
            addCriterion("param1 <>", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThan(String value) {
            addCriterion("param1 >", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThanOrEqualTo(String value) {
            addCriterion("param1 >=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThan(String value) {
            addCriterion("param1 <", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThanOrEqualTo(String value) {
            addCriterion("param1 <=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1Like(String value) {
            addCriterion("param1 like", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotLike(String value) {
            addCriterion("param1 not like", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1In(List<String> values) {
            addCriterion("param1 in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotIn(List<String> values) {
            addCriterion("param1 not in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1Between(String value1, String value2) {
            addCriterion("param1 between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotBetween(String value1, String value2) {
            addCriterion("param1 not between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam2IsNull() {
            addCriterion("param2 is null");
            return (Criteria) this;
        }

        public Criteria andParam2IsNotNull() {
            addCriterion("param2 is not null");
            return (Criteria) this;
        }

        public Criteria andParam2EqualTo(String value) {
            addCriterion("param2 =", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotEqualTo(String value) {
            addCriterion("param2 <>", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThan(String value) {
            addCriterion("param2 >", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThanOrEqualTo(String value) {
            addCriterion("param2 >=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThan(String value) {
            addCriterion("param2 <", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThanOrEqualTo(String value) {
            addCriterion("param2 <=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2Like(String value) {
            addCriterion("param2 like", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotLike(String value) {
            addCriterion("param2 not like", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2In(List<String> values) {
            addCriterion("param2 in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotIn(List<String> values) {
            addCriterion("param2 not in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2Between(String value1, String value2) {
            addCriterion("param2 between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotBetween(String value1, String value2) {
            addCriterion("param2 not between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam3IsNull() {
            addCriterion("param3 is null");
            return (Criteria) this;
        }

        public Criteria andParam3IsNotNull() {
            addCriterion("param3 is not null");
            return (Criteria) this;
        }

        public Criteria andParam3EqualTo(String value) {
            addCriterion("param3 =", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotEqualTo(String value) {
            addCriterion("param3 <>", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThan(String value) {
            addCriterion("param3 >", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThanOrEqualTo(String value) {
            addCriterion("param3 >=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThan(String value) {
            addCriterion("param3 <", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThanOrEqualTo(String value) {
            addCriterion("param3 <=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Like(String value) {
            addCriterion("param3 like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotLike(String value) {
            addCriterion("param3 not like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3In(List<String> values) {
            addCriterion("param3 in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotIn(List<String> values) {
            addCriterion("param3 not in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Between(String value1, String value2) {
            addCriterion("param3 between", value1, value2, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotBetween(String value1, String value2) {
            addCriterion("param3 not between", value1, value2, "param3");
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