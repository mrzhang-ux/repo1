package com.yidongxueyuan.utils;

import java.util.UUID;

/**
 * ����һ�������ࣺ �ܹ����һ��Ψһ��uuid��ֵ��string
 * 
 * @author Mrzhang
 *
 */
public class UUIDUtils {

	/**
	 * 
	 * @return ���String���͵�UUID��ֵ�� 
	 */
	public static String getUUID() {
		
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

}
