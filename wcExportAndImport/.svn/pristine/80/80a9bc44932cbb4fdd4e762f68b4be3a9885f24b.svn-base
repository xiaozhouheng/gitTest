package cn.abl.dao;

import cn.abl.pojo.TEstimate;
import cn.abl.pojo.TEstimateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEstimateMapper {
    int countByExample(TEstimateExample example);

    int deleteByExample(TEstimateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TEstimate record);

    int insertSelective(TEstimate record);

    List<TEstimate> selectByExample(TEstimateExample example);

    TEstimate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TEstimate record, @Param("example") TEstimateExample example);

    int updateByExample(@Param("record") TEstimate record, @Param("example") TEstimateExample example);

    int updateByPrimaryKeySelective(TEstimate record);

    int updateByPrimaryKey(TEstimate record);
}