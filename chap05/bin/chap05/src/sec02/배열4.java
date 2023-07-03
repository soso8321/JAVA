package sec02;

import java.util.Scanner;

public class 배열4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("첫 번째 숫자를 입력해 주세요");
		int a = s.nextInt();
		System.out.println("첫 번째 숫자를 입력해 주세요");
		int b = s.nextInt();
		
		
		
		int[] c = new int[2]; //2개 공간을 가진 int 배열 생성
		c[0] = a;
		c[1] = b;
		int sum = c[0]+c[1];
		System.out.println("합계는 : " + sum);
		
		int sum2=0; //int sum2 값을 넣어주어야 계산 가능
		for(int i=0; i<2; i++) {
			sum2 += c[i]; 
		}System.out.println("합계는 : " + sum2);

	}

}
