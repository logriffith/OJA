package overriding;

public class PlayerMain {

	public static void main(String[] args) {
		Player p1=new Player(100, "Sachin");
		System.out.println(p1);//JVM calls toString() for you
		//System.out.println(p1.toString()); //same output as line 7
		
		Player p2=new Player(102, "Sachin");
		System.out.println(p2);
		
		if(p1.equals(p2))/* thanks to Implicit Casting i.e. p2 is converted to Object object */ {
			System.out.println("p1 and p2 are same");
		}else {
			System.out.println("p1 and p2 are different");
	}
	}
}
