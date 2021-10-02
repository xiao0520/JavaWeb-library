package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Book;
import com.bean.Bookshelf;
import com.config.BeanFactory;
import com.service.IBookService;
import com.service.IBookshelfService;

public class BookController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IBookService bookService = (IBookService) BeanFactory.getBean("bookService");
	private IBookshelfService bookshelfService = (IBookshelfService) BeanFactory.getBean("bookshelfService");


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");

		
		if(methodName.equals("findAllBook")) {
					
			try {

				String adminJudge = request.getParameter("admin");

				Integer startIndex = Integer.parseInt(request.getParameter("startIndex"));

				
				
				List<Book> books = bookService.findAllBook(startIndex,9);
		

		
				request.getSession().setAttribute("allBook",books);
				
				if(adminJudge.equals("true")) {
					
					request.getRequestDispatcher("/adminpage/book/list.jsp").forward(request, response);
					return ;
				}
	
				
				request.getRequestDispatcher("/studentpage/booklist.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("deleteBookByNo")) {
			
			try {
				
				String no = request.getParameter("bookNo");
				bookService.deleteBookByNo(no);
				response.sendRedirect("/bookmanagement/book/findAllBook?admin=true&startIndex=0");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(methodName.equals("findCanReserveBook")) {
			
			try {

				List<Book> books = bookService.findCanReserveBook();
				
				request.getSession().setAttribute("canReserveBook",books);
				
				request.getRequestDispatcher("/studentpage/reservebook.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toEditBookPage")) {
			
			try {

				String originalBookNo = (String) request.getParameter("originalBookNo");
				
				Book book = bookService.findBookByNo(originalBookNo);
				
				List<Bookshelf> allBookshelf = bookshelfService.findAllBookshelf();
				
				request.setAttribute("book",book);
				request.setAttribute("originalBookNo",originalBookNo);
				request.setAttribute("allBookshelf",allBookshelf);
				
				request.getRequestDispatcher("/adminpage/book/edit.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} else if(methodName.equals("toAddBookPage")) {
			
			try {

				List<Bookshelf> allBookshelf = bookshelfService.findAllBookshelf();
				
				request.setAttribute("allBookshelf",allBookshelf);

				request.getRequestDispatcher("/adminpage/book/add.jsp").forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getRequestURI();
		String methodName = url.substring(url.lastIndexOf("/")+1);

		request.setCharacterEncoding("UTF-8");
		
		if(methodName.equals("findBookByNo")) {
			
			try {
				
				String no = request.getParameter("no");
				Book book = bookService.findBookByNo(no);
				System.out.println(book);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(methodName.equals("insertBook")) {
		
			try {
				System.out.print(request.getParameter("money"));
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String author = request.getParameter("author");
				Double price = Double.parseDouble(request.getParameter("price"));
				Integer num = Integer.parseInt(request.getParameter("num"));
				String shelf = request.getParameter("shelf");
				String remark = request.getParameter("remark");
				
				bookService.insertBook(new Book(no,name,author,price,num,shelf,remark));
				
				response.sendRedirect("/bookmanagement/book/findAllBook?admin=true&startIndex=0");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		} else if(methodName.equals("updateBook")) {
				
			try {
				
				String originalBookNo = request.getParameter("originalBookNo");
				
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String author = request.getParameter("author");
				double price = Double.parseDouble(request.getParameter("price"));
				int num = Integer.parseInt(request.getParameter("num"));
				String shelf = request.getParameter("shelf");
				String remark = request.getParameter("remark");
				
				bookService.updateBook(originalBookNo,new Book(no,name,author,price,num,shelf,remark));
				
				response.sendRedirect("/bookmanagement/book/findAllBook?admin=true&startIndex=0");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
