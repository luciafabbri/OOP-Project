package dynamicBody.character.enemy.creator;

import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.boss.BossImpl;
import dynamicBody.character.enemy.move.TypeMove;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * Class that implements interface EnemyCreator
 */
public class EnemyCreatorImpl implements EnemyCreator {

	@Override
	public Enemy getMonster(int type, Pair<Integer, Integer> pos, int health, int damage, RoomModel room) {
		switch (type) {
		case 1:
			return new EnemyImpl(pos, damage, health, TypeMove.STRAIGHT, TypeAttack.ONE_SIDE, room, TypeEnemy.BOWMAN);
		case 2:
			return new EnemyImpl(pos, damage, health, TypeMove.TELEPORT, TypeAttack.TWO_SIDE, room, TypeEnemy.MAGE);
		case 3:
			return new EnemyImpl(pos, damage, health, TypeMove.RANDOM, TypeAttack.TRIPLE, room, TypeEnemy.NINJA);
		case 4:
			return new EnemyImpl(pos, damage, health, TypeMove.IMMOBILIZED, TypeAttack.FOUR_SIDE, room,	TypeEnemy.PLANT);
		default:
			throw new IllegalArgumentException("Number isn't between 1 and 4");
		}
	}

	@Override
	public Enemy getBossA(Pair<Integer, Integer> pos, RoomModel room) {
		return new BossImpl(pos, room);
	}

	@Override
	public Enemy getMonsterA(Pair<Integer, Integer> pos, int health, int damage, RoomModel room) {
		return new EnemyImpl(pos, damage, health, TypeMove.STRAIGHT, TypeAttack.ONE_SIDE, room, TypeEnemy.BOWMAN);
	}

	@Override
	public Enemy getMonsterB(Pair<Integer, Integer> pos, int health, int damage, RoomModel room) {
		return new EnemyImpl(pos, damage, health, TypeMove.TELEPORT, TypeAttack.TWO_SIDE, room, TypeEnemy.MAGE);
	}

	@Override
	public Enemy getMonsterC(Pair<Integer, Integer> pos, int health, int damage, RoomModel room) {
		return new EnemyImpl(pos, damage, health, TypeMove.RANDOM, TypeAttack.TRIPLE, room, TypeEnemy.NINJA);
	}

	@Override
	public Enemy getMonsterD(Pair<Integer, Integer> pos, int health, int damage, RoomModel room) {
		return new EnemyImpl(pos, damage, health, TypeMove.IMMOBILIZED, TypeAttack.FOUR_SIDE, room,	TypeEnemy.PLANT);
	}

}
