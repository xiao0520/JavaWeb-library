package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Major;
import com.bean.Student;
import com.config.BeanFactory;
import com.service.IMajorService;
import com.service.IStudentService;


public class StudentController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IStudentService studentService = (IStudentService) BeanFactory.getBean("studentService");
	private IMajorService majorService = (IMajorService) BeanFactory.getBean("majorService");
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findAllStudent")) {
			
			try {

				List<Student> students = studentService.findAllStudent();
				
				request.setAttribute("allStudent",students);
				
				request.getRequestDispatcher("/adminpage/student/list.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteStudentByNo")) {
			
			try {
				
				Integer no = Integer.parseInt(request.getParameter("studentNo"));
				studentService.deleteStudentByNo(no);

				response.sendRedirect("/bookmanagement/student/findAllStudent");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditStudentPage")) {
			
			try {

				Integer originalStudentNo = Integer.valueOf(request.getParameter("originalStudentNo"));
				
				Student student = studentService.findStudentByNo(originalStudentNo);
				
				request.setAttribute("student",student);
				request.setAttribute("originalStudentNo",originalStudentNo);
				
				List<Major> majors = majorService.findAllMajor();
				
				
				request.setAttribute("allMajor",majors);
				
				request.getRequestDispatcher("/adminpage/student/edit.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toAddStudentPage")) {
			
			try {
				
				
				List<Major> majors = majorService.findAllMajor();
				
				request.setAttribute("allMajor",majors);
				
				request.getRequestDispatcher("/adminpage/student/add.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findStudentByNo")) {
			
			Integer no = Integer.parseInt(request.getParameter("no"));
			
			try {
				
				Student student = studentService.findStudentByNo(no);
				System.out.println(student);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("insertStudent")) {
			
			try {
				
				Integer studentNo = Integer.parseInt(request.getParameter("no"));
				String name = request.getParameter("name");
				Integer age = Integer.parseInt(request.getParameter("age"));
				String sex = request.getParameter("sex");
				String tel = request.getParameter("tel");
				String major = request.getParameter("major");	
				

				Student student = new Student(studentNo, name, age, sex, tel, major);
				
				studentService.insertStudent(student);
				
				response.sendRedirect("/bookmanagement/student/findAllStudent");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateStudent")) {
			
			try {
				
				Integer originalStudentNo = Integer.parseInt(request.getParameter("originalStudentNo"));
				
				Integer studentNo = Integer.parseInt(request.getParameter("no"));
				String name = request.getParameter("name");
				Integer age = Integer.parseInt(request.getParameter("age"));
				String sex = request.getParameter("sex");
				String tel = request.getParameter("tel");
				String major = request.getParameter("major");	
				
				Student student = new Student(studentNo, name, age, sex, tel, major);
				
				studentService.updateStudent(originalStudentNo,student);
				
				response.sendRedirect("/bookmanagement/student/findAllStudent");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
