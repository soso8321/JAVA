package sec01;

import java.util.Scanner;

public class Computer다시확인 {
	String brand;
	int price;
	String prod_year;

	final String wifi = "000000";

	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	

	boolean wifiLink() {
		Scanner s = new Scanner(System.in);
		System.out.println("와이파이 번호를 입력하세요");
		String wifi_num = s.next();
		
		if (wifi_num .equals(wifi)) {
			return true;
		} else {
			System.out.println("와이파이 번호가 일치하지 않았습니다.");
			return false;
		}
	}

	void game(String gameName) {
		System.out.println("게임: " + gameName + "을(를) 합니다.");
	}

}
