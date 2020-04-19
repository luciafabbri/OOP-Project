package player.movement;

import design.utilities.Pair;
import design.utilities.enums.Door;
import design.utilities.enums.Entities;
import gameEntities.GameEntity;
import player.PlayerImpl;
import utility.CheckPosImpl;

import utility.DoorCheck;
import utility.Entity;
import design.utilities.GameSettings;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import design.RoomDesign;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */


public class CheckPlayerImpl extends CheckPosImpl implements CheckPlayer, GameSettings{
				
	PlayerImpl player;
	
	public CheckPlayerImpl(Entity entity, PlayerImpl player) {
		super(entity);
		this.player = player;
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
	public boolean checkEntityRoom(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		Set<GameEntity> itemSet = room.getEntitiesSet();
		for (GameEntity item : itemSet) {
			checkX = pos.getX() + leftPix < item.getPosition().getX() + GameSettings.TILESIZE && pos.getX() + rightPix > item.getPosition().getX();
			checkY = pos.getY() < item.getPosition().getY() + (TILESIZE - rightPix) && pos.getY() + downPix > item.getPosition().getY();
			if (checkX && checkY) {
				if (item.getTypeEnt().equals(Entities.COIN)) {
					player.getInventory().addCoin();
				}
				else if (item.getTypeEnt().equals(Entities.KEY)) {
					player.getInventory().addKey();
				}
				System.out.println("Item preso\n");
				return true;
			}
		}
		return false;
	}
}
