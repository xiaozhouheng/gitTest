package cn.abl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.SShippingPlanDetails;
import cn.abl.service.SShippingPlanDetailsService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("SShippingPlanDetails")
public class SShippingPlanDetailsController {
	
	@Autowired
	private SShippingPlanDetailsService shippingPlanDetailsServiceImpl;

	@RequestMapping(value = "/getAllSShippingPlanDetails", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllSShippingPlanDetails(int page, int limit, SShippingPlanDetails shippingPlanDetails) {
		PageBean pageBean = shippingPlanDetailsServiceImpl.getAllSShippingPlanDetails(page, limit, shippingPlanDetails);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/enditSShippingPlanDetails")
	public String enditSShippingPlanDetails(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sId = request.getParameter("sId");
		if (null != id) {
			SShippingPlanDetails shippingPlanDetails = shippingPlanDetailsServiceImpl.getByID(Integer.valueOf(id));
			request.setAttribute("shippingPlanDetails", shippingPlanDetails);
		}
		request.setAttribute("sId", sId);
		return "views/sShippingPlan/enditSShippingPlanDetails";
	}
	
	@RequestMapping(value = "/updateSShippingPlanDetails", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateSShippingPlanDetails(SShippingPlanDetails shippingPlanDetails) {
		E3Result result = shippingPlanDetailsServiceImpl.updateSShippingPlanDetails(shippingPlanDetails);
		return result;
	}
	
	@RequestMapping(value = "/deleteSShippingPlanDetails", method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteSShippingPlanDetails(String ids) {
		E3Result result = shippingPlanDetailsServiceImpl.deleteSShippingPlanDetails(ids);
		return result;
	}
	
}
