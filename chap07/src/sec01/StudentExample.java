package sec01;

public class StudentExample {

	public static void main(String[] args) {

		
		Student student = new Student(20213, "��", 183 );
		
		
		System.out.println(student.gender +"�л�/ �й� "+ student.studentCode + "�� ���� �ϰ�");
		System.out.println("");
		student.sleep(); //�θ� �޼ҵ� ȣ��
		student.awake(); //�θ� �޼ҵ� ȣ��
		student.study("������"); //�ڱ� �޼ҵ� ȣ��
		String result = student.eat("������");
		System.out.println(result);
		student.sleep(); //�θ� �޼ҵ� ȣ��
		

		
		
	}

}
