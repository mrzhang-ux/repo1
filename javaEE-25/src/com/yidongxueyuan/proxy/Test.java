package com.yidongxueyuan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		
		
		//获得实现类对象： 
		final SpringBrother sb = new SpringBrother();
		
		//获得sb对象的代理对象： JDK： 
		
		/**
		 * loader： 被代理类的类的加载器
		 * interfaces：被代理类的接口当中所有的方法：  sb.getClass().getInterfaces()
		 * handler 被代理类和代理类要实现代理的策略： 代理类如何去代理？
		 */
		Human proxy = (Human)Proxy.newProxyInstance(sb.getClass().getClassLoader(), sb.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					/**
					 *  handler： 实现了如何代理： 
					 *  proxy： 代理类的引用： 
					 *  method： 当前执行的方法： 
					 *  args: 封装了当前执行方法的参数： 
					 *  返回值： 如果当中执行的方法的返回值， 
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						//获得当前执行方法的名称： 
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
