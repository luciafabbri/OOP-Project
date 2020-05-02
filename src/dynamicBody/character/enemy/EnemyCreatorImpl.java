package dynamicBody.character.enemy;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.boss.Boss;
import dynamicBody.character.enemy.boss.BossImpl;
import dynamicBody.character.enemy.move.TypeMove;

public class EnemyCreatorImpl implements EnemyCreator {
	
	/*private Monster getMonster(TypeMonster monster, Pair<Integer, Integer> pos, int lvl, RoomDesign room) {
		
		switch(monster) {
			case MONSTER1:
				return new Monster(pos, lvl, TypeMove.STRAIGHT, TypeAttack.ONE_SIDE, room, monster);
				
			case MONSTER2:
				return new Monster(pos, lvl, TypeMove.RANDOM, TypeAttack.TWO_SIDE, room, monster);
				
			case MONSTER3:
				return new Monster(pos, lvl, TypeMove.TELEPORT, TypeAttack.TRIPLE, room, monster);
				
			case PLANT:
				return new Monster(pos, lvl, TypeMove.IMMOBILIZED, TypeAttack.FOUR_SIDE, room, monster);
			
			default:
				throw new IllegalArgumentException();
		}
		
	} */
	
	@Override
	public Enemy getMonsterA(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.STRAIGHT, TypeAttack.ONE_SIDE, room, TypeEnemy.MONSTER1);
	}
	
	@Override
	public Enemy getMonsterB(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.RANDOM, TypeAttack.TWO_SIDE, room, TypeEnemy.MONSTER2);
	}
	
	@Override
	public Enemy getMonsterC(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.TELEPORT, TypeAttack.TRIPLE, room, TypeEnemy.MONSTER3);
	}
	
	@Override
	public Enemy getMonsterD(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.IMMOBILIZED, TypeAttack.FOUR_SIDE, room, TypeEnemy.PLANT);
	}

	@Override
	public Boss getBossA(Pair<Integer, Integer> pos, RoomDesign room) {
		return new BossImpl(pos, room);
	}

}
