package sec03;

public class Board {

	String title;
	String content;
	String writer;
	String date;
	int hitcount;
	
	Board() {
		
	}
	
	Board(String title, String content) {
		this.title = title;
		this.content = content;
		this.writer = "�α����� ȸ�����̵�";
		this.date = "���� ��ǻ�� ��¥";
		this.hitcount = 0;
	}

	
	Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = "���� ��ǻ�� ��¥";
		this.hitcount = 0;
	}

	public Board(String title, String content, String writer, String date) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = 0;
	}


	public Board(String title, String content, String writer, String date, int hitcount) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = hitcount;
	}
	
}
