package sec02;

import java.util.Scanner;

public class ���� {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("ù ��° ���ڸ� �Է��ϼ���");
		int a = s.nextInt();
		System.out.println("�� ��° ���ڸ� �Է��ϼ���");
		int b = s.nextInt();
		System.out.println("�����ڸ� �Է��ϼ���(+,-,*,/)");
		String c =s.next();
		int result;
		int temp;
		double result2;
		
		if(b>a) {        //if(c.equals("-")) { �ȿ� ���� �� '+' ���길 ����ǰ� ���� ù ��°�� ���� �� ��ü ���꿡 ����
			temp=a;
			a=b;
			b=temp; }
		
		
		if(c.equals("+")) {
			result = a+b;
			System.out.println("�� ���� "+ c +"�� :" + result + "�Դϴ�.");
		}
		
		if(c.equals("-")) {
			result = a-b;
			System.out.println("�� ���� "+ c +"�� :" + result + "�Դϴ�.");
		}
		
		if(c.equals("*")) {
			result = a*b;
			System.out.println("�� ���� "+ c +"�� :" + result + "�Դϴ�.");
		}
		
		if(c.equals("/")) {
			result2 = (double)a/ (double)b;
			System.out.println("�� ���� '"+ c +"'�� : " + result2 + "�Դϴ�.");
		}
		
		

	}


}