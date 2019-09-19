package com.yidongxueyuan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 能够对外产生代理对象： 
 * @author Mrzhang
 *
 */
public class SpringBrotherProxy implements InvocationHandler{
	
	//引入被代理对象： 
	private  SpringBrother human;
	
	
	//构造器初始化： 
	public SpringBrotherProxy(SpringBrother human){
	   this.human = human;	
	}


	//达成具体的代理的策略
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		//获得当前执行方法的名称： 
		String name = method.getName();
		if("sing".equals(name)){
			float money =(Float)args[0];
			if(money>2000){
				method.invoke(human, money);
			}
		}
		if("dance".equals(name)){
			float money =(Float)args[0];
			if(money>2000){
				method.invoke(human, money);
			}
		}
		
		return null;
	}
	//产生Human的代理对象： 
	
/*	public  Human getProxy(){
		try {
			Human human =  (Human)Proxy.newProxyInstance(SpringBrotherProxy.class.getClassLoader(), human.getClass().getInterfaces(), this);
		    return human; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}*/

}
