package sec02;

import java.util.Scanner;

public class ConditionOperationExample {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "���� " + grade + "����Դϴ�.");

		// ����ڰ� ������ �Է��մϴ�.
		// ������ 90�� �̻� "��" 80�� �̻� "��" ������ "��"
		
		System.out.println("������ �Է��ϼ���");
		int score2 = s.nextInt();
		char grade2 = ((score >= 90) ? '��' : ((score >= 80)? '��' :'��'));
		System.out.println(score + "���� " + grade + "����Դϴ�.");

	}

}
