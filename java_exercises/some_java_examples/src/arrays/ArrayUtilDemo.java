package arrays;

import java.util.Arrays; //Arrays class is a pre-determined class in Java
//Arrays class is known as a helper class (note the static methods used here)

public class ArrayUtilDemo {

	public static void main(String[] args) {
		int ar[] = { 22, 11, 22, 33, 11, 22, 33, 11, 227888, 456 };
		
		//To print out the contents of an array, you don't need to use a for loop.
		//Instead, you can use the toString (static) method in the Arrays class.
		System.out.println(Arrays.toString(ar));
		
		//The sort (static) method here sorts the elements of the array in ascending order (i.e from least to greatest)
		Arrays.sort(ar);
		
		System.out.println(Arrays.toString(ar));
		
		//for calling binarySearch your array should and must be sorted in ascending order only
		//if search element is found it will print 0 or positive value, if it is not found then it will print negative value
		System.out.println("Arrays.binarySearch(ar, 100) : "+Arrays.binarySearch(ar, 100));
		System.out.println("Arrays.binarySearch(ar, 33) : "+Arrays.binarySearch(ar, 33));
		
		//copyOf method allows you to copy an array (note the new array)
		int ar2[]=Arrays.copyOf(ar, ar.length+10);
		System.out.println("ar2 = "+Arrays.toString(ar2));
		
		int ar3[]=new int [10];
		System.out.println("ar3 = "+Arrays.toString(ar3));
		Arrays.fill(ar3, -22);//fills the array with -22s rather than the default int, which is 0
		System.out.println("ar3 = "+Arrays.toString(ar3));
		
		//fill method is overloaded here
		Arrays.fill(ar3, 2, 5, -1000);//inserts -1000 into array from index 2 to index 5 (but not including index 5)
		System.out.println("ar3 = "+Arrays.toString(ar3));
		
	}

}
