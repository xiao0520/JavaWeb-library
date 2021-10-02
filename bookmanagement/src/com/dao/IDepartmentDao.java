package com.dao;

import java.util.List;

import com.bean.Department;

public interface IDepartmentDao {
	
	public List<Department> findAllDepartment() throws Exception;
	
	public Department findDepartmentByNo(String no) throws Exception;
	
	public void insertDepartment(Department department) throws Exception;
	
	public void updateDepartment(String no,Department department) throws Exception;
	
	public void deleteDepartmentByNo(String no) throws Exception;

}
