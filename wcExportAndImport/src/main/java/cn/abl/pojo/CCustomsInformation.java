package cn.abl.pojo;

import java.util.Date;

public class CCustomsInformation {
    private Integer id;

    private String customsRegistrationNumber;

    private String companyName;

    private String customsContact;

    private String contactNumber;

    private Integer companyType;

    private String corporateCardNumber;

    private Date expirationDate;

    private Date annualReviewDate;

    private String name;

    private String idCard;

    private String corporatePhone;

    private String param1;

    private String param2;

    private Date createTime;

    private String createUserid;

    private Integer status;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomsRegistrationNumber() {
        return customsRegistrationNumber;
    }

    public void setCustomsRegistrationNumber(String customsRegistrationNumber) {
        this.customsRegistrationNumber = customsRegistrationNumber == null ? null : customsRegistrationNumber.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCustomsContact() {
        return customsContact;
    }

    public void setCustomsContact(String customsContact) {
        this.customsContact = customsContact == null ? null : customsContact.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getCorporateCardNumber() {
        return corporateCardNumber;
    }

    public void setCorporateCardNumber(String corporateCardNumber) {
        this.corporateCardNumber = corporateCardNumber == null ? null : corporateCardNumber.trim();
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getAnnualReviewDate() {
        return annualReviewDate;
    }

    public void setAnnualReviewDate(Date annualReviewDate) {
        this.annualReviewDate = annualReviewDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getCorporatePhone() {
        return corporatePhone;
    }

    public void setCorporatePhone(String corporatePhone) {
        this.corporatePhone = corporatePhone == null ? null : corporatePhone.trim();
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2 == null ? null : param2.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid == null ? null : createUserid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}