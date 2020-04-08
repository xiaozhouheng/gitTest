package cn.abl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.CCustomsInformationMapper;
import cn.abl.pojo.CCustomsInformation;
import cn.abl.pojo.CCustomsInformationExample;
import cn.abl.pojo.CCustomsInformationExample.Criteria;
import cn.abl.service.CustomsService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Service
public class CustomsServiceImpl implements CustomsService{
	
	@Autowired
	private CCustomsInformationMapper customsInformationMapper;

	@Override
	public PageBean getAllCustoms(int page, int limit, CCustomsInformation customsInformation) {
		PageHelper.startPage(page, limit);
		List<CCustomsInformation> findAll = customsInformationMapper.findAll(customsInformation);
		PageInfo<CCustomsInformation> pageInfo = new PageInfo<>(findAll);
		long total = pageInfo.getTotal();
		List<CCustomsInformation> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public CCustomsInformation findByID(int id) {
		CCustomsInformation customsInformation = customsInformationMapper.selectByPrimaryKey(id);
		return customsInformation;
	}

	@Override
	public E3Result updateCustoms(CCustomsInformation cCustomsInformation, String userid) {
		if (cCustomsInformation.getId() != null) { // 修改
			CCustomsInformationExample example = new CCustomsInformationExample();
			Criteria criteria = example.createCriteria();
			criteria.andCorporateCardNumberEqualTo(cCustomsInformation.getCorporateCardNumber());
			criteria.andIdNotEqualTo(cCustomsInformation.getId());
			List<CCustomsInformation> checkSize = customsInformationMapper.selectByExample(example);
			if (checkSize.size() > 0) {
				return E3Result.build(400, "法人卡号已存在!");
			} else {
				cCustomsInformation.setCreateUserid(userid);
				cCustomsInformation.setCreateTime(new Date());
				customsInformationMapper.updateByPrimaryKeySelective(cCustomsInformation);
			}
		} else { // 新增
			CCustomsInformationExample example = new CCustomsInformationExample();
			Criteria criteria = example.createCriteria();
			criteria.andCorporateCardNumberEqualTo(cCustomsInformation.getCorporateCardNumber());
			List<CCustomsInformation> list = customsInformationMapper.selectByExample(example);
			if (list.size() > 0) {
				return E3Result.build(400, "法人卡号已存在!");
			} else {
				cCustomsInformation.setCreateTime(new Date());
				cCustomsInformation.setCreateUserid(userid);
				cCustomsInformation.setStatus(1);
				customsInformationMapper.insertSelective(cCustomsInformation);
			}
		}
		return E3Result.ok();
	}

	@Override
	public E3Result deleteByID(String ids) {
		int i = customsInformationMapper.deleteByID(ids);
		if (0 == i) {
			return E3Result.build(400, "删除失败!");
		}
		return E3Result.ok();
	}

}
