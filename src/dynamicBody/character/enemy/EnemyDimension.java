package dynamicBody.character.enemy;

import dynamicBody.UpDownLeftRight;
import dynamicBody.character.enemy.creator.TypeEnemy;

/**
 * Enumeration used to get enemy's dimensions based on his current direction
 */

public enum EnemyDimension {

	DEFAULT(0, 63, 15, 46),
	
	PLANT(0, 63, 0, 63);

	private UpDownLeftRight<Integer> dim;

	/**
	 * Default constructor
	 * 
	 * @param up,    position of up's pixel
	 * @param down,  position of down's pixel
	 * @param left,  position of left's pixel
	 * @param right, position of right's pixel
	 */
	EnemyDimension(int up, int down, int left, int right) {
		this.dim = new UpDownLeftRight<>(up, down, left, right);
	}

	public UpDownLeftRight<Integer> getDimension() {
		return dim;
	}

	/**
	 * Method use to know the dimension of a monster
	 * 
	 * @param mon, TypeMonster of the monster
	 * @return the a Pair<DimensionMonster, DimensionMonster> of the TypeEnemy
	 */
	public static EnemyDimension getDimensionMoster(TypeEnemy mon) {
		switch (mon) {
		case PLANT:
			return PLANT;
		case BOWMAN:
		case NINJA:
		case MAGE:
		case BOSS:
			return DEFAULT;

		default:
			throw new IllegalArgumentException("The Dimension of the TypeEnemy isn't implemented");
		}

	}

}
