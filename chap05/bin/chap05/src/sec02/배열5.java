package sec02;

import java.util.Scanner;

public class 배열5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("배열 개수를 알려주세요");
		int arraynum = s.nextInt();
		int[] num1 = new int[arraynum]; //사용자가 입력한 숫자로 배열 개수 생성
		// for문을 이용하여 배열에 숫자를 1부터 사용자가 입력한 숫자만큼 데이터 추가
		// 입력된 데이터의 평균값 출력
		
//		int sum = 0;
//		double avg=0;
		System.out.print("\"");
		for(int i = 0; i< arraynum; i++) {
			num1[i] = i + 1;
			System.out.print(num1[i]);  //num1배열 출력
			if(i!=num1.length-1) {      //배열길이(-1)까지 ','출력 
				System.out.print(", ");
			}
		}
		System.out.println("\"");
		int sum = 0;
		double avg = 0;
		for(int j=0; j<arraynum; j++) {
			sum += num1[j];
			avg = (double) sum /arraynum;
		}
		
//		for(int i=0; i < arraynum; i++) {
//			sum += (i+1) ;
//			//num1[i] = i+1; sum을 선언하지 않고 배열로
//			//avg = (double)sum/arraynum;
//			//sum = num1[i]
//		} 
//		 avg = sum / arraynum ;
		System.out.println("평균 : " + avg);
		
		
	}

}
