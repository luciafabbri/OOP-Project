package enemy.attack;

import bullet.Bullet;
import bullet.BulletImpl;
import bullet.BulletMonster;
import enemy.Enemy;
import utility.Direction;
import utility.Pair;

public class OneSideAtt implements MonsterAttack{

	@Override
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg) {
				
		//CHECK IF CAN CREATE
		
		BulletImpl bull = new BulletMonster(calculateBullPos(pos, dir), dmg, dir);
		
		//listaFede.add(bull);
		
		
				
	}
	
	private Pair<Integer,Integer> calculateBullPos(Pair<Integer,Integer> pos, Direction dir) {
		
		return new Pair<Integer,Integer>(pos.getX() + calcDistanceByCoord(dir.getAbscissa()), pos.getY() + calcDistanceByCoord(dir.getOrdinate()));
	}
	
	private int calcDistanceByCoord(int value) {
		switch (value) {
		case 1:
			return Enemy.DIMENSION + DISTANCESPAWN;
			
		case -1:
			return -DISTANCESPAWN;
			
		case 0:
			return (Enemy.DIMENSION - Bullet.DIMENSION)/2;
		
		default: 
			throw new IllegalArgumentException();
		
		}
	}

}
