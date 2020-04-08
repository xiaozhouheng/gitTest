package cn.abl.dao;

import cn.abl.pojo.CCorporateInformation;
import cn.abl.pojo.CCorporateInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCorporateInformationMapper {
    int countByExample(CCorporateInformationExample example);

    int deleteByExample(CCorporateInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CCorporateInformation record);

    int insertSelective(CCorporateInformation record);

    List<CCorporateInformation> selectByExample(CCorporateInformationExample example);

    CCorporateInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CCorporateInformation record, @Param("example") CCorporateInformationExample example);

    int updateByExample(@Param("record") CCorporateInformation record, @Param("example") CCorporateInformationExample example);

    int updateByPrimaryKeySelective(CCorporateInformation record);

    int updateByPrimaryKey(CCorporateInformation record);
}