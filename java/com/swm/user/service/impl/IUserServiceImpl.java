package com.swm.user.service.impl;

import java.util.Map;



import com.swm.common.bean.Page;
import com.swm.common.dao.CommonDao;
import com.swm.user.bean.User;
import com.swm.user.service.IUserService;
/**
 * 用户接口实现类
* @Title: IUserServiceImpl.java 
* @Package com.swm.user.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-23 上午10:29:03 
* @version V1.0
 */
public class IUserServiceImpl implements IUserService{
	
	private CommonDao commonDao;
	
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		commonDao.addRecord("addUser", user);
	}

	@Override
	public User queryUserByOpenId(String openId) throws Exception {
		// TODO Auto-generated method stub
		return (User) commonDao.queryForObject("queryUserByOpenId", openId);
	}

	@Override
	public Page qeuryUserByPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public void editUserByLoginIp(User user) throws Exception {
		// TODO Auto-generated method stub
		this.commonDao.updateRecord("editUserByLoginIp", user);
	}

	
}
