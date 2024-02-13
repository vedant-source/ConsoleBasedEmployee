package com.employee.dto;

import java.util.Date;

public class Aadhar {
	private String aadharNumber;
	private Date creationDate;
	private String location;
	
	public Aadhar(String aadharNumber, Date creationDate, String location) {
		super();
		this.aadharNumber = aadharNumber;
		this.creationDate = creationDate;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Aadhar [aadharNumber=" + aadharNumber + ", creationDate=" + creationDate + ", location=" + location
				+ "]";
	}

}
