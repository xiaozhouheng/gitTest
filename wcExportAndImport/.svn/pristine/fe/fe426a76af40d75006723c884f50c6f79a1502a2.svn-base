package cn.abl.service;

import java.util.List;

import cn.abl.pojo.TEstimate;
import cn.abl.pojo.THscode;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface HsCodeService {

	PageBean getAllHsCode(int page, int limit, THscode hscode);
	
	THscode findByID(int id);
	
	List<TEstimate> findAllEstimate();
	
	E3Result enditHsCode(THscode tHscode, String userId);
	
	E3Result checkAdd(String param, int type);
	
	E3Result checkUpdate(String param, int type, int id);
	
	E3Result deleteByID(String id);
	
	E3Result importHcode(String path, String userId);
	
	List<THscode> exportHcode(String id, THscode tHscode) throws Exception;
}
