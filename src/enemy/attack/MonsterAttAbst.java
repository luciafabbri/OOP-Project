package enemy.attack;

import bullet.Bullet;
import enemy.Enemy;

public class MonsterAttAbst {
	
	protected int calcDistanceByCoord(int value) {
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
