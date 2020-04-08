package cn.abl.dao;

import cn.abl.pojo.CCustomsInformation;
import cn.abl.pojo.CCustomsInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCustomsInformationMapper {
    int countByExample(CCustomsInformationExample example);

    int deleteByExample(CCustomsInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CCustomsInformation record);

    int insertSelective(CCustomsInformation record);

    List<CCustomsInformation> selectByExample(CCustomsInformationExample example);

    CCustomsInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CCustomsInformation record, @Param("example") CCustomsInformationExample example);

    int updateByExample(@Param("record") CCustomsInformation record, @Param("example") CCustomsInformationExample example);

    int updateByPrimaryKeySelective(CCustomsInformation record);

    int updateByPrimaryKey(CCustomsInformation record);
    
    List<CCustomsInformation> findAll(CCustomsInformation customsInformation);
    
    int deleteByID(@Param("id") String id);
}