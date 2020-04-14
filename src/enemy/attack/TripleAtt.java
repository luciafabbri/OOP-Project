package enemy.attack;

import design.RoomDesignImpl;
import design.utilities.Pair;
import utility.Direction;

public class TripleAtt implements MonsterAttack {

	private RoomDesignImpl currentRoom;
	
	public TripleAtt(RoomDesignImpl room) {
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
