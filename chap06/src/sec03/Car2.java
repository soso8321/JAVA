package sec03;

public class Car2 { /*������ �ҷ����µ� ���� �ڹ� Ŭ���� => API */
	String company="�����ڵ���" ;
	String model ;
	String color ;
	String number;
	int maxSpeed ;
	int speed;
	
	Car2() {
		
	}

	public Car2(String model) {
		//this.model = model;
		this(model,"�򰭳���");
	}

	public Car2(String model, String color) {
//		this.model = model;
//		this.color = color;
		this(model,color,250);
	}
	public Car2(String company,int speed) {
		//this(model,color,0);
	} /*�Ű������� ������ �����ϴ��� Ÿ���� �ٸ��� �Ű������� ���Ƶ� ������ �߰�����*/

	public Car2(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	
	
	
	
}
