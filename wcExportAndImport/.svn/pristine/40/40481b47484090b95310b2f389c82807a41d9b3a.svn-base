package cn.abl.dao;

import cn.abl.pojo.TCountry;
import cn.abl.pojo.TCountryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCountryMapper {
    int countByExample(TCountryExample example);

    int deleteByExample(TCountryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCountry record);

    int insertSelective(TCountry record);

    List<TCountry> selectByExample(TCountryExample example);

    TCountry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCountry record, @Param("example") TCountryExample example);

    int updateByExample(@Param("record") TCountry record, @Param("example") TCountryExample example);

    int updateByPrimaryKeySelective(TCountry record);

    int updateByPrimaryKey(TCountry record);
}