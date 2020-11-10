package e1;

public class Student implements Comparable<Student> {
	
	private int studentId;
	private String name;
	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int studentId, String name, int age) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student student) {
		if(age == student.age) {
			return 0;
		}else if (age > student.age) {
			return 1;
		}else {
			return -1;
		}	
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
