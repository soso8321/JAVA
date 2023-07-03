package sec01;

import java.util.Scanner;

public class 연산우선순위 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("숫자 하나를 입력하세요");
		int num1 = s.nextInt();
		System.out.println("연산자(+,-)를 입력하세요");
		String oper= s.next();
		
		if(oper.equals("+")) {
			num1++;
			//System.out.println(++num1);
		}
		else {
			num1--;
			//System.out.println(--num1);
		}
		System.out.println(num1);
	
	
	}
	

}
