package cn.abl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.abl.service.AArrivalPlanService;
import cn.abl.service.SShippingPlanService;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("OrderStatistic")
public class OrderStatisticController {
	
	@Autowired
	private AArrivalPlanService arrivalPlanServiceImpl;
	@Autowired
	private SShippingPlanService shippingPlanServiceImpl;
	
	@RequestMapping(value = "/getOrderAArrivalPlan", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getOrderAArrivalPlan() {
		PageBean pageBean = arrivalPlanServiceImpl.getOrderStatistic();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/getOrderSShippingPlan", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getOrderSShippingPlan() {
		PageBean pageBean = shippingPlanServiceImpl.getOrderStatistic();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}

}
