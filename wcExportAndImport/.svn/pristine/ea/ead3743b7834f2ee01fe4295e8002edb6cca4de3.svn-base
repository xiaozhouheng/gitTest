package cn.abl.dao;

import cn.abl.pojo.MModular;
import cn.abl.pojo.MModularExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MModularMapper {
    int countByExample(MModularExample example);

    int deleteByExample(MModularExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MModular record);

    int insertSelective(MModular record);

    List<MModular> selectByExample(MModularExample example);

    MModular selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MModular record, @Param("example") MModularExample example);

    int updateByExample(@Param("record") MModular record, @Param("example") MModularExample example);

    int updateByPrimaryKeySelective(MModular record);

    int updateByPrimaryKey(MModular record);
}