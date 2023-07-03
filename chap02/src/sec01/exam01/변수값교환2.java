package sec01.exam01;

public class 변수값교환2 {

	public static void main(String[] args) {
		int a = 10;
		int b = 30;
		int c = 30;

		a = c - a;
		c = a + b + 10;
		b = c + a;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		

	}

}
