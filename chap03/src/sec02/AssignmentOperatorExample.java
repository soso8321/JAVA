package sec02;

import java.util.Scanner;

public class AssignmentOperatorExample {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num1 = 100;
		System.out.println("숫자를 입력하세요");
		int a = s.nextInt();
		System.out.println("연산자를 입력하세요");
		String b = s.next();
		int result;
		
		//if(b.equals("+")) { num1 += a;}
		if(b.equals("-")) { num1 -= a;}
		if(b.equals("/")) { num1 /= a;}
		if(b.equals("*")) { num1 *= a;}
		if(b.equals("%")) { num1 %= a;}

		System.out.println("결과값은 : " + num1);
		
		//result = b.equals("+")?num1 += a:(b.equals("-")?num1 -= a:(b.equals("/")?num1 /= a:(b.equals("*")?num1 *= a:(b.equals("%")?num1 %= a))))
		// 순서는 왼쪽에서 오른쪽으로 
	}

}
