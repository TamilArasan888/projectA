package com.chainsys.springproject.test;
import org.springframework.context.ApplicationContext; // Parent
import org.springframework.context.support.ClassPathXmlApplicationContext; // Child
import com.chainsys.springproject.beans.Car;
public class TestCar {
	
	public static void firstTest() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Car c=ac.getBean(Car.class);
		c.start();
		c.move();
	}
}
