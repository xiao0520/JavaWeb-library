package com.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Book;
import com.bean.BorrowReturnLog;
import com.bean.Message;
import com.config.DatabaseConnection;
import com.dao.IBorrowReturnLogDao;

public class BorrowReturnLogDaoImpl implements IBorrowReturnLogDao {
	
	
	
	@SuppressWarnings("resource")
	public void borrowBook(Integer studentNo,String bookNo) throws Exception{
		
		
		String borrowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		Connection connection = DatabaseConnection.getConnection();
		
		Book book = (new BookDaoImpl()).findBookByNo(bookNo);
		
		int bookNum = book.getNum();
		
		//添加一条学生借书记录
		
		String sql = "insert into student_book_relation(Sno,Bno,time,renew) values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		System.out.println(studentNo+" "+bookNo+" "+borrowDate);
		
		ps.setInt(1,studentNo);
		ps.setString(2,bookNo);
		ps.setString(3,borrowDate);
		ps.setInt(4,0);

		
		ps.execute();
		
		//更新所借书籍的数量
	
		sql = "update book set Bnum = ? where Bno = ?";
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,bookNum-1);
		ps.setString(2,bookNo);
		
		ps.execute();
		
		//更新学生借书的关系	
		
		sql = "select * from student_borrow_relation where Sno =?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1,studentNo);
		

		ResultSet r=ps.executeQuery();

		
		if(r.next()) {
			
			int num = r.getInt(3);

			if(num<7) {
				
				sql = "update student_borrow_relation set num = ? where Sno = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1,num+1);
				ps.setInt(2,studentNo);
				ps.executeUpdate();
				 
			} else {

				sql = "update student_borrow_relation set num = ?,state = ? where Sno = ?";
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1,num+1);
				ps.setInt(2,0);
				ps.setInt(3,studentNo);
				
				ps.executeUpdate();
				
			}
			
		}
		
		DatabaseConnection.releaseAll(connection, ps, r);
		
	}


	public Integer findUserState(Integer studentNo) throws Exception {
		
		String 	sql = "select * from student_borrow_relation where Sno = ?";
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		
		ResultSet r = ps.executeQuery();
		
		if(r.next()){
			
			int state = r.getInt(4);
			return state;
		}
		
		
		DatabaseConnection.release(ps, r);
		
		return 0;	
		
	}
	
	public Double findFine(Integer studentNo) throws Exception {
		
		
		String 	sql = "select * from student_fine_relation where Sno = ?";
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		
		ResultSet r = ps.executeQuery();
		
		if(r.next()) {
			
			double money = r.getDouble(3);
			
			DatabaseConnection.release(ps, r);
			
			return money;
			
		}

		DatabaseConnection.release(ps, r);
		return null;	
		
	}

	public List<BorrowReturnLog> findAllBorrowBook(Integer studentNo) throws Exception {


		String 	sql = " select r.Bno,b.Bname,b.Bauthor,b.Bprice,r.time,s.type,s.location,r.renew "
					+ " from student_book_relation r "
					+ " left join book b "
					+ " on r.Bno = b.Bno "
					+ " left join bookshelf s "
					+ " on b.Bshelf = s.no "
					+ " where Sno = ? " ;
		
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		
		ResultSet r = ps.executeQuery();
		
		List<BorrowReturnLog> books=new ArrayList<>();
		
		while(r.next()) {
			
	
			String bookNo = r.getString(1);
			String bookname = r.getString(2);
			String author = r.getString(3);
			Double price = r.getDouble(4);
			String borrowTime = r.getString(5);
			String type = r.getString(6);
			String bookLocation = r.getString(7);
			Integer renew = r.getInt(8);
			
			java.sql.Date borrowDate = java.sql.Date.valueOf(borrowTime);
			
			java.sql.Date backDate = new java.sql.Date(borrowDate.getTime()+(renew+1)*15*24*60*60*1000L);
			
			String backTime = new SimpleDateFormat("yyyy-MM-dd").format(backDate);
			
			BorrowReturnLog borrowedBook = new BorrowReturnLog(bookNo,bookname,author,price,borrowTime,backTime,type,bookLocation,renew);
			
			books.add(borrowedBook);
			
		}
		
		DatabaseConnection.release(ps, r);
		
		return books;
		
	}



	@SuppressWarnings("resource")
	public void returnBook(Integer studentNo, String bookNo) throws Exception {
		
		int renew;
		String borrowDate;
		String backDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		

		Connection connection = DatabaseConnection.getConnection();
		
		
		
		//删已借书记录并记录借阅日期
		
		String 	sql = "select time,renew from student_book_relation where Sno = ? and Bno = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		ps.setString(2,bookNo);
		
		ResultSet r = ps.executeQuery();
		
		r.next();
		
		borrowDate = r.getString(1);
		renew = r.getInt(2);
		
		sql = "delete from student_book_relation where Sno = ? and Bno = ?";
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		ps.setString(2,bookNo);

		ps.execute();
		
		//更新所借图书数量
		
		Book book = (new BookDaoImpl()).findBookByNo(bookNo);
		
		int bookNum = book.getNum();
		
		sql = "update book set Bnum = ? where Bno = ?";
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,bookNum+1);
		ps.setString(2,bookNo);
		
		ps.execute();
		
		//更新个人借书状态
		
		sql = "select num , state from student_borrow_relation where Sno = ?";
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		
		r = ps.executeQuery();
		
		r.next();
		
		int num = r.getInt(1);
		int state = r.getInt(2);

		if(num == 8) {
			state = 1;
		} 
		
		num--;
		
		sql = "update student_borrow_relation set num = ?,state = ? where Sno = ?";
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,num);
		ps.setInt(2,state);
		ps.setInt(3,studentNo);
		
		ps.executeUpdate();
		
		
		//更新罚款信息
		
		java.sql.Date borrow = java.sql.Date.valueOf(borrowDate);
		
		java.sql.Date back = java.sql.Date.valueOf(backDate);
		
		int duration =(int) ((back.getTime()-borrow.getTime())/(1000*60*60*24));
		
		int fineMoney = 0;
		
		if(renew == 1) {
			
			if(duration > 30) {
				
				fineMoney += duration-30;
			}
			
		} else {
			
			if(duration > 15) {
				
				fineMoney += duration-15;
			}
			
		}
		
		sql = "select Sno , money from student_fine_relation where Sno = ?";
			
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1,studentNo);

		r = ps.executeQuery();
		
		if(r.next()) {
			
			int money = r.getInt(2);
			
			sql = "update student_fine_relation set money = ? where Sno = ?";
			
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1,money+fineMoney);
			ps.setInt(2,studentNo);
			
			ps.executeUpdate();
			
		} else {
			
			if(fineMoney != 0) {
				
				sql = "insert into student_fine_relation(Sno,money) values(?,?)";
				
				ps = connection.prepareStatement(sql);
				
				ps.setInt(1,studentNo);
				ps.setInt(2,fineMoney);
				
				ps.execute();
				
			} 
			
		}
		
		DatabaseConnection.releaseAll(connection, ps, r);
		
	}


	public void payForFine(Integer studentNo) throws Exception {
		
		String sql = "update student_fine_relation set money = 0 where Sno = ? ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		
		ps.executeUpdate();
		
		ps.close();
		
	}



	public void renewBook(Integer studentNo, String bookNo) throws Exception {

		String sql = "update student_book_relation set renew = 1 where Sno = ? and Bno = ? ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		ps.setString(2,bookNo);
		
		ps.executeUpdate();
		
		ps.close();

	}


	public List<BorrowReturnLog> findAllReserveBook(Integer studentNo) throws Exception {

		String sql = " select b.Bno,b.Bname,b.Bauthor,b.Bprice,b.Bnum,s.type,s.location "
				   + " from book_appointment_relation r "
				   + " left join book b "
				   + " on r.Bno = b.Bno "
				   + " left join bookshelf s "
				   + " on b.Bshelf = s.no "
				   + " where r.Sno = ? ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);

		ResultSet r = ps.executeQuery();
		
		List<BorrowReturnLog> books=new ArrayList<>();
		
		while(r.next()) {
	
			String bookNo = r.getString(1);
			String bookname = r.getString(2);
			String author = r.getString(3);
			Double price = r.getDouble(4);
			
			Integer bookNum = r.getInt(5);
			String type = r.getString(6);
			String bookLocation = r.getString(7);
			
			BorrowReturnLog borrowedBook = new BorrowReturnLog(bookNo,bookNum,bookname,author,price,type,bookLocation);
			
			books.add(borrowedBook);
			
		}
		
		DatabaseConnection.release(ps, r);
		
		return books;
		
	}


	public void reserveBookByNo(Integer studentNo,String bookNo) throws Exception {

	
		String sql = "insert into book_appointment_relation(Sno,Bno) values(?,?)";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		ps.setString(2,bookNo);
		
		ps.execute();
		
		ps.close();
		
	}



	public void cancelReserveBook(Integer studentNo, String bookNo) throws Exception {
		

		String sql = "delete from book_appointment_relation where Sno = ? and Bno = ?";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		ps.setString(2,bookNo);
		
		ps.execute();
		
		ps.close();
		
	}



	public List<Message> findMessageByNo(Integer studentNo) throws Exception {
		
		
		String sql = "select sender,receiver,message,time from notice where receiver = ?";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		

		
		List<Message> messages = new ArrayList<>();
		
		ResultSet r = ps.executeQuery();
		
		while(r.next()) {
			
	
			String sender = r.getString(1);
			String receiver = r.getString(2);
			String message = r.getString(3);
			String time = r.getString(4);

			Message oneMessage = new Message(sender, receiver, message, time);
			
			
			messages.add(oneMessage);

		}
		
		DatabaseConnection.release(ps, r);
		
		return messages;
		
		
	}



	public void initialUserState(Integer studentNo) throws Exception {
		
		String sql = "insert into student_borrow_relation(Sno,num,state) values(?,0,1)";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setInt(1,studentNo);
		
		ps.execute();
		
		ps.close();
		
	}



	public void insertNotice(String sender, String receiver, String message) throws Exception {
		
		String sendDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		String sql = "insert into notice(sender,receiver,message,time) values(?,?,?,?)";
		
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setString(1,sender);
		ps.setString(2,receiver);
		ps.setString(3,message);
		ps.setString(4,sendDate);
		
		ps.execute();
		
		ps.close();
	}



	public List<Message> findAllUserFeedback() throws Exception {
	

		String sql = " select n.sender,n.receiver,n.message,n.time ,s.Sname,m.Mname,m.Mdept from notice n "
				   + " left join student s "
				   + " on n.sender = s.Sno "
				   + " left join major m "
				   + " on m.Mname = s.Smajor "
				   + " where receiver = 'admin' ";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);

		List<Message> messages = new ArrayList<>();
		
		ResultSet r = ps.executeQuery();
		
		while(r.next()) {
			
	
			String sender = r.getString(1);
			String receiver = r.getString(2);
			String message = r.getString(3);
			String time = r.getString(4);
			String senderName = r.getString(5);
			String senderMajor = r.getString(6);
			String senderDepartment = r.getString(7);

			Message oneMessage = new Message(sender, receiver, message, time,senderName,senderMajor,senderDepartment);
			
			
			messages.add(oneMessage);

		}
		
		DatabaseConnection.release(ps, r);
		
		return messages;
	}



	public void deleteOneConceteMessage(String sender, String receiver, String message) throws Exception {
		
		System.out.println(sender+" "+receiver+" "+message);
		
		String sql = "delete from notice where sender = ? and receiver = ? and message = ?";
		
		PreparedStatement ps =DatabaseConnection.getConnection().prepareStatement(sql);
		
		ps.setString(1,sender);
		ps.setString(2,receiver);
		ps.setString(3,message);
		
		ps.execute();
		
		ps.close();
		
		System.out.println(sender+" "+receiver+" "+message);

	}


}
