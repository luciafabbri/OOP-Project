package dynamicBody.bullet;

import worldModel.utilities.Pair;

public class BulletDimFactory {

	public Pair<DimensionBullet, DimensionBullet> getDimensionBullet(TypeBullet bull) {
		switch (bull) {
		case PLAYER_BULL:
			return new Pair<>(DimensionBullet.ORIZONTAL_PLAYER, DimensionBullet.VERTICAL_PLAYER);
		case ENEMY_BULL:
			return new Pair<>(DimensionBullet.MONSTER, DimensionBullet.MONSTER);
		default:
			throw new IllegalArgumentException();
		}
	}
}
