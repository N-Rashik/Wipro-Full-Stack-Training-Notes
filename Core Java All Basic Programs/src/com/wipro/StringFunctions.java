package com.wipro;

import java.util.Scanner;

public class StringFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String: ");
		String email=sc.nextLine().trim().toLowerCase();
		if(email.contains("@")) {
			System.out.println("Valid email");
		}
		else {
			System.out.println("Invalid email");
		}
		//password
		System.out.println("Enter the password: ");
		String password=sc.next();
		if(password.equalsIgnoreCase("Admin@123")) {
			System.out.println("Valid password");
		}
		else {
			System.out.println("Invalid password");
		}
		
		String text="aadghc cuecvud wduhvuhdw";
		String[] afterSplitting=text.split(" ");
		String value=afterSplitting[0];
		
		String values="Java";
		String newValue=new StringBuilder(values).reverse().toString();
		System.out.println("The value after reversing is: "+newValue);
		
		

	}

}
