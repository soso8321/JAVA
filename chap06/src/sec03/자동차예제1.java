package sec03;

public class �ڵ�������1 {

	public static void main(String[] args) {
		//Car car = new Car(); 
		//Car���Ͽ��� �����ڷ� model �� speed���� �޴´ٰ� �����Ͽ����Ƿ� ���� ������ �� ����

		Car car1 = new Car("��Ÿ��",300); // ����� ���� ������ ȣ��
		//Car���Ͽ��� �����ڷ� model�� speed���� �޴´ٰ� �����Ͽ����Ƿ� model�� speed���� ���� �� ����
		
		Car car2 = new Car(); // �⺻ ������ ȣ��
		//Car���Ͽ��� �⺻ �����ڸ� ������� ������ ���� ������ �� ����
	
	
	System.out.println(car1.model);
	System.out.println(car1.speed);
	System.out.println(car2.model);
	
	
	
	}

}
