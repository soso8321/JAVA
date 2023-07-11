package sec02;

public class 필드초기값예제1 {

	public static void main(String[] args) {
		필드초기값 fiv = new 필드초기값();
		System.out.println("byteField : " + fiv.byteField);
		System.out.println("shortField : " + fiv.shortField);
		System.out.println("intField : " + fiv.intField);
		System.out.println("longField : " + fiv.longField);
		System.out.println("booleanField : " + fiv.booleanField);
		System.out.println("charField : " + fiv.charField); /* 기본값이X = 아무것도 출력X */
		System.out.println("floatField : " + fiv.floatField);
		System.out.println("doubleField : " + fiv.doubleField);
		System.out.println("arrField : " + fiv.arrField);
		System.out.println("referenceField : " + fiv.referenceField);

	}

}
