package e1;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		//use the compareTo method in the String class
		return s1.getName().compareTo(s2.getName());
		}

}
