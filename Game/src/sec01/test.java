
package sec01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JFrame implements KeyListener {
	
	private Image offScreenImage; // ���� ���۸��� ���� �̹���
	private Graphics offScreenGraphics; // ���� ���۸��� ���� �׷��Ƚ� ��ü

	private Image backgroundImage = new ImageIcon("src/images/background.jpg").getImage();
	private Image player = new ImageIcon("src/images/kirbyRightStop.png").getImage();
	private Image grape = new ImageIcon("src/images/grape1.png").getImage();
	private Image banana = new ImageIcon("src/images/banana1.png").getImage();

	private int playerX, playerY;
	private int playerWidth = player.getWidth(null);
	private int playerHeight = player.getHeight(null);
	private int grapeX, grapeY;
	private int grapeWidth = grape.getWidth(null);
	private int grapeHeight = grape.getHeight(null);
	private int bananaX, bananaY;
	private int bananaWidth = banana.getWidth(null);
	private int bananaHeight = banana.getHeight(null);

	private int score;
	private int bananaSpeed = 20;
	private int grapeSpeed = 30;
	private int bananaCount = 1;  // �ʱ� �ٳ��� �������� ����
    private int grapeCount = 1;   // �ʱ� ���� �������� ����
    private int bananaFallingCounter = 0;
    private int grapeFallingCounter = 0;

	private JPanel gamePanel; // ���� �׸��� �׸� JPanel
	
	private void updateOffScreenImage() {
	    if (offScreenImage == null) {
	        offScreenImage = createImage(getWidth(), getHeight());
	        offScreenGraphics = offScreenImage.getGraphics();
	    }

	    offScreenGraphics.setColor(getBackground());
	    offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

	    draw(offScreenGraphics);
	}
	
	public test() {
		setTitle("������� ���Ӹ����");
		setVisible(true);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 gamePanel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                draw(g);
	            }
	        };
	        add(gamePanel);

	        addKeyListener(this);
	        setFocusable(true);
	        setFocusTraversalKeysEnabled(false);

	        Init();
	        
//	        gamePanel.repaint(); // �ʱ�ȭ �� �ٷ� �׸����� ����
//	        draw(gamePanel.getGraphics()); // �ʱ� ȭ�鿡 score�� ���̵��� draw �޼ҵ� ȣ��
	    }

	public void Init() {
		score = 0;
		playerX = 10;
		playerY = 550;

		grapeX = (int) (Math.random() * (501 - playerWidth));
		grapeY = (int) (Math.random() * (501 - playerHeight));

		bananaX = (int) (Math.random() * (501 - playerWidth));
		bananaY = (int) (Math.random() * (501 - playerHeight));
	}

	@Override
	public void paint(Graphics g) {
        updateOffScreenImage();
        g.drawImage(offScreenImage, 0, 0, this);

        // �ٳ����� ������ �������� ������ ó��
        bananaFallingCounter++;
        if (bananaFallingCounter >= bananaSpeed) {
            bananaFallingCounter = 0;
            for (int i = 0; i < bananaCount; i++) {
                bananaX = (int) (Math.random() * (getWidth() - bananaWidth));
                bananaY = 0;
            }
        }

        grapeFallingCounter++;
        if (grapeFallingCounter >= grapeSpeed) {
            grapeFallingCounter = 0;
            for (int i = 0; i < grapeCount; i++) {
                grapeX = (int) (Math.random() * (getWidth() - grapeWidth));
                grapeY = 0;
            }
        }
    }
	
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		draw(g); // draw �޼ҵ带 ȣ���Ͽ� �׸��� �׸�
//	}

	public void draw(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(player, playerX, playerY, null);
		g.drawImage(grape, grapeX, grapeY, null);
		g.drawImage(banana, bananaX, bananaY, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("SCORE : " + score, 10, 30);
	}

	public static void main(String[] args) {
		new test();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT && playerX > 0) {
			playerX -= 10;
		} else if (key == KeyEvent.VK_RIGHT && playerX < getWidth() - playerWidth) {
			playerX += 10;
		} else if (key == KeyEvent.VK_UP && playerY > 0) {
			playerY -= 10;
		} else if (key == KeyEvent.VK_DOWN && playerY < getHeight() - playerHeight) {
			playerY += 10;
		}

		// �÷��̾�� ���� �浹 �˻�
		if (playerX < grapeX + grapeWidth && playerX + playerWidth > grapeX && playerY < grapeY + grapeHeight
				&& playerY + playerHeight > grapeY) {
			score += 10;
			grapeX = (int) (Math.random() * (getWidth() - playerWidth));
			grapeY = (int) (Math.random() * (getHeight() - playerHeight));
		}

		if (playerX < bananaX + bananaWidth && playerX + playerWidth > bananaX && playerY < bananaY + bananaHeight
				&& playerY + playerHeight > bananaY) {
			score -= 5;
			bananaX = (int) (Math.random() * (getWidth() - playerWidth));
			bananaY = (int) (Math.random() * (getHeight() - playerHeight));
		}
		
		// �÷��̾� ��ġ�� ȭ���� ����� �ʵ��� ����
	    playerX = Math.max(playerX, 0);
	    playerX = Math.min(playerX, getWidth() - (playerWidth+20));
	    playerY = Math.max(playerY, 0);
	    playerY = Math.min(playerY, getHeight() - (playerHeight+40));
		
		
		// �ٳ��� ��ġ�� ȭ���� ����� �ʵ��� ����
	    bananaX = Math.max(bananaX, 0);
	    bananaX = Math.min(bananaX, getWidth() - (bananaWidth+20));
	    bananaY = Math.max(bananaY, 0);
	    bananaY = Math.min(bananaY, getHeight() - (bananaHeight+30));

	    // ���� ��ġ�� ȭ���� ����� �ʵ��� ����
	    grapeX = Math.max(grapeX, 0);
	    grapeX = Math.min(grapeX, getWidth() - (grapeWidth+20));
	    grapeY = Math.max(grapeY, 0);
	    grapeY = Math.min(grapeY, getHeight() - (grapeHeight+30));


		 gamePanel.repaint(); // draw �޼ҵ带 ȣ���Ͽ� �׸��� �ٽ� �׸�
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// �� �޼ҵ�� ������� ����
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// �� �޼ҵ�� ������� ����
	}
}