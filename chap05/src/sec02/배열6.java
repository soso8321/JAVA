package sec02;

import java.util.Scanner;

public class �迭6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String[] weather = new String[4];
		weather[0] = "��";
		weather[1] = "����";
		weather[2] = "����";
		weather[3] = "�ܿ�";

		//boolean repeat = true
		outer: while (true) {
			//while(repeat)
			System.out.println("�����ϴ� ������ �Է��ϼ���");
			System.out.println("���� 1, ������ 2, ������ 3, �ܿ��� 4");
			int choice = s.nextInt();
			switch(choice) {
			case 1:      //case1���� case3������ ���๮�� �����Ƿ� case4������ �Ѿ�� �����
			// System.out.println(weather[0]+ "�� �����ϼ̽��ϴ�.");
			// repeat=false;  //while�� �̸������� �ϴ� ��� boolean ����X�ϹǷ� repeat=false �Է�X
			// break;
				
			case 2:
			case 3:
			case 4:
				System.out.println(weather[choice-1]);
				break outer;
			default :
				System.out.println("1~4 �̿��� ��ȣ�� �Է��ϼ̽��ϴ�.");
				
			}
		}  
	}

}
