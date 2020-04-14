package enemy.attack;

import bullet.Bullet;
import bullet.BulletMonster;
import utility.Direction;
import design.RoomDesignImpl;
import design.utilities.Pair;

public class OneSideAtt extends MonsterAttAbst implements MonsterAttack{

	private RoomDesignImpl currentRoom;
	
	public OneSideAtt(RoomDesignImpl room) {
		currentRoom = room;
	}
	
	@Override
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg) {
				
		//CHECK IF CAN CREATE
		
		Bullet bull = new BulletMonster(calculateBullPos(pos, dir), dmg, dir, currentRoom);
		
		if(bull.isAlive()) {
			//AGGIUNGERE LISTA FEDE
		}
				
	}

}
