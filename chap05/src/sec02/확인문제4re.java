package sec02;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Ȯ�ι���4re {

	public static void main(String[] args) {
		// ����ڷκ��� �迭������ �Է¹�������
		// �迭 ������ŭ ���ڸ� �Է¹޾Ƽ� �迭�� �����ϼ���
		// �ش� �迭���� ���� ���� ���ڸ� ����ϼ���(��, ���ڴ� ����� ������)
		Scanner s = new Scanner(System.in);
		System.out.println("�迭������ �Է��ϼ���");
		int number = s.nextInt();
		int[] num = new int[number];
		
		for (int i = 0; i < num.length; i++) {
			System.out.println((i+1)+"��°�� ���ڸ� �Է��ϼ���");
			num[i] = s.nextInt();
		}
		int min=num[0]; // int min=0 �� �ִ� ��� min=0���� ������
		for(int j=0; j<num.length; j++) {
			if (min > num[j]) {
					min = num[j];
				}
		
		}	
		System.out.println("�迭���� ���� ���� �� : " + min);
	}

}
