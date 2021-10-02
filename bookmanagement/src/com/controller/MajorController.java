package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Department;
import com.bean.Major;
import com.config.BeanFactory;
import com.service.IDepartmentService;
import com.service.IMajorService;



public class MajorController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IMajorService majorService = (IMajorService) BeanFactory.getBean("majorService");
	private IDepartmentService departmentService = (IDepartmentService) BeanFactory.getBean("departmentService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findAllMajor")) {
			
			try {

				List<Major> majors = majorService.findAllMajor();
				
				request.setAttribute("allMajor",majors);
				
				request.getRequestDispatcher("/adminpage/major/list.jsp").forward(request, response);				
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteMajorByNo")) {

			try {
				

				String no = request.getParameter("majorNo");
				majorService.deleteMajorByNo(no);
				response.sendRedirect("/bookmanagement/major/findAllMajor");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditMajorPage")) {
			
			try {
				
				String originalMajorNo = request.getParameter("originalMajorNo");
				Major major =  majorService.findMajorByNo(originalMajorNo);
				
				List<Department> allDepartment = departmentService.findAllDepartment();
				
				request.setAttribute("major",major);
				request.setAttribute("originalMajorNo",originalMajorNo);
				request.setAttribute("allDepartment",allDepartment);
				
				request.getRequestDispatcher("/adminpage/major/edit.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}  else if(methodName.equals("toAddMajorPage")) {
			
			try {
				
				List<Department> allDepartment = departmentService.findAllDepartment();

				request.setAttribute("allDepartment",allDepartment);
				
				request.getRequestDispatcher("/adminpage/major/add.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("insertMajor")) {

			try {
				
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String department = request.getParameter("department");
			
				
				majorService.insertMajor(new Major(no,name,department));
				
				response.sendRedirect("/bookmanagement/major/findAllMajor");
				
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		} 

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findMajorByNo")) {
			
			String no = request.getParameter("no");
			
			try {
				
				Major major = majorService.findMajorByNo(no);
				System.out.println(major);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateMajor")) {

			try {
				
				String originalMajorNo = request.getParameter("originalMajorNo");
				
				
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String department = request.getParameter("department");
				
				majorService.updateMajor(originalMajorNo,new Major(no,name,department));
				
				response.sendRedirect("/bookmanagement/major/findAllMajor");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
