package cn.abl.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.UUser;
import cn.abl.service.SShippingPlanService;
import cn.abl.utils.E3Result;
import cn.abl.utils.JsonUtils;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("SShippingPlan")
public class SShippingPlanController {

	@Autowired
	private SShippingPlanService shippingPlanServiceImpl;
	
	@RequestMapping(value = "/getAllSShippingPlan", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllSShippingPlan(int page, int limit, SShippingPlan shippingPlan, HttpServletRequest request) {
		UUser user = (UUser)request.getSession().getAttribute("user");
		shippingPlan.setCreateUserid(user.getDataPrivilege());
		PageBean pageBean = shippingPlanServiceImpl.getAllSShippingPlan(page, limit, shippingPlan);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/enditSShippingPlan", method = RequestMethod.GET)
	public String enditSShippingPlan(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (null != id) {
			SShippingPlan sShippingPlan = shippingPlanServiceImpl.getSShippingPlanByID(Integer.valueOf(id));
			request.setAttribute("sShippingPlan", sShippingPlan);
		}
		return "views/sShippingPlan/enditSShippingPlan";
	}
	
	@RequestMapping(value = "/updateSShippingPlan", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateSShippingPlan(HttpServletRequest request) throws Exception {
		String parameter = request.getParameter("shippingPlan");
		SShippingPlan shippingPlan = JsonUtils.jsonToPojo(parameter, SShippingPlan.class);
		String userId = request.getSession().getAttribute("userId").toString();
		E3Result result = shippingPlanServiceImpl.updateSShippingPlan(shippingPlan, userId);
		return result;
	}
	
	@RequestMapping(value = "/deleteSShippingPlan", method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteSShippingPlan(String ids) {
		E3Result result = shippingPlanServiceImpl.deleteSShippingPlan(ids);
		return result;
	}
	
	@RequestMapping(value = "/jumpSShippingPlanDetails")
	public String jumpAArrivalPlanDetails(HttpServletRequest request){
		String id = request.getParameter("id");
		request.setAttribute("sId", id);
		return "views/sShippingPlan/SShippingPlanDetails";
	}
}
