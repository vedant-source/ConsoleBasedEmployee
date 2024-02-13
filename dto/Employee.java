package com.employee.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

//emp id, first name , last name , email ,deptId , join date , salary
public class Employee {
	private int empId;
	private String fname;
	private String lname;
	private String email;
	private String deptId;
	private Date joinDate;
	private double salary;
	private Aadhar aadhar;
	private String msg;
	public static SimpleDateFormat sdf;

	static {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	public Employee() {

	}

	public Employee(int empId, String fname, String lname, String email, String deptId, Date joinDate, double salary) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.deptId = deptId;
		this.joinDate = joinDate;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		msg = aadhar == null ? "Aadhar card is NOT Linked" : "Aadhar card is Linked";
		return "Employee [empId=" + empId + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", deptId="
				+ deptId + ", joinDate=" + sdf.format(joinDate) + ", salary=" + salary + ", Aadhar" + msg + "]";
	}

	public String linkAadharcard(String aadharNumber, Date creationDate, String location) {
		this.aadhar = new Aadhar(aadharNumber, creationDate, location);
		return "Adhar Linked Successfully to emplyee portal empId: " + empId;
	}

}
