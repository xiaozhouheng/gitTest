package cn.abl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.TEstimate;
import cn.abl.service.EstimateService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("estimate")
public class EstimateController {

	@Autowired
	private EstimateService estimateServiceImpl;
	
	@RequestMapping(value = "/getAllEstimate")
	@ResponseBody
	public JSONObject getAllEstimate(int page, int limit, TEstimate estimate) {
		PageBean pageBean = estimateServiceImpl.getAllEstimate(page, limit, estimate);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/editUi")
	public String editUi(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (null != id) {
			TEstimate estimate = estimateServiceImpl.getEstimateByID(id);
			request.setAttribute("estimate", estimate);
		}
		return "/after/estimate/enditEstimate";
	}
	
	@RequestMapping(value = "/updateEstimate", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateEstimate(TEstimate estimate) {
		E3Result result = estimateServiceImpl.updateEstimate(estimate);
		return result;
	}
	
	@RequestMapping(value = "/deleteEstimateByID", method = RequestMethod.POST)
	@ResponseBody	
	public E3Result deleteEstimateByID(String id) {
		E3Result result = estimateServiceImpl.deleteEstimateByID(id);
		return result;
	}
}
