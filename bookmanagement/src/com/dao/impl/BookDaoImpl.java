package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.Book;
import com.config.DatabaseConnection;
import com.dao.IBookDao;


public class BookDaoImpl implements IBookDao {
	
	
	
	public List<Book> findAllBook(Integer startIndex,Integer length) throws Exception {
		
		String sql = "select * from book limit ?,?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, startIndex);
		ps.setInt(2, length);
		
		ResultSet r=ps.executeQuery();
		
		List<Book> books=new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(2);
			String name = r.getString(3);
			String author = r.getString(4);
			double price = r.getDouble(5);
			int num = r.getInt(6);
			String shelf = r.getString(7);
			String remark = r.getString(8);
			
			Book book = new Book(no,name,author,price,num,shelf,remark);
			
			books.add(book);
			
		}
		
		DatabaseConnection.releaseAll(connection, ps, r);
		return books;
		
	}
	
	public Book findBookByNo(String no) throws Exception {
		
		String sql = "select * from book where Bno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,no);
		ResultSet r=ps.executeQuery();
		
		r.next();
		
		String bookNo = r.getString(2);
		String name = r.getString(3);
		String author = r.getString(4);
		double price = r.getDouble(5);
		int num = r.getInt(6);
		String shelf = r.getString(7);
		String remark = r.getString(8);
		
		Book book = new Book(bookNo,name,author,price,num,shelf,remark);
		
		
		DatabaseConnection.releaseAll(connection, ps, r);
		
		return book;
		
	}
	
	public void insertBook(Book book) throws Exception {
		
		String sql = "insert into book(Bno,Bname,Bauthor,Bprice,Bnum,Bshelf,Bremark) values(?,?,?,?,?,?,?)";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,book.getNo());
		ps.setString(2,book.getName());
		ps.setString(3,book.getAuthor());
		ps.setDouble(4, book.getPrice());
		ps.setInt(5, book.getNum());
		ps.setString(6,book.getShelf());
		ps.setString(7,book.getRemark());
		
		ps.execute();
		
		DatabaseConnection.release(connection, ps);
	}


	public void updateBook(String no,Book book) throws Exception {
		
		String sql = "update book set Bno = ?,Bname = ?,Bauthor = ?,Bprice = ?,Bnum = ? ,Bshelf = ? ,Bremark = ? where Bno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,book.getNo());
		ps.setString(2,book.getName());
		ps.setString(3,book.getAuthor());
		ps.setDouble(4,book.getPrice());
		ps.setInt(5, book.getNum());
		ps.setString(6,book.getShelf());
		ps.setString(7,book.getRemark());
		ps.setString(8,no);
		
		ps.execute();
		
		DatabaseConnection.release(connection, ps);
		
	}


	public void deleteBookByNo(String no) throws Exception {
		
		String sql = "delete from book where Bno = ?";
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection, ps);
		
	}


	public List<Book> findCanReserveBook() throws Exception {


		String sql = " select Bno,Bname,Bauthor,Bprice,Bshelf,type,location "
				   + " from book "
				   + " left join bookshelf " 
				   + " on no = Bshelf "
				   + " where " 
				   + " Bnum = 0 ";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		
		ResultSet r=ps.executeQuery();
		
		List<Book> books=new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(1);
			String name = r.getString(2);
			String author = r.getString(3);
			double price = r.getDouble(4);

			String shelf = r.getString(5);
			String bookType = r.getString(6);
			String bookLocation = r.getString(7);
			
			Book book = new Book(no,name,author,price,shelf,bookType,bookLocation);
			
			books.add(book);
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		return books;
		
	}

}
