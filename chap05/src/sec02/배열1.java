package sec02;

public class �迭1 {

	public static void main(String[] args) {
		int[] score = { 50, 80, 90 };

		for (int i = 0; i <= score.length; i++) { // �迭�� ������ 0���� �����̹Ƿ� int i=0// i<3���� �Է��ϸ� 3�ڸ��� �ǹ����� ǥ���� �� ����
			
			if (i < score.length - 1) {
				System.out.print(score[i]+",");
			} else {
				System.out.print(score[i]);
			}
		}

	}

}
