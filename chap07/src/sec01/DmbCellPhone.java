package sec01;

public class DmbCellPhone extends CellPhone {
	int channel; // ��� �ʵ�

	DmbCellPhone(String model, String color, int channel) {
		this.model = model; // ��ӹ��� �ʵ�
		this.color = color; // ��ӹ��� �ʵ�
		this.channel = channel;

	}

	void turnOnDmb() {
		System.out.println("ä�� " + channel + "�� Dmb ��� ������ �����մϴ�.");

	}

	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("ä�� " + channel + "������ �ٲߴϴ�..");
	}

	void turnOffDmb() {
		System.out.println("Dmb ��� ������ ����ϴ�.");

	}
}
