package cn.abl.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.CCorporateInformation;
import cn.abl.pojo.FFinance;
import cn.abl.pojo.UUser;
import cn.abl.service.ContractService;
import cn.abl.service.FFinanceService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("finance")
public class FinanceController {
	
	@Autowired
	private FFinanceService financeServiceImpl;
	@Autowired
	private ContractService contractServiceImpl;
	
	@RequestMapping(value = "/findAllFFinance", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject findAllFFinance(int page, int limit, String companyName, String orderType, String startTime, String endTime, HttpServletRequest request) {
		PageBean pageBean = financeServiceImpl.findAllFFinance(page, limit, companyName, orderType, startTime, endTime);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/insertFFinance", method = RequestMethod.POST)
	@ResponseBody
	public E3Result insertFFinance(FFinance fFinance, HttpServletRequest request) {
		UUser user = (UUser)request.getSession().getAttribute("user");
		CCorporateInformation corporateInformation = contractServiceImpl.findByUserID(fFinance.getUserId()); // 企业信息
		fFinance.setCompanyId(corporateInformation.getId());
		fFinance.setCompanyName(corporateInformation.getCompanyChName());
		fFinance.setCreateTime(new Date());
		fFinance.setCreateUserId(user.getId());
		E3Result result = financeServiceImpl.insertFFinance(fFinance);
		return result;
	}

}
