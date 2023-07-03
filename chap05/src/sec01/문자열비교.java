package sec01;

import java.util.Scanner;

public class 문자열비교 {

	public static void main(String[] args) {
		String var1 = "홍길동";
		String var2 = "홍길동";

		if (var1 == var2) {
			System.out.println("두 데이터 참조가 같아요");
		} else {
			System.out.println("두 데이터 참조가 달라요");
		}
		Scanner s = new Scanner(System.in);
		String a = s.next();
		String b = s.next();

		if (a == b) {
			System.out.println("두 데이터 참조가 같아요");
		} else {
			System.out.println("두 데이터 참조가 달라요");
		}

		String var3 = new String("홍길동");
		String var4 = new String("홍길동");
		if(var3==var4) {
			System.out.println("두 데이터 참조가 같아요");
		} else {
			System.out.println("두 데이터 참조가 달라요");
		}
	}

}
