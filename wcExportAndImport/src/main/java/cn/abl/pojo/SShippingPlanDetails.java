package cn.abl.pojo;

import java.io.Serializable;

public class SShippingPlanDetails implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer serialNumber;

    private String itemNumber;

    private String chItemName;

    private String hscode;

    private String model;

    private Integer number;

    private String unit;

    private String price;

    private String totalPrice;

    private String currency;

    private String netWeight;

    private String domesticSourceOfGoods;

    private String note;

    private Integer sId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber == null ? null : itemNumber.trim();
    }

    public String getChItemName() {
        return chItemName;
    }

    public void setChItemName(String chItemName) {
        this.chItemName = chItemName == null ? null : chItemName.trim();
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode == null ? null : hscode.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight == null ? null : netWeight.trim();
    }

    public String getDomesticSourceOfGoods() {
        return domesticSourceOfGoods;
    }

    public void setDomesticSourceOfGoods(String domesticSourceOfGoods) {
        this.domesticSourceOfGoods = domesticSourceOfGoods == null ? null : domesticSourceOfGoods.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}