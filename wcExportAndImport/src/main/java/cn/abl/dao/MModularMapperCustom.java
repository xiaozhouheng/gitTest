package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.MModular;
import cn.abl.vo.MModularVO;

public interface MModularMapperCustom {
	
	List<MModular> findModularPrivilege(int parentId);
	
	List<MModularVO> findAllModular(MModular modular);
	
	List<MModular> checkModularName(@Param("name")String name, @Param("id")int id);
	
	List<MModular> checkModularCode(@Param("code")String code, @Param("id")int id);
	
	int deleteModularByID(@Param("id")String id);

}
