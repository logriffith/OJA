package exceptions;

import java.util.Arrays;//need for static sort and toString methods
import java.util.InputMismatchException;
import java.util.Scanner;//need this to use Scanner class

public class ExampleOne {

	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);//needed for user input
		System.out.println("Enter the number of tests you had for a class");
		int tests = sc.nextInt();
		double grades[] = new double[tests];
		System.out.println("Enter the grades for each test");
		for (int i = 0; i < grades.length; i++) {
			grades[i]=sc.nextDouble();
		}
		sc.close();//no more input from here
		Arrays.sort(grades);
		System.out.println("The grades from least to greatest is "+Arrays.toString(grades));
		double average=0d;
		for (int i = 0; i < grades.length; i++) {
			average+=grades[i];
		}
		double total=tests;
		System.out.println("Your average test score is "+average/total+"%");
		}
//		catch(Exception anException){
//		//Doesn't matter what the parent class Exception object is named because only one
//		//Exception object is created if there is an exception and a parent object 
//		//doesn't have access to the methods of the child. This is because only ONE catch  
//		//block is executed at a time per try block. Thus, if this catch block isn't commented  
//		//out here, the, following catch blocks will be considered unreachable code. Due to  
//		//implicit casting, if there are exceptions in the parent class, their corresponding  
//		//catch blocks must be placed AFTER the catch blocks corresponding to their child classes.
//		}
		catch(NegativeArraySizeException e) {
			System.out.println("An array cannot have a negative number of elements");
		}catch(InputMismatchException e) {
			System.out.println("There must be a whole number of tests and other inputs must be the percents for each test");
		}catch(Exception e) {
			//this is the parent exception
			System.out.println("Some other exception occured.");
		}
		finally {
			System.out.println("As Yoda said, \"Do there is no try!\"");
		}
		
		
	}

}
