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
				
		BulletImpl bull = new BulletMonster(calculateBullPos(pos, dir), dmg, dir);
		
		//listaFede.add(bull);
		
		
				
	}
	
	private Pair<Integer,Integer> calculateBullPos(Pair<Integer,Integer> pos, Direction dir) {
		
		int x,y;
		
		if (dir.getAbscissa() == 1) {
			x = pos.getX() + Enemy.DIMENSION + DISTANCESPAWN;
		} else if (dir.getAbscissa() == 1) {
			x = pos.getX() - DISTANCESPAWN;
		} else {
			x = pos.getX() + (Enemy.DIMENSION - Bullet.DIMENSION)/2;
		}
		
		if (dir.getOrdinate() == 1) {
			y = pos.getY() + Enemy.DIMENSION + DISTANCESPAWN;
		} else if (dir.getOrdinate() == 1) {
			y = pos.getY() - DISTANCESPAWN;
		} else {
			y = pos.getY() + (Enemy.DIMENSION - Bullet.DIMENSION)/2;
		}
		
		return new Pair<Integer,Integer>(x,y);
	}

}
