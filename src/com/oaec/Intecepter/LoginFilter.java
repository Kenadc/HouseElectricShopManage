package com.oaec.Intecepter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author itellyou
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) arg0;
	     HttpServletResponse response = (HttpServletResponse) arg1;
	     HttpSession session = request.getSession();
	     String currentURL = request.getRequestURI();
	     String ctxPath = request.getContextPath();
	 /* // 不需要过滤的url
			String[] urls = { "/login", "/json", ".js", ".css", ".ico", ".jpg", ".png", ".gif", "scaptcha.action" };
			boolean flag = true;
			for (String str : urls) {
				if (currentURL.indexOf(str) != -1 || ctxPath.indexOf(str) != -1) {
					flag = false;
					break;
				}
			}
			if (flag == false) {
				arg2.doFilter(request, response);
			}

			if (session.getAttribute("loginInfo") == null) {
				response.sendRedirect("/HouseElectricShopManage/login/page/login.jsp");
			} else {
				arg2.doFilter(request, response);
			}
	     */
	     if(currentURL.indexOf("login") > 0 || currentURL.indexOf("scaptcha.action") > 0 || currentURL.indexOf("css") > 0 || currentURL.indexOf("js") > 0 || currentURL.indexOf("images") > 0 || currentURL.indexOf("font") > 0
	    		 || currentURL.indexOf("img") > 0 || currentURL.indexOf("ico") > 0
	    		 ) {
	    	 arg2.doFilter(request, response);
	     }else {
	    	 if(session.getAttribute("loginInfo") == null) {
	    		 response.sendRedirect("/HouseElectricShopManage/login/page/login.jsp");
	    	 }else {
	    		 arg2.doFilter(request, response);
	    	 }
	     }
	     System.out.println("currentURL:"+currentURL+"---ctxPath:"+ctxPath);
	     
	     /*if(currentURL.indexOf("login") > 0 || currentURL.indexOf("scaptcha.action") > 0) {
	    	 arg2.doFilter(request, response);
	     }else {
	    	 if(session.getAttribute("loginInfo") == null) {
	    		 response.sendRedirect("/HouseElectricShopManage/login/page/login.jsp");
	    	 }else {
	    		 arg2.doFilter(request, response);
	    	 }
	     }*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
