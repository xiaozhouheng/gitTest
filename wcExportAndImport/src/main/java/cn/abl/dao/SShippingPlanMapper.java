package cn.abl.dao;

import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.SShippingPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SShippingPlanMapper {
    int countByExample(SShippingPlanExample example);

    int deleteByExample(SShippingPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SShippingPlan record);

    int insertSelective(SShippingPlan record);

    List<SShippingPlan> selectByExample(SShippingPlanExample example);

    SShippingPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SShippingPlan record, @Param("example") SShippingPlanExample example);

    int updateByExample(@Param("record") SShippingPlan record, @Param("example") SShippingPlanExample example);

    int updateByPrimaryKeySelective(SShippingPlan record);

    int updateByPrimaryKey(SShippingPlan record);
}