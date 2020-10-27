package operators;

public class Arithmetic {
	private int x;
	private int y;

	public Arithmetic(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Arithmetic() {
		
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
	//Check out math library
	public float powerFunction(float x, float y) {
		float result = 1f;
		for(float i = 0;i<y;i++) {
			result*=x;
		}
		if(y==0) {
			return 1f;
		}else if(y>0) {
			return result;
		}else {
			return 1f/result;	//this part isn't working for some reason e.g. 2^(-3)=.125 yet powerFunction(2,-3) outputs as 1.0
		}
					
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
