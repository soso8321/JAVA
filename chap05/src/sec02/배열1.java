package sec02;

public class 배열1 {

	public static void main(String[] args) {
		int[] score = { 50, 80, 90 };

		for (int i = 0; i <= score.length; i++) { // 배열의 시작은 0부터 시작이므로 int i=0// i<3으로 입력하면 3자리를 의미함을 표시할 수 있음
			
			if (i < score.length - 1) {
				System.out.print(score[i]+",");
			} else {
				System.out.print(score[i]);
			}
		}

	}

}
