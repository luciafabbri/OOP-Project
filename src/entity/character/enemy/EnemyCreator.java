package entity.character.enemy;

import design.RoomDesign;
import design.utilities.Pair;
import entity.character.enemy.boss.Boss;


public interface EnemyCreator {
	
	public Enemy getMonsterA(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterB(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterC(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterD(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Boss getBossA(Pair<Integer, Integer> pos, RoomDesign room);

}
