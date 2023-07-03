package sec02;

import java.lang.reflect.Array;
import java.util.Scanner;

public class 확인문제4re {

	public static void main(String[] args) {
		// 사용자로부터 배열개수를 입력받으세요
		// 배열 개수만큼 숫자를 입력받아서 배열에 삽입하세요
		// 해당 배열에서 가장 작은 숫자를 출력하세요(단, 숫자는 양수만 가능함)
		Scanner s = new Scanner(System.in);
		System.out.println("배열개수를 입력하세요");
		int number = s.nextInt();
		int[] num = new int[number];
		
		for (int i = 0; i < num.length; i++) {
			System.out.println((i+1)+"번째의 숫자를 입력하세요");
			num[i] = s.nextInt();
		}
		int min=num[0]; // int min=0 을 주는 경우 min=0으로 고정됨
		for(int j=0; j<num.length; j++) {
			if (min > num[j]) {
					min = num[j];
				}
		
		}	
		System.out.println("배열에서 가장 작은 수 : " + min);
	}

}
