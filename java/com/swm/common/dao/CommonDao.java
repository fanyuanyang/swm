package com.swm.common.dao;

import java.util.List;
import java.util.Map;


/**
 * 持久类
 * 
 * @project JahwaInfomationAdmin
 * @author 范元洋
 * @开发日期: Oct 21, 2012 4:23:09 PM
 * @version 1.0
 * @description
 * @see
 */
public interface CommonDao {

	/**
	 * 根据查询参数实体类查询出列表
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的查询id
	 * @param queryParams
	 * @return
	 */
	public List<?> queryForList(String sqlId, Object queryParams);

	/**
	 * 根据查询参数map查询出列表
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的查询id
	 * @param map
	 * @return
	 */
	public List<?> queryForList(String sqlId, Map<String, Object> map);

	/**
	 * 根据查询参数实体类查询出对象
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的查询id
	 * @param queryParams
	 * @return
	 */
	public Object queryForObject(String sqlId, Object queryParams);

	/**
	 * 根据查询参数map查询出对象
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的查询id
	 * @param map
	 * @return
	 */
	public Object queryForObject(String sqlId, Map<String, Object> map);

	/**
	 * 添加数据
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的id
	 * @param addParams
	 */
	public void addRecord(String sqlId);
	/**
	 * 添加数据
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的id
	 * @param addParams
	 */
	public void addRecord(String sqlId, Object addParams);

	/**
	 * 添加数据
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的id
	 * @param map
	 */
	public void addRecord(String sqlId, Map<String, Object> map);

	/**
	 * 更新数据
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的id
	 * @param updateParams
	 */
	public void updateRecord(String sqlId, Object updateParams);

	/**
	 * 更新数据
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的id
	 * @param map
	 */
	public void updateRecord(String sqlId, Map<String, Object> map);

	/**
	 * 批量更新数据
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的id
	 * @param map
	 */
	public void updateBatchRecord(final String sqlId, final List list);
	/**
	 * 删除数据
	 * 
	 * @param sqlId         ibatis配置文件对应的id
	 * @param deleteParams
	 */
	public void deleteRecord(String sqlId, String deleteParams);

	/**
	 * 删除数据
	 * 
	 * @param sqlId
	 *            ibatis配置文件对应的id
	 * @param map
	 */
	public void deleteRecord(String sqlId, Map<String, Object> map);

	/**
	 * 新增批量数据
	 * 
	 * @param sqlId
	 *            sqlId ibatis配置文件对应的id
	 * @param list
	 *            批量数据集合
	 */
	public void addBatch(final String sqlId, final List<?> list);

	/**
	 * 批量删除
	 * 
	 * @param sqlId
	 *            sqlId sqlId ibatis配置文件对应的id
	 * @param list
	 *            批量数据集合
	 */
	public void batchDelete(final String sqlId, final List list);

	/**
	 * 批量查询
	 * 
	 * @param sqlId
	 *            参数sql
	 * @param list
	 *            集合
	 */
	public void seleteBatch(final String sqlId, final List list);

}
