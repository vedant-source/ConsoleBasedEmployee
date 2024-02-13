package com.employee.utils;

import com.employee.customExceptions.EmployeeException;
import com.employee.dto.Employee;
import com.employee.organization.Organization;

public class MyUtils {
	public static Employee getEmpById(int empId) throws EmployeeException {
		Employee[] employees = Organization.emps;
		for(Employee e : employees) {
			if(e.getEmpId() == empId) {
				return e;
			}
		}
		throw new EmployeeException("Wrong EmpId...");		
	}
}
