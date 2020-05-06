package dynamicBody.character.enemy.boss;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.boss.BossDefault;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.character.enemy.move.TypeMove;
import dynamicBody.move.Direction;

public class BossImpl extends EnemyImpl implements Boss {

	public BossImpl(Pair<Integer, Integer> pos, int damage, int speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomDesign room, TypeEnemy mon) {
		super(pos, damage, speed, health, move, dir, att, room, mon);
	}

	public BossImpl(Pair<Integer, Integer> pos, RoomDesign room) {
		this(pos, BossDefault.DAMAGE.getValue(), 1, BossDefault.HEALTH.getValue(),
				TypeMove.TO_PLAYER, Direction.getRandomDir(), TypeAttack.getBossAtt(), room, TypeEnemy.BOSS);
	}

	public boolean isAlive() {
		return super.isAlive();
	}

}
