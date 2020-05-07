package dynamicBody.bullet;

import design.utilities.Pair;
import dynamicBody.character.Character;
import dynamicBody.UpDownLeftRight;
import dynamicBody.move.Direction;

public class DistanceBullAbst {

	/**
	 * Method that calculate the position where spawn bullet
	 * 
	 * @param dir,       direction where to spawn
	 * @param character, the Character who create that
	 * @return return a Pair with the coordinates
	 */

	protected Pair<Integer, Integer> calculateBullPos(Direction dir, Character character) {

		Pair<Integer, Integer> distance = calcDistance(dir, character);
		return new Pair<Integer, Integer>(character.getPosition().getX() + distance.getX(),
				character.getPosition().getY() + distance.getY());

	}

	private Pair<Integer, Integer> calcDistance(Direction dir, Character character) {

		UpDownLeftRight<Integer> dim = DimensionBullet.getDimensionBullet(TypeBullet.ENEMY).getX().getDimension();

		int distanceSpawn = BulletDefault.DISTANCESPAWNBULL.getValue();

		switch (dir) {
		case NORTH:
			return new Pair<Integer, Integer>(0, -(dim.getDown() + distanceSpawn));
		case SOUTH:
			return new Pair<Integer, Integer>(0, (character.getDimension().getDown() - dim.getUp()) + distanceSpawn);
		case EAST:
			return new Pair<Integer, Integer>((character.getDimension().getRight() - dim.getLeft()) + distanceSpawn, 0);
		case WEST:
			return new Pair<Integer, Integer>(character.getDimension().getLeft() - (dim.getRight() + distanceSpawn), 0);
		default:
			throw new IllegalArgumentException();
		}
	}

}
