package com.swm.store.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swm.store.service.IStoreService;


/**
 * 
* @Title: StoreController.java 
* @Package com.swm.store.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-23 上午10:38:39 
* @version V1.0
 */
@Controller  
@RequestMapping("/store") 
public class StoreController {
	public static Logger logger = LogManager.getLogger(StoreController.class);
	/**
	 * 用户业务对象
	 */
	@Resource(name="storeService")
	private IStoreService storeService;

	/**
	 * 获取微信用户CODE
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/queryStoreByCity.do")
	public void oauth(HttpServletRequest request,HttpServletResponse response) throws IOException{
		 String city = request.getParameter("city");
		 JSONObject json = new JSONObject();
		JSONArray jsonArray = null;
		try {
			json.put("data", jsonArray = JSONArray.fromObject(this.storeService.queryStoreByCityName(city)));
			json.put("status", true);
		} catch (Exception e) {
			logger.debug("根据城市获取门店信息异常--->"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json);
	}
}