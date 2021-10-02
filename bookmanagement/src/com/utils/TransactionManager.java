package com.utils;

import java.sql.SQLException;

public class TransactionManager 
{
	
	private ConnectionUtils connectionUtils = new ConnectionUtils();
	
	public void beginTransaction()
	{
		try {
			connectionUtils.getThreadConnection().setAutoCommit(false);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void commit()
	{
		try {
			connectionUtils.getThreadConnection().commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public void rollback()
	{
		try {
			connectionUtils.getThreadConnection().rollback();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void release()
	{
		try {
			connectionUtils.getThreadConnection().close();
			connectionUtils.removeConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
