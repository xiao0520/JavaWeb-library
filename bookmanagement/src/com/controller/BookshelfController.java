package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Bookshelf;
import com.config.BeanFactory;
import com.service.IBookshelfService;



public class BookshelfController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IBookshelfService bookshelfService = (IBookshelfService) BeanFactory.getBean("bookshelfService");

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findAllBookshelf")) {
			
			try {

				List<Bookshelf> bookshelfs = bookshelfService.findAllBookshelf();
				
				request.setAttribute("allBookshelf",bookshelfs);
				
				request.getRequestDispatcher("/adminpage/bookshelf/list.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteBookshelfByNo")) {
		
			
			try {
				
				String no = request.getParameter("bookshelfNo");
				bookshelfService.deleteBookshelfByNo(no);
				response.sendRedirect("/bookmanagement/bookshelf/findAllBookshelf");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditBookshelfPage")) {

			try {
				
				String originalBookshelfNo = request.getParameter("originalBookshelfNo");
				
				Bookshelf bookshelf = bookshelfService.findBookshelfByNo(originalBookshelfNo);
				
				request.setAttribute("bookshelf",bookshelf);
				request.setAttribute("originalBookshelfNo",originalBookshelfNo);
				
				request.getRequestDispatcher("/adminpage/bookshelf/edit.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toAddBookshelfPage")) {
			
			try {

				request.getRequestDispatcher("/adminpage/bookshelf/add.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findBookshelfByNo")) {
			
			try {
				
				String no = request.getParameter("no");
				
				Bookshelf bookshelf = bookshelfService.findBookshelfByNo(no);
				System.out.println(bookshelf);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("insertBookshelf")) {

			
			try {
				
				String no = request.getParameter("no");
				String area = request.getParameter("area");
				String location = request.getParameter("location");
				String type = request.getParameter("type");
				String remark = request.getParameter("remark");
				
				bookshelfService.insertBookshelf(new Bookshelf(no, area, location, type, remark));
				
				response.sendRedirect("/bookmanagement/bookshelf/findAllBookshelf");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateBookshelf")) {
			
			try {
				
				String originalBookshelfNo = request.getParameter("originalBookshelfNo");
				
				String no = request.getParameter("no");
				String area = request.getParameter("area");
				String location = request.getParameter("location");
				String type = request.getParameter("type");
				String remark = request.getParameter("remark");
				
				bookshelfService.updateBookshelf(originalBookshelfNo,new Bookshelf(no, area, location, type, remark));
				
				response.sendRedirect("/bookmanagement/bookshelf/findAllBookshelf");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		
		} else if(methodName.equals("insertBookshelf")) {
			
			try {
				
				String no = request.getParameter("no");
				String area = request.getParameter("area");
				String location = request.getParameter("location");
				String type = request.getParameter("type");
				String remark = request.getParameter("remark");
				
				bookshelfService.insertBookshelf(new Bookshelf(no, area, location, type, remark));
					
				response.sendRedirect("/bookmanagement/bookshelf/findAllBookshelf");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		
		}
	}

}
