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
		}catch(NegativeArraySizeException e) {
			System.out.println("An array cannot have a negative number of elements");
		}catch(InputMismatchException e) {
			System.out.println("There must be a whole number of tests and other inputs must be the percents for each test");
		}finally {
			System.out.println("As Yoda said, \"Do there is no try!\"");
		}
		
		
	}

}
