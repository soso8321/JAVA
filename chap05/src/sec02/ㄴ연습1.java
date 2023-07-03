package sec02;

import java.util.Scanner;

public class ㄴ연습1 {

	public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 
		System.out.println("배열의 갯수를 입력하세요");
		int number = s.nextInt();
		int[] num = new int[number];
		for(int i=0; i<num.length; i++) {
			System.out.println((i+1)+ "번째 수를 입력하세요");
			num[i] = s.nextInt();
		}
		System.out.print("{");
		for(int i=0; i<num.length; i++) {
			if(i<num.length-1) {
			System.out.print(num[i]+ ",");
			} else {
				System.out.print(num[i]);
			}
		}
		System.out.println("}");		
		
		int sum=0;
		for(int i=0; i<num.length; i++) {
			sum += num[i];
		}
		double avg = (double)sum/num.length;
		System.out.println("배열의 총합 : "+ sum);
		System.out.println("배열의 평균 : "+ avg);

	}

}
