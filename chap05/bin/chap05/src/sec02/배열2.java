package sec02;

public class �迭2 {

	public static void main(String[] args) {
		
		int[] d = {52,87,94,77,69};   
		int sum=0;
		
		//�迭�� ��ü �հ�� ����� ���ϼ���
		//����� double Ÿ������
		//for�� ���
		
		for(int i=0; i<5; i++) {
			sum += d[i];
		}
		System.out.println("����: " + sum);
		double avg = (double) sum /5 ;
		System.out.println("��� : "+ avg);
	
		//int a;
		//a+=5;
		//a�� ���� �־����� �ʾ� ����
		
		//int[] t;
		//t= {1,2,3};    ������ ���� �߻�(t�� ���� �־����� ����)
		
		int[] s=null;
		//s= {1,2,3};    �⺻Ÿ���� �ƴ� ����Ÿ���̹Ƿ� new����
		s= new int[]{1,2,3};
		int[] p = new int[] {1,2,3}; 
		int[] q = {4,5,6}; 
		System.out.println(p[]);
	
	
	} 

}
