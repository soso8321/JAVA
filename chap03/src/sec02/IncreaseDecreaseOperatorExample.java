package sec02;

public class IncreaseDecreaseOperatorExample {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("-------------------------");
		x++;
		++x;
		System.out.println("x=" + x);  //12
		
		System.out.println("-------------------------");
		y--;
		--y;
		System.out.println("y=" + y);  //8
		
		System.out.println("-------------------------");
		z = x++;  
		System.out.println("z=" + z);  //12
		System.out.println("x=" + x);  //13
		
		//x=13, y=8, z=12
		
		System.out.println("-------------------------");
		z = ++x;  
		System.out.println("z=" + z);  //14
		System.out.println("x=" + x);  //14
		
		
		//x =14, y=8, z=14
		System.out.println("-------------------------");
		z = ++x + y++;   //z=15+8 -> z=23, y=9, x=15
		System.out.println("z=" + z);  //23
		System.out.println("x=" + x);  //15
		System.out.println("y=" + y);  //9
		
		
	}

}
