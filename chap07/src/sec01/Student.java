package sec01;

public class Student extends Human {

	int studentCode; // �й�
	String studentDept; // �а�
	
	Student(int weight, int height, int studentCode) {
		super(weight, height);
		this.studentCode = studentCode;
	}
	
	Student (int studentCode, String gender, int height) {
		super(height, gender);
		this.studentCode = studentCode;
	}

	
	

	void study(String place) {
		System.out.println(place + "���� �����մϴ�.");
	}

	void dressOn() {
		System.out.println("������ �Ծ��");
	}
	
	void dressOff() {
		System.out.println("������ �����");
	}




	@Override
	String eat(String food) {
		String result = food + "��(��) ���� �Ծ��";
		return result;
		
	}

}
