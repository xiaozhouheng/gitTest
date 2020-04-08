package cn.abl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.TCountry;
import cn.abl.service.CountryService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("country")
public class CountryController {

	@Autowired
	private CountryService countryServiceImpl;
	
	@RequestMapping(value = "/getAllCountry")
	@ResponseBody
	public JSONObject getAllCountry(int page, int limit, TCountry country) {
		PageBean pageBean = countryServiceImpl.getAllCountry(page, limit, country);
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
			TCountry country = countryServiceImpl.findCountryByID(Integer.parseInt(id));
			request.setAttribute("country", country);
		}
		return "/after/country/enditCountry";
	}
	
	@RequestMapping(value = "/updateCountry", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateCountry(TCountry country, HttpServletRequest request) {
		E3Result result = countryServiceImpl.updateCountry(country);
		return result;
	}
	
	@RequestMapping(value = "/deleteByID", method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteByID(String id) {
		E3Result result = countryServiceImpl.deleteByID(id);
		return result;
	}
}
