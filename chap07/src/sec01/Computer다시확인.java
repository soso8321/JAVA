package sec01;

import java.util.Scanner;

public class Computer�ٽ�Ȯ�� {
	String brand;
	int price;
	String prod_year;

	final String wifi = "000000";

	void powerOn() {
		System.out.println("������ �մϴ�.");
	}

	void powerOff() {
		System.out.println("������ ���ϴ�.");
	}

	

	boolean wifiLink() {
		Scanner s = new Scanner(System.in);
		System.out.println("�������� ��ȣ�� �Է��ϼ���");
		String wifi_num = s.next();
		
		if (wifi_num .equals(wifi)) {
			return true;
		} else {
			System.out.println("�������� ��ȣ�� ��ġ���� �ʾҽ��ϴ�.");
			return false;
		}
	}

	void game(String gameName) {
		System.out.println("����: " + gameName + "��(��) �մϴ�.");
	}

}
