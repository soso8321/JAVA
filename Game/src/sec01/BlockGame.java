package sec03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlockGame {

	static class MyFrame extends JFrame {
		
//		x,y (0,0)시작점
//			  . ㅡ ㅡ ㅡ ㅡ
//			  ㅣ
//			  ㅣ
//			  ㅣ
//			  ㅣ                    -width--
//			  . ㅡ ㅡ ㅡ ㅡ          <        > I -height

		// 상수 constant선언(대문자)
		static int BALL_WIDTH = 20;
		static int BALL_HEIGTH = 20;
		static int BLOCK_ROWS = 5; // 5줄`	
		static int BLOCK_COLUMNS = 10; // 한줄에 10개
		static int BLOCK_WIDTH = 40; // 벽돌 너비
		static int BLOCK_HEIGHT = 20; // 벽돌 높이
		static int BLOCK_GAP = 3; // 벽돌간 사이
		static int BAR_WIDTH = 80; // 바 너비
		static int BAR_HEIGHT = 20; // 바 높이
		static int CANVAS_WIDTH = 400 + (BLOCK_GAP * BLOCK_COLUMNS) - BLOCK_GAP; // 화면 너비 = (벽돌너비*한줄에 갯수) + (벽돌간 사이* 한줄에 갯수) - 맨 오른 쪽 갭은 필요없으므로
		static int CANVAS_HEIGHT = 600; // 화면 높이

		// 변수 variable선언
		static MyPanel myPanel = null;
		static int score = 0;
		static Timer timer = null;
		static Block[][] blocks = new Block[BLOCK_ROWS][BLOCK_COLUMNS];// 5줄*10개
		static Bar bar = new Bar();
		static Ball ball = new Ball();
		static int barXTarget = bar.x; // Target Value - interpolation(보관) 바를 키보드 키로 움직일 때 어쩌고저쩌고
		static int dir = 0; // 0: 오른쪽위, 1:오른쪽아래, 2:왼쪽위, 3:왼쪽아래 대각선으로 볼이 이동하는 방향값
		static int ballspeed = 5; // 공이 움직이는 속도
		static boolean isGameFinish=false;

		static class Ball {
			int x = CANVAS_WIDTH / 2 - BALL_WIDTH / 2; // 가로에서 중앙에 오기위해 (전체 너비-공의너비)/2
			int y = CANVAS_HEIGHT / 2 - BALL_HEIGTH / 2; // 세로에서 중앙에 오기위해 (전체 높이-공의높이)/2
			int width = BALL_WIDTH; // 볼의 너비
			int height = BALL_HEIGTH; // 볼의 높이

			//Point 클래스에서 X,Y 가짐
			Point getCenter() {
				//ball의 정중앙 값
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGTH / 2));
			}

			Point getBottomCenter() {
				//ball의 중앙아래 값
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGTH));
			}

			Point getTopCenter() {
				//ball의 중앙위 값
				return new Point(x + (BALL_WIDTH / 2), y);
			}

			Point getLeftCenter() {
				//ball의 왼쪽중앙 값 
				return new Point(x, y + (BALL_HEIGTH));
			}

			Point getRightCenter() {
				//ball의 오른쪽중앙 값 
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGTH));
			}
		}

		static class Bar {
			int x = CANVAS_WIDTH / 2 - BAR_WIDTH / 2; // 가로에서 중앙에 오기위해 (전체 너비-바의너비)/2
			int y = CANVAS_HEIGHT - 100; // 전체 600높이에서 100 떨어진 높이로 bar 위치함
			int width = BAR_WIDTH; // 바 너비
			int height = BAR_HEIGHT; // 바 높이
		}

		static class Block {
			int x = 0; // 벽돌이 여러개이므로 한번에 값을 설정할 수 없어 0으로 초기화하고 후에 for문으로 위치 선정예정
			int y = 0;
			int width = BLOCK_WIDTH; // 벽돌 너비
			int height = BLOCK_HEIGHT; // 벽돌 높이
			int color = 0; // 0=white(5), 1=yellow(10), 2=blue(15), 3=magenta(20), 4=red(5) 벽돌색깔(획득점수)
			boolean isHidden = false; // after collision, block will be hidden.(충돌 후에 블록이 사라짐)

		}

		// 캔버스를 그릴 panel객체 생성
		static class MyPanel extends JPanel {
			public MyPanel() {
				this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT); // 패널 사이즈는 캔버스크기랑 동일
				this.setBackground(Color.BLACK);// 배경색은 검정
			}

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D) g;

				drawUI(g2d);
			}
			//화면에 표시(draw)함
			private void drawUI(Graphics2D g2d) {
				for (int i = 0; i < BLOCK_ROWS; i++) {
					for (int j = 0; j < BLOCK_COLUMNS; j++) {
						if (blocks[i][j].isHidden) {
							continue;
						}

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
						g2d.fillRect(blocks[i][j].x, blocks[i][j].y, blocks[i][j].width, blocks[i][j].height);
					}
					// score표시
					g2d.setColor(Color.WHITE);
					g2d.setFont(new Font("Arial", Font.BOLD, 20));
					g2d.drawString("score : " + score, CANVAS_WIDTH / 2 - 30, 20);
					//벽돌을 모두 클리어해서 게임이 종료되면 Game Over빨간색으로 출력
					if(isGameFinish) {
					    g2d.setColor(Color.RED);
						g2d.drawString("Game Over!", CANVAS_WIDTH / 2 - 55, 50);
					}
					

					// ball표시
					g2d.setColor(Color.WHITE);
					g2d.fillRect(ball.x, ball.y, BALL_WIDTH, BALL_HEIGTH);
					// bar표시
					g2d.setColor(Color.GRAY);
					g2d.fillRect(bar.x, bar.y, bar.width, bar.height);

				}

			}
			
		}

		// 생성자
		public MyFrame(String title) {
			super(title);
			this.setVisible(true); // 화면에 보이게
			this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT); // 화면 너비와 높이는 캔버스 사이즈와 동일하게
			this.setLocation(400, 300); // 창이 모니터에서 나타나는 위치
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x를 눌렀을 때 종료

			initData();

			myPanel = new MyPanel(); // 패널 생성
			this.add("Center", myPanel); // 패널 중앙에 넣기

			setKeyListener();
			startTimer();

		}

		public void initData() { // 변수 초기화
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					blocks[i][j] = new Block();
					blocks[i][j].x = BLOCK_WIDTH * j + BLOCK_GAP * j;
					blocks[i][j].y = 100 + BLOCK_HEIGHT * i + BLOCK_GAP * i;
					blocks[i][j].width = BLOCK_WIDTH;
					blocks[i][j].height = BLOCK_HEIGHT;
					blocks[i][j].color = 4 - i; // 0=white(5), 1=yellow(10), 2=blue(20); 3=mazanta(30), 4=red(40) 벽돌색깔
					blocks[i][j].isHidden = false;
				}
			}

		}

		public void setKeyListener() { // 키보드로 움직 일수 있게
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("Pressed Left Key");
						barXTarget -= 20;
						if (bar.x < barXTarget) { //계속 키를 눌렀을떄
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
		//Swing애 포함된 Timer
		public void startTimer() { //
			timer = new Timer(20, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { //Timer Event
					movement();
					checkCollision(); // 벽, 바와 ball 충돌시 시행 할 메소드 
					checkCollisionBlock(); // 벽돌 50개(5줄*10개)와 충돌시 시행 할 메소드
					myPanel.repaint(); // Redraw

					//Game Success!
					//for(int i=0;i<BLOCK_ROWS;i++) {
					//   fot(int j=0;j<BLOCK_COLUMNS;j++) {
					//       Block block = blocks[i][j];
					//   }를 isGameFinish() 코드로 대체
					isGameFinish();
				}
			});
			timer.start();
		}
		//Game Success!
		public void isGameFinish() {
			int count = 0;
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					Block block = blocks[i][j];
					//벽돌이 충돌로 사라질 때마다 count수 증가 
					if (block.isHidden) {
						count++;
					}
				}
			}
			//count수가 벽돌갯수(5줄*10개) 총50개가 되면 game이 종료
			if (count == BLOCK_ROWS * BLOCK_COLUMNS) {
				//timer.stop();timer가 draw하므로 보류
				isGameFinish = true;
			}
		}

		public void movement() {
			if (bar.x < barXTarget) {
				bar.x += 5;
			} else if (bar.x > barXTarget) {
				bar.x -= 5;
			}
			if (dir == 0) { //0: 오른쪽위 방향으로 이동
				ball.x += ballspeed;
				ball.y -= ballspeed;
			} else if (dir == 1) { //1: 오른쪽아래 방향으로 이동
				ball.x += ballspeed;
				ball.y += ballspeed;
			} else if (dir == 2) { //2: 왼쪽위 방향으로 이동
				ball.x -= ballspeed;
				ball.y -= ballspeed;
			} else if (dir == 3) { //3: 왼쪽아래 방향으로 이동
				ball.x -= ballspeed;
				ball.y += ballspeed;
			}
		}
		
		//충돌여부 체크(두개의 사각형이 중복되지 않는지 확인)
		public boolean duplRect(Rectangle rect1, Rectangle rect2) {
			return rect1.intersects(rect2);
		}

		public void checkCollision() {

			if (dir == 0) { //0: 오른쪽위 방향으로 이동
				//위쪽 벽에 충돌한 경우
				if (ball.y < 0) {
					dir = 1; //오른쪽아래 방향으로 이동
				}
				//오른쪽 벽에 충돌한 경우
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) {
					dir = 2; //왼쪽위 방향으로 이동
				}
				//위로 이동하기 떄문에 bar에 충돌할 경우가 없으므로 충돌 처리none
				
			} else if (dir == 1) { //1: 오른쪽아래 방향으로 이동
				//아래쪽 벽에 충돌한 경우
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGTH - BALL_HEIGTH) {
					dir = 0; //오른쪽위 방향으로 이동
					
					//game reset
					dir = 0;
					ball.x = CANVAS_WIDTH / 2 - BALL_WIDTH / 2;
					ball.y = CANVAS_HEIGHT / 2 - BALL_HEIGTH / 2;
					score = 0;
				}
				//오른쪽 벽에 충돌한 경우
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) {
					dir = 3; //왼쪽아래 방향으로 이동
				}
				//아래로 이동하기 때문에 bar와 충돌할 경우) ball의 중앙아래쪽값이 bar의 높이 값보다 크다 
				if (ball.getBottomCenter().y >= bar.y) {
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 0; //오른쪽위 방향으로 이동
					}
				}

			} else if (dir == 2) { //2: 왼쪽위 방향으로 이동
				//위쪽 벽에 충돌한 경우
				if (ball.y < 0) {
					dir = 3; //왼쪽아래 방향으로 이동
				}
				//왼쪽 벽에 충돌한 경우
				if (ball.x < 0) {
					dir = 0; //오른쪽위 방향으로 이동
				}
				//위로 이동하기 떄문에 bar에 충돌할 경우가 없으므로 충돌 처리none
				
			} else if (dir == 3) { //3: 왼쪽아래 방향으로 이동
				//아래쪽 벽에 충돌한 경우
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGTH - BALL_HEIGTH) {
					dir = 2; //왼쪽위로 이동
					
					//game reset
					dir = 0;
					ball.x = CANVAS_WIDTH / 2 - BALL_WIDTH / 2;
					ball.y = CANVAS_HEIGHT / 2 - BALL_HEIGTH / 2;
					score = 0;
				}
				//왼쪽 벽에 충돌한 경우
				if (ball.x < 0) {
					dir = 1; //오른쪽아래 방향으로 이동
				}
				//아래로 이동하기 때문에 bar와 충돌할 경우) ball의 중앙아래쪽값이 bar의 높이 값보다 크다 
				if (ball.getBottomCenter().y >= bar.y) {
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 2; //왼쪽위 방향으로 이동
					}
				}
			}
		}
		//ball이 벽돌과 충돌할 경우 메소드(0: 오른쪽위, 1:오른쪽아래, 2:왼쪽위, 3:왼쪽아래 대각선으로 볼이 이동하는 방향값)
		public void checkCollisionBlock() {
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					Block block = blocks[i][j];
					//충돌한 벽돌이 사라진 벽돌이 아닌경우
					if (block.isHidden == false) {
						if (dir == 0) { //0: 오른쪽위 방향으로 이동
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								//벽돌의 아래쪽에 충돌한 경우(ball의 중앙값이 벽돌 아래쪽에 충돌하는 것이므로 대략2로 계산)
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
									dir = 1; //오른쪽아래 방향으로 이동
								}//벽돌의 왼쪽에 충돌한 경우 
								else {
									dir = 2; //왼쪽위 방향으로 이동
								}
								//벽돌과 충돌한 경우 벽돌이 사라지면서 벽돌 색깔에 따라 점수 증가
								block.isHidden = true; //벽돌 사라짐
								//벽돌 색깔마다 점수를 다르게 줌 
								if (block.color == 0) {
									score += 5;
								} else if (block.color == 1) {
									score += 10;
								} else if (block.color == 2) {
									score += 15;
								} else if (block.color == 3) {
									score += 20;
								} else if (block.color == 4) {
									score += 5;
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
								//벽돌과 충돌한 경우 벽돌이 사라지면서 벽돌 색깔에 따라 점수 증가
								block.isHidden = true;
								if (block.color == 0) {
									score += 5;
								} else if (block.color == 1) {
									score += 10;
								} else if (block.color == 2) {
									score += 15;
								} else if (block.color == 3) {
									score += 20;
								} else if (block.color == 4) {
									score += 5;
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
								//벽돌과 충돌한 경우 벽돌이 사라지면서 벽돌 색깔에 따라 점수 증가
								block.isHidden = true;
								if (block.color == 0) {
									score += 5;
								} else if (block.color == 1) {
									score += 10;
								} else if (block.color == 2) {
									score += 15;
								} else if (block.color == 3) {
									score += 20;
								} else if (block.color == 4) {
									score += 5;
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
								//벽돌과 충돌한 경우 벽돌이 사라지면서 벽돌 색깔에 따라 점수 증가
								block.isHidden = true;
								if (block.color == 0) {
									score += 5;
								} else if (block.color == 1) {
									score += 10;
								} else if (block.color == 2) {
									score += 15;
								} else if (block.color == 3) {
									score += 20;
								} else if (block.color == 4) {
									score += 5;
								}
							}

						}
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		new MyFrame("벽돌깨기");

	}

}
