package com.chainsys.springproject.startup;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.test.TestAnnotationConfig;
import com.chainsys.springproject.test.TestCar;
import com.chainsys.springproject.test.TestClassPathXml;

public class Main {

	public static void main(String[] args) {
//		TestCar.firstTest();
//		TestClassPathXml.testLifeCycle();
//		TestClassPathXml.testAnnotationLc();
//		TestClassPathXml.testAutoWire();
//		TestClassPathXml.testAutoWireQualifier();
		TestAnnotationConfig.testPhone();

	}
}
