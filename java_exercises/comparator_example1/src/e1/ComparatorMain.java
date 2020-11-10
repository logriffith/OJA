package e1;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorMain {

	public static void main(String[] args) {
		
		ArrayList<Student> sal = new ArrayList<Student>();
		sal.add(new Student(782, "Billy-Boy Brown", 27));
		sal.add(new Student(878, "Anglela Hanson", 28));
		sal.add(new Student(787, "William Sanders", 25));
		
		System.out.println("Here are the students before sorting:");
		for (Student s : sal) {
			System.out.println("Student ID = "+s.getStudentId()+" Studnet Name = "+s.getName()+" Student Age = "+s.getAge());
		}
		
		System.out.println("\nNow using the AgeComparator class to sort the students by their ages");
		Collections.sort(sal,new AgeComparator());
		//here are the results
		
		for (Student s : sal) {
			System.out.println("Student ID = "+s.getStudentId()+" Studnet Name = "+s.getName()+" Student Age = "+s.getAge());
		}
		
		System.out.println("\nNow using the NameComparator class to sort the students by their ages:");
		Collections.sort(sal, new NameComparator()); //puts them in alphabetical order by first name
		//here are the results

		for (Student s : sal) {
			System.out.println("Student ID = "+s.getStudentId()+" Studnet Name = "+s.getName()+" Student Age = "+s.getAge());
		}
	}

}
