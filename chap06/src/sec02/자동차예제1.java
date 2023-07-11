package sec02;

public class 자동차예제1 {

	public static void main(String[] args) {
		Car myCar = new Car(); //Car 객체 생성(=인스턴스 생성)
		
		System.out.println("회사이름 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);

		myCar.company = "페라리";
		myCar.model = "아벤타도르";
		// 정보 변경 가능
		
		System.out.println("회사이름 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
			
			
	
	
	
	
	
	}

}
