package wrapper;

public class ExampleOne {

	public static void main(String[] args) {
		
		Integer i = 7; //in primitive pool
		Integer i2 = 101; //in primitive pool
		Integer x = new Integer(7); //separate memory
		// i and x have different addresses
		//Observe
		System.out.println("i==x is "+(i==x));
		System.out.println(i.equals(x));//equals method is overridden in Integer class
		
		String s=i+""; //converts i to String object s
		System.out.println(s);
		
		/*compareTo method is used for sorting
		 * intObject.compareTo.(intVar) outputs 0 if intObject and intVar are equal,
		 * outputs negative number if intVar>inObject,
		 * and outputs positive number if inObject>intVar
		 */
		System.out.println("i.compareTo(7) : "+i.compareTo(7));
		System.out.println("i.compareTo(50) : "+i.compareTo(50));
		System.out.println("i.compareTo(5) : "+i.compareTo(5));
		
		//toBinaryString is a static method in the Integer class that returns a string representation of the integer argument as an unsigned integer in base 2.
		System.out.println(Integer.toBinaryString(5));
		
		//toHexString is a static method in the Integer class that returns a string representation of the integer argument as an unsigned integer in base 16
		System.out.println(Integer.toHexString(40));
		
		//toOctalString is a static method in the Integer class that returns a string representation of the integer argument as an unsigned integer in base 8.
		System.out.println(Integer.toOctalString(75));
		
		Float f=i2.floatValue();//converts i2 to Float
		System.out.println("f = "+f);
		f=88.77f;
		int m=f.intValue();//converts f to int
		System.out.println("m = "+m);
		
		//Explore
		Double d1=22.7d; //in primitive pool
		Double d2=78.4884799d;// in primitive pool
		Double d3=new Double(22.7d);//separate memory address than d1
		System.out.println("\nd1==d3 is "+(d1==d3));
		System.out.println(d1.equals(d3));//equals method is overridden in Double class
		
		String s2="54.4";
		Double d4=Double.parseDouble(s2);
		System.out.println("d4*10 = "+d4*10);
		System.out.println("s2 converted to Double: " + d4);
		System.out.println(d4+"");//converted back to String object
		System.out.println("Could also use toString: "+d4.toString());
		
		System.out.println("Double.MAX_VALUE is "+Double.MAX_VALUE);
		System.out.println("Double.MIN_VALUE is "+Double.MIN_VALUE);
		System.out.println("\nd2.compareTo(78.4884799): "+d2.compareTo(78.4884799));
		System.out.println("d2.compareTo(50.0): "+d2.compareTo(50.0));
		System.out.println("d2.compareTo(150.0): "+d2.compareTo(150.0));
		
		Float f2=d1.floatValue();
		float ff=f2;
		System.out.println("f2 : "+ f2);
		System.out.println("ff : "+ff);
		Integer i3=d1.intValue();
		Long l=d1.longValue();
		Short st=d1.shortValue();
		Byte bt=d1.byteValue();
		System.out.println("i3 : "+i3);
		System.out.println("l: "+l);
		System.out.println("st : "+st);
		System.out.println("bt : "+ bt);
	}

}
