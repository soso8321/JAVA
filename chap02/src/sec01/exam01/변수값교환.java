package sec01.exam01;

public class ��������ȯ {

	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		System.out.println("x:" + x + ", y:" + y);

		int temp = x;
//    	temp���� x��� ���� (x=3)
		x = y;
//		x���� y�� ������ (y=5)
		y= temp;
//		
		System.out.println("x:" + x + ", y:" + y);
//		�ش� ������ ���� x�� y�� ���� ��ü�ϴ� ������
	}

}
