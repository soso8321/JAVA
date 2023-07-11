package sec01;

public class Student extends Human {

	int studentCode; // 학번
	String studentDept; // 학과
	
	Student(int weight, int height, int studentCode) {
		super(weight, height);
		this.studentCode = studentCode;
	}
	
	Student (int studentCode, String gender, int height) {
		super(height, gender);
		this.studentCode = studentCode;
	}

	
	

	void study(String place) {
		System.out.println(place + "에서 공부합니다.");
	}

	void dressOn() {
		System.out.println("교복을 입어요");
	}
	
	void dressOff() {
		System.out.println("교복을 벗어요");
	}




	@Override
	String eat(String food) {
		String result = food + "을(를) 매일 먹어요";
		return result;
		
	}

}
