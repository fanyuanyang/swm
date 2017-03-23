package com.swm.common.util;

import javax.sql.DataSource;

public class DataSourceUtil {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
}
