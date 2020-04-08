package cn.abl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.UUser;
import cn.abl.service.UserService;
import cn.abl.utils.E3Result;
import cn.abl.utils.JsonUtils;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/jump")
	public ModelAndView jumpUser() {
		ModelAndView view = new ModelAndView();
		view.setViewName("after/user/userManagement");
		return view;
	}

	@RequestMapping(value = "/findAllUser")
	@ResponseBody
	public JSONObject findAllUser(int page, int limit, UUser user) {
		PageBean pageBean = userServiceImpl.findAllUser(page, limit, user);
		List list = pageBean.getList();
		long total = pageBean.getTotal();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", total);
		jsonObject.put("value", list);
		jsonObject.put("success", true);
		
		return jsonObject;
	}
	
	@RequestMapping(value = "/modularPrivilege")
	@ResponseBody
	public String getModularPrivilege(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object object = session.getAttribute("userId");
		String userId = object.toString();
		Map<String, Object> map = userServiceImpl.getUserBySession(userId);
		request.getSession().setAttribute("modularPriv", map.get("modularPriv"));
		request.getSession().setAttribute("dataPriv", map.get("dataPriv"));
		request.getSession().setAttribute("id", map.get("id"));
		request.getSession().setAttribute("username", map.get("username"));
		System.out.println(userId);
		return null;
		
	}
	
	@RequestMapping(value = "/findModularPrivilege")
	@ResponseBody
	public Object findModularPrivilege(HttpServletRequest request) {
		Object object2 = userServiceImpl.findModularPrivilege();
		return object2;
	}
	
	@RequestMapping(value = "/findDataPrivilege")
	@ResponseBody
	public List<UUser> findDataPrivilege() {
		List<UUser> list = userServiceImpl.findDataPrivilege();
		return list;
	}
	
	@RequestMapping("/editUser")
	public String editUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (id != null) {
			UUser user = userServiceImpl.findUserByID(id);
			request.setAttribute("users", user);
		}
		return "after/user/enditUser";
	}
	
	@RequestMapping(value = "/updateModularPrivilege", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateModularPrivilege(UUser user, HttpServletRequest request) {
		String userId = request.getSession().getAttribute("userId").toString();
		E3Result result = userServiceImpl.updateModularPrivilege(user, userId);
		return result;
	}
	
	@RequestMapping(value = "/deleteByID")
	@ResponseBody
	public E3Result deleteByID(String ids) {
		E3Result result = userServiceImpl.deleteByID(ids);
		return result;
	}
	
	@RequestMapping(value = "/updateDataPrivilege", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateDataPrivilege(int userId, String dataPrivilege) {
		E3Result result = userServiceImpl.updateDataPrivilege(userId, dataPrivilege);
		return result;
	}
	
	@RequestMapping(value = "selectAllUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<UUser> selectAllUsers() {
		List<UUser> list = userServiceImpl.selectAllUsers();
		return list;
	}
	
}
