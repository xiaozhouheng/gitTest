package cn.abl.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.CCustomsInformation;
import cn.abl.pojo.UUser;
import cn.abl.service.CustomsService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;



//海关登记信息

@Controller
@RequestMapping("/customs")
public class CustomsController {
	
	@Autowired
	private CustomsService customsServiceImpl;
	
	@RequestMapping("customsUI")
	public ModelAndView companyUI(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("views/customs/customsVO");
		return mv;
	}
	
	@RequestMapping(value = "/getAllCustoms", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllCustoms(int page, int limit, CCustomsInformation customsInformation, HttpServletRequest request) {
		UUser user = (UUser)request.getSession().getAttribute("user");
		customsInformation.setCreateUserid(user.getDataPrivilege());
		PageBean pageBean = customsServiceImpl.getAllCustoms(page, limit, customsInformation);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/jumpPage", method = RequestMethod.GET)
	public String jumpPage(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (null != id) {
			CCustomsInformation customsInformation = customsServiceImpl.findByID(Integer.valueOf(id));
			request.setAttribute("customsInformation", customsInformation);
		}
		return "views/customs/enditCustoms";
	}
	
	@RequestMapping(value = "/updateCustoms", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateCustoms(CCustomsInformation customsInformation, HttpServletRequest request) {
		UUser user = (UUser)request.getSession().getAttribute("user");
		E3Result result = customsServiceImpl.updateCustoms(customsInformation, String.valueOf(user.getId()));
		return result;
	}
	
	@RequestMapping(value = "/deleteByID", method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteByID(String ids) {
		E3Result result = customsServiceImpl.deleteByID(ids);
		return result;
	}
	
}
