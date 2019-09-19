package com.yidongxueyuan.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestCGLIB {
	public static void main(String[] args) {
		//被代理对象： 
		final Human human = new Human(); 
		
		
		//cglib 获得human 对象的代理对象：  被代理对象的子类对象： 
	    
		/*
		 * callback：回调函数：  接口类型： 不直接使用callback函数： 使用该回调函数的一个子接口： 
		 * 
		 * MethodInterceptor： 
		 * 
		 */
		Human proxy = (Human)Enhancer.create(human.getClass(), new MethodInterceptor() {
			
			/*
			 *  proxy： 代理对象的引用： 
			 *  method:当前执行的方法： 
			 *  args： 数组类型，封装了当前执行方法的参数： 
			 *  args：调用方法的引用：
			 *   Object：当前调用方法的返回值： 
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
