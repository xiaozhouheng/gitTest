package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.CCorporateInformation;

public interface CCorporateInformationMapperCustom {

	List<CCorporateInformation> getAllCompany(CCorporateInformation corporateInformation);
	
	int checkCompanyChName(@Param("id")int id, @Param("companyChName")String companyChName);
	
	int checkCompanyEnName(@Param("id")int id, @Param("companyEnName")String companyEnName);
	
	int checkCreditCode(@Param("id")int id, @Param("creditCode")String creditCode);
	
	int checkCustomsCode(@Param("id")int id, @Param("customsCode")String customsCode);
	
	int checkCommodityNumber(@Param("id")int id, @Param("commodityNumber")String commodityNumber);
	
	int deleteCompanyByID(@Param("id")String id);
	
	String findByUserId(@Param("createUserid")String createUserid);
	
	int AnnualInspection(@Param("create_userid")String userId);
}
