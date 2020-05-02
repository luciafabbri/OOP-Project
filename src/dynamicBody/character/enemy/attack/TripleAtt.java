package dynamicBody.character.enemy.attack;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.move.Direction;

public class TripleAtt implements MonsterAttack {

	private RoomDesign currentRoom;
	private Enemy enemy;
	
	public TripleAtt(RoomDesign room, Enemy enemy) {
		currentRoom = room;
		this.enemy = enemy;
		
	}
	
	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		MonsterAttack attOne = new OneSideAtt(currentRoom, enemy);
		MonsterAttack attTwo = new TwoSideAtt(currentRoom, enemy);
		
		attOne.createBullets(pos, dir, dmg);
		attTwo.createBullets(pos, dir, dmg);
		
	}

}
