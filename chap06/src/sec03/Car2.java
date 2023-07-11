package sec03;

public class Car2 { /*정보를 불러오는데 쓰는 자바 클래스 => API */
	String company="현대자동차" ;
	String model ;
	String color ;
	String number;
	int maxSpeed ;
	int speed;
	
	Car2() {
		
	}

	public Car2(String model) {
		//this.model = model;
		this(model,"흰강낭콩");
	}

	public Car2(String model, String color) {
//		this.model = model;
//		this.color = color;
		this(model,color,250);
	}
	public Car2(String company,int speed) {
		//this(model,color,0);
	} /*매개변수의 개수가 동일하더라도 타입이 다르면 매개변수가 같아도 생성자 추가가능*/

	public Car2(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	
	
	
	
}
