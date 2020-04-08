package cn.abl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.abl.dao.CCorporateInformationMapperCustom;
import cn.abl.pojo.CCorporateInformation;
import cn.abl.pojo.UUser;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	
	 @Override  
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
	    		Object handler) throws Exception {  
		
	    	Object obj = request.getSession().getAttribute("user");
			if(obj != null) {
				request.getSession().setAttribute("user", obj);
				String servletPath = request.getServletPath();
				if(servletPath.equals("/company/updateCompany.do"))
					return true;
				UUser uu =	(UUser)obj;
				if(uu.getCreateUserId()==0&&uu.getUserType()==2&&!servletPath.equals("/company/editCompany")){
					request.getSession().setAttribute("compant", "1");
					response.sendRedirect(request.getContextPath() + "/company/editCompany");
				}
				if(uu.getCreateUserId()==1){
					request.getSession().setAttribute("compant", "0");
				}
				return true;
			}
			
			
			response.sendRedirect(request.getContextPath() + "/page/login");
	        return false;  
	    }  
	 
	 @Override  
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
	    		Object handler, ModelAndView modelAndView) throws Exception {  
	          
	    }
	 
	 @Override  
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	    		Object handler, Exception ex) throws Exception {  
	    } 

}
