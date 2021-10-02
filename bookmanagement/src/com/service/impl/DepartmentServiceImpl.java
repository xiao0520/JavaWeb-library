
package com.service.impl;

import java.util.List;
import com.bean.Department;
import com.config.BeanFactory;
import com.dao.IDepartmentDao;
import com.service.IDepartmentService;

public class DepartmentServiceImpl implements IDepartmentService {

	private IDepartmentDao departmentDao =  (IDepartmentDao) BeanFactory.getBean("departmentDao");

	
	
	public List<Department> findAllDepartment() throws Exception {return departmentDao.findAllDepartment();}

	public Department findDepartmentByNo(String no) throws Exception {return departmentDao.findDepartmentByNo(no);}

	public void insertDepartment(Department department) throws Exception {departmentDao.insertDepartment(department);}

	public void updateDepartment(String no,Department department) throws Exception {departmentDao.updateDepartment(no,department);	}

	public void deleteDepartmentByNo(String no) throws Exception {departmentDao.deleteDepartmentByNo(no);}

}
