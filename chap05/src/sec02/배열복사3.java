package sec02;

public class �迭����3 {

	public static void main(String[] args) {
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];

		System.arraycopy(oldIntArray, 0, newIntArray, 0, oldIntArray.length);
		//������ �迭, ������, ����� �迭, ������, ������ �迭 ����
		
		for (int i = 0; i < newIntArray.length; i++) {
			if (i < newIntArray.length - 1) {
				System.out.print(newIntArray[i] + ",");

			} else {
				System.out.println(newIntArray[i]);

			}
		}

	}

}
