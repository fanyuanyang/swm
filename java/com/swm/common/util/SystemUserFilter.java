package com.swm.common.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 该类主要负责过滤请求，验证用户是否登录。
 * JLEcgWeb   
 * @author fanyuanyang
 * @开发日期: 2012-9-29 上午10:54:15 
 * @version 1.0
 * @description 登录过滤器
 * @see
 */
public class SystemUserFilter implements Filter{
	/**
	 * 销毁
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 过滤
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String urlPath = request.getRequestURI().split("/")[(request.getRequestURI().split("/").length-1)];
		System.out.println(urlPath);
		if("oauth.do".equals(urlPath) || "callback.do".equals(urlPath)){//如果url请求路径是login,则继续下发
			arg2.doFilter(request,response);
			return;
		}
		else{//验证用户是否登录，如果没有，则要求用户登录后，继续下发
			if(request.getSession().getAttribute("user") == null){
				String url = request.getContextPath()+"/weChat/oauth.do";
				response.setContentType("text/html;charset=utf-8");
				response.sendRedirect(url);
			}else{
				arg2.doFilter(request,response);
			}
		}
	}
	/**
	 * 初始化
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
