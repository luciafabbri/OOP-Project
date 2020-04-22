package enemy.boss;

import design.RoomDesign;
import design.utilities.Pair;

public interface BossCreator {

	public Boss getBossA(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Boss getBossB(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Boss getBossC(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
	
	public Boss getBossD(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room);
}
