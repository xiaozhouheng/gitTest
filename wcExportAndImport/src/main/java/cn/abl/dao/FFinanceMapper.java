package cn.abl.dao;

import cn.abl.pojo.FFinance;
import cn.abl.pojo.FFinanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FFinanceMapper {
    int countByExample(FFinanceExample example);

    int deleteByExample(FFinanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FFinance record);

    int insertSelective(FFinance record);

    List<FFinance> selectByExample(FFinanceExample example);

    FFinance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FFinance record, @Param("example") FFinanceExample example);

    int updateByExample(@Param("record") FFinance record, @Param("example") FFinanceExample example);

    int updateByPrimaryKeySelective(FFinance record);

    int updateByPrimaryKey(FFinance record);
}