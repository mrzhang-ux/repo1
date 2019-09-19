package com.yidongxueyuan.utils;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 作用：将map集合当中的数据直接封装到javaBean当中： 
 * @author Mrzhang
 *
 */
public class ToBean {

	/**
	 * 
	 * @param map map集合
	 * @param clazz 实体bean的Class类型
	 * @return 返回出去的一个不确定的对象： 
	 */
	public static <T> T toBean(Map map, Class clazz) {// T 返回值类型 <T> 静态方法上的泛型在使用的时候，，必须声明
		
		try {
			//clazz 对象获得了一个实体bean
			T  bean =(T) clazz.newInstance();
			
			BeanUtils.populate(bean, map); 
			return bean; 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
