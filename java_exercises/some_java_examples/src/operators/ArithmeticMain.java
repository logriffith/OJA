package operators;

public class ArithmeticMain {
	public static void main(String[] args) {
		Arithmetic number = new Arithmetic(2,3);
		Arithmetic number2 = new Arithmetic(2,-3);
		Arithmetic number3 = new Arithmetic(2,0);
		System.out.println(number.getX()+ " is positive? "+ number.isPositive(number.getX()));
		System.out.println(number.getY()+ " is negative? "+ number.isNegative(number.getY()));
		System.out.println(number.getX()+" is "+number.isEvenOrOdd(number.getX()));
		System.out.println(number.getY()+" is "+number.isEvenOrOdd(number.getY()));
		System.out.println(number.getX()+"^("+number.getY()+") is "+ number.powerFunction(number.getX(), number.getY()));
		System.out.println(number2.getX()+"^("+number2.getY()+") is "+ number2.powerFunction(number2.getX(), number2.getY()));
		System.out.println(number3.getX()+"^("+number3.getY()+") is "+ number3.powerFunction(number3.getX(), number3.getY()));
		
	}
}
