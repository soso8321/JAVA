package sec02;

import java.util.Scanner;

public class 배열복사2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// 사용자에게 3명의 이름을 입력받아 배열에 저장하세요
		// String 타입의 5개짜리 배열을 별도로 생성하세요
		// 첫번째 배열에서 두번째 배열로 값을 복사하세요
		// 예) 두번째 배열에 철수, 영희, 순희, null, null
		// 두번째 배열의 null값을 영수로 채우세요

		String[] name = new String[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("학생 이름을 입력해 주세요");
			name[i] = s.next();
		}
		String[] name2 = new String[5];
		System.arraycopy(name, 0, name2, 0, name.length);
		 
		for(int i=0; i<5; i++) {
			if(name2[i]==null) { //null 은 .equals(X)'함수'이므로 null성립불가 / ==(O)'비교연산자'
				name2[i]="영수";
			} 
			System.out.println(name2[i]);
		}
		// for(int i=0; i<5; i++) {
		// System.out.println(name2[i]);
//			for(int i=0; i<5; i++ ) {
//				if(i>=3) {
//					name2[i] = "영수";
//				}
//		System.out.println("name2[i]");
//     }

	}

}
