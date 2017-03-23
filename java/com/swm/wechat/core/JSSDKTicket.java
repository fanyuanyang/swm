package com.swm.wechat.core;

import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.swm.common.util.HttpTookit;
import com.swm.common.util.Sha1Util;

/**
 * 
* @Title: JSSDKTicket.java 
* @Package com.swm.wechat.core 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-20 下午1:10:26 
* @version V1.0
 */
public class JSSDKTicket {
	public static Logger logger = LogManager.getLogger(JSSDKTicket.class);
	private String ticket;
	private int expires_in;
	private long timeStamp = System.currentTimeMillis() / 1000;
	// 单例模式实现
	private static JSSDKTicket JSAPI_TICKET;

	public static String getTicket() {
		if (JSAPI_TICKET == null) {
			try {
				JSAPI_TICKET = getJsTicket();
			} catch (Exception e) {

				e.printStackTrace();
				return null;
			}
		}
		if (JSAPI_TICKET.isExpire()) {
			try {
				JSAPI_TICKET = getJsTicket();
			} catch (Exception e) {

				e.printStackTrace();
				return null;
			}
			return getTicket();
		} else {
			return JSAPI_TICKET.ticket;
		}

	}

	private JSSDKTicket() {
		super();
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public boolean isExpire() {
		return System.currentTimeMillis() / 1000 < (timeStamp + expires_in) ? false
				: true;
	}

	private static JSSDKTicket getJsTicket() throws Exception {
		String ticket = null;
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
				+ WeChatAccessToken.getAccessToken() + "&type=jsapi";
		JSONObject result = JSONObject.fromObject(HttpTookit.doGet(url, null,
				"utf-8", true));
		if ( result.getInt("errcode") == 0) {
			JSSDKTicket t = new JSSDKTicket();
			t.setTicket((String) result.get("ticket"));
			t.setExpires_in(result.getInt("expires_in"));
			return t;
		} else {
			throw new Exception(result.get("access_token missing").toString());
		}
	}
	public static void main(String[] args) {
		try {
			String url="http://swm.jahwaec.com/fyy.html";
			String str = Sha1Util.getNonceStr();
			String time = Sha1Util.getTimeStamp();
			String ticket = JSSDKTicket.getJsTicket().getTicket();
			 String strs = "jsapi_ticket="+ticket+"&noncestr="+str+"&timestamp="+time+"&url="+url;
			System.out.println(str+"\r\n"+time+"\r\n"+ticket);
			System.out.println(Sha1Util.getSha1(strs));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
