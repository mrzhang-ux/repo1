package com.yidongxueyuan.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC的封装： 
 * @author Mrzhang
 *
 */
public class JDBCUtils {
	
	//准备了数据库的四大参数： 
	private static	String driver;
	private static	String url;
	private static	String user; 
	private static	String password ;
	
	
	
	//注册驱动： 
	static{
		try {
		
			
			//读取配置文件： src下， 使用类的加载器读取
			InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("dbConfig.properties");
			
			Properties p = new Properties(); 
			
			//in当中的数据将p集合填充： 
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
	 * 能够对外提供一个链接对象： 
	 * @return
	 * @throws Exception
	 */
   public static Connection getConnection()throws Exception{
	    return DriverManager.getConnection(url, user, password);
   }
   
   /**
    *  释放资源： 
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
			connection = null; //加速垃圾回收器的回收： 
		}
		if(stmt !=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null; //加速垃圾回收器的回收： 
		}
		if(rs !=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null; //加速垃圾回收器的回收： 
		}
   }
   
   
	
	
}
