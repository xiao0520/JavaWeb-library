package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Department;
import com.config.BeanFactory;
import com.service.IDepartmentService;



public class DepartmentController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IDepartmentService departmentService = (IDepartmentService) BeanFactory.getBean("departmentService");
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findAllDepartment")) {
			
			try {

				List<Department> departments = departmentService.findAllDepartment();
				
				request.setAttribute("allDepartment",departments);
				
				request.getRequestDispatcher("/adminpage/department/list.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteDepartmentByNo")) {
			
			try {
				
				String no = request.getParameter("departmentNo");
				departmentService.deleteDepartmentByNo(no);
				response.sendRedirect("/bookmanagement/department/findAllDepartment");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditDepartmentPage")) {

			try {
				
				String originalDepartmentNo = request.getParameter("originalDepartmentNo");
				Department department = departmentService.findDepartmentByNo(originalDepartmentNo);
				
				
				request.setAttribute("originalDepartmentNo",originalDepartmentNo);
				request.setAttribute("department",department);
				request.getRequestDispatcher("/adminpage/department/edit.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toAddDepartmentPage")) {

			try {

				request.getRequestDispatcher("/adminpage/department/add.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findDepartmentByNo")) {

			try {
				
				String no = request.getParameter("no");
				Department department = departmentService.findDepartmentByNo(no);
				
				System.out.println(department);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(methodName.equals("insertDepartment")) {
			

			try {
				
				String no = request.getParameter("no");
				String name = request.getParameter("name");

				departmentService.insertDepartment(new Department(no, name));
				response.sendRedirect("/bookmanagement/department/findAllDepartment");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateDepartment")) {

			
			try {
				
				String originalDepartmentNo = request.getParameter("originalDepartmentNo");
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				departmentService.updateDepartment(originalDepartmentNo,new Department(no, name));
				
				response.sendRedirect("/bookmanagement/department/findAllDepartment");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
