package com.lingfeng.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class AjaxInterceptor implements HandlerInterceptor {

	public AjaxInterceptor(){
		System.out.println("ajaxInterceptor被创建");
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("ajax拦截器受到请求::"+request.getRequestURI());
//		System.out.println("当前ajax请求,response charset::"+response.getCharacterEncoding());
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/json; charset=utf-8");
//		  response.setContentType("application/json");
//		  response.setHeader("Pragma", "No-cache");
//		  response.setHeader("Cache-Control", "no-cache");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/json; charset=utf-8");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
		// TODO Auto-generated method stub
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/json; charset=utf-8");

	}

}
