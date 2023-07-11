package sec01.exam02;

public class Student extends People {
	public int studentNo; //학번
	
	public Student(String name, String ssn, int studentNo) {
		super(name,ssn); //부모 생성자 호출(기본적으로는 default를 호출)
		this.studentNo = studentNo;
		
	}

}
