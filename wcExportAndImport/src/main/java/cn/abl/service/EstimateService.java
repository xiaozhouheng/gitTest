package cn.abl.service;

import cn.abl.pojo.TEstimate;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface EstimateService {

	PageBean getAllEstimate(int page, int limit, TEstimate estimate);
	
	TEstimate getEstimateByID(String id);
	
	E3Result updateEstimate(TEstimate estimate);
	
	E3Result checkData(String param, int type);
	
	E3Result checkUpdate(String param, int type, int id);
	
	E3Result deleteEstimateByID(String id);
}
