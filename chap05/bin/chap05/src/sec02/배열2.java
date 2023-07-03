package sec02;

public class 배열2 {

	public static void main(String[] args) {
		
		int[] d = {52,87,94,77,69};   
		int sum=0;
		
		//배열의 전체 합계와 평균을 구하세요
		//평균은 double 타입으로
		//for문 사용
		
		for(int i=0; i<5; i++) {
			sum += d[i];
		}
		System.out.println("총합: " + sum);
		double avg = (double) sum /5 ;
		System.out.println("평균 : "+ avg);
	
		//int a;
		//a+=5;
		//a에 값을 넣어주지 않아 오류
		
		//int[] t;
		//t= {1,2,3};    컴파일 에러 발생(t에 값을 넣어주지 않음)
		
		int[] s=null;
		//s= {1,2,3};    기본타입이 아닌 참조타입이므로 new선언
		s= new int[]{1,2,3};
		int[] p = new int[] {1,2,3}; 
		int[] q = {4,5,6}; 
		System.out.println(p[]);
	
	
	} 

}
