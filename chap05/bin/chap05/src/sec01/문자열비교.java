package sec01;

import java.util.Scanner;

public class ���ڿ��� {

	public static void main(String[] args) {
		String var1 = "ȫ�浿";
		String var2 = "ȫ�浿";

		if (var1 == var2) {
			System.out.println("�� ������ ������ ���ƿ�");
		} else {
			System.out.println("�� ������ ������ �޶��");
		}
		Scanner s = new Scanner(System.in);
		String a = s.next();
		String b = s.next();

		if (a == b) {
			System.out.println("�� ������ ������ ���ƿ�");
		} else {
			System.out.println("�� ������ ������ �޶��");
		}

		String var3 = new String("ȫ�浿");
		String var4 = new String("ȫ�浿");
		if(var3==var4) {
			System.out.println("�� ������ ������ ���ƿ�");
		} else {
			System.out.println("�� ������ ������ �޶��");
		}
	}

}
