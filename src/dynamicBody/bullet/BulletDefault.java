package dynamicBody.bullet;

public enum BulletDefault {

	DISTANCESPAWNBULL(10),
	SPEED(2);

	private int value;

	BulletDefault(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
