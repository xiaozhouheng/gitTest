package cn.abl.service;

import cn.abl.pojo.FFinance;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface FFinanceService {

	PageBean findAllFFinance(int page, int limit, String companyName, String orderType, String startTime, String endTime);
	
	E3Result insertFFinance(FFinance finance);
}
