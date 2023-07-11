package sec01;

public class StudentExample {

	public static void main(String[] args) {

		
		Student student = new Student(20213, "남", 183 );
		
		
		System.out.println(student.gender +"학생/ 학번 "+ student.studentCode + "의 오늘 일과");
		System.out.println("");
		student.sleep(); //부모 메소드 호출
		student.awake(); //부모 메소드 호출
		student.study("독서실"); //자기 메소드 호출
		String result = student.eat("갈비탕");
		System.out.println(result);
		student.sleep(); //부모 메소드 호출
		

		
		
	}

}
