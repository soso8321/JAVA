package sec03;

public class Student {

	String name; //�̸�
	int age; //����
	String number; //�й�
	String gender; //����
	String call_number; //����ó
	

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