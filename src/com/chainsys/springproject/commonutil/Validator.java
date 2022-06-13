package com.chainsys.springproject.commonutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static boolean checkStringForParseInt(String data) throws InvalidInputDataException {
		boolean result = false;
		for (int i = 0; i < data.length(); i++) {
			int c = (int) data.charAt(i);
			if (!(c >= 48 && c <= 58)) {
				result = false;
			if(!result) throw new InvalidInputDataException("Please Enter Integer Values!!");

			}
		} // if data is invalid throw new InvalidInputDataException("The value in string
			// must contain only numbers ");
		return result;
	}

	public static boolean checkNumberForGreaterThanZero(int data) throws InvalidInputDataException {
		boolean result = false;
		if (data <=0) {
			throw new InvalidInputDataException("The value must be greater then zero");
		} // if data is invalid throw new InvalidInputDataException("The value must be
			// greater then zero");
		return result;
	}
	
	public static void checkNumberForGreaterThanZero(float data) throws InvalidInputDataException {
		if(data<0) 
			throw new InvalidInputDataException("Please enter value greater than zero");
		
	}

	public static boolean checkCharLessThanTwenty(String data) throws InvalidInputDataException {
		boolean result = false;
		int count = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) != ' ') {
				count++;
			}
			if (count >= 20) {
				throw new InvalidInputDataException("The value of character must be less then twenty digit");
			}
		}
		return result;
	}
	
	public static boolean checkNumberLessThanTenDigit(Float data) throws InvalidInputDataException {
		boolean result = false;
		String d = Float.toString(data);
		int count = 0;
		for (int i = 0; i < d.length(); i++) {
			if (d.charAt(i) != ' ') {
				count++;
			}
			if (count >= 10) {
				throw new InvalidInputDataException("The Digits of Number must be less then ten digit");
			}
		}
		return result;
	}

	public static boolean checkMailContainsAtsymbol(String data) throws InvalidInputDataException {
		boolean result = false;
		Pattern p = Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher(data);

		if (!m.find()) {
			throw new InvalidInputDataException("The Input Data is not valid ");
		}
		return result;
	}

	public static void checkStringOnly(String data) throws InvalidInputDataException {
		boolean result=false;
		String pattern="^[a-zA-Z]+(\\s[a-zA-Z]+)?$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InvalidInputDataException("please enter character only");
	}
	
	public static void checkEmail(String data) throws InvalidInputDataException{
		boolean result=false;
	    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	    Pattern patt=Pattern.compile(regexPattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
	    if(!result) throw new InvalidInputDataException("your email does not meet required length or complex");
	}
	
	public static void checkJobId(String data) throws InvalidInputDataException{
		boolean result=false;
		String pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InvalidInputDataException("wrong pattern for job id");
	}
	
	public static void checkSalaryLimit(float data) throws InvalidInputDataException {
		if(data<7000 && data>150000) {
			throw new InvalidInputDataException("please enter salary between 7000 and 150000");
		}
	}
	
	public static void checkPhone(String data) throws InvalidInputDataException{
		boolean result=false;
		String pattern="^[0-9]{10}$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InvalidInputDataException("please enter 10 digit ");
	}
}
