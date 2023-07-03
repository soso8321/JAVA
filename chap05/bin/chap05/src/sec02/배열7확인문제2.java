package sec02;

import java.util.Scanner;

public class 배열7확인문제2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] lotto = new int[6];
		// 로또 몇 게임을 하시겠습니까?
		// 사용자가 입력한 숫자만큼 로또번호를 랜덤으로 출력하세요
		System.out.println("로또 게임을 몇 게임 하시겠습니까");
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
