package sec02;

import java.util.Scanner;

public class �������迭2�ٽ�Ȯ�� {

	public static void main(String[] args) {
	 Scanner s = new Scanner(System.in);
	 
	 System.out.println("�̸��� �Է��ϼ���");
	 
	 String[] person = new String[3];
	 for(int i=0; i<person.length;i++ ) {
		 System.out.println((i+1) + "��° ��� �̸��� �Է��ϼ���");
		 person[i] = s.next();
	 }
		 
		 
	 int[][] num = new int[3][2]; //3�� 2ĭ ¥�� �迭 ����
	 double[] result = new double[3]; // ��հ��� �����ϱ� ���� �迭 ����
	 for(int i=0; i<num.length; i++) {
			 int sum = 0; //����� �ٲ� ������ �հ谪 �ʱ�ȭ(����X)
			 
			 for(int j=0; j<num[i].length; j++) {
				 
				 if(j==0) { //ù��° �Է°��̸� �߰����, �ι�° �Է°��̸� �⸻���
				 System.out.println(person[i]+ "�� �߰������� �Է��ϼ���");
				 }else {
					 System.out.println(person[i]+ "�� �⸻������ �Է��ϼ���");
				 }
				 num[i][j] = s.nextInt(); // ���� ��ġ�� �� ����
				 sum+=num[i][j]; //�� ����� �հ谪 ���
			 //sum+=num[i][0]; // �� ����� �߰���� �հ谪 ���
		 } 
			 result[i] = (double)sum/2; //������ ��հ� ���� �� result �迭�� ����
			 
			//double avg = (double)sum/2; // �� ����� ��հ� ��� �� ���
			//System.out.println(person[i] + "�� ��� ������ " + avg + "�Դϴ�");
	 }
	 // 3���� ��հ� ���
	 for(int i=0; i<3; i++) {
		 System.out.println(person[i] + "�� ��������� " +result[i] + "�Դϴ�.");
	 }

	}

}
