package sec02;

import java.util.Scanner;

public class �迭����2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// ����ڿ��� 3���� �̸��� �Է¹޾� �迭�� �����ϼ���
		// String Ÿ���� 5��¥�� �迭�� ������ �����ϼ���
		// ù��° �迭���� �ι�° �迭�� ���� �����ϼ���
		// ��) �ι�° �迭�� ö��, ����, ����, null, null
		// �ι�° �迭�� null���� ������ ä�켼��

		String[] name = new String[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("�л� �̸��� �Է��� �ּ���");
			name[i] = s.next();
		}
		String[] name2 = new String[5];
		System.arraycopy(name, 0, name2, 0, name.length);
		 
		for(int i=0; i<5; i++) {
			if(name2[i]==null) { //null �� .equals(X)'�Լ�'�̹Ƿ� null�����Ұ� / ==(O)'�񱳿�����'
				name2[i]="����";
			} 
			System.out.println(name2[i]);
		}
		// for(int i=0; i<5; i++) {
		// System.out.println(name2[i]);
//			for(int i=0; i<5; i++ ) {
//				if(i>=3) {
//					name2[i] = "����";
//				}
//		System.out.println("name2[i]");
//     }

	}

}
