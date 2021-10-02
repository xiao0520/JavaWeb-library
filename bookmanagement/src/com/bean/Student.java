package com.bean;

import java.io.Serializable;

public class Student implements Serializable {
	
    private Integer id;
    private Integer no;
    private String name;
    private Integer age;
    private String sex;
    private String telephone;
    private String major;
    
    

    public Student(Integer no, String name, Integer age, String sex, String telephone, String major) {

		this.no = no;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.telephone = telephone;
		this.major = major;
	}

	public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getNo() { return no; }

    public void setNo(Integer no) { this.no = no; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    public String getTelephone() { return telephone; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getMajor() { return major; }

    public void setMajor(String major) { this.major = major; }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
