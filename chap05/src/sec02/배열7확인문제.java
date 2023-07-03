package sec02;

import java.util.Scanner;

public class 배열7확인문제 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int sum = 0;

		System.out.println("배열의 개수를 입력하세요");
		int number = s.nextInt();
		
		int[] num = new int[number]; //입력받은 숫자로 배열의 갯수를 생성
		for (int i = 0; i < num.length; i++) {
			System.out.println((i+1)+ "번째 숫자를 입력하세요 : ");
			num[i] = s.nextInt(); //배열 i번에 숫자를 입력받는다.
			// int num2 = s.nextInt();
			// scores[i] = num2;
			// sum += scores[i];
			sum += num[i];
		}
		double avg = (double) sum / num.length;

		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + avg);

	}

}
