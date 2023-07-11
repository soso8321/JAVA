package sec03;

public class Card다시확인 {

	private String cardName;
	
	public Card다시확인() {
		this("현대"); //다른생성자 호출
	}
	
	public Card다시확인(String cardName) {
		this.cardName = cardName;
	}
	
	public void getCard() {
		System.out.println("카드사는 " + this.cardName +"입니다.");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Card다시확인 card1 = new Card다시확인();
		Card다시확인 card2 = new Card다시확인("삼성");
		
		card1.getCard();
		card2.getCard();
		

	}

}
