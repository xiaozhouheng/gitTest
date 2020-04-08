package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.UUser;

public interface UUserMapperCustom {
	
	List<UUser> findAllUser(UUser user);
	
	List<UUser> findDataPrivilege();
	
	List<UUser> checkUserByUsername(UUser user);
	
	int deleteByID(@Param("id")String id);
	
	int insertUser(UUser user);
	
}
