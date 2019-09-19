package com.yidongxueyuan.utils;

import java.util.UUID;

/**
 * 创建一个工具类： 能够会的一个唯一的uuid的值：string
 * 
 * @author Mrzhang
 *
 */
public class UUIDUtils {

	/**
	 * 
	 * @return 获得String类型的UUID的值： 
	 */
	public static String getUUID() {
		
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

}
