package sec02;

import java.util.Scanner;

public class �迭5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("�迭 ������ �˷��ּ���");
		int arraynum = s.nextInt();
		int[] num1 = new int[arraynum]; //����ڰ� �Է��� ���ڷ� �迭 ���� ����
		// for���� �̿��Ͽ� �迭�� ���ڸ� 1���� ����ڰ� �Է��� ���ڸ�ŭ ������ �߰�
		// �Էµ� �������� ��հ� ���
		
//		int sum = 0;
//		double avg=0;
		System.out.print("\"");
		for(int i = 0; i< arraynum; i++) {
			num1[i] = i + 1;
			System.out.print(num1[i]);  //num1�迭 ���
			if(i!=num1.length-1) {      //�迭����(-1)���� ','��� 
				System.out.print(", ");
			}
		}
		System.out.println("\"");
		int sum = 0;
		double avg = 0;
		for(int j=0; j<arraynum; j++) {
			sum += num1[j];
			avg = (double) sum /arraynum;
		}
		
//		for(int i=0; i < arraynum; i++) {
//			sum += (i+1) ;
//			//num1[i] = i+1; sum�� �������� �ʰ� �迭��
//			//avg = (double)sum/arraynum;
//			//sum = num1[i]
//		} 
//		 avg = sum / arraynum ;
		System.out.println("��� : " + avg);
		
		
	}

}
