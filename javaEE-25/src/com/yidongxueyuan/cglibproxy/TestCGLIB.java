package com.yidongxueyuan.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestCGLIB {
	public static void main(String[] args) {
		//��������� 
		final Human human = new Human(); 
		
		
		//cglib ���human ����Ĵ������  ����������������� 
	    
		/*
		 * callback���ص�������  �ӿ����ͣ� ��ֱ��ʹ��callback������ ʹ�øûص�������һ���ӽӿڣ� 
		 * 
		 * MethodInterceptor�� 
		 * 
		 */
		Human proxy = (Human)Enhancer.create(human.getClass(), new MethodInterceptor() {
			
			/*
			 *  proxy�� �����������ã� 
			 *  method:��ǰִ�еķ����� 
			 *  args�� �������ͣ���װ�˵�ǰִ�з����Ĳ����� 
			 *  args�����÷��������ã�
			 *   Object����ǰ���÷����ķ���ֵ�� 
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy arg3) throws Throwable {
				Object obj=null;
				String name = method.getName();
				if("sing".equals(name)){
					float money =(Float)args[0];
					if(money>2000){
						obj= method.invoke(human, money);
					}
				}
				if("dance".equals(name)){
					float money =(Float)args[0];
					if(money>2000){
						obj= method.invoke(human, money);
					}
				}
				return obj;
			}
		} ); 
		
		/*human.sing(3000);
		human.dance(3000);*/
		
		proxy.sing(3000);
		proxy.dance(1000);
	}
}
