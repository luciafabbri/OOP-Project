package entity.character.enemy.attack;

import bullet.Bullet;
import design.utilities.Pair;
import entity.character.enemy.Enemy;
import entity.move.Direction;

public class MonsterAttAbst {
	
	protected Pair<Integer,Integer> calculateBullPos(Pair<Integer,Integer> pos, Direction dir, Enemy enemy) {
		
		Pair<Integer, Integer> distance = calcDistance(dir, enemy);
		return new Pair<Integer,Integer>(pos.getX() + distance.getX(), pos.getY() + distance.getY());
		
	}
	
	private Pair<Integer, Integer> calcDistance(Direction value, Enemy enemy) {
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
		switch (value) {
			case NORTH:
				return new Pair<Integer, Integer>(0 , - (MonsterAttack.DISTANCESPAWN + Bullet.DIMENSION));
			case SOUTH:
				return new Pair<Integer, Integer>(0 , MonsterAttack.DISTANCESPAWN + enemy.getDimension().getDown());
			case EAST:
				return new Pair<Integer, Integer>(MonsterAttack.DISTANCESPAWN + enemy.getDimension().getRight(), 0);
			case WEST:
				return new Pair<Integer, Integer>( - (MonsterAttack.DISTANCESPAWN + Bullet.DIMENSION), 0);
			default:
				throw new IllegalArgumentException();
		}
	}

}
