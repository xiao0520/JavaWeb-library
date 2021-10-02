package com.service.impl;

import java.util.List;

import com.bean.Bookshelf;
import com.config.BeanFactory;
import com.dao.IBookshelfDao;
import com.service.IBookshelfService;

public class BookshelfServiceImpl implements IBookshelfService {

	private IBookshelfDao bookshelfDao =  (IBookshelfDao) BeanFactory.getBean("bookshelfDao");

	
	
	public List<Bookshelf> findAllBookshelf() throws Exception {return bookshelfDao.findAllBookshelf();}

	public Bookshelf findBookshelfByNo(String no) throws Exception{ return bookshelfDao.findBookshelfByNo(no);}

	public void insertBookshelf(Bookshelf bookshelf) throws Exception {	bookshelfDao.insertBookshelf(bookshelf);}

	public void updateBookshelf(String no,Bookshelf bookshelf) throws Exception {bookshelfDao.updateBookshelf(no,bookshelf);}

	public void deleteBookshelfByNo(String no) throws Exception {	bookshelfDao.deleteBookshelfByNo(no);}

}
