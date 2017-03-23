package com.swm.user.bean;

import java.io.Serializable;

/**
 * 用户对象
* @Title: User.java 
* @Package com.swm.user.bean 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-21 下午5:20:17 
* @version V1.0
 */
public class User implements Serializable{
	/** 用户ID*/
	private String id;
	/** 用户openid*/
	private String openId;
	/** 用户呢称*/
	private String nick;
	/** 用户姓名*/
	private String name;
	/** 用户性别*/
	private String gender;
	/** 用户邮箱*/
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/** 用户电话*/
	private String mobile;
	/** 用户状态*/
	private String status;
	/** 用户qq*/
	private String qq;
	/** 用户注册时间*/
	private String created;
	/** 用户最后登录的IP*/
	private String lastLoginIP;
	/** 用户最后登录时间*/
	private String lastLoginTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getLastLoginIP() {
		return lastLoginIP;
	}
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	
	
}
