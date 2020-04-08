package cn.abl.service;

import cn.abl.pojo.CCustomerInformation;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface CustomerService {

	PageBean getAllCustomer(int page, int limit, CCustomerInformation cCustomerInformation, String userID);
	
	CCustomerInformation getCustomerByID(String id);
	
	E3Result updateCustomer(CCustomerInformation cCustomerInformation, String userID);
	
	E3Result delete(String ids);
}
