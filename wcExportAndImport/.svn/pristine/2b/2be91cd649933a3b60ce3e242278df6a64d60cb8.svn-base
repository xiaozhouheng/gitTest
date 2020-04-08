package cn.abl.controller;

import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

	@RequestMapping("/pageJump")
	public String pageJump(String path) {
		return path;
	}
	
	@RequestMapping("/updateJump")
	public String updateJump(String path, HttpServletRequest request) {
		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		return path;
	}
	
	@RequestMapping(value = "/jumpContract")
	public String jumpContract(String path, HttpServletRequest request) {
		String id = request.getParameter("id");
		String invoice = request.getParameter("invoice");
		request.setAttribute("id", id);
		request.setAttribute("invoice", invoice);
		return path;
	}
	
	@RequestMapping(value = "/pageContract")
	public String pageContract(String path, HttpServletRequest request) {
		TreeMap<String, String> values = new TreeMap<String, String>();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
		        String name =(String) paramNames.nextElement();
		        String value = request.getParameter(name);  
		        values.put(name, value);
		    }
		request.setAttribute("map", values);
		return path;
	}
}
