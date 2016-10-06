package com.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Department {

	String Departname;
	String staffName;
	int employeeID;
	public String getDepartname() {
		return Departname;
	}
	public void setDepartname(String departname) {
		Departname = departname;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
	

	//getter and setter methods

}