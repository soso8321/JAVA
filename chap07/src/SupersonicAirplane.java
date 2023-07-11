
public class SupersonicAirplane extends AirPlane {
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;

	public int flyMode = NORMAL;

	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속비행합니다.");
		} else {
			super.fly(); //부모의 fly() 메소드 호출, 일반 비행
		}
	}

}
