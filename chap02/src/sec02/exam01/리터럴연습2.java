package sec02.exam01;

public class 리터럴연습2 {

	public static void main(String[] args) {
		byte var1 = 115;
		byte var2 = 0;
		byte var3 = 127;
		// byte var3 = 128; byte 수 표현 범위를 벗어남
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);

		// bit< byte < short < int <iong

		long var4 = 12345678L;
		// long var5 = 10000000000000;
		// 컴파일러가 기본적으로 int로 간주하기에 int 의 범위를 넘어가는 경우 L 붙여야함
		 
		long var6 = 10000000000000L;
		System.out.println(var4);
		// System.out.println(var5);
		System.out.println(var6);

	}

}
