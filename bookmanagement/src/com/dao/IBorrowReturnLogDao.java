package com.dao;

import java.util.List;

import com.bean.BorrowReturnLog;
import com.bean.Message;

public interface IBorrowReturnLogDao {
	
	public void borrowBook(Integer studentNo,String bookNo) throws Exception;

	public Integer findUserState(Integer studentNo) throws Exception;
	
	public Double findFine(Integer studentNo) throws Exception;
	
	public List<BorrowReturnLog> findAllReserveBook(Integer studentNo) throws Exception;
	
	public List<BorrowReturnLog> findAllBorrowBook(Integer studentNo) throws Exception;
	
	public void returnBook(Integer studentNo,String bookNo) throws Exception;
	
	public void payForFine(Integer studentNo) throws Exception;
	
	public void renewBook(Integer studentNo,String bookNo) throws Exception;
	
	public void reserveBookByNo(Integer studentNo,String bookNo) throws Exception;
	
	public void cancelReserveBook(Integer studentNo,String bookNo) throws Exception;
	
	public List<Message> findMessageByNo(Integer studentNo) throws Exception;
	
	public void initialUserState(Integer studentNo) throws Exception;
	
	public void insertNotice(String sender,String receiver,String message) throws Exception;
	
	public List<Message> findAllUserFeedback() throws Exception;
	
	public void deleteOneConceteMessage(String sender,String receiver,String message) throws Exception;

}

