package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.BorrowReturnLog;
import com.bean.Message;
import com.dao.impl.AdminOperationDaoImpl;
import com.dao.impl.BorrowReturnLogDaoImpl;


public class AdminOperationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findStudentBorrowBookByNo")) {
			   
			try {
				   
				Integer studentNo =  Integer.parseInt(request.getParameter("studentNo"));
				
				List<BorrowReturnLog> allBorrowBook = (new AdminOperationDaoImpl()).findStudentBorrowBookByNo(studentNo);
				
				
				request.setAttribute("allBorrowBook",allBorrowBook);
		

				request.getRequestDispatcher("/adminpage/onestudentborrow.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllStudentFineInfo")) {
		   
		try {
			   

			List<BorrowReturnLog> allFineInfo = (new AdminOperationDaoImpl()).findAllStudentFineInfo();

			request.setAttribute("allFineInfo",allFineInfo);
			
			request.getRequestDispatcher("/adminpage/allstudentfineinfo.jsp").forward(request, response);
				
		} catch (Exception e) {

			e.printStackTrace();
		}
		   
	  } else if(methodName.equals("toUserFeedbackPage")) {
		   
			try {
				  
				List<Message> allMessage = (new BorrowReturnLogDaoImpl()).findAllUserFeedback();

				request.setAttribute("allMessage",allMessage);
				request.getRequestDispatcher("/adminpage/alluserfeedback.jsp").forward(request,response);

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toOneConcreteFeedbackPage")) {
		   
			try {
				  
			   	String senderName =  request.getParameter("senderName");
			   	String time =  request.getParameter("time");
			   	String message =  request.getParameter("message");
			   	
				request.setAttribute("senderName",senderName);
				request.setAttribute("time",time);
				request.setAttribute("message",message);
	
				request.getRequestDispatcher("/adminpage/onefeedback.jsp").forward(request, response);

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("urgeOneUserPayback")) {
		   
			try {
				  
			   	String studentNo =  request.getParameter("studentNo");
			   	
				(new BorrowReturnLogDaoImpl()).insertNotice("admin",studentNo,"好兄弟该还钱啦 !");
	
				response.sendRedirect("/bookmanagement/admin/findAllStudentFineInfo");

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("deleteOneFeedback")) {
		   
			try {
				  
			   	String senderNo =  request.getParameter("senderNo");
			   	
			   	String message = request.getParameter("message");
			   	
				(new BorrowReturnLogDaoImpl()).deleteOneConceteMessage(senderNo, "admin", message);
	
				response.sendRedirect("/bookmanagement/admin/toUserFeedbackPage");

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   }
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
