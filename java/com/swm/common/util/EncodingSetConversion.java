package com.swm.common.util;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 主要负责客服端以GET方式提交上来的数据，进行编码集转换
 * 
 * JahwaInformationAdmin   
 * @author fanyuanyang
 * @开发日期: 2012-9-29 上午10:58:39 
 * @version 1.0
 * @description  转编码集格式
 * @see
 */
public class EncodingSetConversion implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 过滤器
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		Map<String, String[]> map = request.getParameterMap();
		if(request.getMethod().equalsIgnoreCase("get")){
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				String[] vals = map.get(key);
				for (int i = 0; i < vals.length; i++) {
					vals[i] = new String(vals[i].getBytes("ISO-8859-1"), "UTF-8");
				}
			}
		}
		arg2.doFilter(request,response);
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
