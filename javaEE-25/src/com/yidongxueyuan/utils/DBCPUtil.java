package com.yidongxueyuan.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * ������ı�д�� 
 * @author Mrzhang
 *
 */
public class DBCPUtil {
	private static DataSource ds; //��������Դ��
	
	static{
		
		try {
			//��ȡ�ⲿ�������ļ���������ļ�������ȡ�� 
			InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties p= new Properties();
			//ʹ��in ��p�������ݵ���䣺 
			p.load(in);
			//ע�������� 
			Class.forName(p.getProperty("driverClassName"));
			
			//�������Դ���� 
			ds= BasicDataSourceFactory.createDataSource(p);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
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
