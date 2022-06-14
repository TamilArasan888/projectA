package com.chainsys.springproject.startup;


import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.chainsys.springproject.view.EmployeeSpring;
import com.chainsys.springproject.test.TestClassPathXml;

public class Main {

	public static void main(String[] args) {
	
	employeeMenu();
	}
	public static void employeeMenu() {
		ConfigurableApplicationContext apcontext=new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeSpring empspring = apcontext.getBean(EmployeeSpring.class);
		Scanner sc=new Scanner(System.in);
		empspring.setApcontext(apcontext);
		empspring.setSc(sc);
		System.out.println("1) To add New employee in to table");
		System.out.println("2) To Get employee datails by id from table");
		System.out.println("3) To Update employee details");
		System.out.println("4) To Delete Employee details");
		System.out.println("Enter your choice :");
		int vCase=sc.nextInt();
		switch(vCase) {
		case 1:
			empspring.addNewEmployee();
			break;
		case 2:
			empspring.GetEmplyeeById();
			break;
		case 3:
			empspring.UpdateEmployee();
			break;
		case 4:
			empspring.DeleteEmployee();
			break;
		default:
			System.out.println("Enter valid number");
			break;
		}
		apcontext.close();
		sc.close();
	
	}
}
