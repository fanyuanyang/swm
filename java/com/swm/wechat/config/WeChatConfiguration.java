package com.swm.wechat.config;

/**
 * 微信相关参数
* @Title: WeChatConfiguration.java 
* @Package com.swm.wechat.config 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-21 下午2:31:33 
* @version V1.0
 */
public class WeChatConfiguration {
	/**
	 * 微信开发者ID	
	 */
	public final static String APPID = "wx204a842e06ae62e7";
	/**
	 * 微信开发者密钥
	 */
	public final static String SECRET = "f8f2e6db452b79e6076086f88d7de42b";
	/**
	 * 微信获取access_token地址
	 */
	
	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";
	/**
	 * 微信获取JSSDK票据地址
	 */
	public final static String TICKET_URL= "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={0}&type=jsapi";
	/**
	 * 微信获取用户CODE，该类型直接跳转，用户没有感知
	 */
	public final static String SNSAPI_BASE = "snsapi_base"; 
	/**
	 * 微信获取用户CODE，该类型需要用户主动授权
	 */
	public final static String SNSAPI_USER_INFO = "snsapi_userinfo";
	/**
	 * 微信授权获取用户CODE回调地址
	 */
	public final static String REDIRECT_URL = "http://ehome.jahwaec.com/weChat/callback.do";
}
