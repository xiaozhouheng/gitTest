package cn.abl.service;

import java.util.List;

import cn.abl.pojo.AArrivalPlan;
import cn.abl.pojo.AArrivalPlanDetails;
import cn.abl.pojo.CCorporateInformation;
import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.SShippingPlanDetails;

public interface ContractService {
	
	AArrivalPlan findByID(int id);
	
	List<AArrivalPlanDetails> findByAID(int id);

	CCorporateInformation findByUserID(int userID);
	
	SShippingPlan findSShippingPlanByID(int id);
	
	List<SShippingPlanDetails> findBySID(int id);
}
