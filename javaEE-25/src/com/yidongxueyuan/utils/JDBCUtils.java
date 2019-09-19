package com.yidongxueyuan.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC�ķ�װ�� 
 * @author Mrzhang
 *
 */
public class JDBCUtils {
	
	//׼�������ݿ���Ĵ������ 
	private static	String driver;
	private static	String url;
	private static	String user; 
	private static	String password ;
	
	
	
	//ע�������� 
	static{
		try {
		
			
			//��ȡ�����ļ��� src�£� ʹ����ļ�������ȡ
			InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("dbConfig.properties");
			
			Properties p = new Properties(); 
			
			//in���е����ݽ�p������䣺 
			p.load(in); 
			
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ܹ������ṩһ�����Ӷ��� 
	 * @return
	 * @throws Exception
	 */
   public static Connection getConnection()throws Exception{
	    return DriverManager.getConnection(url, user, password);
   }
   
   /**
    *  �ͷ���Դ�� 
    * @param connection 
    * @param stmt
    * @param rs 
    */
   public static void release(Connection connection, Statement stmt, ResultSet rs){
	   if(connection !=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null; //���������������Ļ��գ� 
		}
		if(stmt !=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null; //���������������Ļ��գ� 
		}
		if(rs !=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null; //���������������Ļ��գ� 
		}
   }
   
   
	
	
}
