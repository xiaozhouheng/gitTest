package cn.abl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.abl.pojo.UUser;
import cn.abl.service.UserService;
import cn.abl.utils.E3Result;

@Controller
public class UserLoginController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/page/login")
	public String showLogin() {
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpServletRequest request) {
		E3Result result = userServiceImpl.login(username, password);
		String userId = result.getMsg();
		if ("用户名或密码错误".equals(userId) || "该账号未经审核".equals(userId)) {
			request.setAttribute("message", userId);
			return "redirect:/page/login";
		}
		request.getSession().setAttribute("userId", userId);
		UUser user = (UUser)result.getData();
		request.getSession().setAttribute("user", user);
		if (user.getUserType() == 0 || user.getUserType() == 1) {
			int i = userServiceImpl.findCorporateByStatus();
			if (i > 0) {
				request.getSession().setAttribute("PromptMessage", "您有未审核的企业,请及时审核!");
			}
			return "after/menu";
		}
		return "views/index";
	}
}
