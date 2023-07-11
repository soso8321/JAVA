package sec03;

public class 자동차예제1 {

	public static void main(String[] args) {
		//Car car = new Car(); 
		//Car파일에서 생성자로 model 과 speed값을 받는다고 생성하였으므로 빈값을 선언할 수 없음

		Car car1 = new Car("싼타페",300); // 사용자 정의 생성자 호출
		//Car파일에서 생성자로 model과 speed값을 받는다고 생성하였으므로 model과 speed값을 받을 수 있음
		
		Car car2 = new Car(); // 기본 생성자 호출
		//Car파일에서 기본 생성자를 만들었기 때문에 빈값을 선언할 수 있음
	
	
	System.out.println(car1.model);
	System.out.println(car1.speed);
	System.out.println(car2.model);
	
	
	
	}

}
