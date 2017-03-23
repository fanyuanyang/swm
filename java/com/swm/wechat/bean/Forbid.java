package com.swm.wechat.bean;

import java.io.Serializable;

/**
 * 
* @Title: Forbid.java 
* @Package com.jahwaec.fornid.bean 
* @Description: TODO(违禁词对象) 
* @author fyy 
* @date 2016-12-2 上午9:17:02 
* @version V1.0
 */
public class Forbid implements Serializable{
	/** 违禁词序号*/
	private String id;
	/** 违禁词*/
	private String value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
