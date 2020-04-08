package cn.abl.dao;

import cn.abl.pojo.THscode;
import cn.abl.pojo.THscodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THscodeMapper {
    int countByExample(THscodeExample example);

    int deleteByExample(THscodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THscode record);

    int insertSelective(THscode record);

    List<THscode> selectByExample(THscodeExample example);

    THscode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THscode record, @Param("example") THscodeExample example);

    int updateByExample(@Param("record") THscode record, @Param("example") THscodeExample example);

    int updateByPrimaryKeySelective(THscode record);

    int updateByPrimaryKey(THscode record);
}