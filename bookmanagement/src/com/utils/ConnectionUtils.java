package com.utils;

import java.sql.Connection;

import com.config.DatabaseConnection;

public class ConnectionUtils 
{
	
	private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	public Connection getThreadConnection() 
	{
		Connection connection = threadLocal.get();
		
		if(connection == null)
		{
			try {
				
				connection = DatabaseConnection.getConnection();
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
			threadLocal.set(connection);
		}
		
		return connection;
	}
	
	//连接与线程解绑
    public void removeConnection()
    {
    	threadLocal.remove();
    }

}
