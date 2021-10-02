package com.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import com.utils.TransactionManager;

public class ProxyFactory implements InvocationHandler  {
	
	private Object proxyObject;
	private TransactionManager transactionManager = (TransactionManager) BeanFactory.getBean("transactionManager");
	
	
	
	public Object getProxyObject() {return proxyObject;}

	public void setProxyObject(Object proxyObject) {this.proxyObject = proxyObject;}



	public Object getProxyInstance() {
		
		return  Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(),
				proxyObject.getClass().getInterfaces(),this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
				Object value = null;
				try {
					
				transactionManager.beginTransaction();
				method.invoke(proxyObject, args);
				if(method.getName().equals("test"))
				System.out.println(222);
				transactionManager.commit();
				return value;
				
				}catch(Exception e){
					transactionManager.rollback();
					throw new RuntimeException(e);
				}finally {
					transactionManager.release(); 
				
				}
	}
	
	
}
