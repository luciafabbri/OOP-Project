package dynamicBody.character.enemy.attack;

import design.utilities.Pair;
import dynamicBody.character.Character;
import dynamicBody.UpDownLeftRight;
import dynamicBody.bullet.BulletDefault;
import dynamicBody.bullet.DimensionBullet;
import dynamicBody.bullet.TypeBullet;
import dynamicBody.character.enemy.EnemyDefault;
import dynamicBody.move.Direction;

public class DistanceBullAbst {
	
	
	protected Pair<Integer,Integer> calculateBullPos(Direction dir, Character character) {
		
		Pair<Integer, Integer> distance = calcDistance(dir, character);
		return new Pair<Integer,Integer>(character.getPosition().getX() + distance.getX(), character.getPosition().getY() + distance.getY());
		
	}
	
	private Pair<Integer, Integer> calcDistance(Direction dir, Character character) {
		
		UpDownLeftRight<Integer> dim = DimensionBullet.getDimensionBullet(TypeBullet.MONSTER).getX().getDimension();
		
		int distanceSpawn = BulletDefault.DISTANCESPAWNBULL.getValue();
		/*switch (value) {
		case 1:
			return Enemy.DIMENSION + MonsterAttack.DISTANCESPAWN;
			
		case -1:
			return -MonsterAttack.DISTANCESPAWN;
			
		case 0:
			return (Enemy.DIMENSION - Bullet.DIMENSION)/2;
		
		default: 
			throw new IllegalArgumentException();
		
		}*/
		switch (dir) {
			case NORTH:
				return new Pair<Integer, Integer>(0 , - (dim.getDown() + distanceSpawn));
			case SOUTH:
				return new Pair<Integer, Integer>(0 ,(character.getDimension().getDown() - dim.getUp()) + distanceSpawn);
			case EAST:
				return new Pair<Integer, Integer>((character.getDimension().getRight() - dim.getLeft()) + distanceSpawn, 0);
			case WEST:
				return new Pair<Integer, Integer>(character.getDimension().getLeft() - (dim.getRight() + distanceSpawn), 0);
			default:
				throw new IllegalArgumentException();
		}
	}

}
