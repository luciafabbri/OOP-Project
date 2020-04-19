package player.movement;

import java.util.Map;
import java.util.Optional;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.enums.Door;
import utility.CheckPos;

public interface CheckPlayer extends CheckPos{

	public boolean checkDoors(Pair<Integer, Integer> pos, Map<Door, Optional<RoomDesign>> map);
	
	public boolean checkEntityRoom(RoomDesign room,Pair<Integer, Integer> pos);	

}
