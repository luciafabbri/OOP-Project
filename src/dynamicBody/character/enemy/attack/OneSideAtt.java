package dynamicBody.character.enemy.attack;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.bullet.Bullet;
import dynamicBody.bullet.BulletMonsterImpl;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.move.Direction;

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
		
		Bullet bull = new BulletMonsterImpl(calculateBullPos(pos, dir, enemy), dmg, dir, currentRoom);
		
		enemy.addBullet(bull);
				
	}

}
