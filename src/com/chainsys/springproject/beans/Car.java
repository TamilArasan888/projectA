package com.chainsys.springproject.beans;

public class Car {
	public Engine petrolEngine;
	public Wheel alloy;
	
	public Car(Engine petrolEngine,Wheel alloy) {
		System.out.println("Car object created : " + hashCode());
		this.petrolEngine=petrolEngine;
		this.alloy=alloy;
	}
	
	public void start() {
		petrolEngine.start();
		
	}
	
	public void move() {
		alloy.rotate();
	}
}
