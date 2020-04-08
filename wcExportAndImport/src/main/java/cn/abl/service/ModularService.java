package cn.abl.service;

import cn.abl.pojo.MModular;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface ModularService {

	MModular findModularByID(String id);
	
	PageBean findAllModular(int page, int limit, MModular modular);
	
	E3Result updateModular(MModular modular);
	
	E3Result deleteModularByID(String id);
}
