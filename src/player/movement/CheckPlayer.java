package player.movement;

import java.util.Map;
import java.util.Optional;

import design.RoomDesign;
import design.utilities.Door;
import design.utilities.Pair;
import utility.CheckPos;

public interface CheckPlayer extends CheckPos{

	public boolean checkDoors(Pair<Integer, Integer> pos, Map<Door, Optional<RoomDesign>> map);
	
	public boolean checkItemsRoom(RoomDesign room,Pair<Integer, Integer> pos);	
}
