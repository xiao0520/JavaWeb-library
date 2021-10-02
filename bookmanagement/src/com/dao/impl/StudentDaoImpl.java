package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bean.Student;
import com.config.DatabaseConnection;
import com.dao.IStudentDao;


public class StudentDaoImpl implements IStudentDao {

	public List<Student> findAllStudent() throws Exception {

		String sql = "select * from student";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet r=ps.executeQuery();
		
		List<Student> students=new ArrayList<>();
		
		while(r.next()) {
			
			int no = r.getInt(2);
			String name = r.getString(3);
			int age = r.getInt(4);
			String sex = r.getString(5);
			String telephone = r.getString(6);
			String major = r.getString(7);
			
			Student student = new Student(no,name, age, sex, telephone,major);
			
			students.add(student);
			
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		return students;
	}


	public Student findStudentByNo(Integer no) throws Exception {

		String sql = "select * from student where Sno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,no);
		ResultSet r=ps.executeQuery();
		
	
		if(r.next()) {
		
			int studentNo = r.getInt(2);
			String name = r.getString(3);
			int age = r.getInt(4);
			String sex = r.getString(5);
			String telephone = r.getString(6);
			String major = r.getString(7);
			
			Student student = new Student(studentNo,name, age, sex, telephone,major);
			
			return student;
		
		}
		
		DatabaseConnection.releaseAll(connection,ps, r);
		
		return null;
		
	}


	public void insertStudent(Student student) throws Exception {

		String sql = "insert into student(Sno,Sname,Sage,Ssex,Stel,Smajor) values(?,?,?,?,?,?)";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,student.getNo());
		ps.setString(2,student.getName());
		ps.setInt(3,student.getAge());
		ps.setString(4,student.getSex());
		ps.setString(5,student.getTelephone());
		ps.setString(6,student.getMajor());
		
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void updateStudent(Integer no,Student student) throws Exception {

		String sql = "update student set Sno = ?,Sname = ?,Sage = ?,Ssex = ?,Stel = ?,Smajor = ? where Sno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,student.getNo());
		ps.setString(2,student.getName());
		ps.setInt(3,student.getAge());
		ps.setString(4,student.getSex());
		ps.setString(5,student.getTelephone());
		ps.setString(6,student.getMajor());
		ps.setInt(7,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);
		
	}


	public void deleteStudentByNo(Integer no) throws Exception {
		
		String sql = "delete from student where Sno = ?";
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1,no);
		ps.execute();
		
		DatabaseConnection.release(connection,ps);

	}

}
