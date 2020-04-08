package cn.abl.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.MModularMapper;
import cn.abl.dao.MModularMapperCustom;
import cn.abl.pojo.MModular;
import cn.abl.pojo.MModularExample;
import cn.abl.pojo.MModularExample.Criteria;
import cn.abl.service.ModularService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;
import cn.abl.vo.MModularVO;

@Service
public class ModularServiceImpl implements ModularService {

	@Autowired
	private MModularMapper mModularMapper;
	@Autowired
	private MModularMapperCustom mModularMapperCustom;
	
	@Override
	public MModular findModularByID(String id) {
		MModular modular = mModularMapper.selectByPrimaryKey(Integer.valueOf(id));
		return modular;
	}

	@Override
	public PageBean findAllModular(int page, int limit, MModular modular) {
		PageHelper.startPage(page, limit);
		List<MModularVO> modulars = mModularMapperCustom.findAllModular(modular);
		PageInfo<MModularVO> pageInfo = new PageInfo<>(modulars);
		List<MModularVO> list = pageInfo.getList();
		long total = pageInfo.getTotal();
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setTotal(total);
		return pageBean;
	}

	@Override
	public E3Result updateModular(MModular modular) {
		if (StringUtils.isBlank(modular.getName()) || StringUtils.isBlank(modular.getCode())) {
			return E3Result.build(400, "数据不完整,操作失败!");
		}
		if (modular.getId() != null) {
			List<MModular> list = mModularMapperCustom.checkModularCode(modular.getCode(), modular.getId());
			if (list.size() > 0 && list != null) {
				return E3Result.build(400, "模块编码已存在!");
			}
			List<MModular> list4 = mModularMapperCustom.checkModularName(modular.getName(), modular.getId());
			if (list4.size() > 0 && list4 != null) {
				return E3Result.build(400, "模块名称已存在!");
			}
			modular.setCreateTime(new Date());
			modular.setStatus(1);
			if (modular.getParentId() == null || "".equals(modular.getParentId())) {
				modular.setParentId(0);
			}
			mModularMapper.updateByPrimaryKey(modular);
		} else {
			MModularExample example = new MModularExample();
			Criteria criteria = example.createCriteria();
			criteria.andCodeEqualTo(modular.getCode());
			List<MModular> list2 = mModularMapper.selectByExample(example);
			if (list2.size() > 0 && list2 != null) {
				return E3Result.build(400, "模块编码已存在!");
			}
			criteria.andNameEqualTo(modular.getName());
			List<MModular> list3 = mModularMapper.selectByExample(example);
			if (list3.size() > 0 && list3 != null) {
				return E3Result.build(400, "模块名称已存在!");
			}
			if (modular.getParentId() == null || "".equals(modular.getParentId())) {
				modular.setParentId(0);
			}
			modular.setCreateTime(new Date());
			modular.setStatus(1);
			mModularMapper.insert(modular);
		}
		return E3Result.ok();
	}

	@Override
	public E3Result deleteModularByID(String id) {
		mModularMapperCustom.deleteModularByID(id);
		return E3Result.ok();
	}

}
