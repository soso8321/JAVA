package sec02;

import java.util.Scanner;

public class 다차원배열2다시확인 {

	public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 
	 System.out.println("이름을 입력하세요");
	 
	 String[] person = new String[3];
	 for(int i=0; i<person.length;i++ ) {
		 System.out.println((i+1) + "번째 사람 이름을 입력하세요");
		 person[i] = s.next();
	 }
		 
		 
	 int[][] num = new int[3][2]; //3줄 2칸 짜리 배열 생성
	 double[] result = new double[3]; // 평균값을 저장하기 위한 배열 생성
	 for(int i=0; i<num.length; i++) {
			 int sum = 0; //사람이 바뀔 때마다 합계값 초기화(누적X)
			 
			 for(int j=0; j<num[i].length; j++) {
				 
				 if(j==0) { //첫번째 입력값이면 중간고사, 두번째 입력값이면 기말고사
				 System.out.println(person[i]+ "의 중간점수를 입력하세요");
				 }else {
					 System.out.println(person[i]+ "의 기말점수를 입력하세요");
				 }
				 num[i][j] = s.nextInt(); // 각각 위치에 값 삽입
				 sum+=num[i][j]; //각 사람의 합계값 계산
			 //sum+=num[i][0]; // 각 사람의 중간고사 합계값 계산
		 } 
			 result[i] = (double)sum/2; //각각의 평균값 구한 후 result 배열에 삽입
			 
			//double avg = (double)sum/2; // 한 사람의 평균값 계산 후 출력
			//System.out.println(person[i] + "의 평균 점수는 " + avg + "입니다");
	 }
	 // 3명의 평균값 출력
	 for(int i=0; i<3; i++) {
		 System.out.println(person[i] + "의 평균점수는 " +result[i] + "입니다.");
	 }

	}

}
