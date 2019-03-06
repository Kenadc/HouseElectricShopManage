package com.oaec.Intecepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//������ ʵ��HandlerInterceptor   ʵ�ֵ�¼��֤����  ����һЩ������Ҫ��¼���ܲ���
public class LoginIntecepter implements HandlerInterceptor{
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	/**
	 * preHandle  ������ֵ   true  ���У�false ������
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		System.out.println("��������ִ����");
		//��¼���� session������ʱ����ת����
		if(req.getSession().getAttribute("loginInfo") != null) {
			return true;
		}
		if(req.getRequestURI().indexOf("login.action") >= 0) {
			return true;
		}
		res.sendRedirect("/HouseElectricShopManage/login/page/login.html");
		return false;
	}
	
}
