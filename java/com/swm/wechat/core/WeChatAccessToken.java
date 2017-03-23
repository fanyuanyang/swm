package com.swm.wechat.core;

import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONObject;

import com.swm.common.util.HttpTookit;

public class WeChatAccessToken {
	private String access_token;
	private int expires_in;
	private Date time = new Date();

	public boolean isExpires() {
		long secends = System.currentTimeMillis() - this.time.getTime();
		return secends > this.expires_in * 1000 ? true : false;
	}

	// 类静态对象
	private static WeChatAccessToken accessToken;

	// 单例模式实现
	public static String getAccessToken() throws Exception {
		if (accessToken == null) {
			try {
				getWeChatAccessToken();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else if (accessToken.isExpires()) {
			try {
				getWeChatAccessToken();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return accessToken.getAccess_token();
	}

	@Override
	public String toString() {
		return "WeChatAccessToken [access_token=" + access_token
				+ ", expires_in=" + expires_in + ", time=" + time
				+ ", isExpires()=" + isExpires() + "]";
	}

	private static void getWeChatAccessToken() throws Exception {
	    String grant_type = "client_credential";//获取access_token填写client_credential 
	    String AppId="wxb5322c4f25f4f776";//第三方用户唯一凭证
	    String secret="092c45adbb445a20492d18833a8f7b13";//第三方用户唯一凭证密钥，即appsecret 
	    //这个url链接地址和参数皆不能变
	    String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+AppId+"&secret="+secret;
	    JSONObject result = JSONObject.fromObject(HttpTookit.doGet(url, null, "utf-8", true));
	    if(result.containsKey("access_token")){
			accessToken = new WeChatAccessToken();
			accessToken.setAccess_token(result.getString("access_token"));
			accessToken.setExpires_in(result.getInt("expires_in"));
		} else {
			throw new Exception(result.get("access_token missing").toString());
		}
	   
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	public static void main(String[] args) {
		try {
			WeChatAccessToken.getAccessToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}