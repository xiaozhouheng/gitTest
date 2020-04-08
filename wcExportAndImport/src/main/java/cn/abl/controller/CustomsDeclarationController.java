package cn.abl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.AArrivalPlan;
import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.UUser;
import cn.abl.service.AArrivalPlanService;
import cn.abl.service.CustomsDeclarationService;
import cn.abl.service.SShippingPlanService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

/*
 * 进出口报关
 * */
@Controller
@RequestMapping("customsDeclaration")
public class CustomsDeclarationController {
	
	@Autowired
	private CustomsDeclarationService customsDeclarationServiceImpl;
	@Autowired
	private AArrivalPlanService aArrivalPlanServiceImpl;
	@Autowired
	private SShippingPlanService sShippingPlanServiceImpl;
	
	@RequestMapping(value = "/importDeclaration", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject importDeclaration(int page, int limit, String param1, String customsCode, String beginTime, String endTime, String status, HttpServletRequest request) {
		UUser user = (UUser)request.getSession().getAttribute("user");
		PageBean pageBean = customsDeclarationServiceImpl.importDeclaration(page, limit, param1, customsCode, beginTime, endTime, status, String.valueOf(user.getId()), String.valueOf(user.getUserType()));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/getDeclarationByID", method = RequestMethod.GET)
	public String getDeclarationByID(HttpServletRequest request){
		String id = request.getParameter("id");
		AArrivalPlan aArrivalPlan = aArrivalPlanServiceImpl.findAArrivalPlanByID(Integer.valueOf(id));
		request.setAttribute("aArrivalPlan", aArrivalPlan);
		return "after/customsDeclaration/viewDeclaration";
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public List<UUser> getUser() {
		List<UUser> user = customsDeclarationServiceImpl.getUser();
		return user;
	}
	
	@RequestMapping(value = "/updateReview", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateReview(int id, int userId) {
		E3Result result = customsDeclarationServiceImpl.updateReview(id, userId);
		return result;
	}
	
	@RequestMapping(value = "/exportDeclaration", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject exportDeclaration(int page, int limit, String param1, String customsCode, String beginTime, String endTime, String status, HttpServletRequest request) {
		UUser user = (UUser)request.getSession().getAttribute("user");
		PageBean pageBean = customsDeclarationServiceImpl.exportDeclaration(page, limit, param1, customsCode, beginTime, endTime, status, String.valueOf(user.getId()), String.valueOf(user.getUserType()));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/getExportDeclarationByID", method = RequestMethod.GET)
	public String getExportDeclarationByID(HttpServletRequest request) {
		String id = request.getParameter("id");
		SShippingPlan sShippingPlanBy = sShippingPlanServiceImpl.getSShippingPlanByID(Integer.valueOf(id));
		request.setAttribute("sShippingPlanBy", sShippingPlanBy);
		return "after/customsDeclaration/viewExportDeclaration";
	}
	
	@RequestMapping(value = "/updateExportDeclaration", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateExportDeclaration(int id, int userId) {
		E3Result result = customsDeclarationServiceImpl.updateExportDeclaration(id, userId);
		return result;
	}
	
}
