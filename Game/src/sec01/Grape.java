package sec01;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Grape extends Fruit{
	private Image grape = new ImageIcon(Main.class.getResource("grape.jpg")).getImage();
	
	public Grape(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}
	
	public Image getGrape() {
		return grape;
	}

}
