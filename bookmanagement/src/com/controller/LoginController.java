package com.controller;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.bean.User;
import com.config.BeanFactory;
import com.config.DatabaseConnection;
import com.dao.impl.BorrowReturnLogDaoImpl;
import com.service.IStudentService;
import com.service.IUserService;

public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private IUserService userService = (IUserService) BeanFactory.getBean("userService");
	private IStudentService studentService = (IStudentService) BeanFactory.getBean("studentService");


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);
		
		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("login")) {
			
			String identity = request.getParameter("identity");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			try {
				
				if(identity.equals("admin")) {
					
					String sql = "select * from administrator where username = ?";

					PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
					ps.setString(1,username);
					ResultSet r=ps.executeQuery();

					
					if(r.next()) {
		
						String value = r.getString(3);
						
						if(value.equals(password)) {
							
							response.sendRedirect("/bookmanagement/adminpage/welcome.jsp");
							
						} else {
					
							request.setAttribute("message","用户名或密码错误!");
							request.getRequestDispatcher("/index.jsp").forward(request, response);
							
						}
						
					} else {
						
						request.setAttribute("message","用户不存在 请先注册!");
						request.getRequestDispatcher("/index.jsp").forward(request, response);
						
					}
					
					DatabaseConnection.release(ps, r);
					
				} else {
				
					User user = userService.findUserByUsername(username);
				
					if(user != null) {
				
						if(user.getPassword().equals(password)) {

							int state = (new BorrowReturnLogDaoImpl()).findUserState(user.getStudentNo());
							
							Student student = studentService.findStudentByNo(user.getStudentNo()); 
							
							request.getSession().setAttribute("studentName",student.getName());
							request.getSession().setAttribute("studentMajor",student.getMajor());
							request.getSession().setAttribute("studentNo",user.getStudentNo());
							request.getSession().setAttribute("username",user.getUsername());
							request.getSession().setAttribute("studentState",state);
							
							response.sendRedirect("/bookmanagement/studentpage/welcome.jsp");
			
						} else {
							
							request.setAttribute("message","用户名或密码错误!");
							request.getRequestDispatcher("/index.jsp").forward(request, response);

						}
					} else {
		
						request.setAttribute("message","请先注册!");
						request.getRequestDispatcher("/index.jsp").forward(request, response);
						
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("loginout")) {
			
			request.getSession().invalidate();
			response.sendRedirect("/bookmanagement/index.jsp");
			
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);
		
		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("register")) {
			
			try {
				
				Integer studentNo = Integer.parseInt(request.getParameter("studentNo"));
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String passwordAgain = request.getParameter("passwordAgain");
				
				User user = userService.findUserByNo(studentNo);
				
				if(user!=null) {
					
					request.setAttribute("message","您已注册过 请直接登录!");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					
				} else {
					
					Student student = studentService.findStudentByNo(studentNo);
					
					if(student!=null) {
		
						if(password.equals(passwordAgain)) {

							userService.insertUser(new User(studentNo,username,password));
							(new BorrowReturnLogDaoImpl()).initialUserState(studentNo);		
							
							request.setAttribute("message","注册成功 请登录!");
							request.getRequestDispatcher("/index.jsp").forward(request, response);
							
						} else {

							request.setAttribute("message","两次密码输入不一致 请重新输入!");
							request.getRequestDispatcher("/register.jsp").forward(request, response);
						}
						
					} else {

						request.setAttribute("message","您不是我校学生 不能注册!");
						request.getRequestDispatcher("/register.jsp").forward(request, response);
						
					}
					
				}
				
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			
		} else if (methodName.equals("updatePassword")) {
			
			try {
				
				request.getRequestDispatcher("/user/updateUser").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}


	}

}
