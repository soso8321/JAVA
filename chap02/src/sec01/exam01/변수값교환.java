package sec01.exam01;

public class 변수값교환 {

	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		System.out.println("x:" + x + ", y:" + y);

		int temp = x;
//    	temp값을 x라고 선언 (x=3)
		x = y;
//		x값에 y를 대입함 (y=5)
		y= temp;
//		
		System.out.println("x:" + x + ", y:" + y);
//		해당 구문은 변수 x와 y를 서로 교체하는 구문임
	}

}
