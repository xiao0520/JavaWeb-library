package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.Bookshelf;
import com.config.DatabaseConnection;
import com.dao.IBookshelfDao;


public class BookshelfDaoImpl implements IBookshelfDao {


	public List<Bookshelf> findAllBookshelf() throws Exception {
		
		String sql = "select * from bookshelf";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet r=ps.executeQuery();
		
		List<Bookshelf> bookshelfs=new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(2);
			String area = r.getString(3);
			String location = r.getString(4);
			String type = r.getString(5);
			String remark = r.getString(6);
			
			Bookshelf bookshelf = new Bookshelf(no, area, location, type, remark);
			
			bookshelfs.add(bookshelf);
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		return bookshelfs;

	}


	public Bookshelf findBookshelfByNo(String no) throws Exception {
		
		
		String sql = "select * from bookshelf where no = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,no);
		ResultSet r=ps.executeQuery();
		
		if(r.next()) {
			
			String bookshelfNo = r.getString(2);
			String area = r.getString(3);
			String location = r.getString(4);
			String type = r.getString(5);
			String remark = r.getString(6);
			
			Bookshelf bookshelf = new Bookshelf(bookshelfNo,area,location,type,remark);
			
			DatabaseConnection.releaseAll(connection,ps, r);
			
			return bookshelf;
		}

		DatabaseConnection.releaseAll(connection,ps, r);
		
		return null;

	}


	public void insertBookshelf(Bookshelf bookshelf) throws Exception {

		String sql = "insert into bookshelf(no,area,location,type,remark) values(?,?,?,?,?)";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,bookshelf.getNo());
		ps.setString(2,bookshelf.getArea());
		ps.setString(3,bookshelf.getLocation());
		ps.setString(4,bookshelf.getType());
		ps.setString(5,bookshelf.getRemark());
		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void updateBookshelf(String no,Bookshelf bookshelf) throws Exception {

		String sql = "update bookshelf set no = ?,area = ?,location = ?,type = ?,remark = ? where no = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,bookshelf.getNo());
		ps.setString(2,bookshelf.getArea());
		ps.setString(3,bookshelf.getLocation());
		ps.setString(4,bookshelf.getType());
		ps.setString(5,bookshelf.getRemark());
		ps.setString(6,no);
		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void deleteBookshelfByNo(String no) throws Exception {

		String sql = "delete from bookshelf where no = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


}
