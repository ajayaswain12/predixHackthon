package com.example;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeVO {


	private String empName;
	int employeeID;
	private BigDecimal deptId;
	private String lastname;
	
	
	
	public String getEmpName() {
		return empName;
	}
	public BigDecimal getDeptId() {
		return deptId;
	}
	public void setDeptId(BigDecimal deptId) {
		this.deptId = deptId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
	

	//getter and setter methods

}