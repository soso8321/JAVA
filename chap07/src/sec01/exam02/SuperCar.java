package sec01.exam02;

public class SuperCar extends Car {
	int maxSpeed;
	String engine;
	
	
	
	public SuperCar(String model, String company, int maxSpeed, String engine) {
		super(model,company); //�θ� ������ ȣ��
		this.maxSpeed = maxSpeed;
		this.engine = engine;
	}
	
	//�����ڸ� ���弼��
	
}
