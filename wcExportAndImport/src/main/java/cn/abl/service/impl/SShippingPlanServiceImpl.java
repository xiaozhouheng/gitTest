package cn.abl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.SShippingPlanDetailsMapper;
import cn.abl.dao.SShippingPlanMapper;
import cn.abl.dao.SShippingPlanMapperCustom;
import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.SShippingPlanDetails;
import cn.abl.service.SShippingPlanService;
import cn.abl.utils.E3Result;
import cn.abl.utils.IDUtils;
import cn.abl.utils.PageBean;
import cn.abl.vo.OrderStatistics;

@Service
public class SShippingPlanServiceImpl implements SShippingPlanService {

	@Autowired
	private SShippingPlanMapperCustom shippingPlanMapperCustom;
	@Autowired
	private SShippingPlanMapper shippingPlanMapper;
	@Autowired
	private SShippingPlanDetailsMapper shippingPlanDetailsMapper;
	
	@Override
	public PageBean getAllSShippingPlan(int page, int limit, SShippingPlan shippingPlan) {
		PageHelper.startPage(page, limit);
		List<SShippingPlan> allSShippingPlan = shippingPlanMapperCustom.getAllSShippingPlan(shippingPlan);
		PageInfo<SShippingPlan> pageInfo = new PageInfo<>(allSShippingPlan);
		long total = pageInfo.getTotal();
		List<SShippingPlan> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SShippingPlan getSShippingPlanByID(int id) {
		SShippingPlan shippingPlan = shippingPlanMapperCustom.getSShippingPlanByID(id);
		return shippingPlan;
	}

	@Override
	public E3Result updateSShippingPlan(SShippingPlan shippingPlan, String userId) {
		if (null != shippingPlan.getId()) { // 修改
			shippingPlan.setCreateTime(new Date());
			int i = shippingPlanMapper.updateByPrimaryKeySelective(shippingPlan);
			List<SShippingPlanDetails> list = shippingPlan.getShippingPlanDetails();
			for (SShippingPlanDetails sShippingPlanDetails : list) {
				int j = shippingPlanDetailsMapper.updateByPrimaryKeySelective(sShippingPlanDetails);
			}
		} else { // 新增
			shippingPlan.setCreateUserid(String.valueOf(userId));
			shippingPlan.setCreateTime(new Date());
			shippingPlan.setStatus("0");
			shippingPlan.setInvoice(IDUtils.genImageName());
			int i = shippingPlanMapperCustom.insertSShippingPlan(shippingPlan);
			List<SShippingPlanDetails> list = shippingPlan.getShippingPlanDetails();
			for (SShippingPlanDetails sShippingPlanDetails : list) {
				sShippingPlanDetails.setsId(shippingPlan.getId());
				int j = shippingPlanDetailsMapper.insert(sShippingPlanDetails);
			}
		}
		return E3Result.ok();
	}

	@Override
	public E3Result deleteSShippingPlan(String ids) {
		int i = shippingPlanMapperCustom.deleteSShippingPlan(ids);
		if (0 == i) {
			return E3Result.build(400, "删除失败!");
		} else {
			shippingPlanMapperCustom.deleteSShippingPlanDetails(ids);
		}
		return E3Result.ok();
	}

	@Override
	public PageBean getOrderStatistic() {
		List<OrderStatistics> list = shippingPlanMapperCustom.getOrderStatistic();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(list.size());
		pageBean.setList(list);
		return pageBean;
	}

}
