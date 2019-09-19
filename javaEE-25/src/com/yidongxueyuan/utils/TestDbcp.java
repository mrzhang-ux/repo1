package com.yidongxueyuan.utils;

import java.sql.Connection;

public class TestDbcp {
	public static void main(String[] args) {
		
		
		//直接获得一个链接对象： 
		/*Connection connection = DBCPUtil.getConnection();
		System.out.println(connection);
		System.out.println(connection.getClass());*/
		
		
		//connection.close(); close方法， 将链接对象还回池子当中：
		// class org.apache.commons.dbcp.PoolingDataSource$PoolGuardConnectionWrapper
		
		//测试c3po 
		Connection connection = C3P0Util.getConnection();
		System.out.println(connection);
		System.out.println(connection.getClass());
	}
}
