package sec03;

public class 자동차예제2 {

	public static void main(String[] args) {

		Car car2 = new Car("BMW", 250);
		
		System.out.println(car2.model);
		System.out.println(car2.speed);
		System.out.println(car2.company);
		
		Car car3 = new Car("테슬라","빨강",350);
			
		System.out.println(car3.model);
		System.out.println(car3.color);
		System.out.println(car3.maxSpeed);
	
	
	
	}

}
