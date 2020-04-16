package player.movement;

import design.utilities.Pair;
import player.Player;
import utility.CheckPos;
import utility.DoorCheck;
import design.utilities.Door;
import design.utilities.GameSettings;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import design.RoomDesign;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */

public class CheckPositionPlayerImpl implements CheckPos, GameSettings{
		
	/** 
	 * 
	 * This method needs the coordinates of the player and checks if he's not going out of bounds.
	 * If the coordinates are above these limits, the method will return FALSE value otherwise it will return TRUE.
	 *  SE SOPRA LIMITI --> return FALSE
	 *  SE VANNO BENE --> return TRUE 
	 *   
	 *	Se OBSTACLE --> non posso andare sopra
	 *  Se ITEM --> posso andare sopra 
	 *  
	 */
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		if(this.checkObstaclesRoom(room, pos) == false ) {
			return false;
		}
   /*   boolean item = this.checkItemsRoom(room, pos);
		if(item) {
			return true;
<<<<<<< HEAD
		} */
		return !checkWallLimits(pos);		
	}	
	
	public boolean checkWallLimits(Pair<Integer, Integer> pos) {
		//REMINDER: NEED TO CHANGE NUMBERS WHILE CHECKING COORDS BECAUSE MAINCHAR IS DIFFERENT BASED ON DIRECTIONS
		
		return ( (pos.getX() + 15 < LIMITLEFT || pos.getX() + 49 >= LIMITRIGHT) 			|| 
				  (pos.getY() + 48 < LIMITUP || pos.getY() + Player.DIMENSION >= LIMITDOWN));
	}
	
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
	private boolean checkObstaclesRoom(RoomDesign room,Pair<Integer, Integer> pos) {
		Set<Pair<Integer, Integer>> obstacleSet = room.getObstaclePositions();
		//REMINDER: NEED TO CHANGE NUMBERS WHILE CHECKING COORDS BECAUSE MAINCHAR IS DIFFERENT BASED ON DIRECTIONS
		for (Pair<Integer,Integer> obst : obstacleSet) {
//			System.out.println(obstacleSet.size());
			if(!((pos.getX() - 16 >= obst.getX() - GameSettings.TILESIZE && pos.getX() + 16 <= obst.getX() + GameSettings.TILESIZE) &&
				 (pos.getY() >= obst.getY() - GameSettings.TILESIZE && pos.getY() + 48 <= obst.getY() + GameSettings.TILESIZE)) == false) {
				return false;
			}
		}
		return true;
	}
	

	
	/*
	
	/**se dentro al set di item ci sono coordinate che corrispondono a quelle del personaggio, 
	 * allora quest'ultimo si deve muovere anche in quella posizione per poter raccogliere l'item e aggiungerlo alla 
	 * lista delle cose che possiede
	 *	
	private boolean checkItemsRoom(RoomDesign room,Pair<Integer, Integer> pos) {
		HashSet<design.tokens.WorldObject> itemSet = room.getWorldObjectsSet();
		for (design.tokens.WorldObject item : itemSet) {
			if (item.getPosition().getX() == pos.getX() && item.getPosition().getY() == pos.getY()) {
				//aggiungi item alla lista di qualcosa 
				return true;
			}
		}
		return true;
	} */
	
}
