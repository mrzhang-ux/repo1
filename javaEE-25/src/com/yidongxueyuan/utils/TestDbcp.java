package com.yidongxueyuan.utils;

import java.sql.Connection;

public class TestDbcp {
	public static void main(String[] args) {
		
		
		//ֱ�ӻ��һ�����Ӷ��� 
		/*Connection connection = DBCPUtil.getConnection();
		System.out.println(connection);
		System.out.println(connection.getClass());*/
		
		
		//connection.close(); close������ �����Ӷ��󻹻س��ӵ��У�
		// class org.apache.commons.dbcp.PoolingDataSource$PoolGuardConnectionWrapper
		
		//����c3po 
		Connection connection = C3P0Util.getConnection();
		System.out.println(connection);
		System.out.println(connection.getClass());
	}
}
