package sec02;

import java.util.Scanner;

public class �迭7Ȯ�ι���2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] lotto = new int[6];
		// �ζ� �� ������ �Ͻðڽ��ϱ�?
		// ����ڰ� �Է��� ���ڸ�ŭ �ζǹ�ȣ�� �������� ����ϼ���
		System.out.println("�ζ� ������ �� ���� �Ͻðڽ��ϱ�");
		int number = s.nextInt();
		for (int j = 0; j < number; j++) {
			for (int i = 0; i < 6; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1;

				System.out.print(lotto[i]);
				System.out.print("/");

			} System.out.println();
		}

	}

}
