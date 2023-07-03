package sec02;

public class 배열3다시확인 {

	public static void main(String[] args) { //'void' return값이 없음을 의미, 단지 출력
		int[] scores; //밖에서 선언 후 다시 사용 가능
		scores = new int[] {83,90,87};
		
		//int[] scores = {83,90,87}; 압축해서 사용 가능함
		
		int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
			
		} System.out.println("총합 : " + sum1);
		
		int sum2 = add(new int[] {83,90,87});  //main메소드에서 add메소드 호출하여 int배열값을 넘겨줌 => add메소드 선언필요
		System.out.println("총합 : " + sum2);
		System.out.println();
 	} //main구문 종료

	public static int add(int[] scores) { //int로 return 하는 이유 add(int[] scores)타입이 int이므로
		int sum=0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		return sum;
	}
	
}
