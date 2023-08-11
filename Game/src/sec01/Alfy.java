package sec01;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Alfy {
	//이미지 파일
	private Image alfyLeftMove = new ImageIcon(Main.class.getResource("kirbyLeftMove.png")).getImage();
	private Image alfyLeftStop = new ImageIcon(Main.class.getResource("kirbyLeftStop.png")).getImage();
	private Image alfyLeftJump = new ImageIcon(Main.class.getResource("kirbyLeftJump.png")).getImage();
	private Image alfyRightMove = new ImageIcon(Main.class.getResource("kirbyRightMove.png")).getImage();
	private Image alfyRightStop = new ImageIcon(Main.class.getResource("kirbyRightStop.png")).getImage();
	private Image alfyRightJump = new ImageIcon(Main.class.getResource("kirbyRightJump.png")).getImage();

	//위치
	private int pos_x, pos_Y;
	
	//보고 있는 방향
	private String direction;
	
	//사다리를 탔는지 여부
	private boolean laddering = false;
	
	//표시할 이미지
	private Image state;
	
	public void setPosition(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_Y = pos_y;
	}

	
	
	public Image getAlfyLeftMove() {
		return alfyLeftMove;
	}

	public void setAlfyLeftMove(Image alfyLeftMove) {
		this.alfyLeftMove = alfyLeftMove;
	}

	public Image getAlfyLeftStop() {
		return alfyLeftStop;
	}

	public void setAlfyLeftStop(Image alfyLeftStop) {
		this.alfyLeftStop = alfyLeftStop;
	}

	public Image getAlfyLeftJump() {
		return alfyLeftJump;
	}

	public void setAlfyLeftJump(Image alfyLeftJump) {
		this.alfyLeftJump = alfyLeftJump;
	}

	public Image getAlfyRightMove() {
		return alfyRightMove;
	}

	public void setAlfyRightMove(Image alfyRightMove) {
		this.alfyRightMove = alfyRightMove;
	}

	public Image getAlfyRightStop() {
		return alfyRightStop;
	}

	public void setAlfyRightStop(Image alfyRightStop) {
		this.alfyRightStop = alfyRightStop;
	}

	public Image getAlfyRightJump() {
		return alfyRightJump;
	}

	public void setAlfyRightJump(Image alfyRightJump) {
		this.alfyRightJump = alfyRightJump;
	}

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_Y() {
		return pos_Y;
	}

	public void setPos_Y(int pos_Y) {
		this.pos_Y = pos_Y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean isLaddering() {
		return laddering;
	}

	public void setLaddering(boolean laddering) {
		this.laddering = laddering;
	}

	public Image getState() {
		return state;
	}

	public void setState(Image state) {
		this.state = state;
	}

	
	
}
