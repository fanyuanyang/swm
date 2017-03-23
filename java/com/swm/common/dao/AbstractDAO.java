package com.swm.common.dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;


/**
 * IBatis DAO抽象类
 * @author lk
 */

public abstract class AbstractDAO{
	
	protected SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}
	
}
