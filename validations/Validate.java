package com.employee.validations;

import java.util.Date;

import com.employee.customExceptions.EmployeeException;
import com.employee.dto.Employee;

public class Validate {

	public boolean validateEmpId(int empId, Employee[] empdata) throws EmployeeException {
//		System.out.println("In validate Empid :"+ empId + empdata);
		for (Employee e : empdata) {
			if (e != null)
				if (e.getEmpId() == empId)
					throw new EmployeeException("Incorrect Employee Id.");
		}
		return true;
	}

	public boolean validateEmail(String mail) throws EmployeeException {
		if (mail.endsWith("cdac.in") && mail.contains("@")) {
			return true;
		} else {
			throw new EmployeeException("Incorrect Email Address.");
		}
	}

	public boolean validateDeptId(String deptId) throws EmployeeException {
		if (deptId.startsWith("DEV") || deptId.startsWith("FIN") || deptId.startsWith("SALES")) {
			return true;
		} else {
			throw new EmployeeException("Incorrect Department Id.");
		}
	}

	@SuppressWarnings("deprecation")
	public boolean validateJoiningDate(Date date) throws EmployeeException {
//		Date currentDate = new Date();
//		Date minimumJoiningDate = new Date(120, 0, 1);
//
//		if (date.before(currentDate) && date.after(minimumJoiningDate)) {
//			return true;
//		} else {
//			throw new EmployeeException("Incorrect Joining Date.");
//		}
		return true;
	}

}
