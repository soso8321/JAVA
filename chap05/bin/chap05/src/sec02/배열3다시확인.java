package sec02;

public class �迭3�ٽ�Ȯ�� {

	public static void main(String[] args) { //'void' return���� ������ �ǹ�, ���� ���
		int[] scores; //�ۿ��� ���� �� �ٽ� ��� ����
		scores = new int[] {83,90,87};
		
		//int[] scores = {83,90,87}; �����ؼ� ��� ������
		
		int sum1 = 0;
		for(int i=0; i<3; i++) {
			sum1 += scores[i];
			
		} System.out.println("���� : " + sum1);
		
		int sum2 = add(new int[] {83,90,87});  //main�޼ҵ忡�� add�޼ҵ� ȣ���Ͽ� int�迭���� �Ѱ��� => add�޼ҵ� �����ʿ�
		System.out.println("���� : " + sum2);
		System.out.println();
 	} //main���� ����

	public static int add(int[] scores) { //int�� return �ϴ� ���� add(int[] scores)Ÿ���� int�̹Ƿ�
		int sum=0;
		for(int i=0; i<3; i++) {
			sum += scores[i];
		}
		return sum;
	}
	
}
