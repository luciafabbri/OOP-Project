package entity.character.player.movement.check;

import java.util.Map;
import java.util.Optional;

import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.enums.Door;
import entity.move.CheckPos;

/**
 * An interface used to check player's position in the current room 
 */

public interface CheckPlayer extends CheckPos{

	/**
	 * @param pos, coordinates of the player
	 * @param map, 
	 * @return true if the player is next to the doors
	 */
	public boolean checkDoors(Pair<Integer, Integer> pos, Map<Door, Optional<RoomDesign>> map);
	
	/**
	 * Method used to check if the player is in collision with any entity (item or modifiers) in the room
	 * In case he's above item's entity he would pick it up and added it to his inventory
	 * In case he's above modifier's entity he would change the corresponding parameter
	 * @param room, current room where the player is
	 * @param pos, player's coordinates inside the room
	 * @return true if the player had a collision 
	 * @throws SlickException 
	 */
	public boolean checkEntityRoom(RoomDesign room,Pair<Integer, Integer> pos) throws SlickException;	
	
	/**
	 * @param room, current room where the player is
	 * @param pos, player's coordinates inside the room
	 * @return true if the player is above the stairs 
	 */
	public boolean checkStairs(RoomDesign room, Pair<Integer, Integer> pos);
	
	/**
	 * @param room, current room where the player is
	 * @param pos, player's coordinates inside the room	 
	 * @return true if the player is in collision with any enemy in the room
	 */
	public boolean checkEnemyRoom(RoomDesign room, Pair<Integer, Integer> pos);	

}
