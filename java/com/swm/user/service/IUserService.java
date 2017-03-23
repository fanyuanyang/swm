package com.swm.user.service;

import java.util.Map;

import com.swm.common.bean.Page;
import com.swm.user.bean.User;
/**
 * 用户接口
* @Title: UserService.java 
* @Package com.swm.user.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-21 下午5:36:03 
* @version V1.0
 */
public interface IUserService {
	/**
	 * 新增用户
	 * @param user用户
	 */
	public void addUser(User user) throws Exception;
	/**
	 * 根据微信OpenId查找用户
	 * @param OpenId 
	 * @return 用户
	 * @throws Exception
	 */
	public User queryUserByOpenId(String openId) throws Exception;
	/**
	 * 分页获取用户信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Page qeuryUserByPage(Map<String,Object> map) throws Exception;
	/**
	 * 修改用户最后登录信息
	 * @param user
	 * @throws Exception
	 */
	public void editUserByLoginIp(User user) throws Exception;
}
