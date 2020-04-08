package cn.abl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.abl.pojo.UUser;
import cn.abl.service.UserService;
import cn.abl.utils.E3Result;

@Controller
public class RegisterController {

	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register/register";
	}
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public E3Result register(UUser user) {
		E3Result result = userServiceImpl.register(user);
		return result;
		
	}
}
