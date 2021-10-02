package com.service.impl;

import java.util.List;

import com.bean.Student;
import com.config.BeanFactory;
import com.dao.IStudentDao;
import com.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao =  (IStudentDao) BeanFactory.getBean("studentDao");


	public List<Student> findAllStudent() throws Exception {return studentDao.findAllStudent();}

	public Student findStudentByNo(Integer no) throws Exception {return studentDao.findStudentByNo(no);}

	public void insertStudent(Student student) throws Exception {studentDao.insertStudent(student);}

	public void updateStudent(Integer no,Student student) throws Exception {studentDao.updateStudent(no,student);	}

	public void deleteStudentByNo(Integer no) throws Exception {studentDao.deleteStudentByNo(no);	}
}
