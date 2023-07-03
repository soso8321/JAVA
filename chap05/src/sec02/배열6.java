package sec02;

import java.util.Scanner;

public class 배열6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String[] weather = new String[4];
		weather[0] = "봄";
		weather[1] = "여름";
		weather[2] = "가을";
		weather[3] = "겨울";

		//boolean repeat = true
		outer: while (true) {
			//while(repeat)
			System.out.println("좋아하는 계절을 입력하세요");
			System.out.println("봄은 1, 여름은 2, 가을은 3, 겨울은 4");
			int choice = s.nextInt();
			switch(choice) {
			case 1:      //case1부터 case3까지는 실행문이 없으므로 case4번으로 넘어가서 실행됨
			// System.out.println(weather[0]+ "을 선택하셨습니다.");
			// repeat=false;  //while문 이름지정을 하는 경우 boolean 선언X하므로 repeat=false 입력X
			// break;
				
			case 2:
			case 3:
			case 4:
				System.out.println(weather[choice-1]);
				break outer;
			default :
				System.out.println("1~4 이외의 번호를 입력하셨습니다.");
				
			}
		}  
	}

}
