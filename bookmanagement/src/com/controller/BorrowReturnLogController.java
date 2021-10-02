package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.BorrowReturnLog;
import com.bean.Message;
import com.bean.User;
import com.config.BeanFactory;
import com.dao.IBorrowReturnLogDao;
import com.dao.impl.BorrowReturnLogDaoImpl;
import com.service.IUserService;


public class BorrowReturnLogController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	private IUserService userService = (IUserService) BeanFactory.getBean("userService");
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("borrowBookByNo")) {
			
			try {
			
				
				int studentNo =  (int) request.getSession().getAttribute("studentNo");

				int studentState = (new BorrowReturnLogDaoImpl()).findUserState(studentNo);
				
				
				if(studentState==1) {
					
					String bookNo = request.getParameter("bookNo");
							
						(new BorrowReturnLogDaoImpl()).borrowBook(studentNo,bookNo);
						
						response.sendRedirect("/bookmanagement/book/findAllBook?admin=false&startIndex=0");
								
					
				} else {
					
					request.getSession().setAttribute("message","您的借书数量已达上限，请先还书");
					request.getRequestDispatcher("/studentpage/booklist.jsp").forward(request, response);
					
				}
				
			 } catch (Exception e) {
				
				e.printStackTrace();
			}

	   } else if(methodName.equals("findFine")) {
			
			
		   		int studentNo =  (int) request.getSession().getAttribute("studentNo");
		   
			   try {
				   
				Double money = (new BorrowReturnLogDaoImpl()).findFine(studentNo);
				
				
				if(money == null || money == 0) {

					request.setAttribute("fineMessage","您当前没有任何待还罚款");
					request.getRequestDispatcher("/studentpage/finemessage.jsp").forward(request, response);
					
				} else {

					request.setAttribute("fineMoney",money);
					request.getRequestDispatcher("/studentpage/finemessage.jsp").forward(request, response);
					
				}
				
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllBorrowBook")) {
		   
		   
		   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
		   
			try {
				   
				List<BorrowReturnLog> allBorrowBook = (new BorrowReturnLogDaoImpl()).findAllBorrowBook(studentNo);
		
				request.getSession().setAttribute("allBorrowBook",allBorrowBook);
				request.getRequestDispatcher("/studentpage/allborrowbook.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("returnBook")) {
		   
			try {
				   
			   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
				String bookNo =  (String) request.getParameter("bookNo");
				
				(new BorrowReturnLogDaoImpl()).returnBook(studentNo, bookNo);
				
			
				response.sendRedirect("/bookmanagement/log/findAllBorrowBook");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("payForFine")) {
		   
			try {
				  
			   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
			   	
				(new BorrowReturnLogDaoImpl()).payForFine(studentNo);
				
				request.getSession().removeAttribute("fineMoney");
				response.sendRedirect("/bookmanagement/log/findFine");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("renewBook")) {
		   
			try {
				  
			   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
				String bookNo =  (String) request.getParameter("bookNo");
				
				(new BorrowReturnLogDaoImpl()).renewBook(studentNo, bookNo);

				response.sendRedirect("/bookmanagement/log/findAllBorrowBook");
	
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllReserveBook")) {
		   
			try {
				  
			   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
				
				List<BorrowReturnLog> allReserveBook = (new BorrowReturnLogDaoImpl()).findAllReserveBook(studentNo);
				request.getSession().setAttribute("allReserveBook",allReserveBook);

				request.getRequestDispatcher("/studentpage/allreservebook.jsp").forward(request, response);
	
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("reserveBookByNo")) {
		   
			try {
				  
			   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
			   	
				String bookNo =  (String) request.getParameter("bookNo");
				
				(new BorrowReturnLogDaoImpl()).reserveBookByNo(studentNo, bookNo);

				response.sendRedirect("/bookmanagement/book/findCanReserveBook");
	
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("cancelReserveBook")) {
		   
			try {
				  
			   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
			   	
				String bookNo =  (String) request.getParameter("bookNo");
				
				(new BorrowReturnLogDaoImpl()).cancelReserveBook(studentNo, bookNo);
	
				response.sendRedirect("/bookmanagement/log/findAllReserveBook");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("findAllMessage")) {
		   
			try {
				  
			   	int studentNo =  (int) request.getSession().getAttribute("studentNo");
			   	
				
				List<Message> allMessage = (new BorrowReturnLogDaoImpl()).findMessageByNo(studentNo);
				
				request.setAttribute("allMessage",allMessage);
	
				request.getRequestDispatcher("/studentpage/allmessage.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toOneConcreteMessage")) {
		   
			try {
				  
			   	String sender =  request.getParameter("sender");
			   	String time =  request.getParameter("time");
			   	String message =  request.getParameter("message");
			   	
				request.setAttribute("sender",sender);
				request.setAttribute("time",time);
				request.setAttribute("message",message);
	
				request.getRequestDispatcher("/studentpage/onemessage.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toSendLetterPage")) {
		   
			try {

				request.getRequestDispatcher("/studentpage/sendletter.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toSystemFeedbackPage")) {
		   
			try {
				 
				request.getRequestDispatcher("/studentpage/systemfeedback.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("deleteOneConcreteMessage")) {
		   
			try {
				
				String sender = (String) request.getParameter("sender");
				String receiverNo = String.valueOf(request.getSession().getAttribute("studentNo"));
				String message = (String) request.getParameter("message");
				
				(new BorrowReturnLogDaoImpl()).deleteOneConceteMessage(sender, receiverNo, message);
				
				response.sendRedirect("/bookmanagement/log/findAllMessage");
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("toEditPasswordPage")) {
		   
			try {
				
				request.getRequestDispatcher("/studentpage/editpassword.jsp").forward(request, response);;
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } 
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("insertNotice")) {

			try {
				
			   	String sender = Integer.toString((Integer) request.getSession().getAttribute("studentNo"));
			   	
			   	String receiver = request.getParameter("no");
			   	
			   	String message = request.getParameter("message");
				   
		
				(new BorrowReturnLogDaoImpl()).insertNotice(sender, receiver, message);
				
				request.setAttribute("success","success");
				request.getRequestDispatcher("/studentpage/sendletter.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("insertSystemFeedbackNotice")) {

			try {
				
			   	String sender = Integer.toString((Integer) request.getSession().getAttribute("studentNo"));
			   	
			   	String receiver = "admin";
			   	
			   	String message = request.getParameter("message");
				   

		
				(new BorrowReturnLogDaoImpl()).insertNotice(sender, receiver, message);
				
				request.setAttribute("success","success");
				request.getRequestDispatcher("/studentpage/systemfeedback.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   } else if(methodName.equals("insertSystemNotice")) {

			try {
				
				IBorrowReturnLogDao log = new BorrowReturnLogDaoImpl();
			   	
			   	
			   	String sender = "admin";
			   	
			   	String message = request.getParameter("message");
				   
			   	List<User> allUser = userService.findAllUser();
			   	

			   	
			   	for(User user: allUser) {
			   		
			   		String studentNo = String.valueOf(user.getStudentNo());
			   		log.insertNotice(sender,studentNo,message);
			   	}
			   	
	
				request.setAttribute("success","success");
				request.getRequestDispatcher("/adminpage/givenotice.jsp").forward(request, response);
					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			   
	   }
	}

}
