package com.swm.wechat.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.swm.common.util.HttpTookit;
import com.swm.wechat.config.WeChatConfiguration;

public class WeChatOauth {
	public static String code(String scope) throws UnsupportedEncodingException{
		StringBuffer url = new StringBuffer(1024);
		url.append("https://open.weixin.qq.com/connect/oauth2/authorize");
		url.append("?appid=").append(WeChatConfiguration.APPID);
		url.append("&redirect_uri=").append(URLEncoder.encode(WeChatConfiguration.REDIRECT_URL, "UTF-8"));
		url.append("&response_type=code");
		url.append("&scope=").append(scope);
		url.append("&state=8000#wechat_redirect"); 
		 return url.toString();
	}
	
	public static String accessToken(String Code){
		StringBuffer url = new StringBuffer(1024);
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token");
		url.append("?appid=").append(WeChatConfiguration.APPID);
		url.append("&secret=").append(WeChatConfiguration.SECRET);
		url.append("&code=").append(Code);
		url.append("&grant_type=authorization_code");
		System.out.println(url);
	    return HttpTookit.doGet(url.toString(),null, "utf-8",true);
	}
	
	public static String snsapiUserinfo(String accessToken,String openId){
		StringBuffer url = new StringBuffer(1024);
		url.append("https://api.weixin.qq.com/sns/userinfo");
		url.append("?access_token=").append(accessToken);
		url.append("&openid=").append(openId);
		url.append("&lang=zh_CN");
		System.out.println(url);
	    return HttpTookit.doGet(url.toString(),null, "utf-8",true);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(WeChatOauth.code("snsapi_base"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
