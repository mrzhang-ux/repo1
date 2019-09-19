package com.yidongxueyuan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �ܹ��������������� 
 * @author Mrzhang
 *
 */
public class SpringBrotherProxy implements InvocationHandler{
	
	//���뱻������� 
	private  SpringBrother human;
	
	
	//��������ʼ���� 
	public SpringBrotherProxy(SpringBrother human){
	   this.human = human;	
	}


	//��ɾ���Ĵ���Ĳ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		//��õ�ǰִ�з��������ƣ� 
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
	//����Human�Ĵ������ 
	
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
