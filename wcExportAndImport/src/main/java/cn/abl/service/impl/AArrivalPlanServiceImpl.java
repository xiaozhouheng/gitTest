package cn.abl.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.AArrivalPlanDetailsMapper;
import cn.abl.dao.AArrivalPlanMapper;
import cn.abl.dao.AArrivalPlanMapperCustom;
import cn.abl.dao.PPictureListMapper;
import cn.abl.pojo.AArrivalPlan;
import cn.abl.pojo.AArrivalPlanDetails;
import cn.abl.pojo.AArrivalPlanDetailsExample;
import cn.abl.pojo.AArrivalPlanDetailsExample.Criteria;
import cn.abl.pojo.PPictureList;
import cn.abl.pojo.PPictureListExample;
import cn.abl.service.AArrivalPlanService;
import cn.abl.utils.E3Result;
import cn.abl.utils.IDUtils;
import cn.abl.utils.PageBean;
import cn.abl.vo.OrderStatistics;

@Service
public class AArrivalPlanServiceImpl implements AArrivalPlanService {

	@Autowired
	private AArrivalPlanMapperCustom aArrivalPlanMapperCustom;
	@Autowired
	private AArrivalPlanMapper aArrivalPlanMapper;
	@Autowired
	private AArrivalPlanDetailsMapper aArrivalPlanDetailsMapper;
	@Autowired
	private PPictureListMapper pPictureListMapper;
	
	@Override
	public PageBean getAllAArrivalPlan(int page, int limit, AArrivalPlan aArrivalPlan, String userId) {
		PageHelper.startPage(page, limit);
		List<AArrivalPlan> arrivalPlanList = aArrivalPlanMapperCustom.getAllAArrivalPlan(aArrivalPlan.getMainWaybillNumber(), aArrivalPlan.getFenWaybillNumber(), userId);
		PageInfo<AArrivalPlan> pageInfo = new PageInfo<>(arrivalPlanList);
		long total = pageInfo.getTotal();
		List<AArrivalPlan> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public AArrivalPlan findAArrivalPlanByID(int id) {
		AArrivalPlan aArrivalPlan = aArrivalPlanMapperCustom.getAArrivalPlanByID(id);
		return aArrivalPlan;
	}

	@Override
	public E3Result updateAArrivalPlan(AArrivalPlan aArrivalPlan, String userId) {
		if (StringUtils.isEmpty(aArrivalPlan.getMainWaybillNumber())) {
			return E3Result.build(400, "主运单不能为空!");
		}
		if (null != aArrivalPlan.getId()) { //修改
			aArrivalPlan.setCreateTime(new Date());
			aArrivalPlanMapper.updateByPrimaryKeySelective(aArrivalPlan);
			List<AArrivalPlanDetails> list = aArrivalPlan.getaArrivalPlanDetails();
			for (AArrivalPlanDetails aArrivalPlanDetails : list) {
				int j = aArrivalPlanDetailsMapper.updateByPrimaryKeySelective(aArrivalPlanDetails);
			}
		} else { // 新增
			aArrivalPlan.setCreateUserid(Integer.valueOf(userId));
			aArrivalPlan.setCreateTime(new Date());
			aArrivalPlan.setStatus(0);
			aArrivalPlan.setInvoice(IDUtils.genImageName());
			int i = aArrivalPlanMapperCustom.insertAArrivalPlan(aArrivalPlan);
			List<AArrivalPlanDetails> list = aArrivalPlan.getaArrivalPlanDetails();
			for (AArrivalPlanDetails aArrivalPlanDetails : list) {
				aArrivalPlanDetails.setaId(aArrivalPlan.getId());
				int j = aArrivalPlanDetailsMapper.insert(aArrivalPlanDetails);
			}
		}
		return E3Result.ok();
	}
	
	@Override
	public E3Result deleteAArrivalPlan(String ids) {
		int i = aArrivalPlanMapperCustom.deleteAArrivalPlan(ids);
		if (0 == i) {
			return E3Result.build(400, "删除失败!");
		} else {
			int j = aArrivalPlanMapperCustom.deleteAArrivalPlanDetails(ids);
		}
		return E3Result.ok();
	}

	@Override
	public E3Result uploadFile(List<PPictureList> list) {
		int i = pPictureListMapper.uploadFile(list);
		return i > 0 ? E3Result.ok() : E3Result.build(400, "上传失败!");
	}

	@Override
	public JSONArray findPicture(String invoice) {
		PPictureListExample example = new PPictureListExample();
		cn.abl.pojo.PPictureListExample.Criteria criteria = example.createCriteria();
		criteria.andInvoiceEqualTo(invoice);
		List<PPictureList> list = pPictureListMapper.selectByExample(example);
		
		JSONArray jsonArray = new JSONArray();
		for (PPictureList pPictureList : list) {
			File file = new File(pPictureList.getPicAddress());
			if (file.exists()) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", pPictureList.getId());
				jsonObject.put("fileName", file.getName());
				jsonObject.put("size", file.length()/1024);
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}

	@Override
	public E3Result deleteFileByID(int id) {
		PPictureList pictureList = pPictureListMapper.selectByPrimaryKey(id);
		File file = new File(pictureList.getPicAddress());
		if (file.exists()) {
			file.delete();
		}
		int i = pPictureListMapper.deleteByPrimaryKey(id);
		return i > 0 ? E3Result.ok() : E3Result.build(400, "删除失败!");
	}

	@Override
	public String findFileByID(int id) {
		PPictureList pictureList = pPictureListMapper.selectByPrimaryKey(id);
		return pictureList.getPicAddress();
	}

	@Override
	public PageBean getOrderStatistic() {
		List<OrderStatistics> orderStatistics = aArrivalPlanMapperCustom.getOrderStatistic();
		PageBean pageBean = new PageBean();
		pageBean.setTotal(orderStatistics.size());
		pageBean.setList(orderStatistics);
		return pageBean;
	}

}
