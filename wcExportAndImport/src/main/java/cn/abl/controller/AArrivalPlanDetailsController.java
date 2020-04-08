package cn.abl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.AArrivalPlanDetails;
import cn.abl.pojo.CCommodityFiling;
import cn.abl.service.AArrivalPlanDetailsService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("AArrivalPlanDetails")
public class AArrivalPlanDetailsController {
	
	@Autowired
	private AArrivalPlanDetailsService aArrivalPlanDetailsServiceImpl;

	@RequestMapping(value = "/getAllAArrivalPlanDetails", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllAArrivalPlanDetails(int page, int limit, AArrivalPlanDetails aArrivalPlanDetails) {
		PageBean pageBean = aArrivalPlanDetailsServiceImpl.getAllAArrivalPlanDetails(page, limit, aArrivalPlanDetails);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/enditAArrivalPlanDetails")
	public String enditAArrivalPlanDetails(HttpServletRequest request) {
		String id = request.getParameter("id");
		String aId = request.getParameter("aId");
		if (null != id) {
			AArrivalPlanDetails planDetails = aArrivalPlanDetailsServiceImpl.getAArrivalPlanDetailsByID(Integer.valueOf(id));
			request.setAttribute("planDetails", planDetails);
		}
		request.setAttribute("aId", aId);
		return "views/aArrivalPlan/enditAArrivalPlanDetails";
	}
	
	@RequestMapping(value = "/updateAArrivalPlanDetails", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateAArrivalPlanDetails(AArrivalPlanDetails aArrivalPlanDetails) {
		E3Result result = aArrivalPlanDetailsServiceImpl.updateAArrivalPlanDetails(aArrivalPlanDetails);
		return result;
	}
	
	@RequestMapping(value = "/deleteAArrivalPlanDetails", method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteAArrivalPlanDetails(String ids) {
		E3Result result = aArrivalPlanDetailsServiceImpl.deleteAArrivalPlanDetails(ids);
		return result;
	}
	
	@RequestMapping(value = "/findItem", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject findItem() {
		List<CCommodityFiling> list = aArrivalPlanDetailsServiceImpl.findItem();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("itemList", list);
		return jsonObject;
	}
}
