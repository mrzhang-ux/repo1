package com.yidongxueyuan.datasource;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import com.yidongxueyuan.utils.JDBCUtils;

public class MyDataSource implements DataSource {
	private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());
	
	static{
		for(int i=0 ; i<10; i++){
			try {
				Connection conn = JDBCUtils.getConnection(); 
				pool.add(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
	    
		if(pool.size()>0){//���ӵ��������Ӷ��� 
			final Connection conn = pool.remove(0);
			
			//ʹ�ô���ģʽ����Connection���������ǿ��
			Connection proxy = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), 
					conn.getClass().getInterfaces(),
					new InvocationHandler() {
						
						@Override
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
						    
							//����˵�ǰִ�з��������ƣ� 
							String methodName = method.getName();
							if("close".equals(methodName)){
								//���س��ӵ��У�
								return pool.add(conn);//ԭ���ģ�  method.invoke(conn,args)
							}else{
								//�������close������ ֱ��ִ��conn�ķ�������
								return method.invoke(conn, args);
							}
							
						}
			});
			return proxy; 
		}else{
			throw new RuntimeException("������æ");
		}
		
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
