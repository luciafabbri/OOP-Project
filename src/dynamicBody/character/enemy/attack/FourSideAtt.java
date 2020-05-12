package dynamicBody.character.enemy.attack;

import java.util.List;

import dynamicBody.character.enemy.Enemy;
import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * Class implements EnemyAttack use to create 4 bullet in each direction when
 * enemy attack
 */
public class FourSideAtt implements EnemyAttack {

	private RoomModel currentRoom;
	private Enemy enemy;

	/**
	 * Default Constructor
	 * 
	 * @param room,  room where bullet spawn
	 * @param enemy, the Enemy that create this Bullet
	 */
	public FourSideAtt(RoomModel room, Enemy enemy) {
		currentRoom = room;
		this.enemy = enemy;
	}

	private static List<Direction> normalDir = Direction.getDirectionList(true);

	private static List<Direction> mixedDir = Direction.getDirectionList(false);

	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		EnemyAttack attack = new OneSideAtt(currentRoom, enemy);
		if (normalDir.contains(dir)) {
			normalDir.forEach(d -> attack.createBullets(pos, d, dmg));
		} else {
			mixedDir.forEach(d -> attack.createBullets(pos, d, dmg));
		}
	}

}
