package enemy.attack;

import bullet.Bullet;
import design.utilities.Pair;
import enemy.Enemy;
import utility.Direction;

public class MonsterAttAbst {
	
	protected Pair<Integer,Integer> calculateBullPos(Pair<Integer,Integer> pos, Direction dir) {
		
		return new Pair<Integer,Integer>(pos.getX() + calcDistanceByCoord(dir.getAbscissa()), pos.getY() + calcDistanceByCoord(dir.getOrdinate()));
		
	}
	
	private int calcDistanceByCoord(int value) {
		switch (value) {
		case 1:
			return Enemy.DIMENSION + MonsterAttack.DISTANCESPAWN;
			
		case -1:
			return -MonsterAttack.DISTANCESPAWN;
			
		case 0:
			return (Enemy.DIMENSION - Bullet.DIMENSION)/2;
		
		default: 
			throw new IllegalArgumentException();
		
		}
	}

}
