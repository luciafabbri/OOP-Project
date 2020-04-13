package enemy.attack;

import bullet.Bullet;
import bullet.BulletMonster;
import utility.Direction;
import design.utilities.Pair;

public class OneSideAtt extends MonsterAttAbst implements MonsterAttack{

	@Override
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg) {
				
		//CHECK IF CAN CREATE
		
		Bullet bull = new BulletMonster(calculateBullPos(pos, dir), dmg, dir);
		
		if(bull.isAlive()) {
			//AGGIUNGERE LISTA FEDE
		}
		
		
				
	}

}
