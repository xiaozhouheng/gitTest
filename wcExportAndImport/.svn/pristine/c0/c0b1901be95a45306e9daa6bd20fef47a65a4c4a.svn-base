package cn.abl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.AArrivalPlanDetailsMapper;
import cn.abl.dao.AArrivalPlanMapperCustom;
import cn.abl.dao.CCommodityFilingMapper;
import cn.abl.pojo.AArrivalPlanDetails;
import cn.abl.pojo.AArrivalPlanDetailsExample;
import cn.abl.pojo.AArrivalPlanDetailsExample.Criteria;
import cn.abl.pojo.CCommodityFiling;
import cn.abl.pojo.CCommodityFilingExample;
import cn.abl.service.AArrivalPlanDetailsService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Service
public class AArrivalPlanDetailsServiceImpl implements AArrivalPlanDetailsService {

	@Autowired
	private AArrivalPlanMapperCustom aArrivalPlanMapperCustom;
	@Autowired
	private AArrivalPlanDetailsMapper aArrivalPlanDetailsMapper;
	@Autowired
	private CCommodityFilingMapper cCommodityFilingMapper;
	
	@Override
	public PageBean getAllAArrivalPlanDetails(int page, int limit, AArrivalPlanDetails aArrivalPlanDetails) {
		PageHelper.startPage(page, limit);
		List<AArrivalPlanDetails> planDetailsList = aArrivalPlanMapperCustom.getAllAArrivalPlanDetails(aArrivalPlanDetails);
		PageInfo<AArrivalPlanDetails> pageInfo = new PageInfo<>(planDetailsList);
		long total = pageInfo.getTotal();
		List<AArrivalPlanDetails> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public AArrivalPlanDetails getAArrivalPlanDetailsByID(int id) {
		AArrivalPlanDetails planDetails = aArrivalPlanDetailsMapper.selectByPrimaryKey(id);
		return planDetails;
	}

	@Override
	public E3Result updateAArrivalPlanDetails(AArrivalPlanDetails aArrivalPlanDetails) {
		if (null != aArrivalPlanDetails.getId()) { // 修改
			E3Result result = checkUpdate(String.valueOf(aArrivalPlanDetails.getItemNumber()), 1, aArrivalPlanDetails.getId());
			if (!(boolean)result.getData()) {
				return E3Result.build(400, "修改失败,货号已被占用!");
			}
			int i = aArrivalPlanDetailsMapper.updateByPrimaryKey(aArrivalPlanDetails);
			if (0 == i) {
				return E3Result.build(400, "修改失败!");
			}
		} else { // 新增
			E3Result result = checkAdd(String.valueOf(aArrivalPlanDetails.getItemNumber()), 1);
			if (!(boolean)result.getData()) {
				return E3Result.build(400, "新增失败,货号被占用!");
			}
			int i = aArrivalPlanDetailsMapper.insert(aArrivalPlanDetails);
			if (0 == i) {
				return E3Result.build(400, "新增失败!");
			}
		}
		return E3Result.ok();
	}

	@Override
	public E3Result checkAdd(String param, int type) {
		AArrivalPlanDetailsExample example = new AArrivalPlanDetailsExample();
		Criteria criteria = example.createCriteria();
		// 1-货号
		if (1 == type) {
			criteria.andItemNumberEqualTo(Integer.valueOf(param));
		} else {
			E3Result.build(400, "数据类型错误");
		}
		List<AArrivalPlanDetails> list = aArrivalPlanDetailsMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			return E3Result.ok(false);
		}
		return E3Result.ok(true);
	}

	@Override
	public E3Result checkUpdate(String param, int type, int id) {
		// 1-货号
		if (type == 1) {
			List<AArrivalPlanDetails> list = aArrivalPlanMapperCustom.checkUpdate(Integer.valueOf(param), id);
			if (list.size() > 0 && list != null) {
				return E3Result.ok(false);
			}
		} else {
			return E3Result.build(400, "数据类型错误!");
		}
		return E3Result.ok(true);
	}

	@Override
	public E3Result deleteAArrivalPlanDetails(String ids) {
		int i = aArrivalPlanMapperCustom.deleteAArrivalPlanDetailsByID(ids);
		if (0 == i) {
			return E3Result.build(400, "删除失败!");
		}
		return E3Result.ok();
	}

	@Override
	public List<CCommodityFiling> findItem() {
		CCommodityFilingExample example = new CCommodityFilingExample();
		cn.abl.pojo.CCommodityFilingExample.Criteria criteria = example.createCriteria();
		criteria.andReviewStatusEqualTo(1);
		List<CCommodityFiling> list = cCommodityFilingMapper.selectByExample(example);
		return list;
	}

}
