package com.service.impl;

import java.util.List;
import com.bean.User;
import com.config.BeanFactory;
import com.dao.IUserDao;
import com.service.IUserService;

public class UserServiceImpl implements IUserService{

	private IUserDao userDao =  (IUserDao) BeanFactory.getBean("userDao");

	
	public List<User> findAllUser() throws Exception {return userDao.findAllUser();}

	public User findUserByNo(Integer no) throws Exception {return userDao.findUserByNo(no);}
	
	public User findUserByUsername(String username) throws Exception {return userDao.findUserByUsername(username);}

	public void insertUser(User user) throws Exception {userDao.insertUser(user);}

	public void updateUser(User user) throws Exception {userDao.updateUser(user);}
	
	public void deleteUserByNo(Integer no) throws Exception {userDao.deleteUserByNo(no);}

}
