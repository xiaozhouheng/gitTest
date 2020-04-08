package cn.abl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.SShippingPlanDetailsMapper;
import cn.abl.dao.SShippingPlanMapperCustom;
import cn.abl.pojo.SShippingPlanDetails;
import cn.abl.pojo.SShippingPlanDetailsExample;
import cn.abl.service.SShippingPlanDetailsService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Service
public class SShippingPlanDetailsServiceImpl implements SShippingPlanDetailsService {
	
	@Autowired
	private SShippingPlanMapperCustom shippingPlanMapperCustom;
	@Autowired
	private SShippingPlanDetailsMapper shippingPlanDetailsMapper;

	@Override
	public PageBean getAllSShippingPlanDetails(int page, int limit, SShippingPlanDetails shippingPlanDetails) {
		PageHelper.startPage(page, limit);
		List<SShippingPlanDetails> allSShippingPlanDetails = shippingPlanMapperCustom.getAllSShippingPlanDetails(shippingPlanDetails);
		PageInfo<SShippingPlanDetails> pageInfo = new PageInfo<>(allSShippingPlanDetails);
		long total = pageInfo.getTotal();
		List<SShippingPlanDetails> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SShippingPlanDetails getByID(int id) {
		SShippingPlanDetails shippingPlanDetails = shippingPlanDetailsMapper.selectByPrimaryKey(id);
		return shippingPlanDetails;
	}

	@Override
	public E3Result updateSShippingPlanDetails(SShippingPlanDetails shippingPlanDetails) {
		if (null != shippingPlanDetails.getId()) { // 修改
			E3Result result = checkUpdate(String.valueOf(shippingPlanDetails.getItemNumber()), 1, shippingPlanDetails.getId());
			if (!(boolean)result.getData()) {
				return E3Result.build(400, "修改失败,货号已被占用!");
			}
			int i = shippingPlanDetailsMapper.updateByPrimaryKey(shippingPlanDetails);
			if (0 == i) {
				return E3Result.build(400, "修改失败!");
			}
		} else {
			E3Result result = checkAdd(String.valueOf(shippingPlanDetails.getItemNumber()), 1);
			if (!(boolean)result.getData()) {
				return E3Result.build(400, "新增失败,货号被占用!");
			}
			int i = shippingPlanDetailsMapper.insert(shippingPlanDetails);
			if (0 == i) {
				return E3Result.build(400, "新增失败!");
			}
		}
		return E3Result.ok();
	}
	
	@Override
	public E3Result checkAdd(String param, int type) {
		SShippingPlanDetailsExample example = new SShippingPlanDetailsExample();
		cn.abl.pojo.SShippingPlanDetailsExample.Criteria criteria = example.createCriteria();
		// 1-货号
		if (1 == type) {
			criteria.andItemNumberEqualTo(param);
		} else {
			E3Result.build(400, "数据类型错误");
		}
		List<SShippingPlanDetails> list = shippingPlanDetailsMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			return E3Result.ok(false);
		}
		return E3Result.ok(true);
	}

	@Override
	public E3Result checkUpdate(String param, int type, int id) {
		// 1-货号
		if (type == 1) {
			List<SShippingPlanDetails> list = shippingPlanMapperCustom.checkUpdate(param, id);
			if (list.size() > 0 && list != null) {
				return E3Result.ok(false);
			}
		} else {
			return E3Result.build(400, "数据类型错误!");
		}
		return E3Result.ok(true);
	}

	@Override
	public E3Result deleteSShippingPlanDetails(String id) {
		int i = shippingPlanMapperCustom.deleteSShippingPlanDetailsByID(id);
		if (0 == i) {
			return E3Result.build(400, "删除失败!");
		}
		return E3Result.ok();
	}

}
