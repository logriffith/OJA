package arrays;

public class UsingCRUD {
	//arrays have a pre-determined (by user) fixed size.
	//array elements must all have the same type.
	/*CRUD
	 * Creation-create data structure, insert values into structure.
	 * Read-how can you read the values after the structure is created and print them to the user?
	 * Update-how can you update the values in the structure?
	 * Delete-how can you remove values from the structure?
	 */
	public static void main(String[] args) {
		//Creation
		int ar[] = new int[10];// ar array has 10 elements of int type. The elements are stored next to each other in memory i.e contiguous. Also, Java garbage collector doesn't clean up unused space if there are less than 10 elements in the array. 
		ar[0] = 111;
		ar[1] = 2;
		ar[2] = 77;
		ar[3] = 4;
		ar[4] = 33;
		ar[5] = 100;
		int n = 6;
		
		//Read
		System.out.println("Printing array contents");
		for (int i = 0; i < n; i++) {
			System.out.print(ar[i] + " ");
		}
		
		/* Could also do an enhanced for loop->goes from top to bottom (i.e from index 0 to index ar.length)
		 * Inside parentheses reads as for each (:) element in array ar, execute the block of code
		 * for (int element : ar){
		 * 		System.out.println(element);
		 * }
		 */
		
		//Update
		int pos = 3;
		int value = 99;
		for (int i = n; i >= pos; i--) {
			ar[i] = ar[i - 1];
		}
		ar[pos - 1] = value; 
		n++;
		System.out.println("\nPrinting array contents after insertion");
		for (int i = 0; i < n; i++) {
			System.out.print(ar[i] + " ");
		}//this adds 99 to the array by inserting it into the index 2 position

		//Delete
		int delpos = 5;
		for (int i = delpos - 1; i < n; i++) {
			ar[i]=ar[i+1];
		}
		n--;
		
		System.out.println("\nPrinting array contents after deletion");
		for (int i = 0; i < n; i++) {
			System.out.print(ar[i] + " ");
		} //this deletes 4 from the array at index 4

	}
}
