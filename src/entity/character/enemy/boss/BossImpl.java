package entity.character.enemy.boss;

import design.RoomDesign;
import design.utilities.Pair;
import entity.character.enemy.EnemyImpl;
import entity.character.enemy.TypeEnemy;
import entity.character.enemy.attack.TypeAttack;
import entity.character.enemy.boss.BossDefault;
import entity.character.enemy.move.TypeMove;
import entity.move.Direction;
import entity.move.Speed;

public class BossImpl extends EnemyImpl implements Boss {

	private RoomDesign room;

	public BossImpl(Pair<Integer, Integer> pos, int damage, Speed speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomDesign room, TypeEnemy mon) {
		super(pos, damage, speed, health, move, dir, att, room, mon);
		this.room = room;
	}

	public BossImpl(Pair<Integer, Integer> pos, RoomDesign room) {
		this(pos, BossDefault.DAMAGE.getValue(), Speed.SLOW, BossDefault.HEALTH.getValue(),
				TypeMove.RANDOM, Direction.getRandomDir(), TypeAttack.getBossAtt(), room, TypeEnemy.BOSS);
	}

	public boolean isAlive() {
		// room.addEnemy(enemy);
		return super.isAlive();
	}

}
