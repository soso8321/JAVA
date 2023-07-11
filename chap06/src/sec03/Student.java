package sec03;

public class Student {

	String name; //이름
	int age; //나이
	String number; //학번
	String gender; //성별
	String call_number; //연락처
	

	public Student() {
	
	}
	public Student(String name, int age) {
		this.name =name;
		this.age = age;
	}
	public Student(String name, String number, String call_number ) {
		this.name =name;
		this.number=number;
		this.call_number=call_number;
	}
	public Student(String name, int age, String gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}