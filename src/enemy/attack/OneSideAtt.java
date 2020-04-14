package enemy.attack;

import bullet.BulletImpl;
import bullet.BulletMonster;
import utility.Direction;
import design.utilities.Pair;

public class OneSideAtt extends MonsterAttAbst implements MonsterAttack{

	@Override
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg) {
				
		//CHECK IF CAN CREATE
		
		BulletImpl bull = new BulletMonster(calculateBullPos(pos, dir), dmg, dir);
		
		//listaFede.add(bull);
		
		
				
	}
	
	private Pair<Integer,Integer> calculateBullPos(Pair<Integer,Integer> pos, Direction dir) {
		
		return new Pair<Integer,Integer>(pos.getX() + calcDistanceByCoord(dir.getAbscissa()), pos.getY() + calcDistanceByCoord(dir.getOrdinate()));
		
	}

}
