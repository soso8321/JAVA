package sec02;

import java.util.Scanner;

public class �迭7Ȯ�ι��� {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int sum = 0;

		System.out.println("�迭�� ������ �Է��ϼ���");
		int number = s.nextInt();
		
		int[] num = new int[number]; //�Է¹��� ���ڷ� �迭�� ������ ����
		for (int i = 0; i < num.length; i++) {
			System.out.println((i+1)+ "��° ���ڸ� �Է��ϼ��� : ");
			num[i] = s.nextInt(); //�迭 i���� ���ڸ� �Է¹޴´�.
			// int num2 = s.nextInt();
			// scores[i] = num2;
			// sum += scores[i];
			sum += num[i];
		}
		double avg = (double) sum / num.length;

		System.out.println("���� : " + sum);
		System.out.println("��� : " + avg);

	}

}
