package enemy.attack;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.utilities.Pair;
import utility.Direction;

public class TripleAtt implements MonsterAttack {

	private RoomDesign currentRoom;
	
	public TripleAtt(RoomDesign room) {
		currentRoom = room;
	}
	
	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		MonsterAttack attOne = new OneSideAtt(currentRoom);
		MonsterAttack attTwo = new TwoSideAtt(currentRoom);
		
		attOne.createBullets(pos, dir, dmg);
		attTwo.createBullets(pos, dir, dmg);
		
	}

}
