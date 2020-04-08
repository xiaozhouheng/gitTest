package cn.abl.service;

import cn.abl.pojo.TCountry;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface CountryService {

	PageBean getAllCountry(int page, int limit, TCountry country);
	
	TCountry findCountryByID(int id);
	
	E3Result updateCountry(TCountry country);
	
	E3Result checkAdd(String param, int type);
	
	E3Result checkUpdate(String param, int type, int id);
	
	E3Result deleteByID(String id);
}
