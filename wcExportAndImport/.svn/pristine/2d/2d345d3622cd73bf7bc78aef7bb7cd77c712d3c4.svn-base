package cn.abl.service;

import java.util.List;

import cn.abl.pojo.AArrivalPlanDetails;
import cn.abl.pojo.CCommodityFiling;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface AArrivalPlanDetailsService {

	PageBean getAllAArrivalPlanDetails(int page, int limit, AArrivalPlanDetails aArrivalPlanDetails);
	
	AArrivalPlanDetails getAArrivalPlanDetailsByID(int id);
	
	E3Result updateAArrivalPlanDetails(AArrivalPlanDetails aArrivalPlanDetails);
	
	E3Result checkAdd(String param, int type);
	
	E3Result checkUpdate(String param, int type, int id);
	
	E3Result deleteAArrivalPlanDetails(String ids);
	
	List<CCommodityFiling> findItem();
}
