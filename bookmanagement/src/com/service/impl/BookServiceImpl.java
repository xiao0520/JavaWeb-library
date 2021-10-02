package com.service.impl;

import java.util.List;
import com.bean.Book;
import com.config.BeanFactory;
import com.dao.IBookDao;
import com.service.IBookService;

public class BookServiceImpl implements IBookService {

	private IBookDao bookDao = (IBookDao) BeanFactory.getBean("bookDao");


	public List<Book> findAllBook(Integer startIndex,Integer length) throws Exception {return bookDao.findAllBook(startIndex,length);}
	
	public List<Book> findCanReserveBook() throws Exception {return bookDao.findCanReserveBook();}

	public Book findBookByNo(String no) throws Exception {return bookDao.findBookByNo(no);}

	public void insertBook(Book book) throws Exception {bookDao.insertBook(book);}

	public void updateBook(String no,Book book) throws Exception {bookDao.updateBook(no,book);}

	public void deleteBookByNo(String no) throws Exception {bookDao.deleteBookByNo(no);}

}
