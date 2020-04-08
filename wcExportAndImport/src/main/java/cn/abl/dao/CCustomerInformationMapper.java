package cn.abl.dao;

import cn.abl.pojo.CCustomerInformation;
import cn.abl.pojo.CCustomerInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCustomerInformationMapper {
    int countByExample(CCustomerInformationExample example);

    int deleteByExample(CCustomerInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CCustomerInformation record);

    int insertSelective(CCustomerInformation record);

    List<CCustomerInformation> selectByExample(CCustomerInformationExample example);

    CCustomerInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CCustomerInformation record, @Param("example") CCustomerInformationExample example);

    int updateByExample(@Param("record") CCustomerInformation record, @Param("example") CCustomerInformationExample example);

    int updateByPrimaryKeySelective(CCustomerInformation record);

    int updateByPrimaryKey(CCustomerInformation record);
}