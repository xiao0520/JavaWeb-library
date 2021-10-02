package com.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class DatabaseConnection {
	
	static String driver=null;
	static String url=null;
	static String username=null;
	static String password=null;
	
	static 
	{
		try 
		{
			InputStream in=DatabaseConnection.class.getClassLoader().getResourceAsStream("datebase.properties");
			Properties prop=new Properties();
			prop.load(in);
			
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			
			Class.forName(driver);
			
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws Exception {
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	public static void release(PreparedStatement ps,ResultSet r) {
		
		if(r!=null) {
			
			try {
				r.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			r=null;
		}
		
		if(ps!=null) {
			try {
				ps.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public static void releaseAll(Connection c,PreparedStatement ps,ResultSet r)
	{
		if(r!=null)
		{
			try {
				r.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			r=null;
		}
		if(ps!=null)
		{
			try {
				ps.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(c!=null)
		{
			try {
				c.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public static void release(Connection c,PreparedStatement ps)
	{
	
		if(ps!=null) {
			
			try {
				ps.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		if(c!=null)	{
			
			try {
				c.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
