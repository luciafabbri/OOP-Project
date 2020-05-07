package dynamicBody.character.enemy.boss;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.boss.BossDefault;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.character.enemy.move.TypeMove;
import dynamicBody.move.Direction;

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
	 * @param room,   RoomDesign where Boss spawn
	 * @param mon,    TypeEnemy of Boss
	 */
	public BossImpl(Pair<Integer, Integer> pos, int damage, int speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomDesign room, TypeEnemy mon) {
		super(pos, damage, speed, health, move, dir, att, room, mon);
	}

	/**
	 * Constructor with Boss default value
	 * 
	 * @param pos,  position of the Boss
	 * @param room, RoomDesign where Boss spawn
	 */
	public BossImpl(Pair<Integer, Integer> pos, RoomDesign room) {
		this(pos, BossDefault.DAMAGE.getValue(), 1, BossDefault.HEALTH.getValue(), TypeMove.TO_PLAYER,
				Direction.getRandomDir(), TypeAttack.getBossAtt(), room, TypeEnemy.BOSS);
	}

}
