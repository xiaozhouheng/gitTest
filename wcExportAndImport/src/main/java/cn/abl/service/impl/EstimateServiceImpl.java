package cn.abl.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.TEstimateMapper;
import cn.abl.dao.TEstimateMapperCheck;
import cn.abl.pojo.TEstimate;
import cn.abl.pojo.TEstimateExample;
import cn.abl.pojo.TEstimateExample.Criteria;
import cn.abl.service.EstimateService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Service
public class EstimateServiceImpl implements EstimateService{
	
	@Autowired
	private TEstimateMapperCheck tEstimateMapperCheck;
	@Autowired
	private TEstimateMapper teEstimateMapper;

	@Override
	public PageBean getAllEstimate(int page, int limit, TEstimate estimate) {
		PageHelper.startPage(page, limit);
		List<TEstimate> allEstimate = tEstimateMapperCheck.getAllEstimate(estimate);
		PageInfo<TEstimate> pageInfo = new PageInfo<>(allEstimate);
		long total = pageInfo.getTotal();
		List<TEstimate> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setTotal(total);
		return pageBean;
	}

	@Override
	public TEstimate getEstimateByID(String id) {
		TEstimate estimate = teEstimateMapper.selectByPrimaryKey(Integer.valueOf(id));
		return estimate;
	}

	@Override
	public E3Result updateEstimate(TEstimate teEstimate) {
		if (null != teEstimate.getId()) {
			// 数据有效性验证
						if (StringUtils.isBlank(String.valueOf(teEstimate.getCode())) || StringUtils.isBlank(teEstimate.getShortname()) || StringUtils.isBlank(teEstimate.getName())) {
							return E3Result.build(400, "数据不完整,操作失败");
						}
						// 1-币制编码 2-简称 3-全称
						E3Result result = checkUpdate(String.valueOf(teEstimate.getCode()), 1, teEstimate.getId());
						if (!(boolean) result.getData()) {
							return result.build(400, "计量单位已被占用");
						}
						result = checkUpdate(teEstimate.getShortname(), 2, teEstimate.getId());
						if (!(boolean) result.getData()) {
							return result.build(400, "简称已被占用");
						}
						result = checkUpdate(teEstimate.getName(), 3, teEstimate.getId());
						if (!(boolean) result.getData()) {
							return result.build(400, "全称已被占用");
						}
						// 修改数据
						teEstimateMapper.updateByPrimaryKey(teEstimate);
					} else {
						// 数据有效性验证
						if (StringUtils.isBlank(String.valueOf(teEstimate.getCode())) || StringUtils.isBlank(teEstimate.getShortname()) || StringUtils.isBlank(teEstimate.getName())) {
							return E3Result.build(400, "数据不完整,操作失败");
						}
							// 1-币制编码 2-简称 3-全称
							E3Result result = checkData(String.valueOf(teEstimate.getCode()), 1);
						if (!(boolean) result.getData()) {
							return E3Result.build(400, "计量单位已被占用");
						}
							result = checkData(teEstimate.getShortname(), 2);
						if (!(boolean) result.getData()) {
							return E3Result.build(400, "简称已被占用");
						}
							result = checkData(teEstimate.getName(), 3);
						if (!(boolean) result.getData()) {
							return E3Result.build(400, "全称已被占用");
						}
						// 增加数据
						teEstimateMapper.insert(teEstimate);
					}
					return E3Result.ok();
	}

	@Override
	public E3Result checkData(String param, int type) {
		TEstimateExample example = new TEstimateExample();
		Criteria criteria = example.createCriteria();
		// 1-币制编码 2-简称 3-全称
		if (type == 1) {
			criteria.andCodeEqualTo(Integer.parseInt(param));
		} else if (type == 2) {
			criteria.andShortnameEqualTo(param);
		} else if (type == 3) {
			criteria.andNameEqualTo(param);
		} else {
			E3Result.build(400, "数据类型错误");
		}
		// 执行查询
		List<TEstimate> list = teEstimateMapper.selectByExample(example);
		// 判断结果中是否包含数据
		if (list.size() > 0 && list != null) {
			// 有数据返回false
			return E3Result.ok(false);
		} 
		return E3Result.ok(true);
	}

	@Override
	public E3Result checkUpdate(String param, int type, int id) {
		if (type == 1) {
			List<TEstimate> list = tEstimateMapperCheck.getCheckCode(param, id);
			// 判断结果中是否包含数据
			if (list.size() > 0 && list != null) {
				// 有数据返回false
				return E3Result.ok(false);
			} 
		}else if (type == 2) {
			List<TEstimate> list = tEstimateMapperCheck.getCheckShortname(param, id);
			// 判断结果中是否包含数据
			if (list.size() > 0 && list != null) {
				// 有数据返回false
				return E3Result.ok(false);
			} 
		}else if (type == 3) {
			List<TEstimate> list = tEstimateMapperCheck.getCheckName(param, id);
			// 判断结果中是否包含数据
			if (list.size() > 0 && list != null) {
				// 有数据返回false
				return E3Result.ok(false);
			} 
		}else {
			E3Result.build(400, "数据类型错误");
		}
		return E3Result.ok(true);
	}

	@Override
	public E3Result deleteEstimateByID(String id) {
		int i = tEstimateMapperCheck.deleteEstimateByID(id);
		if (0 == i) {
			return E3Result.build(400, "删除失败!");
		}
		return E3Result.ok();
	}

}
