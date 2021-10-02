package com.dao;

import java.util.List;

import com.bean.BorrowReturnLog;

public interface IAdminOperationDao {
	
	public List<BorrowReturnLog> findStudentBorrowBookByNo(Integer studentNo) throws Exception;
	
	public List<BorrowReturnLog> findAllStudentFineInfo() throws Exception;
}
