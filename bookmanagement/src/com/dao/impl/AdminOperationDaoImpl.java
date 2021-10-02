package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.BorrowReturnLog;
import com.config.DatabaseConnection;
import com.dao.IAdminOperationDao;

public class AdminOperationDaoImpl implements IAdminOperationDao {


	public List<BorrowReturnLog> findStudentBorrowBookByNo(Integer studentNo) throws Exception {
		
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


	public List<BorrowReturnLog> findAllStudentFineInfo() throws Exception {
		
		
		String sql = " select r.Sno,s.Sname,s.Sage,s.Ssex,s.Stel,s.Smajor,r.money "
				   + " from student_fine_relation r "
				   + " left join student s "
				   + " on s.Sno = r.Sno " ;
		
		PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
		
		ResultSet r = ps.executeQuery();
		
		List<BorrowReturnLog> allFineInfo = new ArrayList<>();
		
		while(r.next()) {
			
	
			Integer studentNo = r.getInt(1);
			String studentName = r.getString(2);
			Integer studentAge = r.getInt(3);
			String studentSex = r.getString(4);
			String studentTelephone = r.getString(5);
			String studentMajor = r.getString(6);
	
			Double fineMoney = r.getDouble(7);
		
			
			BorrowReturnLog fineInfo = new BorrowReturnLog(studentNo,studentName,studentAge,studentSex,studentTelephone,studentMajor,fineMoney);
			
			allFineInfo.add(fineInfo);
		}
		
		DatabaseConnection.release(ps, r);
		
		return allFineInfo;
		
	}

}
