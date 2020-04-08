package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.TCountry;

public interface TCountryMapperCheck {
	List<TCountry> getCheckCode(String param, int id);
	
	List<TCountry> getCheckCountry(String param, int id);
	
	List<TCountry> getAllCountry(TCountry country);
	
	int deleteByID(@Param("id")String id);

}
