package buffer_builder;

public class TitleCaseDemo {

	public static void main(String[] args) {
		String s="hello hi good morning I am enjoying programming with java";
		System.out.println(s);
		System.out.println("Now capitalizing the first letter of each word...");
		StringBuilder sb=new StringBuilder();
		String ar[]=s.split(" ");
		for(String s1:ar) {
			sb.append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).append(" ");
		}
		System.out.println(sb.toString().trim());
		
		//Task - Convert every words last char to uppercase
		System.out.println("\n"+s);
		System.out.println("Now to capitalize the last character of each word...");
		StringBuilder sb2=new StringBuilder();
		for (String word:ar) {
			sb2.append(word.substring(0, word.length()-1)).append(Character
					.toUpperCase(word.charAt(word.length()-1))).append(" ");//could also use reverse() method
		}
		System.out.println(sb2.toString().trim());	
	}

}




