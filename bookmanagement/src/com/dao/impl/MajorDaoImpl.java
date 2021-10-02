package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.Major;
import com.config.DatabaseConnection;
import com.dao.IMajorDao;

public class MajorDaoImpl implements IMajorDao {


	public List<Major> findAllMajor() throws Exception {
		
		String sql = "select * from major";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet r=ps.executeQuery();
		
		List<Major> majors = new ArrayList<>();
		
		while(r.next()) {
			
			String no = r.getString(2);
			String name = r.getString(3);
			String department = r.getString(4);
			
			Major major = new Major(no,name,department);
			
			majors.add(major);
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		
		return majors;

	}

	
	public Major findMajorByNo(String no) throws Exception {


		String sql = "select * from major where Mno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,no);
		ResultSet r=ps.executeQuery();
		
		if(r.next()) {
			
			String majorNo = r.getString(2);
			String name = r.getString(3);
			String department = r.getString(4);

			
			Major major = new Major(majorNo,name,department);
			
			DatabaseConnection.releaseAll(connection,ps, r);
			
			return major;
			
		}
		
		return null;

	}


	public void insertMajor(Major major) throws Exception {

		String sql = "insert into major(Mno,Mname,Mdept) values(?,?,?)";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,major.getNo());
		ps.setString(2,major.getName());
		ps.setString(3,major.getDepartment());

		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void updateMajor(String originalMajorNo,Major major) throws Exception {
		
		String sql = "update major set Mno = ?,Mname = ?,Mdept = ? where Mno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,major.getNo());
		ps.setString(2,major.getName());
		ps.setString(3,major.getDepartment());
		ps.setString(4,originalMajorNo);

		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
	
	}

	public void deleteMajorByNo(String no) throws Exception {

		String sql = "delete from major where Mno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}

}
