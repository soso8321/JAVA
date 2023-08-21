package sec03;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;

public class BlockGame {

	static class MyFrame extends JFrame {
		// ��� constant����(�빮��)
		static final int BALL_WIDTH = 20;
		static final int BALL_HEIGTH = 20;
		static final int BLOCK_ROWS = 5; // 5��`
		static final int BLOCK_COLUMNS = 10; // ���ٿ� 10��
		static final int BLOCK_WIDTH = 40; // ���� �ʺ�
		static final int BLOCK_HEIGHT = 20; // ���� ����
		static final int BLOCK_GAP = 3; // ������ ����
		static final int BAR_WIDTH = 80; // �� �ʺ�
		static final int BAR_HEIGHT = 20; // �� ����
		static final int CANVAS_WIDTH = 400 + (BLOCK_GAP * BLOCK_COLUMNS) - BLOCK_GAP; 
		// ȭ�� �ʺ� = (�����ʺ�*���ٿ� ����) + (����������* ���ٿ� ����) - �� ���� �� ���� �ʿ�����Ƿ�
		static final int CANVAS_HEIGHT = 600; // ȭ�� ����

		// ���� variable����
		static MyPanel myPanel = null;
		static int score = 0;
		static Timer timer = null;
		static Block[][] blocks = new Block[BLOCK_ROWS][BLOCK_COLUMNS];// 5��*10��
		static Bar bar = new Bar();
		static Ball ball = new Ball();
		static int barXTarget = bar.x; // Ű�����Է����� �¿�����̵� �� �� �� �ε巴�� �̵�  
		static int dir = 0; // 0: ��������, 1:�����ʾƷ�, 2:������, 3:���ʾƷ� �밢������ ���� �̵��ϴ� ���Ⱚ
		static int ballspeed = 5; // ���� �����̴� �ӵ�
		static boolean isGameFinish = false;

		static class Ball {
			int x = CANVAS_WIDTH / 2 - BALL_WIDTH / 2; // ���ο��� �߾ӿ� �������� (��ü �ʺ�-���ǳʺ�)/2
			int y = CANVAS_HEIGHT / 2 - BALL_HEIGTH / 2; // ���ο��� �߾ӿ� �������� (��ü ����-���ǳ���)/2
			int width = BALL_WIDTH; // ���� �ʺ�
			int height = BALL_HEIGTH; // ���� ����

			// Point Ŭ�������� X,Y ����
			Point getCenter() {
				// ball�� ���߾� ��
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGTH / 2));
			}
			Point getBottomCenter() {
				// ball�� �߾ӾƷ� ��
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGTH));
			}
			Point getTopCenter() {
				// ball�� �߾��� ��
				return new Point(x + (BALL_WIDTH / 2), y);
			}
			Point getLeftCenter() {
				// ball�� �����߾� ��
				return new Point(x, y + (BALL_HEIGTH));
			}
			Point getRightCenter() {
				// ball�� �������߾� ��
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGTH));
			}
		}

		static class Bar {
			int x = CANVAS_WIDTH / 2 - BAR_WIDTH / 2; // ���ο��� �߾ӿ� �������� (��ü �ʺ�-���ǳʺ�)/2
			int y = CANVAS_HEIGHT - 100; // ��ü 600���̿��� 100 ������ ���̷� bar ��ġ��
			int width = BAR_WIDTH; // �� �ʺ�
			int height = BAR_HEIGHT; // �� ����
		}

		static class Block {
			int x = 0; // ������ �������̹Ƿ� �ѹ��� ���� ������ �� ���� 0���� �ʱ�ȭ�ϰ� �Ŀ� for������ ��ġ ��������
			int y = 0;
			int width = BLOCK_WIDTH; // ���� �ʺ�
			int height = BLOCK_HEIGHT; // ���� ����
			int color = 0; // 0=white(5), 1=yellow(10), 2=blue(15), 3=magenta(20), 4=red(5) ��������(ȹ������)
			boolean isHidden = false; // �浹����=�浹�� ������ �����
		}

		public void initData() { // ������ �ʱ�ȭ
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					blocks[i][j] = new Block();
					blocks[i][j].x = BLOCK_WIDTH * j + BLOCK_GAP * j; // x(���� ��ġ)=�ش� ���� ���° �������� ���� x���� �������Ƿ�..
					blocks[i][j].y = 100 + BLOCK_HEIGHT * i + BLOCK_GAP * i; // x(���� ��ġ)= �� ���� ����(100)+���° �������� ���� y����
																				// �޶���
					blocks[i][j].width = BLOCK_WIDTH;
					blocks[i][j].height = BLOCK_HEIGHT;
					blocks[i][j].color = 4 - i; // 0=white(5), 1=yellow(10), 2=blue(15); 3=mazanta(20), 4=red(10) �ະ
												// ��������
					blocks[i][j].isHidden = false; // �ʱ�ȭ �ܰ迡�� �����浹�� �����Ƿ� ��� ����
				}
			}

		}

		// ĵ������ �׸� panel��ü ����
		static class MyPanel extends JPanel {
			public MyPanel() {
				this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT); // �г� ������� ĵ����ũ��� ����
				this.setBackground(Color.BLACK);// ������ ����
			}

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D) g;

				drawUI(g2d);
			}

			// ȭ�鿡 ǥ��(draw)��
			private void drawUI(Graphics2D g2d) {
				for (int i = 0; i < BLOCK_ROWS; i++) { // ���� ��
					for (int j = 0; j < BLOCK_COLUMNS; j++) { // ���� ĭ(��)
						if (blocks[i][j].isHidden) {
							continue; // ����浹�� �Ͼ�ٸ� ���� ǥ���� �ʿ䰡 �����Ƿ�..
						} else {
							if (blocks[i][j].color == 0) {
								g2d.setColor(Color.WHITE);
							} else if (blocks[i][j].color == 1) {
								g2d.setColor(Color.YELLOW);
							} else if (blocks[i][j].color == 2) {
								g2d.setColor(Color.BLUE);
							} else if (blocks[i][j].color == 3) {
								g2d.setColor(Color.MAGENTA);
							} else if (blocks[i][j].color == 4) {
								g2d.setColor(Color.RED);
							}
						} // ������(x,y) ��ǥ�� �ʺ�width, ����height ũ��� �簢���� �׸�
						g2d.fillRect(blocks[i][j].x, blocks[i][j].y, blocks[i][j].width, blocks[i][j].height);
					}
					// scoreǥ��
					g2d.setColor(Color.WHITE);
					g2d.setFont(new Font("Arial", Font.BOLD, 20));
					g2d.drawString("score : " + score, CANVAS_WIDTH / 2 - 30, 20);
					// ������ ��� Ŭ�����ؼ� ������ ����Ǹ� Game Over!���������� ���
					if (isGameFinish) {
						g2d.setColor(Color.RED);
						g2d.drawString("Game Over!", CANVAS_WIDTH / 2 - 55, 50);
					}

					// ballǥ��
					g2d.setColor(Color.WHITE);
					g2d.fillOval(ball.x, ball.y, BALL_WIDTH, BALL_HEIGTH);
					// barǥ��
					g2d.setColor(Color.GRAY);
					g2d.fillRect(bar.x, bar.y, bar.width, bar.height);
				}
			}
		}

		// ������
		public MyFrame(String title) {
			super(title);
			this.setVisible(true); // ȭ�鿡 ���̰�
			this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT); // ȭ�� �ʺ�� ���̴� ĵ���� ������� �����ϰ�
			this.setLocation(400, 150); // â�� ����Ϳ��� ��Ÿ���� ��ġ
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x�� ������ �� ����

			initData();

			myPanel = new MyPanel(); // �г� ����
			this.add("Center", myPanel); // �г� �߾ӿ� �ֱ�

			setKeyListener();
			startTimer();
			StartAudio();
			BackgroundAudio();
			
		}

		public void setKeyListener() { // Ű����� ���� �ϼ� �ְ�
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("Pressed Left Key");
						barXTarget -= 20;
						if (bar.x < barXTarget) { // ��� Ű�� ��������
							barXTarget = bar.x;
						}
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("Pressed Right Key");
						barXTarget += 20;
						if (bar.x > barXTarget) {
							barXTarget = bar.x;
						}
					}
				}
			});
		}
		
		public void startTimer() { //
			timer = new Timer(20, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { // Timer Event
					movement();
					checkCollision(); // ��, �ٿ� ball �浹�� ���� �� �޼ҵ�
					checkCollisionBlock(); // ���� 50��(5��*10��)�� �浹�� ���� �� �޼ҵ�
					myPanel.repaint(); // Redraw
					isGameFinish();
				}
				
			});
			timer.start();
		}

		// Game Success!
		public void isGameFinish() {
			int count = 0;
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					Block block = blocks[i][j];
					// ������ �浹�� ����� ������ count�� ����
					if (block.isHidden) {
						count++;
					}
				}
			}
			// count���� ��������(5��*10��) ��50���� �Ǹ� game�� ����
			if (count == BLOCK_ROWS * BLOCK_COLUMNS) {
				// timer.stop();timer�� draw�ϹǷ� ����
				isGameFinish = true;
			}
		}

		public void movement() {
			if (bar.x < barXTarget) {
				bar.x += 5;
			} else if (bar.x > barXTarget) {
				bar.x -= 5;
			}
			if (dir == 0) { // 0: �������� �������� �̵�
				ball.x += ballspeed;
				ball.y -= ballspeed;
			} else if (dir == 1) { // 1: �����ʾƷ� �������� �̵�
				ball.x += ballspeed;
				ball.y += ballspeed;
			} else if (dir == 2) { // 2: ������ �������� �̵�
				ball.x -= ballspeed;
				ball.y -= ballspeed;
			} else if (dir == 3) { // 3: ���ʾƷ� �������� �̵�
				ball.x -= ballspeed;
				ball.y += ballspeed;
			}
		}
		// �浹���� üũ(�ΰ��� �簢���� �ߺ����� �ʴ��� Ȯ��)
		public boolean duplRect(Rectangle rect1, Rectangle rect2) {
			return rect1.intersects(rect2);
		}

		public void checkCollision() {
			if (dir == 0) { // 0: �������� �������� �̵�
				// ���� ���� �浹�� ���
				if (ball.y < 0) {
					dir = 1; // �����ʾƷ� �������� �̵�
				}
				// ������ ���� �浹�� ���
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) {
					dir = 2; // ������ �������� �̵�
				}
				// ���� �̵��ϱ� ������ bar�� �浹�� ��찡 �����Ƿ� �浹 ó��none

			} else if (dir == 1) { // 1: �����ʾƷ� �������� �̵�
				// �Ʒ��� ���� �浹�� ���
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGTH - BALL_HEIGTH) {
					BottomCollisionAudio();
					dir = 0; // �������� �������� �̵�

					// game reset
					dir = 0;
					ball.x = CANVAS_WIDTH / 2 - BALL_WIDTH / 2;
					ball.y = CANVAS_HEIGHT / 2 - BALL_HEIGTH / 2;
					score = 0;
				}
				// ������ ���� �浹�� ���
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) {
					dir = 3; // ���ʾƷ� �������� �̵�
				}
				// �Ʒ��� �̵��ϱ� ������ bar�� �浹�� ���) ball�� �߾ӾƷ��ʰ��� bar�� ���� ������ ũ��
				if (ball.getBottomCenter().y >= bar.y) {
					//ball�� bar�� �浹�� �Ͼ�ٸ�
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 0; // �������� �������� �̵�
					}
				}

			} else if (dir == 2) { // 2: ������ �������� �̵�
				// ���� ���� �浹�� ���
				if (ball.y < 0) {
					dir = 3; // ���ʾƷ� �������� �̵�
				}
				// ���� ���� �浹�� ���
				if (ball.x < 0) {
					dir = 0; // �������� �������� �̵�
				}
				// ���� �̵��ϱ� ������ bar�� �浹�� ��찡 �����Ƿ� �浹 ó��none

			} else if (dir == 3) { // 3: ���ʾƷ� �������� �̵�
				// �Ʒ��� ���� �浹�� ���
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGTH - BALL_HEIGTH) {
					BottomCollisionAudio();
					dir = 2; // �������� �̵�
					
					// game reset
					dir = 0;
					ball.x = CANVAS_WIDTH / 2 - BALL_WIDTH / 2;
					ball.y = CANVAS_HEIGHT / 2 - BALL_HEIGTH / 2;
					score = 0;
				}
				// ���� ���� �浹�� ���
				if (ball.x < 0) {
					dir = 1; // �����ʾƷ� �������� �̵�
				}
				// �Ʒ��� �̵��ϱ� ������ bar�� �浹�� ���) ball�� �߾ӾƷ��ʰ��� bar�� ���� ������ ũ��
				if (ball.getBottomCenter().y >= bar.y) {
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 2; // ������ �������� �̵�
					}
				}
			}
		}
		
		//����� �޼ҵ�
		public static void BackgroundAudio() {
            try {
         	   File file = new File("src/audio/Background.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.start();
            } catch (Exception e) {
                System.err.println("Put the music.wav file in the sound folder "
                		+ "if you want to play background music, only optional!");
            }
        }
		//ó�� ���� ȿ���� �޼ҵ�
		public static void StartAudio() {
            try {
         	   File file = new File("src/audio/Start.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.start();
            } catch (Exception e) {
                System.err.println("Put the music.wav file in the sound folder "
                		+ "if you want to play background music, only optional!");
            }
        }
		
		//�Ʒ��� ���� �浹�� ȿ���� �޼ҵ�
		 public static void BottomCollisionAudio() {
            try {
         	   File file = new File("src/audio/OhNo.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.start();
            } catch (Exception e) {
                System.err.println("Put the music.wav file in the sound folder "
                		+ "if you want to play background music, only optional!");
            }
        }
		
		//���� �浹�� ȿ���� �޼ҵ�
		 public static void CollisionBlockAudio() {
             try {
          	   File file = new File("src/audio/collision.wav");
                 Clip clip = AudioSystem.getClip();
                 clip.open(AudioSystem.getAudioInputStream(file));
                 clip.start();
             } catch (Exception e) {
                 System.err.println("Put the music.wav file in the sound folder "
                 		+ "if you want to play background music, only optional!");
             }
         }
		
		// ball�� ������ �浹�� ��� �޼ҵ�(0: ��������, 1:�����ʾƷ�, 2:������, 3:���ʾƷ� �밢������ ���� �̵��ϴ� ���Ⱚ)
		public void checkCollisionBlock() {
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					Block block = blocks[i][j];
					// �浹�� ������ ����� ������ �ƴѰ��
					if (block.isHidden == false) {
						if (dir == 0) { // 0: �������� �������� �̵�
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								// ������ �Ʒ��ʿ� �浹�� ���(ball�� �߾Ӱ��� ���� �Ʒ��ʿ� �浹�ϴ� ���̹Ƿ� �뷫2�� ���)
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
									dir = 1; // �����ʾƷ� �������� �̵�
								} // ������ ���ʿ� �浹�� ���
								else {
									dir = 2; // ������ �������� �̵�
								}
								// ������ �浹�� ��� ������ ������鼭 ���� ���� ���� ���� ����
								block.isHidden = true; // ���� �����
								// ���� ���򸶴� ������ �ٸ��� ��
								if (block.color == 0) {
									score += 5;
									CollisionBlockAudio();
								} else if (block.color == 1) {
									score += 10;
									CollisionBlockAudio();
								} else if (block.color == 2) {
									score += 15;
									CollisionBlockAudio();
								} else if (block.color == 3) {
									score += 20;
									CollisionBlockAudio();
								} else if (block.color == 4) {
									score += 10;
									CollisionBlockAudio();
								}
							}

						} else if (dir == 1) {
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
									dir = 0;
								} else {
									dir = 3;
								}
								// ������ �浹�� ��� ������ ������鼭 ���� ���� ���� ���� ����
								block.isHidden = true;
								if (block.color == 0) {
									score += 5;
									CollisionBlockAudio();
								} else if (block.color == 1) {
									score += 10;
									CollisionBlockAudio();
								} else if (block.color == 2) {
									score += 15;
									CollisionBlockAudio();
								} else if (block.color == 3) {
									score += 20;
									CollisionBlockAudio();
								} else if (block.color == 4) {
									score += 10;
									CollisionBlockAudio();
								}
							}
						} else if (dir == 2) {
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
									dir = 3;
								} else {
									dir = 0;
								}
								// ������ �浹�� ��� ������ ������鼭 ���� ���� ���� ���� ����
								block.isHidden = true;
								if (block.color == 0) {
									score += 5;
									CollisionBlockAudio();
								} else if (block.color == 1) {
									score += 10;
									CollisionBlockAudio();
								} else if (block.color == 2) {
									score += 15;
									CollisionBlockAudio();
								} else if (block.color == 3) {
									score += 20;
									CollisionBlockAudio();
								} else if (block.color == 4) {
									score += 10;
									CollisionBlockAudio();
								}
							}

						} else if (dir == 3) {
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
									dir = 2;
								} else {
									dir = 1;
								}
								// ������ �浹�� ��� ������ ������鼭 ���� ���� ���� ���� ����
								block.isHidden = true;
								if (block.color == 0) {
									score += 5;
									CollisionBlockAudio();
								} else if (block.color == 1) {
									score += 10;
									CollisionBlockAudio();
								} else if (block.color == 2) {
									score += 15;
									CollisionBlockAudio();
								} else if (block.color == 3) {
									score += 20;
									CollisionBlockAudio();
								} else if (block.color == 4) {
									score += 10;
									CollisionBlockAudio();
								}
							}

						}
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		new MyFrame("��������");

	}

}
