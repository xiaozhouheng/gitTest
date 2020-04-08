package cn.abl.service;

import cn.abl.pojo.CCustomsInformation;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface CustomsService {

	PageBean getAllCustoms(int page, int limit, CCustomsInformation customsInformation);
	
	CCustomsInformation findByID(int id);
	
	E3Result updateCustoms(CCustomsInformation cCustomsInformation, String userid);
	
	E3Result deleteByID(String ids);
	
}
