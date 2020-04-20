package enemy;

import design.RoomDesign;
import design.utilities.Pair;

public class MonsterCreatorImpl implements MonsterCreator {
	
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
	public Monster getMonsterA(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new Monster(pos, damage, health, TypeMove.STRAIGHT, TypeAttack.ONE_SIDE, room, TypeMonster.MONSTER1);
	}
	
	@Override
	public Monster getMonsterB(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new Monster(pos, damage, health, TypeMove.RANDOM, TypeAttack.TWO_SIDE, room, TypeMonster.MONSTER2);
	}
	
	@Override
	public Monster getMonsterC(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new Monster(pos, damage, health, TypeMove.TELEPORT, TypeAttack.TRIPLE, room, TypeMonster.MONSTER3);
	}
	
	@Override
	public Monster getMonsterD(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new Monster(pos, damage, health, TypeMove.IMMOBILIZED, TypeAttack.FOUR_SIDE, room, TypeMonster.PLANT);
	}

}
