package sec01.exam02;

public class SuperCar extends Car {
	int maxSpeed;
	String engine;
	
	
	
	public SuperCar(String model, String company, int maxSpeed, String engine) {
		super(model,company); //부모 생성자 호출
		this.maxSpeed = maxSpeed;
		this.engine = engine;
	}
	
	//생성자를 만드세요
	
}
