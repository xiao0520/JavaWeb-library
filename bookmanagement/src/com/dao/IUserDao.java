package com.dao;

import java.util.List;
import com.bean.User;

public interface IUserDao {
	
	public List<User> findAllUser() throws Exception;
	
	public User findUserByNo(Integer no) throws Exception;
	
	public User findUserByUsername(String username) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public void deleteUserByNo(Integer no) throws Exception;

}
