package cn.abl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.abl.pojo.CCustomerInformation;

public interface CCustomerInformationMapperCustom {

	List<CCustomerInformation> getAllCustomer(CCustomerInformation cCustomerInformation);
	
	int delete(@Param("id") String id);
}
