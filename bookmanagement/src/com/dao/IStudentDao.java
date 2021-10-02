package com.dao;

import java.util.List;

import com.bean.Student;

public interface IStudentDao {
	
	public List<Student> findAllStudent() throws Exception;
	
	public Student findStudentByNo(Integer no) throws Exception;
	
	public void insertStudent(Student student) throws Exception;
	
	public void updateStudent(Integer no,Student student) throws Exception;
	
	public void deleteStudentByNo(Integer no) throws Exception;

}
