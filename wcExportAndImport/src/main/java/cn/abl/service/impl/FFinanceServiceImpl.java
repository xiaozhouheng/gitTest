package cn.abl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.FFinanceMapper;
import cn.abl.dao.FFinanceMapperCustom;
import cn.abl.pojo.FFinance;
import cn.abl.service.FFinanceService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Service
public class FFinanceServiceImpl implements FFinanceService{

	@Autowired
	private FFinanceMapperCustom financeMapperCustom;
	@Autowired
	private FFinanceMapper financeMapper;
	
	@Override
	public PageBean findAllFFinance(int page, int limit, String companyName, String orderType, String startTime, String endTime) {
		PageHelper.startPage(page, limit);
		List<FFinance> allFFinance = financeMapperCustom.findAllFFinance(companyName, orderType, startTime, endTime);
		PageInfo<FFinance> pageInfo = new PageInfo<>(allFFinance);
		long total = pageInfo.getTotal();
		List<FFinance> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public E3Result insertFFinance(FFinance finance) {
		int i = financeMapper.insertSelective(finance);
		if (i <= 0) {
			return E3Result.build(400, "新增失败!");
		}
		return E3Result.ok();
	}
	
	

}
