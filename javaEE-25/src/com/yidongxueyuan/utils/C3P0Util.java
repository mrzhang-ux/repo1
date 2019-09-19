package com.yidongxueyuan.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0工具类的编写： 
 * @author Mrzhang
 *
 */
public class C3P0Util {
	//该类加载的时候： static就执行了： ComboPooledDataSource对象初始化了： 默认去读取类路径下的名称为 c3p0-config.xml文件当中的数据：
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	//private static ComboPooledDataSource ds = new ComboPooledDataSource("知名文件的名称");
	
	
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
