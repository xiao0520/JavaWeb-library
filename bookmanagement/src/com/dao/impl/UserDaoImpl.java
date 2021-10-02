package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.User;
import com.config.DatabaseConnection;
import com.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	
	public List<User> findAllUser() throws Exception {

		String sql = "select * from user";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet r=ps.executeQuery();
		
		List<User> users = new ArrayList<>();
		
		while(r.next()) {
			
			int studentNo = r.getInt(2);
			String username = r.getString(3);
			String password = r.getString(4);
			
			User user = new User(studentNo,username,password);
			
			users.add(user);
			
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		
		return users;
	}


	public User findUserByNo(Integer no) throws Exception {


		String sql = "select * from user where Sno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,no);
		ResultSet r=ps.executeQuery();
		
		if(r.next()) {
			
			int studentNo = r.getInt(2);
			String username = r.getString(3);
			String password = r.getString(4);
			
			DatabaseConnection.releaseAll(connection,ps, r);

			return new User(studentNo,username,password);
			
		}
		

		

		
		return null;
	}


	public void insertUser(User user) throws Exception {
		

		String sql = "insert into user(Sno,username,password) values(?,?,?)";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,user.getStudentNo());
		ps.setString(2,user.getUsername());
		ps.setString(3,user.getPassword());

		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}
	


	public void updateUser(User user) throws Exception {
	
		String sql = "update user set username = ?,password = ? where Sno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		

		ps.setString(1,user.getUsername());
		ps.setString(2,user.getPassword());
		ps.setInt(3,user.getStudentNo());

		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void deleteUserByNo(Integer no) throws Exception {

		String sql = "delete from user where Sno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}



	public User findUserByUsername(String username) throws Exception {
	
		String sql = "select * from user where username = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,username);
		
		ResultSet r=ps.executeQuery();
		
		if(r.next()) {
			
			int studentNo = r.getInt(2);
			String name = r.getString(3);
			String password = r.getString(4);
			
			DatabaseConnection.releaseAll(connection,ps,r);
	
			return (new User(studentNo,name,password));
			
		}

		DatabaseConnection.releaseAll(connection,ps,r);
		
		return null;
		
	}


}
