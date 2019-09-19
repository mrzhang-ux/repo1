package com.yidongxueyuan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		
		
		//���ʵ������� 
		final SpringBrother sb = new SpringBrother();
		
		//���sb����Ĵ������ JDK�� 
		
		/**
		 * loader�� �����������ļ�����
		 * interfaces����������Ľӿڵ������еķ�����  sb.getClass().getInterfaces()
		 * handler ��������ʹ�����Ҫʵ�ִ���Ĳ��ԣ� ���������ȥ����
		 */
		Human proxy = (Human)Proxy.newProxyInstance(sb.getClass().getClassLoader(), sb.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					/**
					 *  handler�� ʵ������δ��� 
					 *  proxy�� ����������ã� 
					 *  method�� ��ǰִ�еķ����� 
					 *  args: ��װ�˵�ǰִ�з����Ĳ����� 
					 *  ����ֵ�� �������ִ�еķ����ķ���ֵ�� 
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						//��õ�ǰִ�з��������ƣ� 
						String name = method.getName();
						if("sing".equals(name)){
							float money =(Float)args[0];
							if(money>2000){
								method.invoke(sb, money);
							}
						}
						if("dance".equals(name)){
							float money =(Float)args[0];
							if(money>2000){
								method.invoke(sb, money);
							}
						}
						
						return null;
					}
				}
				
				); 
		proxy.dance(3000);
		proxy.sing(23000);
		
		/*sb.dance(3000);
		sb.sing(3000);*/
	}
}
