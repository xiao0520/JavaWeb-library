package com.bean;

import java.io.Serializable;

public class BorrowReturnLog implements Serializable{
	
	private Integer studentNo;
	private String bookNo;
	private String borrowDate;
	private String backDate;
	private Integer renew;
	
	private String studentName;
	private Integer studentAge;
	private String studentSex;
	private String studentTelephone;
	private String studentMajor;

	private Double fineMoney;
	
	private Integer bookNum;
	private String bookName;
	private String bookAuthor;
	private Double bookPrice;
	private String bookType;
	private String bookLocation;
	


	
	public BorrowReturnLog(Integer studentNo, String bookNo, String borrowDate, Integer renew) {
		
		this.studentNo = studentNo;
		this.bookNo = bookNo;
		this.borrowDate = borrowDate;
		this.renew = renew;
	}
	
	public BorrowReturnLog(String bookNo, String bookName,String bookAuthor,Double bookPrice,String borrowDate,String backDate,String bookType,String bookLocation,Integer renew) {
		
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.borrowDate = borrowDate;
		this.backDate = backDate;
		this.bookType = bookType;
		this.bookLocation = bookLocation;
		this.renew = renew;
	}
	
	

	public BorrowReturnLog(String bookNo, Integer bookNum, String bookName, String bookAuthor, Double bookPrice,String bookType, String bookLocation) {
		this.bookNo = bookNo;
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookType = bookType;
		this.bookLocation = bookLocation;
	}
	
	
	
	

	public BorrowReturnLog(Integer studentNo, String studentName, Integer studentAge, String studentSex,String studentTelephone, String studentMajor, Double fineMoney) {
		
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentSex = studentSex;
		this.studentTelephone = studentTelephone;
		this.studentMajor = studentMajor;
		this.fineMoney = fineMoney;
	}


	public String getStudentName() {return studentName;}

	public void setStudentName(String studentName) {this.studentName = studentName;}

	public Integer getStudentAge() {return studentAge;}

	public void setStudentAge(Integer studentAge) {this.studentAge = studentAge;}

	public String getStudentSex() {return studentSex;}

	public void setStudentSex(String studentSex) {this.studentSex = studentSex;}

	public String getStudentTelephone() {return studentTelephone;}

	public void setStudentTelephone(String studentTelephone) {this.studentTelephone = studentTelephone;}

	public String getStudentMajor() {return studentMajor;}

	public void setStudentMajor(String studentMajor) {this.studentMajor = studentMajor;}

	public Double getFineMoney() {return fineMoney;}

	public void setFineMoney(Double fineMoney) {this.fineMoney = fineMoney;}

	public Integer getBookNum() {return bookNum;}

	public void setBookNum(Integer bookNum) {this.bookNum = bookNum;}

	public Integer getStudentNo() {return studentNo;}

	public void setStudentNo(Integer studentNo) {this.studentNo = studentNo;}

	public String getBookNo() {return bookNo;}

	public void setBookNo(String bookNo) {this.bookNo= bookNo;}

	public String getBorrowDate() {return borrowDate;}

	public void setBorrowDate(String borrowDate) {this.borrowDate = borrowDate;}

	public String getBackDate() {return backDate;}

	public void setBackDate(String backDate) {this.backDate = backDate;}

	public Integer getRenew() {return renew;}

	public void setRenew(Integer renew) {this.renew = renew;}

	public String getBookName() {return bookName;}

	public void setBookName(String bookName) {	this.bookName = bookName;}

	public String getBookAuthor() {return bookAuthor;}

	public void setBookAuthor(String bookAuthor) {this.bookAuthor = bookAuthor;}

	public Double getBookPrice() {return bookPrice;}

	public void setBookPrice(Double bookPrice) {this.bookPrice = bookPrice;}

	public String getBookType() {return bookType;}

	public void setBookType(String bookType) {this.bookType = bookType;}

	public String getBookLocation() {return bookLocation;}

	public void setBookLocation(String bookLocation) {this.bookLocation = bookLocation;}
	
	
	
}
