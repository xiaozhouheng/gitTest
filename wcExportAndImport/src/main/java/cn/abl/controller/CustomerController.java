package cn.abl.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.CCustomerInformation;
import cn.abl.service.CustomerService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

//往来客户信息管理

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerServiceImpl;
	
	@RequestMapping("customerUI")
	public ModelAndView companyUI(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("views/customer/customerVO");
		return mv;
	}
	
	@RequestMapping(value = "/getAllCustomer")
	@ResponseBody
	public JSONObject getAllCustomer(int page, int limit, CCustomerInformation cCustomerInformation, HttpServletRequest request){
		String userId = request.getSession().getAttribute("userId").toString();
		PageBean pageBean = customerServiceImpl.getAllCustomer(page, limit, cCustomerInformation, userId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/jumpEndit")
	public String jumpEndit(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (null != id) {
			CCustomerInformation customerInformation = customerServiceImpl.getCustomerByID(id);
			request.setAttribute("customerInformation", customerInformation);
		}
		return "views/customer/EnditCustomerVo";
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateCustomer(CCustomerInformation customerInformation, HttpServletRequest request) {
		String userId = request.getSession().getAttribute("userId").toString();
		E3Result result = customerServiceImpl.updateCustomer(customerInformation, userId);
		return result;
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public E3Result delete(String ids) {
		E3Result result = customerServiceImpl.delete(ids);
		return result;
	}
}
