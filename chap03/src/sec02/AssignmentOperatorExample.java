package sec02;

import java.util.Scanner;

public class AssignmentOperatorExample {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num1 = 100;
		System.out.println("���ڸ� �Է��ϼ���");
		int a = s.nextInt();
		System.out.println("�����ڸ� �Է��ϼ���");
		String b = s.next();
		int result;
		
		//if(b.equals("+")) { num1 += a;}
		if(b.equals("-")) { num1 -= a;}
		if(b.equals("/")) { num1 /= a;}
		if(b.equals("*")) { num1 *= a;}
		if(b.equals("%")) { num1 %= a;}

		System.out.println("������� : " + num1);
		
		//result = b.equals("+")?num1 += a:(b.equals("-")?num1 -= a:(b.equals("/")?num1 /= a:(b.equals("*")?num1 *= a:(b.equals("%")?num1 %= a))))
		// ������ ���ʿ��� ���������� 
	}

}
