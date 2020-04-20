package enemy;

import design.RoomDesign;
import design.utilities.Pair;

public interface MonsterCreator {
	
	public Monster getMonsterA(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Monster getMonsterB(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Monster getMonsterC(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Monster getMonsterD(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);

}
