package sec02;

public class 배열복사3 {

	public static void main(String[] args) {
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];

		System.arraycopy(oldIntArray, 0, newIntArray, 0, oldIntArray.length);
		//복사할 배열, 시작점, 복사될 배열, 시작점, 복사할 배열 갯수
		
		for (int i = 0; i < newIntArray.length; i++) {
			if (i < newIntArray.length - 1) {
				System.out.print(newIntArray[i] + ",");

			} else {
				System.out.println(newIntArray[i]);

			}
		}

	}

}
