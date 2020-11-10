package e1;

import java.util.ArrayList;
import java.util.Collections;

public class SortByAge {

	public static void main(String[] args) {
		ArrayList<Student> sal = new ArrayList<Student>();
		sal.add(new Student(782, "Billy-Boy Brown", 27));
		sal.add(new Student(878, "Jane Hanson", 28));
		sal.add(new Student(787, "William Sanders", 25));
		
		System.out.println("Printing the students from ArrayList:");
		for(Student s : sal) {
			System.out.println(s.getStudentId()+" "+s.getName()+" "+s.getAge());
		}
		
		System.out.println("\nNow sorting them by age:");
		Collections.sort(sal);
		for(Student s : sal) {
			System.out.println(s.getStudentId()+" "+s.getName()+" "+s.getAge());
		}
	}

}

//Comparable Interface
//1) Comparable provides a single sorting sequence. In other words, we can sort the 
//collection on the basis of a single element such as id, name, and price.
//
//2) Comparable affects the original class, i.e., the actual class is modified.
//
//3) Comparable provides compareTo() method to sort elements.
//
//4) Comparable is present in java.lang package.
//
//5) We can sort the list elements of Comparable type by Collections.sort(List) method.
