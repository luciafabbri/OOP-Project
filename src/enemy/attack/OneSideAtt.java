package enemy.attack;

import bullet.BulletMonster;
import bullet.BulletMonsterImpl;
import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;
import enemy.Enemy;

public class OneSideAtt extends MonsterAttAbst implements MonsterAttack{

	private RoomDesign currentRoom;
	private Enemy enemy;
	
	public OneSideAtt(RoomDesign room, Enemy enemy) {
		currentRoom = room;
		this.enemy = enemy;		
	}
	
	@Override
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg) {
				
		//CHECK IF CAN CREATE
		
		BulletMonster bull = new BulletMonsterImpl(calculateBullPos(pos, dir, enemy), dmg, dir, currentRoom);
		
		enemy.addBullet(bull);
				
	}

}
