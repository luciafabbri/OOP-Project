package dynamicBody.bullet;

import dynamicBody.UpDownLeftRight;
import worldModel.utilities.Pair;

/**
 * Enumeration used to represent bullet's dimension, which means that for each
 * type of bullet has been checked the exacts pixel in order to be displayed in
 * the dungeon as real as possible
 */

public enum DimensionBullet {

	VERTICAL_PLAYER(30, 33, 20, 51), ORIZONTAL_PLAYER(13, 47, 28, 37),

	MONSTER(22, 40, 23, 42);

	private UpDownLeftRight<Integer> dim;

	/**
	 * Default constructor
	 * 
	 * @param up,    bullet's up dimension
	 * @param down,  bullet's down dimension
	 * @param left,  bullet's left dimension
	 * @param right, bullet's right dimension
	 */
	DimensionBullet(int up, int down, int left, int right) {
		this.dim = new UpDownLeftRight<>(up, down, left, right);
	}

	public UpDownLeftRight<Integer> getDimension() {
		return dim;
	}

	public static Pair<DimensionBullet, DimensionBullet> getDimensionBullet(TypeBullet bull) {
		switch (bull) {
		case PLAYER_BULL:
			return new Pair<>(ORIZONTAL_PLAYER, VERTICAL_PLAYER);
		case ENEMY_BULL:
			return new Pair<>(MONSTER, MONSTER);
		default:
			throw new IllegalArgumentException();
		}
	}

}
