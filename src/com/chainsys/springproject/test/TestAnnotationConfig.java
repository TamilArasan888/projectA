package com.chainsys.springproject.test;
import org.springframework.context.ApplicationContext; // Parent
import org.springframework.context.annotation.AnnotationConfigApplicationContext; // Child

import com.chainsys.springproject.appconfig.AppConfig;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.component.MobilePhone;


public class TestAnnotationConfig
{
	public static void testA() 
	{
		ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp=ac.getBean(Employee.class);
		emp.setId(7);
		emp.setName("Tamil");
		emp.print();
		Employee secondemp=ac.getBean(Employee.class);

	}
	public static void testPhone() {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext();
		ac.scan("com.chainsys.springproject.component");
		ac.refresh();
		MobilePhone phone=ac.getBean(MobilePhone.class);
		phone.setPhoneNumber(81100045201l);
		long number=phone.getPhoneNumber();
		System.out.println("Phone number :"+number);

	}
}
