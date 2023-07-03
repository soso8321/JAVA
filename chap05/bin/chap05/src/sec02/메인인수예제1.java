package sec02;

public class 메인인수예제1 {

	public static void main(String[] args) {
		if(args.length!=3) { //args 배열의 길이를 지정하였으면 값을 길이만큼 입력해야함 (Run configuration->Argument)
			System.out.println("값의 수가 부족합니다.");
			System.exit(0);
		}
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		

	}

}
