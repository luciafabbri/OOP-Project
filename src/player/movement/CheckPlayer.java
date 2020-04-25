package player.movement;

import java.util.Map;
import java.util.Optional;

import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.enums.Door;
import utility.CheckPos;

public interface CheckPlayer extends CheckPos{

	public boolean checkDoors(Pair<Integer, Integer> pos, Map<Door, Optional<RoomDesign>> map);
	
	public boolean checkEntityRoom(RoomDesign room,Pair<Integer, Integer> pos) throws SlickException;	

	public boolean checkStairs(RoomDesign room, Pair<Integer, Integer> pos);
	
	public boolean checkEnemyRoom(RoomDesign currentRoom, Pair<Integer, Integer> newPos);	

}
