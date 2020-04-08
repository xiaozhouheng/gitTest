package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.SShippingPlanDetails;
import cn.abl.vo.CustomsDeclarationVO;
import cn.abl.vo.OrderStatistics;

public interface SShippingPlanMapperCustom {
	
	List<SShippingPlan> getAllSShippingPlan(SShippingPlan shippingPlan);
	
	int deleteSShippingPlan(@Param("id")String id);
	
	int deleteSShippingPlanDetails(@Param("sid")String sid);
	
	List<SShippingPlanDetails> getAllSShippingPlanDetails(SShippingPlanDetails shippingPlanDetails);
	
	List<SShippingPlanDetails> checkUpdate(@Param("param")String param, @Param("id")int id);
	
	int deleteSShippingPlanDetailsByID(@Param("id") String id);
	
	int insertSShippingPlan(SShippingPlan shippingPlan);
	
	SShippingPlan getSShippingPlanByID(@Param("id") int id);
	
	List<CustomsDeclarationVO> exportDeclaration(@Param("param1")String param1, @Param("customsCode")String customsCode, @Param("beginTime")String beginTime, @Param("endTime")String endTime, @Param("status")String status, @Param("createUserid")String createUserid, @Param("userType")String userType);
	
	int updateExportDeclaration(@Param("id")int id, @Param("userId")int userId);
	
	List<OrderStatistics> getOrderStatistic();

}
