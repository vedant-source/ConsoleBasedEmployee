package com.employee.organization;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.employee.customExceptions.EmployeeException;
import com.employee.dto.Employee;
import com.employee.validations.*;
import com.employee.utils.*;

public class Organization {

	public static Employee[] emps;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("------ Employee Portal------");
			System.out.println("Logged In...");

			System.out.println("Enter how many vacancies are there ?");
			emps = new Employee[sc.nextInt()];

			int counter = 0;
			boolean flag = true;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Validate validate = new Validate();

			while (flag) {
				System.out.println("1.Hire Employee.");
				System.out.println("2.Display Emplyees Details Of This Recruitment.");
				System.out.println("3.Link Aadhar.");
				System.out.println("4.EXIT.");

				switch (sc.nextInt()) {

				case 1:
					try {
						System.out.println(
								"Enter EmpId, FirstName, LastName, Email, DeptId, JoiningDate(dd/MM/yyyy), salary");
						if (counter < emps.length) {
							Employee e = new Employee(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
									sdf.parse(sc.next()), sc.nextDouble());

							if (emps.length > 0) {
								validate.validateEmpId(e.getEmpId(), emps);
								validate.validateEmail(e.getEmail());
								validate.validateDeptId(e.getDeptId());
								validate.validateJoiningDate(e.getJoinDate());
							}
							emps[counter] = e;

							counter++;
						} else {
							throw new EmployeeException("Seats are not vacant at this moment....");
						}
						System.out.println("Employee Hired");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 2:
					try {
						if (emps == null) {
							throw new EmployeeException("No Record Available To Display");
						}
						System.out.println("Emplyees Details Of This Recruitment.");
						for (Employee e : emps) {
							if (e != null) {
								System.out.println(e);
							}
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:
					System.out.println("Enter your EmpId : ");
					int empId = sc.nextInt();

					try {
						Employee e = MyUtils.getEmpById(empId);

						if (e != null) {
							System.out.println("Enter Aadhar Number");
							String aadharNumber = sc.next();
							System.out.println("Enter Creation date");
							Date creationDate = sdf.parse(sc.next());
							System.out.println("Enter Location");
							String location = sc.next();

							e.linkAadharcard(aadharNumber, creationDate, location);
							System.out.println("Aadhar Linked Successfully");
						}

					} catch (EmployeeException e) {					
						e.printStackTrace();
					}
					break;

				case 4:
					flag = false;
					System.out.println("Logged Out...");
					break;

				default:
					System.out.println("You have entered wrong choice...");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
