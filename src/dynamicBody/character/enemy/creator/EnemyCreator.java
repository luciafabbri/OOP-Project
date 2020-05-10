package dynamicBody.character.enemy.creator;

import dynamicBody.character.enemy.Enemy;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * Interface that presents all the methods needed to create different type of
 * enemy
 */
public interface EnemyCreator {

	/**
	 * The following methods create Monster with some specific characteristics
	 * 
	 * @param pos,
	 * @param damage
	 * @param health
	 * @param room
	 * @return Enemy
	 */

	public Enemy getMonsterA(Pair<Integer, Integer> pos, int damage, int health, RoomModel room);

	public Enemy getMonsterB(Pair<Integer, Integer> pos, int damage, int health, RoomModel room);

	public Enemy getMonsterC(Pair<Integer, Integer> pos, int damage, int health, RoomModel room);

	public Enemy getMonsterD(Pair<Integer, Integer> pos, int damage, int health, RoomModel room);

	public Enemy getMonster(int type, Pair<Integer, Integer> pos, int health, int damage, RoomModel room);
	/**
	 * Create Boss
	 * 
	 * @param pos
	 * @param room
	 * @return Boss
	 */
	public Enemy getBossA(Pair<Integer, Integer> pos, RoomModel room);

}
