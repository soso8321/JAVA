package sec01;

import java.util.Scanner;

public class ����켱����re {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("ù��° ���ڸ� �Է��ϼ���");
		int num1 = s.nextInt();
		System.out.println("�ι�° ���ڸ� �Է��ϼ���");
		int num2 = s.nextInt();
		
		//���� �����ڸ� ����Ͽ� �� ���� ���� 50�̻��̸� "���"
		//50�̸��̸� "Ż��"�� ����Ͻÿ�
		
		int a = num1 + num2;
		String result = (a>=50)? "���" : "Ż��";
		System.out.println(result);
				
	
	
	}

}
