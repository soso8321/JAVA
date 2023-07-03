package sec01.exam01;

public class 변수사용범위 {

	public static void main(String[] args) {
		
		String a= ""; 
		String b;
		
		
		int v1 = 15;
		int v2 = 0;
		if (v1 > 10) {
			v2 = v1 - 10;
		}
		int v3 = v1 + v2 + 5;
		System.out.println(v3);

		
	}

}
