package com.bean;

import java.io.Serializable;

public class Bookshelf implements Serializable {
	
    private Integer id;
    private String no;
    private String area;
    private String location;
    private String type;
    private String remark;
    
    

    public Bookshelf(String no, String area, String location, String type, String remark) {
    	
		this.no = no;
		this.area = area;
		this.location = location;
		this.type = type;
		this.remark = remark;
	}

	public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNo() { return no; }

    public void setNo(String no) { this.no = no; }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "no='" + no + '\'' +
                ", area='" + area + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
