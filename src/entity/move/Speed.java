package entity.move;

public enum Speed {
	
	VERY_SLOW, SLOW, NORMAL, FAST, VERY_FAST;
	
	private static boolean check;
	
	public static int getSpeed(Speed speed) {
		switch(speed) {
			case VERY_SLOW:
				return verySlow();
			case SLOW:
				return 1;
			case NORMAL:
				return normal();
			case FAST:
				return 2;
			case VERY_FAST:
				return 3;
			default: 
				throw new IllegalArgumentException();
		}
	}
	
	private static int calcSpeed(int f, int s) {
		int speed;
		if(check) {
			speed = f;
		} else {
			speed = s;
		}
		check = !check;
		return speed;
	}
	
	private static int verySlow() {
		return calcSpeed(1,0);
	}
	
	private static int normal() {
		return calcSpeed(2,1);
	}
	
	
}
