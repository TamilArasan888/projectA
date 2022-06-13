package com.chainsys.springproject.beans;

public class Movie {
	public String title;
	public String director;
	public Movie(String filmTitle , String filmDirector) {
		title=filmTitle; 
		director=filmDirector;
		System.out.println(title);
		System.out.println(director);
		
	}
}
