package sec01;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;

public class BricksAndLadders extends JFrame {
	// 더블 버퍼링을 활용하기 위한 변수 선언
	private Image screenImage;
	private Graphics screenGraphic;
	
	//스테이지 생성
	public static Stage stage = new Stage();
	
	//알피 캐릭터 생성
	public static Alfy alfy = new Alfy();
	
	// 사용할 이미지파일
	private Image background = new ImageIcon(Main.class.getResource("background.png")).getImage();
	private Image brick = new ImageIcon(Main.class.getResource("brick.jpg")).getImage();
	private Image brick8 = new ImageIcon(Main.class.getResource("brick.jpg")).getImage();
	private Image ladder1 = new ImageIcon(Main.class.getResource("ladder1.png")).getImage();
	
	//생성자
	public BricksAndLadders() {
		//타이틀 바에 띄울 이름 설정
		setTitle("Bricks and Ladders");
		//화면 크기 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//크기변경 가능 여부 설정
		setResizable(false);
		//실행 시 화면 띄울 위치 설정(가운데)
		setLocationRelativeTo(null);
		//화면을 닫으면 프로그램도 같이 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에 보이게 함
		setVisible(true);

		//알피 초기 설정
		alfy.setPosition(165, 425);
		alfy.setDirection("left");
		alfy.setState(alfy.getAlfyLeftMove());
		
		//각 객체의 스레드 실행
		stage.start();
	}
	
	public void paint(Graphics g) {
		//오프스크린 생성
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//생성한 오프스크린에 대하여 Graphics 객체 생성
		screenGraphic = screenImage.getGraphics();
		//생성한 screenGraphic 객체를 이용하여 오프스크린에 그림
		screenDraw(screenGraphic);
		//오프스트린에 그린 내용을 실제 화면에 그림
		g.drawImage(screenImage, 0, 0, null);
		
		}
	
	public void screenDraw(Graphics g) {
		// Map을 오프스크린에 그림
		g.drawImage(background, 0, 0, null);
		g.drawImage(brick, 8, 550, null);
		g.drawImage(brick, 856, 550, null);
		g.drawImage(brick, 1063, 380, null);
		g.drawImage(brick8, 109, 220, null);
		g.drawImage(brick8, 643, 220, null);
		g.drawImage(ladder1, 316, 241, null);
	
		//템 몹을 오프스크린에 그림
		stage.drawItems(g);
		
		//반복해서 알피 그리기
		g.drawImage(alfy.getState(), alfy.getPos_x(), alfy.getPos_Y(), null);
		
		//paint() 함수로 돌아감
		this.repaint();
	}
	
}
