package com.chainsys.springproject.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chainsys.springproject.dao.EmployeeDao;
import com.chainsys.springproject.commonutil.InvalidInputDataException;
import com.chainsys.springproject.commonutil.Validator;
import com.chainsys.springproject.dao.Employee;
public class EmployeeController {
	
	public   void addNewEmployee() {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Employee newemp = new Employee();
			System.out.println("Enter Employee Id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParseInt(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.checkNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			EmployeeDao dao = new EmployeeDao(); // TODO: Use Spring getBean() here
			Employee emp = dao.getEmployeeById(empId);
			if (emp == null) {
				System.out.println("Employee Doesn't Exist For Id " + empId);
				return;
			}
			newemp.setE_Id(empId);
			
			
			System.out.println("Enter First_Name:");
			String fName = sc.nextLine();
			try {
				Validator.checkCharLessThanTwenty(fName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				Validator.checkStringForParseInt(fName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setFirst_Name(fName);
			
			
			System.out.println("Enter Last_Name :");
			String lName = sc.nextLine();
			try {
				Validator.checkCharLessThanTwenty(lName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				Validator.checkStringForParseInt(lName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setLast_Name(lName);
			
			
			System.out.println("Enter Email :");
			String eMail = sc.nextLine();
			try {
				Validator.checkMailContainsAtsymbol(eMail);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setEmail(eMail);
			
			
			System.out.println("Enter Date :");
			 String dateFormat = "dd/MM/yyyy";
			  
			    try {
					newemp.setHire_Date(new SimpleDateFormat(dateFormat));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			newemp.setHire_Date(dateFormat);
			
			
			System.out.println("Enter Job_id :");
			String jobId = sc.nextLine();
			try {
				Validator.checkCharLessThanTwenty(jobId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setJob_ID(jobId);
			
			
			System.out.println("Enter Salary :");
			float salary = sc.nextFloat();
			try {
				Validator.checkSalaryLimit(salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				
				Validator.checkNumberForGreaterThanZero((int) salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				Validator.checkNumberLessThanTenDigit((float) salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setSalary(salary);
			
			
			EmployeeDao dao1 = new EmployeeDao(); // TODO: Use Spring getBean() here
			int result = dao1.insertEmployee(newemp);
			System.out.println(result);
		} finally {
			sc.close();
		}
	}

	public void updateEmployee() 
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Employee newemp = new Employee();
			System.out.println("Enter Employee Id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParseInt(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.checkNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			
			EmployeeDao dao = new EmployeeDao(); // TODO: Use Spring getBean() here
			Employee emp = dao.getEmployeeById(empId);
			if (emp == null) {
				System.out.println("Employee Doesn't Exist For Id " + empId);
				return;
			}
			newemp.setE_Id(empId);
			
			
			System.out.println("Enter First_Name to Modify:");
			String fName = sc.nextLine();
			try {
				Validator.checkCharLessThanTwenty(fName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setFirst_Name(fName);
			
			
			System.out.println("Enter Last_Name to Modify:");
			String lName = sc.nextLine();
			try {
				Validator.checkCharLessThanTwenty(lName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setLast_Name(lName);
			
			
			System.out.println("Enter Email to Modify:");
			String eMail = sc.nextLine();
			try {
				Validator.checkMailContainsAtsymbol(eMail);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setEmail(eMail);
			
			
			System.out.println("Enter Job_id to Modify:");
			String jobId = sc.nextLine();
			try {
				Validator.checkCharLessThanTwenty(jobId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setJob_ID(jobId);
			
			
			System.out.println("Enter Salary to Modify:");
			float salary = sc.nextFloat();
			try {
				Validator.checkSalaryLimit(salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				Validator.checkNumberForGreaterThanZero((int) salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				Validator.checkSalaryLimit((int) salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setSalary(salary);
			
			
			EmployeeDao dao1 = new EmployeeDao(); // TODO: Use Spring getBean() here
			int result = dao1.updateEmployee(newemp);
			System.out.println(result);
		} finally {
			sc.close();
		}
	}

	public void updateEmployeeFirstName()
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Employee newemp = new Employee();
			System.out.println("Enter Employee Id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParseInt(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.checkNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			
			EmployeeDao dao = new EmployeeDao(); // TODO: Use Spring getBean() here
			Employee emp = dao.getEmployeeById(empId);
			if (emp == null) {
				System.out.println("Employee Doesn't Exist For Id " + empId); //
				return;
			}
			newemp.setE_Id(empId);
			
			
			System.out.println("Enter Update Name :");
			String fName = sc.nextLine();
			try {
				Validator.checkCharLessThanTwenty(fName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				Validator.checkStringOnly(fName);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setFirst_Name(fName);
			
			
			EmployeeDao dao1 = new EmployeeDao(); // TODO: Use Spring getBean() here
			int result = dao1.updateEmployeeFirstName(empId, fName);
			System.out.println(result);
		} finally {
			sc.close();
		}
	}

	public void updateEmployeeSalary() 
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Employee newemp = new Employee();
			System.out.println("Enter Employee Id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParseInt(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.checkNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			
			EmployeeDao dao = new EmployeeDao(); // TODO: Use Spring getBean() here
			Employee emp = dao.getEmployeeById(empId);
			if (emp == null) {
				System.out.println("Employee Doesn't Exist For Id " + empId); //
				return;
			}
			newemp.setE_Id(empId);
			
			
			System.out.println("Enter Update salary :");
			float salary = sc.nextFloat();
			try {
				Validator.checkSalaryLimit(salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int sl =(int) salary;
			try {
				Validator.checkNumberForGreaterThanZero((int) salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			try {
				Validator.checkSalaryLimit(sl);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newemp.setSalary(salary);
			
			EmployeeDao dao1 = new EmployeeDao(); // TODO: Use Spring getBean() here
			int result = dao1.updateEmployeeSalary(empId, salary);
			System.out.println(result);
		} finally {
			sc.close();
		}
	}

	public void deleteEmployee() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Employee newemp = new Employee();
			System.out.println("Enter Employee Id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParseInt(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.checkNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			EmployeeDao dao = new EmployeeDao(); // TODO: Use Spring getBean() here
			Employee emp = dao.getEmployeeById(empId);
			if (emp == null) {
				System.out.println("Employee Doesn't Exist For Id " + empId); //
				return;
			}
			newemp.setE_Id(empId);
			
			
			EmployeeDao dao1 = new EmployeeDao(); // TODO: Use Spring getBean() here
			int result = dao1.deleteEmployee(empId);
			System.out.println(result);
		} finally {
			sc.close();
		}
	}

	public   void getEmployeeById() 
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			Employee newemp = new Employee();
			System.out.println("Enter Employee Id :");
			String id = sc.nextLine();
			try {
				Validator.checkStringForParseInt(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.checkNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			
			
			EmployeeDao dao = new EmployeeDao(); // TODO: Use Spring getBean() here
			Employee emp = dao.getEmployeeById(empId);
			if (emp == null) {
				System.out.println("Employee Doesn't Exist For Id " + empId); //
				return;
			}
			newemp.setE_Id(empId);
			
			
			EmployeeDao dao1 = new EmployeeDao(); // TODO: Use Spring getBean() here
			Employee result = dao1.getEmployeeById(empId);
			System.out.println(result.getE_Id() + " " + result.getFirst_Name() + " " + result.getLast_Name() + " "
					+ result.getEmail() + " " + result.getHire_Date() + " " + result.getJob_ID() + " "
					+ result.getSalary());
		} finally {
			sc.close();
		}
	}

	public   void getAllEmployeesDetails() 
	{
		EmployeeDao dao = new EmployeeDao(); // TODO: Use Spring getBean() here
		List<Employee> allEmployees = dao.getAllEmployee();
		Iterator<Employee> empIterator = allEmployees.iterator();
		while (empIterator.hasNext()) {
			Employee emp = empIterator.next();
			System.out.println(emp.getE_Id() + " " + emp.getFirst_Name() + " " + emp.getLast_Name() + " "
					+ emp.getEmail() + " " + emp.getHire_Date() + " " + emp.getJob_ID() + " " + emp.getSalary());
		}
	}
}
