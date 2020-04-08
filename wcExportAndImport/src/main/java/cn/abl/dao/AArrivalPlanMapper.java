package cn.abl.dao;

import cn.abl.pojo.AArrivalPlan;
import cn.abl.pojo.AArrivalPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AArrivalPlanMapper {
    int countByExample(AArrivalPlanExample example);

    int deleteByExample(AArrivalPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AArrivalPlan record);

    int insertSelective(AArrivalPlan record);

    List<AArrivalPlan> selectByExample(AArrivalPlanExample example);

    AArrivalPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AArrivalPlan record, @Param("example") AArrivalPlanExample example);

    int updateByExample(@Param("record") AArrivalPlan record, @Param("example") AArrivalPlanExample example);

    int updateByPrimaryKeySelective(AArrivalPlan record);

    int updateByPrimaryKey(AArrivalPlan record);
}