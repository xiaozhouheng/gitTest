package cn.abl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.CCommodityFiling;
import cn.abl.pojo.THscode;

public interface CCommodityFilingCustom {
	
	List<CCommodityFiling> getAllcommodityFiling(CCommodityFiling commodityFiling);
	
	THscode findHscodeByItemName(@Param("hcode")String hcode);
	
	int insertAllCommodityFiling(List<CCommodityFiling> commodityFilings);
	
	List<CCommodityFiling> findAfterCommodityFiling(CCommodityFiling commodityFiling);
	
	List<Map<String, Object>> exportCommodityFiling(CCommodityFiling commodityFiling);
	
	List<Map<String, Object>> exportCommodityFilingByID(@Param("id") String id);

}
