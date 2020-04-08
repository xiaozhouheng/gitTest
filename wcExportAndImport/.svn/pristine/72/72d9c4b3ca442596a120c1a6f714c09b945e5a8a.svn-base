package cn.abl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.AArrivalPlanMapperCustom;
import cn.abl.dao.SShippingPlanMapperCustom;
import cn.abl.pojo.UUser;
import cn.abl.service.CustomsDeclarationService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;
import cn.abl.vo.CustomsDeclarationVO;

@Service
public class CustomsDeclarationServiceImpl implements CustomsDeclarationService {
	
	@Autowired
	private AArrivalPlanMapperCustom aArrivalPlanMapperCustom;
	@Autowired
	private SShippingPlanMapperCustom shippingPlanMapperCustom;

	@Override
	public PageBean importDeclaration(int page, int limit, String param1, String customsCode, String beginTime, String endTime,
			String status, String createUserid, String userType) {
		PageHelper.startPage(page, limit);
		List<CustomsDeclarationVO> importDeclaration = aArrivalPlanMapperCustom.importDeclaration(param1, customsCode, beginTime, endTime, status, createUserid, userType);
		PageInfo<CustomsDeclarationVO> pageInfo = new PageInfo<>(importDeclaration);
		long total = pageInfo.getTotal();
		List<CustomsDeclarationVO> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List<UUser> getUser() {
		List<UUser> list = aArrivalPlanMapperCustom.getUserForType();
		return list;
	}

	@Override
	public E3Result updateReview(int id, int userId) {
		int i = aArrivalPlanMapperCustom.updateReview(id, userId);
		if (0 == i) {
			return E3Result.build(400, "派单失败!");
		}
		return E3Result.ok();
	}

	@Override
	public PageBean exportDeclaration(int page, int limit, String param1, String customsCode, String beginTime,
			String endTime, String status, String createUserid, String userType) {
		PageHelper.startPage(page, limit);
		List<CustomsDeclarationVO> exportDeclaration = shippingPlanMapperCustom.exportDeclaration(param1, customsCode, beginTime, endTime, status, createUserid, userType);
		PageInfo<CustomsDeclarationVO> pageInfo = new PageInfo<>(exportDeclaration);
		long total = pageInfo.getTotal();
		List<CustomsDeclarationVO> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public E3Result updateExportDeclaration(int id, int userId) {
		int i = shippingPlanMapperCustom.updateExportDeclaration(id, userId);
		if (0 == i) {
			return E3Result.build(400, "派单失败!");
		}
		return E3Result.ok();
	}

}
