package sec01;

public class Human {

	int weight; // ������
	int height; // Ű
	String gender; // ����

	Human(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
	
	Human(int height, String gender){
		this.height = height;
		this.gender = gender;
	}
	
	
	void sleep() {
		System.out.println("���� ��ϴ�.");
	}

	void awake() {
		System.out.println("�Ͼ�ϴ�.");
	}

	String eat(String food) {
		String result = food + "��(��) �Խ��ϴ�.";
		return result;
	}

	String run(int speed ) {
		String result = speed + "�ӵ��� �޸��ϴ�.";
		return result;
	}

}
