
package com.swm.common.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import com.ibatis.sqlmap.client.SqlMapExecutor;
/**
 * 持久对象
 * @project JahwaInfomationAdmin   
 * @author 范元洋
 * @开发日期: Oct 20, 2012 9:21:29 PM 
 * @version 1.0
 * @description  增删查改
 * @see
 */
public class CommonDaoImpl extends AbstractDAO implements CommonDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<?> queryForList(String sqlId,Object queryParams){
			return this.sqlMapClientTemplate.queryForList(sqlId, queryParams);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> queryForList(String sqlId,Map<String, Object> map){
		if(map.get("startRow")!=null){
			if(map.get("rows")!=null){
				int startRow=(Integer)map.get("startRow")-1;
				int rows=(Integer)map.get("rows");
				return this.sqlMapClientTemplate.queryForList(sqlId, map, startRow*rows, rows);
			}
		}
		return this.sqlMapClientTemplate.queryForList(sqlId, map);
	}

	@Override
	public Object queryForObject(String sqlId, Object queryParams){
		return this.sqlMapClientTemplate.queryForObject(sqlId, queryParams);
	}

	@Override
	public Object queryForObject(String sqlId, Map<String, Object> map){
		return this.sqlMapClientTemplate.queryForObject(sqlId, map);
	}

	@Override
	public void addRecord(String sqlId, Object addParams) {
		this.sqlMapClientTemplate.insert(sqlId, addParams);
	}

	@Override
	public void addRecord(String sqlId, Map<String, Object> map) {
		this.sqlMapClientTemplate.insert(sqlId, map);
	}

	@Override
	public void updateRecord(String sqlId, Object updateParams) {
		this.sqlMapClientTemplate.update(sqlId, updateParams);
	}

	@Override
	public void updateRecord(String sqlId, Map<String, Object> map) {
		this.sqlMapClientTemplate.update(sqlId, map);
	}
    
	@Override
	public void deleteRecord(String sqlId, String deleteParams) {
		this.sqlMapClientTemplate.delete(sqlId, deleteParams);
	}

	@Override
	public void deleteRecord(String sqlId, Map<String, Object> map) {
		this.sqlMapClientTemplate.delete(sqlId, map);
	}
	public void addBatch(final String sqlId,final List<?> list) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
		            public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
		                executor.startBatch();
		                for (int i = 0; i < list.size(); i++) {
		                    executor.insert(sqlId, list.get(i));
		                }
		                return executor.executeBatch();
		            }
		        });

	}
	@SuppressWarnings("unchecked")
	public void batchDelete(final String sqlId, final List list) {
	           if (list != null) {
	              this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
	                  public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
	                     executor.startBatch();
	                     for (int i = 0, n = list.size(); i < n; i++) {
	                         executor.delete(sqlId, list.get(i));
	                     }
	                     executor.executeBatch();
	                     return null;

	                  }

	              });
	           }
	    }

	@Override
	public void seleteBatch(final String sqlId, final List list) {
		// TODO Auto-generated method stub
	    if (list != null) {
            this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
                public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                   executor.startBatch();
                   for (int i = 0, n = list.size(); i < n; i++) {
                       executor.delete(sqlId, list.get(i));
                   }
                   executor.executeBatch();
                   return null;

                }

            });
         }
	}

	@Override
	public void addRecord(String sqlId) {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().insert(sqlId);
	}

	@Override
	public void updateBatchRecord(final String sqlId, final List list) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
            public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                executor.startBatch();
                for (int i = 0; i < list.size(); i++) {
                    executor.insert(sqlId, list.get(i));
                }
                return executor.executeBatch();
            }
        });
		
	}
}
