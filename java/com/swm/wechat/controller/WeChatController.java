package com.swm.wechat.controller;

import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swm.user.bean.User;
import com.swm.user.service.IUserService;
import com.swm.wechat.config.WeChatConfiguration;
import com.swm.wechat.core.WeChatOauth;


/**
 * 微信请求处理类
* @Title: WeChatController.java 
* @Package com.swm.wechat.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-23 上午10:38:48 
* @version V1.0
 */
@Controller  //类似Struts的Action
@RequestMapping("/weChat") 
public class WeChatController {
	public static Logger logger = LogManager.getLogger(WeChatController.class);
	/**
	 * 用户业务对象
	 */
	@Resource(name="userService")
	private IUserService userService;

	/**
	 * 获取微信用户CODE
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/oauth.do")
	public void oauth(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//请求获取用户CODE
		response.sendRedirect(WeChatOauth.code(WeChatConfiguration.SNSAPI_BASE));
	}
	/**
	 * 微信回调地址，通过微信CODE获取openid
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/callback.do")
	public void callback(HttpServletRequest request,HttpServletResponse response){
		logger.info("回调成功");
		//根据微信返回的CODE查询openid信息
		try{
			String ip = this.getIpAddr(request);
			JSONObject result = JSONObject.fromObject(WeChatOauth.accessToken(request.getParameter("code")));
			//获取用户的OPENID 还是获取用户的基本信息
			String scope = result.getString("scope");
			//根据openid查找用户对象
			User user = userService.queryUserByOpenId(result.getString("openid"));
			if(WeChatConfiguration.SNSAPI_BASE.equals(scope) && null == user){//如果用户不在，再次调用微信获取用户的基本信息
				logger.info("通过openid未查询到相关用户信息，重定向获取用户SNSAPI_USER_INFO信息");
				response.sendRedirect(WeChatOauth.code(WeChatConfiguration.SNSAPI_USER_INFO));
				
			}else if(WeChatConfiguration.SNSAPI_USER_INFO.equals(scope) && null == user){//如果用户不存在，获取到了用户信息，保存
				logger.info("开始获取微信用户信息");
				JSONObject userInfo = JSONObject.fromObject(WeChatOauth.snsapiUserinfo(result.getString("access_token"), result.getString("openid")));
			    user = new User();
				user.setOpenId(userInfo.getString("openid"));
				user.setGender(userInfo.getString("sex"));
				user.setNick(userInfo.getString("nickname"));
				user.setLastLoginIP(ip);
				userService.addUser(user);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/map/index.jsp");
			}else{
				logger.info("用户信息已存在，跳转页面!");
				user.setLastLoginIP(ip);
				userService.editUserByLoginIp(user);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/map/index.jsp");
			}
		}catch(Exception e){
			logger.error("出现异常-->"+e.getMessage());
		}
		
	}

	public static String getIpAddr(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
}