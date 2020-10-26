package regex;

import java.util.Scanner;

public class ValidName {
	
	public static void main(String[] args) {
		System.out.println("Please enter a name");
		Scanner scan=new Scanner(System.in);
		String name = scan.nextLine().trim();//trim removes any white space on either end of name
		scan.close();
		//we will accept only names from the English alphabet and they must be at least one letter 
		if(name.matches("[ a-zA-Z]{1,}"))/* Note that his RegEx allows for spaces in the pattern */{
			System.out.println("Hello "+name);
		}else
			System.out.println(name+" is not a valid name");
	}
}
