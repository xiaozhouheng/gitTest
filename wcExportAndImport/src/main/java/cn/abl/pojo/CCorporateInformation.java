package cn.abl.pojo;

import java.io.Serializable;
import java.util.Date;

public class CCorporateInformation implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String companyChName;

    private String companyEnName;

    private String province;

    private String city;

    private String area;

    private String enAddress;

    private String creditCode;

    private Integer taxpayerType;

    private String customsCode;

    private String commodityNumber;

    private String registeredCapital;

    private String corporate;

    private String corporateContact;

    private String fixedTelephone;

    private String mobilePhone;

    private String businessMailbox;

    private String businessScope;

    private Integer isInstitution; // 是否事业单位 0-否 1-是

    private Integer isFreightForwarding; // 是否货代企业 0-否 1-是

    private Integer isImportAndExport; // 是否进出口贸易企业 0-否 1-是

    private Integer isManufacturer; // 是否生产企业 0-否 1-是

    private Integer entityType; // 是否其他企业类型 0-否 1-是

    private String businessLicense;

    private String foreignTrade;

    private String customsRegistration;

    private String uscc;

    private Integer status;

    private Integer createUserid;

    private Date createTime;

    private Date annualInspectionTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyChName() {
        return companyChName;
    }

    public void setCompanyChName(String companyChName) {
        this.companyChName = companyChName == null ? null : companyChName.trim();
    }

    public String getCompanyEnName() {
        return companyEnName;
    }

    public void setCompanyEnName(String companyEnName) {
        this.companyEnName = companyEnName == null ? null : companyEnName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getEnAddress() {
        return enAddress;
    }

    public void setEnAddress(String enAddress) {
        this.enAddress = enAddress == null ? null : enAddress.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public Integer getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(Integer taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode == null ? null : customsCode.trim();
    }

    public String getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(String commodityNumber) {
        this.commodityNumber = commodityNumber == null ? null : commodityNumber.trim();
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    public String getCorporate() {
        return corporate;
    }

    public void setCorporate(String corporate) {
        this.corporate = corporate == null ? null : corporate.trim();
    }

    public String getCorporateContact() {
        return corporateContact;
    }

    public void setCorporateContact(String corporateContact) {
        this.corporateContact = corporateContact == null ? null : corporateContact.trim();
    }

    public String getFixedTelephone() {
        return fixedTelephone;
    }

    public void setFixedTelephone(String fixedTelephone) {
        this.fixedTelephone = fixedTelephone == null ? null : fixedTelephone.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getBusinessMailbox() {
        return businessMailbox;
    }

    public void setBusinessMailbox(String businessMailbox) {
        this.businessMailbox = businessMailbox == null ? null : businessMailbox.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public Integer getIsInstitution() {
        return isInstitution;
    }

    public void setIsInstitution(Integer isInstitution) {
        this.isInstitution = isInstitution;
    }

    public Integer getIsFreightForwarding() {
        return isFreightForwarding;
    }

    public void setIsFreightForwarding(Integer isFreightForwarding) {
        this.isFreightForwarding = isFreightForwarding;
    }

    public Integer getIsImportAndExport() {
        return isImportAndExport;
    }

    public void setIsImportAndExport(Integer isImportAndExport) {
        this.isImportAndExport = isImportAndExport;
    }

    public Integer getIsManufacturer() {
        return isManufacturer;
    }

    public void setIsManufacturer(Integer isManufacturer) {
        this.isManufacturer = isManufacturer;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getForeignTrade() {
        return foreignTrade;
    }

    public void setForeignTrade(String foreignTrade) {
        this.foreignTrade = foreignTrade == null ? null : foreignTrade.trim();
    }

    public String getCustomsRegistration() {
        return customsRegistration;
    }

    public void setCustomsRegistration(String customsRegistration) {
        this.customsRegistration = customsRegistration == null ? null : customsRegistration.trim();
    }

    public String getUscc() {
        return uscc;
    }

    public void setUscc(String uscc) {
        this.uscc = uscc == null ? null : uscc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAnnualInspectionTime() {
        return annualInspectionTime;
    }

    public void setAnnualInspectionTime(Date annualInspectionTime) {
        this.annualInspectionTime = annualInspectionTime;
    }
}