package cn.abl.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.TCountryMapper;
import cn.abl.dao.TCountryMapperCheck;
import cn.abl.pojo.TCountry;
import cn.abl.pojo.TCountryExample;
import cn.abl.pojo.TCountryExample.Criteria;
import cn.abl.service.CountryService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private TCountryMapperCheck tCountryMapperCheck;
	@Autowired
	private TCountryMapper tCountryMapper;
	
	@Override
	public PageBean getAllCountry(int page, int limit, TCountry country) {
		PageHelper.startPage(page, limit);
		List<TCountry> countryList = tCountryMapperCheck.getAllCountry(country);
		PageInfo<TCountry> pageInfo = new PageInfo<>(countryList);
		List<TCountry> list = pageInfo.getList();
		long total = pageInfo.getTotal();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public TCountry findCountryByID(int id) {
		TCountry country = tCountryMapper.selectByPrimaryKey(id);
		return country;
	}

	@Override
	public E3Result updateCountry(TCountry tCountry) {
		if(tCountry.getId() != null){
			if (StringUtils.isBlank(tCountry.getCode()) || StringUtils.isBlank(tCountry.getCountry())) {
				return E3Result.build(400, "数据不完整,操作失败");
			}
			E3Result result = checkUpdate(tCountry.getCode(), 1, tCountry.getId());
			if (!(boolean) result.getData()) {
				return result.build(400, "国家编码已被占用");
			}
			result = checkUpdate(tCountry.getCountry(), 2, tCountry.getId());
			if (!(boolean) result.getData()) {
				return result.build(400, "国家名称已被占用");
			}
			// 修改数据
			tCountryMapper.updateByPrimaryKey(tCountry);
		}else{
			// 数据有效性验证
			if (StringUtils.isBlank(tCountry.getCode()) || StringUtils.isBlank(tCountry.getCountry())) {
				return E3Result.build(400, "数据不完整,操作失败");
			}
			E3Result result = checkAdd(tCountry.getCode(), 1);
			if (!(boolean) result.getData()) {
				return E3Result.build(400, "国家编码已被占用");
			}
			result = checkAdd(tCountry.getCountry(), 2);
			if (!(boolean) result.getData()) {
				return E3Result.build(400, "国家名称已被占用");
			}
			// 添加数据
			tCountryMapper.insert(tCountry);
	}
		return E3Result.ok();
	}

	@Override
	public E3Result checkAdd(String param, int type) {
		// 根据不同的type生成不同的查询条件
		TCountryExample example = new TCountryExample();
		Criteria criteria = example.createCriteria();
		// 1-编码 2-国家
		if (type == 1) {
			criteria.andCodeEqualTo(param);
		}else if (type == 2) {
			criteria.andCountryEqualTo(param);
		}else {
			return E3Result.build(400, "数据类型错误");
		}
		// 执行查询
		List<TCountry> list = tCountryMapper.selectByExample(example);
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
			List<TCountry> list = tCountryMapperCheck.getCheckCode(param, id);
			// 判断结果中是否包含数据
			if (list.size() > 0 && list != null) {
			// 有数据返回false
			return E3Result.ok(false);
			} 
		}else if (type == 2) {
			List<TCountry> list = tCountryMapperCheck.getCheckCountry(param, id);
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
	public E3Result deleteByID(String id) {
		int i = tCountryMapperCheck.deleteByID(id);
		if (0 == i) {
			return E3Result.build(400, "删除失败!");
		}
		return E3Result.ok();
	}

}
