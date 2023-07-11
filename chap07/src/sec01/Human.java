package sec01;

public class Human {

	int weight; // 몸무게
	int height; // 키
	String gender; // 성별

	Human(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
	
	Human(int height, String gender){
		this.height = height;
		this.gender = gender;
	}
	
	
	void sleep() {
		System.out.println("잠이 듭니다.");
	}

	void awake() {
		System.out.println("일어납니다.");
	}

	String eat(String food) {
		String result = food + "을(를) 먹습니다.";
		return result;
	}

	String run(int speed ) {
		String result = speed + "속도로 달립니다.";
		return result;
	}

}
