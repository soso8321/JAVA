package sec01;

import java.util.Scanner;

public class ����켱���� {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("���� �ϳ��� �Է��ϼ���");
		int num1 = s.nextInt();
		System.out.println("������(+,-)�� �Է��ϼ���");
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
