package player.movement;

import design.utilities.Pair;
import design.utilities.enums.Door;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;
import gameEntities.GameEntity;
import gameEntities.modifiers.AttackUpgrade1;
import gameEntities.modifiers.HealthUpgrade1;
import gameEntities.modifiers.ModifiersImpl;
import player.PlayerImpl;
import utility.CheckPosImpl;

import utility.DoorCheck;
import utility.Entity;
import design.utilities.GameSettings;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.newdawn.slick.SlickException;

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
	 * @throws SlickException 
	 */
	@Override
	public boolean checkEntityRoom(RoomDesign room, Pair<Integer, Integer> pos) throws SlickException {
		boolean checkX, checkY;
		Set<GameEntity> itemSet = room.getEntitiesSet();
		for (GameEntity item : itemSet) {
			checkX = pos.getX() + leftPix < item.getPosition().getX() + GameSettings.TILESIZE && pos.getX() + rightPix > item.getPosition().getX();
			checkY = pos.getY() < item.getPosition().getY() + (TILESIZE - rightPix) && pos.getY() + downPix > item.getPosition().getY();
			if (checkX && checkY) {
				if (item.getPickUps().get().equals(Pickupables.COIN)) {
					player.getInventory().addCoin();
					room.getEntitiesSet().remove(item);
				}
				if (item.getPickUps().get().equals(Pickupables.KEY)) {
					player.getInventory().addKey();
					room.getEntitiesSet().remove(item);
				}
				if (item.getPickUps().get().equals(Pickupables.HEALTHUPGRADE1)) {
					ModifiersImpl mod = new HealthUpgrade1(item.getPosition());
					player.getHealth().upgradeHealth(mod.getModQty());
					room.getEntitiesSet().remove(item);
				}
				if (item.getPickUps().get().equals(Pickupables.ATTACKUPGRADE1)) {
					//SISTEMA CON AGGIUNTA ATTACCO
					ModifiersImpl mod = new AttackUpgrade1(item.getPosition());
					room.getEntitiesSet().remove(item);
					System.out.println("Item attack preso\n");
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean checkStairs(RoomDesign room, Pair<Integer, Integer> pos) {
		if( room.areStairsPresent() ) {
			boolean checkX, checkY;
			checkX = pos.getX() + leftPix < room.getStairs().getPosition().getX() + GameSettings.TILESIZE && pos.getX() + rightPix > room.getStairs().getPosition().getX();
			checkY = pos.getY() < room.getStairs().getPosition().getY() + (TILESIZE - rightPix) && pos.getY() + downPix > room.getStairs().getPosition().getY();
			if (checkX && checkY) {
				return true;
			}
		}
		return false;
	}
}
