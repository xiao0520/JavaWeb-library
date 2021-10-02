package com.dao;

import java.util.List;

import com.bean.Bookshelf;

public interface IBookshelfDao {
	
	public List<Bookshelf> findAllBookshelf() throws Exception;
	
	public Bookshelf findBookshelfByNo(String no) throws Exception;
	
	public void insertBookshelf(Bookshelf bookshelf) throws Exception;
	
	public void updateBookshelf(String no,Bookshelf bookshelf) throws Exception;
	
	public void deleteBookshelfByNo(String no) throws Exception;

}
