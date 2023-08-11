package sec01;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;

public class BricksAndLadders extends JFrame {
	// ���� ���۸��� Ȱ���ϱ� ���� ���� ����
	private Image screenImage;
	private Graphics screenGraphic;
	
	//�������� ����
	public static Stage stage = new Stage();
	
	//���� ĳ���� ����
	public static Alfy alfy = new Alfy();
	
	// ����� �̹�������
	private Image background = new ImageIcon(Main.class.getResource("background.png")).getImage();
	private Image brick = new ImageIcon(Main.class.getResource("brick.jpg")).getImage();
	private Image brick8 = new ImageIcon(Main.class.getResource("brick.jpg")).getImage();
	private Image ladder1 = new ImageIcon(Main.class.getResource("ladder1.png")).getImage();
	
	//������
	public BricksAndLadders() {
		//Ÿ��Ʋ �ٿ� ��� �̸� ����
		setTitle("Bricks and Ladders");
		//ȭ�� ũ�� ����
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//ũ�⺯�� ���� ���� ����
		setResizable(false);
		//���� �� ȭ�� ��� ��ġ ����(���)
		setLocationRelativeTo(null);
		//ȭ���� ������ ���α׷��� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ȭ�鿡 ���̰� ��
		setVisible(true);

		//���� �ʱ� ����
		alfy.setPosition(165, 425);
		alfy.setDirection("left");
		alfy.setState(alfy.getAlfyLeftMove());
		
		//�� ��ü�� ������ ����
		stage.start();
	}
	
	public void paint(Graphics g) {
		//������ũ�� ����
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//������ ������ũ���� ���Ͽ� Graphics ��ü ����
		screenGraphic = screenImage.getGraphics();
		//������ screenGraphic ��ü�� �̿��Ͽ� ������ũ���� �׸�
		screenDraw(screenGraphic);
		//������Ʈ���� �׸� ������ ���� ȭ�鿡 �׸�
		g.drawImage(screenImage, 0, 0, null);
		
		}
	
	public void screenDraw(Graphics g) {
		// Map�� ������ũ���� �׸�
		g.drawImage(background, 0, 0, null);
		g.drawImage(brick, 8, 550, null);
		g.drawImage(brick, 856, 550, null);
		g.drawImage(brick, 1063, 380, null);
		g.drawImage(brick8, 109, 220, null);
		g.drawImage(brick8, 643, 220, null);
		g.drawImage(ladder1, 316, 241, null);
	
		//�� ���� ������ũ���� �׸�
		stage.drawItems(g);
		
		//�ݺ��ؼ� ���� �׸���
		g.drawImage(alfy.getState(), alfy.getPos_x(), alfy.getPos_Y(), null);
		
		//paint() �Լ��� ���ư�
		this.repaint();
	}
	
}
