package dynamicBody.character.enemy.creator;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.boss.Boss;


public interface EnemyCreator {
	
	/**
	 * The following methods create Monster with some specific characteristics
	 * @param pos,
	 * @param damage
	 * @param health
	 * @param room
	 * @return Enemy
	 */
	
	public Enemy getMonsterA(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterB(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterC(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterD(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	/**
	 * Create Boss
	 * @param pos
	 * @param room
	 * @return Boss
	 */
	public Boss getBossA(Pair<Integer, Integer> pos, RoomDesign room);

}
