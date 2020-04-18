package player.movement;

import design.utilities.Pair;
import player.Player;
import player.PlayerImpl;
import utility.CheckPos;
import utility.Direction;

import utility.CheckPosImpl;

import utility.DoorCheck;
import utility.Entity;
import design.utilities.Door;
import design.utilities.GameSettings;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import design.RoomDesign;
import design.tokens.WorldObject;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */


public class CheckPlayerImpl  extends CheckPosImpl implements CheckPlayer, GameSettings{
				
	public CheckPlayerImpl(Entity entity) {
		super(entity);
	}
	
	@Override
	public boolean checkDoors(Pair<Integer, Integer> pos, Map<Door, Optional<RoomDesign>> map) {
		//REMINDER: NEED TO CHANGE NUMBERS WHILE CHECKING COORDS BECAUSE MAINCHAR IS DIFFERENT BASED ON DIRECTIONS
		DoorCheck check = new DoorCheck();
		
		if(map.entrySet().stream().filter(s -> s.getKey().equals(Door.NORTH)).findFirst().get().getValue().isPresent() && check.doorNorth(pos)){
			return true;
		} else if(map.entrySet().stream().filter(s -> s.getKey().equals(Door.SOUTH)).findFirst().get().getValue().isPresent() && check.doorSouth(pos)) {
			return true;
		}  else if(map.entrySet().stream().filter(s -> s.getKey().equals(Door.EAST)).findFirst().get().getValue().isPresent() && check.doorEast(pos)) {
			return true;
		}  else if(map.entrySet().stream().filter(s -> s.getKey().equals(Door.WEST)).findFirst().get().getValue().isPresent() && check.doorWest(pos)) {
			return true;
		}
		return false;
	}
	
	
	/**se dentro al set di ostacoli ci sono coordinate che corrispondono a quelle del personaggio, 
	 * allora quest'ultimo non si deve muovere perchè quella posizione è già occupata
	 */
	@Override
	public boolean checkItemsRoom(RoomDesign room, Pair<Integer, Integer> pos) {
		/**Set<WorldObject> itemSet; room.getWorldObjectsSet();
		for (design.tokens.WorldObject item : itemSet) {
			if ( controllo degli item quando implementati ) {
				prendi tipologia di item e modifica  
				aggiungi alla lista di qualcosa 
				return true;
			}
		} */
		return false;
	} 
	
	public boolean checkModifiersRoom(RoomDesign room, Pair<Integer, Integer> pos) {
		return false;
	}
}
