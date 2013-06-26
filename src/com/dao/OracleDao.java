package com.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OracleDao {
	private static DataSource testRestDS = null;
	private static Context context = null;
	public static DataSource getDataSource() throws Exception{
		if(testRestDS != null){
			return testRestDS;
		}
		try{
			context = new InitialContext();
			testRestDS = (DataSource)context.lookup("testrestserviceDateOracle");
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return testRestDS;
	}
}
