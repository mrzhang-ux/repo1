package com.yidongxueyuan.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0������ı�д�� 
 * @author Mrzhang
 *
 */
public class C3P0Util {
	//������ص�ʱ�� static��ִ���ˣ� ComboPooledDataSource�����ʼ���ˣ� Ĭ��ȥ��ȡ��·���µ�����Ϊ c3p0-config.xml�ļ����е����ݣ�
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	//private static ComboPooledDataSource ds = new ComboPooledDataSource("֪���ļ�������");
	
	
	/**
	 * ���һ����׼������Դ�� 
	 * @return
	 */
	public static DataSource getDataSource(){
		return ds; 
	}
	
	/**
	 *   �ṩ��һ�����Ӷ��� 
	 *   ���Ӷ�������ӳ��ӵ��л�ã�
	 */
	
	public static Connection getConnection(){
		 try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null; 
	}
}
