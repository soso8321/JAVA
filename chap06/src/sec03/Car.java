package sec03;

public class Car { /*정보를 불러오는데 쓰는 자바 클래스 => API */
	String company ;
	String model="쉐보레" ;
	String color ;
	int maxSpeed ;
	int speed;
	
	public Car() { // 기본생성자
		
	}
	
	public Car(String model, int speed) {  //모델명과 속도가 들어가는 생성자 만듬
		// 생성자가 하나 있으므로 컴퓨터가 생성자를 자동으로 만들지 않음
		this.model = model; //class에 model을 this.로 명칭 
		this.speed = speed;
	 
	}
	
	public Car(String model,String color, int maxSpeed ) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
				
	}

	
	
	
}
