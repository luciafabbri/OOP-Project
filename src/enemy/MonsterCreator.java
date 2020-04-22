package enemy;

import design.RoomDesign;
import design.utilities.Pair;

public interface MonsterCreator {
	
	public Enemy getMonsterA(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterB(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterC(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Enemy getMonsterD(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);

}
