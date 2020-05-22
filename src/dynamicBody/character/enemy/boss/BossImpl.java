package dynamicBody.character.enemy.boss;

import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.boss.BossDefault;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.character.enemy.move.TypeMove;
import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * Enumeration used to set enemy's image based on his current direction
 */
public class BossImpl extends EnemyImpl implements Enemy {

	/**
	 * Default constructor
	 * 
	 * @param pos,    position of the Boss
	 * @param damage, damage of the Boss
	 * @param speed,  speed of the Boss
	 * @param health, max health of the Boss
	 * @param move,   TypeMove of Boss
	 * @param dir,    Direction of Boss
	 * @param att,    TypeAttack of Boss
	 * @param room,   RoomModel where Boss spawn
	 */
	public BossImpl(Pair<Integer, Integer> pos, int damage, int speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomModel room) {
		super(pos, damage, speed, health, move, dir, att, room, TypeEnemy.BOSS);
	}

	/**
	 * Constructor with Boss default value
	 * 
	 * @param pos,  position of the Boss
	 * @param room, RoomModel where Boss spawn
	 */
	public BossImpl(Pair<Integer, Integer> pos, RoomModel room) {
		this(pos, BossDefault.DAMAGE.getValue(), 1, BossDefault.HEALTH.getValue(), TypeMove.getBossMove(),
				Direction.getRandomDir(), TypeAttack.getBossAtt(), room);
	}

}
