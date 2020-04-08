package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.FFinance;

public interface FFinanceMapperCustom {

	List<FFinance> findAllFFinance(@Param("companyName")String companyName, @Param("orderType")String orderType, @Param("startTime")String startTime, @Param("endTime")String endTime);
}
