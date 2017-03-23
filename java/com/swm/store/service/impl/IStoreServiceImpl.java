package com.swm.store.service.impl;

import java.util.List;

import com.swm.common.dao.CommonDao;
import com.swm.store.bean.Store;
import com.swm.store.service.IStoreService;

public class IStoreServiceImpl implements IStoreService{
	private CommonDao commonDao;
	@Override
	public List<Store> queryStoreByCityName(String city) throws Exception {
		// TODO Auto-generated method stub
		return (List<Store>) this.commonDao.queryForList("queryStoreByCityName", city);
	}
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	
	
	
}
