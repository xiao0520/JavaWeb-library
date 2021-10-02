package com.bean;

import java.io.Serializable;

public class User implements Serializable
{
    private Integer id;
    private Integer studentNo;
    private String username;
    private String password;
    
    

    public User(Integer studentNo, String username, String password) {
		this.studentNo = studentNo;
		this.username = username;
		this.password = password;
	}

	public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getStudentNo() { return studentNo; }

    public void setStudentNo(Integer studentNo) { this.studentNo = studentNo; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "studentNo=" + studentNo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
