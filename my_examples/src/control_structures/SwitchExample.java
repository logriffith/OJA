package control_structures;

public class SwitchExample {
	//Switch statements work best for fixed or constant values
	public static void main(String[] args) {
		int day = 5;

		switch (day) {

		case 1:
			System.out.println("Its Monday");
			break;
		case 2:
			System.out.println("Its Tuesday");
			break;
		case 3:
			System.out.println("Its Wednesday");
			break;
		case 4:
			System.out.println("Its Thursday");
			break;
		case 5:
			System.out.println("Its Friday"); //Code will run until it reaches a break. 
			//break;//If day=5 and there is no break in case 5, then the block of code in both case 5 and case 6 will execute. 
		case 6:
			System.out.println("Its Saturday");
			break;
		case 7:
			System.out.println("Its Sunday");
			break;
		default:
			System.out.println("There are only 7 days in a week!");
		}
		
	}

}
