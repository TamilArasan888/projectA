package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext; // Parent
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; // Child

import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.ScoreBoard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;


public class TestClassPathXml {
	
	public static void testA() {
		Employee emp=new Employee();
		emp.setId(101);
		emp.setName("Dhoni");
		emp.print();
	}
	
	public static void testB() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=ac.getBean(Employee.class); // overloaded method of getBean(Class) returns of the class Employee , typecasting not required
//		Employee emp=(Employee)ac.getBean("emp"); // overloaded method of getBean(Class) returns object , typecasting is required
		emp.setId(102);
		emp.setName("Raina");
		emp.print();
		Customer c=ac.getBean(Customer.class);
		c.setId(50);
		c.setName("Jadeja");
		c.print();
	}
	
	public static void testLazyInit() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=ac.getBean(Employee.class);
		Customer c= ac.getBean(Customer.class);
		// lazy-init ="true" for customer. An object is created now (firstcall to getBean() method for Customer.class)
		Employee secondemp=ac.getBean(Employee.class);
		Customer secondcus= ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(c.hashCode());
		System.out.println(secondemp.hashCode());
		System.out.println(secondcus.hashCode());
	}
	
	public static void testPrototype() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Actor hero=ac.getBean(Actor.class);
		Actor heroin=ac.getBean(Actor.class);
		Actor comedian=ac.getBean(Actor.class);
		Actor friend=ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(heroin.hashCode());
		System.out.println(comedian.hashCode());
		System.out.println(friend.hashCode());
	}
	
	public static void testBeanWithConstructor() {
			ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		}
	
	public static void testFactoryMethod() {
			ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
			ScoreBoard sb=ac.getBean("sb1",ScoreBoard.class);
			sb.targetScore=183;
			System.out.println(sb.targetScore);
			ScoreBoard sb2=ac.getBean("sb2",ScoreBoard.class);
			System.out.println(sb2.targetScore);
		}
	
	public static void testCalendarFactory() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Calendar today=ac.getBean(Calendar.class);
		today.day=9;
		today.month="june";
		today.year=2022;
		System.out.println(today.day);
		System.out.println(today.month);
		System.out.println(today.year);
	}
	
	public static void testLunchFactory() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nvsilunch=ac.getBean("nvsilunch",Lunch.class);
		Lunch vsilunch=ac.getBean("vsilunch",Lunch.class);
		Lunch nilunch=ac.getBean("nilunch",Lunch.class);
		Lunch chlunch=ac.getBean("chlunch",Lunch.class);
		System.out.println("-------------");
		nvsilunch.serve();
		System.out.println("-------------");
		vsilunch.serve();
		System.out.println("-------------");
		nilunch.serve();
		System.out.println("-------------");
		chlunch.serve();
	}
	
	public static void testSetterDi() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("Lunch.xml");
		Employee emp=ac.getBean("emp2",Employee.class);
		emp.print();

	}
	
	public static void testLifeCycle() {
		ConfigurableApplicationContext ac=new ClassPathXmlApplicationContext("lc.xml");
		LifeCycleBean life=ac.getBean(LifeCycleBean.class);
		life.print();
		life=null;
//		System.gc();
		ac.close();
		ac=null;

	}
	
	public static void testInitDestroyBean() {
		ConfigurableApplicationContext ac=new ClassPathXmlApplicationContext("lc.xml");
		InitDesposeBean init=ac.getBean(InitDesposeBean.class);
		init.print();
	}
	
	public static void testAnnotationLc() {
		ConfigurableApplicationContext ac=new ClassPathXmlApplicationContext("lc.xml");
		AnnotationLc ann=ac.getBean(AnnotationLc.class);
		ann.print();
		ann=null;
	}
	
	public static void testAutoWire() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("autowired.xml");
		Car c= ac.getBean("car",Car.class);
		c.start();
		c.move();
		c= null;
		ac.close();
	}

	public static void testAutoWireQualifier() {
		ConfigurableApplicationContext ac=new ClassPathXmlApplicationContext("autowired.xml");
		CarServices cs=ac.getBean(CarServices.class);
		cs.startTrip();

	}
}
