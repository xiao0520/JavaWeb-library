package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.Department;
import com.config.DatabaseConnection;
import com.dao.IDepartmentDao;

public class DepartmentDaoImpl implements IDepartmentDao {
	

	public List<Department> findAllDepartment() throws Exception {

		String sql = "select * from department";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet r=ps.executeQuery();
		
		List<Department> departments = new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(2);
			String name = r.getString(3);
	
			Department department = new Department(no,name);
			
			departments.add(department);
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		return departments;

	}


	public Department findDepartmentByNo(String no) throws Exception {
		
		String sql = "select * from department where Dno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,no);
		ResultSet r=ps.executeQuery();
		
		if(r.next()) {
			
			String departmentNo = r.getString(2);
			String name = r.getString(3);

			Department department = new Department(departmentNo,name);
			
			DatabaseConnection.releaseAll(connection,ps, r);
			
			return department;
			
		}
		
		return null;

	}


	public void insertDepartment(Department department) throws Exception {

		String sql = "insert into department(Dno,Dname) values(?,?)";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,department.getNo());
		ps.setString(2,department.getName());

		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void updateDepartment(String no,Department department) throws Exception {
	
		String sql = "update department set Dno = ?,Dname = ? where Dno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,department.getNo());
		ps.setString(2,department.getName());
		ps.setString(3,no);

		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void deleteDepartmentByNo(String no) throws Exception {

		String sql = "delete from department where Dno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}

}
