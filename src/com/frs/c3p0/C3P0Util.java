package com.frs.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource datasource=null;
	static{
		datasource=new ComboPooledDataSource();
	}
	public static DataSource getdatasource(){
		return datasource;
	}
	public static Connection getconnection(){
		Connection conn=null;
		try {
			conn=datasource.getConnection();
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void getclose(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
