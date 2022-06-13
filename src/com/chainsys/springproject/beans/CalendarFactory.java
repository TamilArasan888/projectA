package com.chainsys.springproject.beans;
// Multiple factory method in one class
// Calendar factory is also called as initiating bean because methods in this bean instaniates objects for other beans
public class CalendarFactory {
//	The factory method is not static here
	public Calendar createCalendar() {
//		The Calendar constructor is default access modifier so, can be called here.
//		The Calendar class and the calendar factory class are both in the same package 
		return new Calendar();
	}
	public Appointments createAppointment() {
		return new Appointments();
	}
}
