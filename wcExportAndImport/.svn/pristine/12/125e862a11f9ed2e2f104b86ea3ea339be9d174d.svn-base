package cn.abl.service;

import cn.abl.pojo.CCorporateInformation;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface CompanyService {

	PageBean getAllCompany(int page, int limit, CCorporateInformation corporateInformation);
	
	CCorporateInformation findCompanyByID(String id);
	
	CCorporateInformation findCompanyByUserID(String userId);
	
	E3Result updateCompany(CCorporateInformation corporateInformation, String userId);
	
	E3Result deleteCompanyByID(String id);
	
	E3Result updateCompanyStatus(int id);
	
	E3Result AnnualInspection(String userId);
}
