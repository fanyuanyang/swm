package com.swm.store.service;

import java.util.List;

import com.swm.store.bean.Store;
/**
 * 门店接口
* @Title: IStoreService.java 
* @Package com.swm.store.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-23 上午10:31:48 
* @version V1.0
 */
public interface IStoreService {
	/**
	 * 根据城市查询门店信息
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public List<Store> queryStoreByCityName(String city) throws Exception;
}
