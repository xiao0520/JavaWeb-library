package com.bean;

import java.io.Serializable;

public class Message implements Serializable {
	
	private String sender;
	private String receiver;
	private String message;
	private String time;
	
	private String senderName;
	private String senderMajor;
	private String senderDepartment;
	
	
	
	public Message(String sender, String receiver, String message, String time) {

		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.time = time;
	}
	
	

	public Message(String sender, String receiver, String message, String time, String senderName, String senderMajor,String senderDepartment) {
		
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.time = time;
		this.senderName = senderName;
		this.senderMajor = senderMajor;
		this.senderDepartment = senderDepartment;
	}


	


	public String getSender() {return sender;}
	
	public void setSender(String sender) {this.sender = sender;}
	
	public String getReceiver() {return receiver;}
	
	public void setReceiver(String receiver) {this.receiver = receiver;}
	
	public String getMessage() {return message;}
	
	public void setMessage(String message) {this.message = message;}
	
	public String getTime() {return time;}
	
	public void setTime(String time) {this.time = time;}
	
	public String getSenderName() {return senderName;}

	public void setSenderName(String senderName) {this.senderName = senderName;}

	public String getSenderMajor() {return senderMajor;}

	public void setSenderMajor(String senderMajor) {this.senderMajor = senderMajor;}

	public String getSenderDepartment() {return senderDepartment;}

	public void setSenderDepartment(String senderDepartment) {this.senderDepartment = senderDepartment;}

	
	
}
