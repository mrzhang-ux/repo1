package com.yidongxueyuan.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 工具类的编写： 
 * @author Mrzhang
 *
 */
public class DBCPUtil {
	private static DataSource ds; //引入数据源：
	
	static{
		
		try {
			//读取外部的配置文件：采用类的加载器读取： 
			InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties p= new Properties();
			//使用in 将p进行数据的填充： 
			p.load(in);
			//注册驱动： 
			Class.forName(p.getProperty("driverClassName"));
			
			//获得数据源对象： 
			ds= BasicDataSourceFactory.createDataSource(p);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	/**
	 * 获得一个标准的数据源： 
	 * @return
	 */
	public static DataSource getDataSource(){
		return ds; 
	}
	
	/**
	 *   提供了一个链接对象： 
	 *   链接对象从链接池子当中获得：
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
