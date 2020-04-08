package cn.abl.service;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

import cn.abl.pojo.CCommodityFiling;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface CommodityFilingService {
	
	PageBean getAllcommodityFiling(int page, int limit, CCommodityFiling commodityFiling, String userId);

	E3Result insertAllcommodityFiling(String path, String userId) throws Exception;
	
	PageBean findAfterCommodityFiling(int page, int limit, CCommodityFiling commodityFiling, String dataPrivilege);
	
	Workbook exportCommodityFiling(CCommodityFiling commodityFiling, String ids) throws IOException;
	
	E3Result ReviewCommodityFiling(String path, String userId);
}
