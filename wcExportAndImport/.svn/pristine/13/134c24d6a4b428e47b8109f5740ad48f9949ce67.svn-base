package cn.abl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.MModular;
import cn.abl.service.ModularService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("modular")
public class ModularController {
	
	@Autowired
	private ModularService modularServiceImpl;
	
	@RequestMapping("/jump")
	public ModelAndView jumpModular() {
		ModelAndView view = new ModelAndView();
		view.setViewName("after/module/module");
		return view;
	}
	
	@RequestMapping(value = "/findAllModular")
	@ResponseBody
	public JSONObject findAllModular(int page, int limit, MModular modular) {
		PageBean pageBean = modularServiceImpl.findAllModular(page, limit, modular);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping("/updateJump")
	public String updateJump(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (null != id) {
			MModular modular = modularServiceImpl.findModularByID(id);
			request.setAttribute("modular", modular);
		}
		return "after/module/updateModule";
	}
	
	@RequestMapping("/insertJump")
	public String insertJump(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "after/module/insertModule";
	}
	
	@RequestMapping(value = "/editModular")
	@ResponseBody
	public E3Result endit(MModular modular) {
		E3Result result = modularServiceImpl.updateModular(modular);
		return result;
	}

	@RequestMapping(value = "/deleteModularByID")
	@ResponseBody
	public E3Result deleteModularByID(String ids) {
		E3Result result = modularServiceImpl.deleteModularByID(ids);
		return result;
		
	}
	
}
