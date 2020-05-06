package dynamicBody.character.enemy;

public enum EnemyDefault {

	/**
	 * Rate of Fire
	 */
	ROF(2000);

	private int value;

	EnemyDefault(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
