package dynamicBody.character.enemy.attack;

public enum TypeAttack {
	
	ONE_SIDE, TWO_SIDE, FOUR_SIDE, TRIPLE;
	
	/**
	 * @return the TypeAttack of Boss
	 */
	public static TypeAttack getBossAtt() {
		return TRIPLE;
	}
}
