package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.User;
import com.config.BeanFactory;
import com.service.IUserService;


public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IUserService userService = (IUserService) BeanFactory.getBean("userService");
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findAllUser")) {
			
			try {

				List<User> users = userService.findAllUser();
				
				for(User user:users) System.out.println(user);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteUserByNo")) {

			try {
				
				Integer no = Integer.parseInt(request.getParameter("no"));
				userService.deleteUserByNo(no);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findUserByNo")) {
			
			try {
				
				Integer no = Integer.parseInt(request.getParameter("no"));
				User user= userService.findUserByNo(no);
				System.out.println(user);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("insertUser")) {
			
			Integer no = Integer.parseInt(request.getParameter("no"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			try {
				
				userService.insertUser(new User(no,username,password));
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateUser")) {

			try {
				
				String studentNo = String.valueOf(request.getSession().getAttribute("studentNo"));
				Integer no = Integer.valueOf(studentNo);
				
				String username = (String) request.getSession().getAttribute("username");
				String password = request.getParameter("password");
				
				userService.updateUser(new User(no,username,password));
				
				request.setAttribute("success","success");
				
				request.getRequestDispatcher("/studentpage/editpassword.jsp").forward(request, response);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
