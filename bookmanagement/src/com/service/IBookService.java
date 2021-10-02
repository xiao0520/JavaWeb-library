package com.service;

import java.util.List;

import com.bean.Book;

public interface IBookService {
	
	public List<Book> findAllBook(Integer startIndex,Integer length) throws Exception;
	
	public List<Book> findCanReserveBook() throws Exception;
	
	public Book findBookByNo(String no) throws Exception;
	
	public void insertBook(Book book) throws Exception;
	
	public void updateBook(String no,Book book) throws Exception;
	
	public void deleteBookByNo(String no) throws Exception;

}
