package operators;

public class Arithmetic {
	private int x=-7;
	private int y=6;
	
	public static void main(String[] args) {
		Arithmetic number = new Arithmetic();
		System.out.println(number.getX()+ " is positive? "+ number.isPositive(number.getX()));
		System.out.println(number.getY()+ " is negative? "+ number.isNegative(number.getY()));
		System.out.println(number.getX()+" is "+number.isEvenOrOdd(number.getX()));
		System.out.println(number.getY()+" is "+number.isEvenOrOdd(number.getY()));
		System.out.println(number.getX()+" to the "+number.getY()+"th power is "+ number.powerFunction(number.getX(), number.getY()));
}
	
	public boolean isPositive(int x) {
		if (x>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isNegative(int x) {
		if (x<0) {
			return true;
		}else {
			return false;
		}
	}
	
	public String isEvenOrOdd(int x){
		if(x%2==0) {
			return "even";
		}else {
			return "odd";
		}
	}
	
	public int powerFunction(int x, int y) {
		int result=1;
		for (int i=0;i<y;i++) {
			result*=x;
		}
		return result;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
