package sec01;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		DmbCellPhone dmbcellPhone = new DmbCellPhone("�ڹ���", "����", 10);
		//CellPhone cellphone = new CellPhone(); 
		//CellPhone���� �����ڸ� ������ �ʾ����Ƿ� �⺻�����ڰ� �ڵ� �����ǹǷ� ���� ���� �Է� ����
		
		System.out.println(dmbcellPhone.model); //��ӹ��� �ʵ� ���
		
		dmbcellPhone.turnOnDmb(); //�ڱ� �޼ҵ� ���
		dmbcellPhone.bell(); //��ӹ��� �޼ҵ� ���
		dmbcellPhone.sendVoice("���� �湮�ص� �ɱ��?");
		dmbcellPhone.receiveVoice("������ ���� 7�ñ��� �����Դϴ�.");
		dmbcellPhone.hangUp();

	}

}
