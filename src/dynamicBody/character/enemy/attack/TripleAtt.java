package dynamicBody.character.enemy.attack;

import dynamicBody.character.enemy.Enemy;
import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * Class implements use to create 3 bullet in 3 different direction when enemy
 * attack
 */
public class TripleAtt implements MonsterAttack {

	private RoomModel currentRoom;
	private Enemy enemy;

	/**
	 * Default Constructor
	 * 
	 * @param room,  room where bullet spawn
	 * @param enemy, the Enemy that create this Bullet
	 */
	public TripleAtt(RoomModel room, Enemy enemy) {
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
