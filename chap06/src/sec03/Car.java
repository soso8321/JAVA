package sec03;

public class Car { /*������ �ҷ����µ� ���� �ڹ� Ŭ���� => API */
	String company ;
	String model="������" ;
	String color ;
	int maxSpeed ;
	int speed;
	
	public Car() { // �⺻������
		
	}
	
	public Car(String model, int speed) {  //�𵨸�� �ӵ��� ���� ������ ����
		// �����ڰ� �ϳ� �����Ƿ� ��ǻ�Ͱ� �����ڸ� �ڵ����� ������ ����
		this.model = model; //class�� model�� this.�� ��Ī 
		this.speed = speed;
	 
	}
	
	public Car(String model,String color, int maxSpeed ) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
				
	}

	
	
	
}
