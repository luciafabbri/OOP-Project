package dynamicBody.character.enemy.boss;

public enum BossDefault {
	
	HEALTH(1000),
	SPEED(15),
	DAMAGE(100);
	
	private int value;
	
	BossDefault(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
