package sec02;

import java.util.Scanner;

public class 계산기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자를 입력하세요");
		int a = s.nextInt();
		System.out.println("두 번째 숫자를 입력하세요");
		int b = s.nextInt();
		System.out.println("연산자를 입력하세요(+,-,*,/)");
		String c =s.next();
		int result;
		int temp;
		double result2;
		
		if(b>a) {        //if(c.equals("-")) { 안에 선언 시 '+' 연산만 적용되고 먼저 첫 번째로 선언 시 전체 연산에 적용
			temp=a;
			a=b;
			b=temp; }
		
		
		if(c.equals("+")) {
			result = a+b;
			System.out.println("두 수의 "+ c +"는 :" + result + "입니다.");
		}
		
		if(c.equals("-")) {
			result = a-b;
			System.out.println("두 수의 "+ c +"는 :" + result + "입니다.");
		}
		
		if(c.equals("*")) {
			result = a*b;
			System.out.println("두 수의 "+ c +"는 :" + result + "입니다.");
		}
		
		if(c.equals("/")) {
			result2 = (double)a/ (double)b;
			System.out.println("두 수의 '"+ c +"'는 : " + result2 + "입니다.");
		}
		
		

	}


}