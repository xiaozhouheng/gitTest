package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.TEstimate;
import cn.abl.pojo.THscode;

public interface THscodeMapperCustom {

	List<THscode> getAllHsCode(THscode hscode);
	
	List<TEstimate> getByEstimate();
	
	List<THscode> getCheckHcode(String param, int id);
	
	List<THscode> getCheckItemName(String param, int id);
	
	int deleteByID(@Param("id")String id);
	
	void insertAll(List<THscode> tHscode);
	
	List<THscode> getHscodeAndItemName();
	
	List<THscode> getByID(@Param(value="id")String id);
}
