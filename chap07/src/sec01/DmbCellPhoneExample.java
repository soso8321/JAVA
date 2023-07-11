package sec01;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		DmbCellPhone dmbcellPhone = new DmbCellPhone("자바폰", "검정", 10);
		//CellPhone cellphone = new CellPhone(); 
		//CellPhone에서 생성자를 만들지 않았으므로 기본생성자가 자동 생성되므로 위와 같이 입력 가능
		
		System.out.println(dmbcellPhone.model); //상속받은 필드 출력
		
		dmbcellPhone.turnOnDmb(); //자기 메소드 출력
		dmbcellPhone.bell(); //상속받은 메소드 출력
		dmbcellPhone.sendVoice("오늘 방문해도 될까요?");
		dmbcellPhone.receiveVoice("오늘은 오후 7시까지 영업입니다.");
		dmbcellPhone.hangUp();

	}

}
