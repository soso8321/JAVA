package sec03;

public class Card�ٽ�Ȯ�� {

	private String cardName;
	
	public Card�ٽ�Ȯ��() {
		this("����"); //�ٸ������� ȣ��
	}
	
	public Card�ٽ�Ȯ��(String cardName) {
		this.cardName = cardName;
	}
	
	public void getCard() {
		System.out.println("ī���� " + this.cardName +"�Դϴ�.");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Card�ٽ�Ȯ�� card1 = new Card�ٽ�Ȯ��();
		Card�ٽ�Ȯ�� card2 = new Card�ٽ�Ȯ��("�Ｚ");
		
		card1.getCard();
		card2.getCard();
		

	}

}
