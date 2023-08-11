package sec01;

import java.awt.Graphics;
import java.util.ArrayList;

public class Stage extends Thread {
// 아이템 담을 리스트
	private ArrayList<Fruit> itemList = new ArrayList<>();

	public ArrayList<Fruit> getItemList() {
		return itemList;
	}

	public void makeItems(Fruit item) {
		itemList.add(item);
	}

	public void drawItems(Graphics g) {

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i) instanceof Banana) {
				Banana ban = (Banana) itemList.get(i);
				g.drawImage(ban.getBanana(), ban.getPos_x(), ban.getPos_y(), null);
			} else if (itemList.get(i) instanceof Grape) {
				Grape gar = (Grape) itemList.get(i);
				g.drawImage(gar.getGrape(), gar.getPos_x(), gar.getPos_y(), null);
			}
		}
	}

	@Override
	public void run() {
		makeItems(new Banana(8, 503));
		makeItems(new Banana(64, 503));
		makeItems(new Banana(1161, 503));
		makeItems(new Banana(1216, 503));
		makeItems(new Banana(110, 172));
		makeItems(new Banana(900, 172));
		makeItems(new Grape(690, 172));
		makeItems(new Grape(420, 172));
	}
	
	
}
