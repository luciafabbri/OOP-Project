package dynamicBody.character.player.movement.check;

import dynamicBody.DynamicBody;
import dynamicBody.character.DoorCheck;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.player.PlayerImpl;
import dynamicBody.move.CheckPosImpl;
import gameEntities.GameEntity;
import gameEntities.Pickupable;
import gameEntities.items.Coin;
import gameEntities.items.Key;
import gameEntities.modifiers.*;
import levels.Level;
import worldModel.RoomModel;
import worldModel.utilities.GameSettings;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Door;
import worldModel.utilities.enums.Entities;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * Class that implements interface CheckPlayer used to check and then to force the player 
 * to do the specific chosen actions
 */

public class CheckPlayerMovementImpl extends CheckPosImpl implements CheckPlayerMovement, GameSettings{
				
	private PlayerImpl player;
	
	/**
	 * Variable used to start counting milliseconds to track the passing of time 
	 * Set to zero because the count repeats itself each time the player start pressing the keyboard
	 */
	private long startMillis = 0; 
	
	/**
	 * Variable used to stop counting milliseconds to track the passing of time 
	 * Used in method checkEnemyRoom 
	 * If the player has already had a first collision with an enemy and the difference between start and stop 
	 * is major than 1000, he will take additional damage ( because it means that after 1 second the player
	 * is still being hurt by an enemy ) 
	 */
	private long stopMillis;
	
	/**
	 * Sounds variables used when the player picks an item or a modifier up
	 */
	private Sound keyPickup;
	private Sound coinPickup;
	private Sound modPickup;
	
	/**
	 * Default constructor
	 * 
	 *  @param entity, entity is used to inherit all the methods implemented in class CheckPosImpl
	 *  @param player, current entity of which we will do the check
	 */
	public CheckPlayerMovementImpl(PlayerImpl player) {
		super(player);
		this.player = player;

		try {
			keyPickup = new Sound("./res/audio/pickups/keyPickup.wav");
			coinPickup = new Sound("./res/audio/pickups/coinPickup.wav");
			modPickup = new Sound("./res/audio/pickups/modifierPickup.wav");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean checkDoors(Pair<Integer, Integer> pos, Map<Door, Optional<RoomModel>> map) {
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

	@Override
	public boolean checkStairs(RoomModel room, Pair<Integer, Integer> pos) {
		if( room.areStairsPresent() ) {
			boolean checkX, checkY;
			checkX = pos.getX() + player.getDimension().getLeft() < room.getStairs().getPosition().getX() + GameSettings.TILESIZE && 
					pos.getX() + player.getDimension().getRight() > room.getStairs().getPosition().getX();
			checkY = pos.getY() < room.getStairs().getPosition().getY() + (TILESIZE - player.getDimension().getRight()) &&
					pos.getY() + player.getDimension().getDown() > room.getStairs().getPosition().getY();
			if (checkX && checkY) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkEnemyRoom(RoomModel room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		Set<Enemy> enemySet = room.getEnemySet();
		for (Enemy enemy : enemySet) {
			checkX = pos.getX() + player.getDimension().getLeft() < enemy.getPosition().getX() + GameSettings.TILESIZE &&
					pos.getX() + player.getDimension().getRight() > enemy.getPosition().getX();
			checkY = pos.getY() < enemy.getPosition().getY() + (TILESIZE - player.getDimension().getRight()) &&
					pos.getY() + player.getDimension().getDown() > enemy.getPosition().getY();
			stopMillis = System.currentTimeMillis();
			if ( (checkX && checkY) && (stopMillis - startMillis > 1000) ){ 
				player.takeDamage(enemy.getDamage());
				startMillis = System.currentTimeMillis();
				return true;
			}
		}
    	return false;
    }
	
	@Override
	public boolean checkGameEntities(RoomModel room, Pair<Integer,Integer> pos, Level level) throws SlickException {
		return ( checkCoin(pos, level) || checkKey(pos, level) || checkModifiers(room,pos) ) ;
	}
	
	/**
	 * Method used to check if the player is in collision with any modifiers in the room
	 * In a positive case, he will change the corresponding parameter
	 * 
	 * @param room, current room where the player is
	 * @param pos, player's coordinates inside the room
	 * @return true if the player had a collision 
	 * @throws SlickException 
	 */
	private boolean checkModifiers(RoomModel room, Pair<Integer, Integer> pos) throws SlickException {
		boolean checkX, checkY;
		Set<Pickupable> itemSet = room.getPickupablesSet();
		for (GameEntity item : itemSet) {
			checkX = pos.getX() + player.getDimension().getLeft() < item.getPosition().getX() + GameSettings.TILESIZE && 
					pos.getX() + player.getDimension().getRight() > item.getPosition().getX();
			checkY = pos.getY() < item.getPosition().getY() + (TILESIZE - player.getDimension().getRight()) && 
					pos.getY() + player.getDimension().getDown() > item.getPosition().getY();
			if (checkX && checkY) {
				/**
				 * check modifier "RECOVERHEALTH", to increase player's current health
				 */
				if (item.getTypeEnt().equals(Entities.RECOVERHEALTH)) {
					ModifiersImpl mod = new HealthUpgrade1(item.getPosition());
					player.heal(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "HEALTHUPGRADE1", to increase player's max health
				 */
				if (item.getTypeEnt().equals(Entities.HEALTHUPGRADE1)) {
					ModifiersImpl mod = new HealthUpgrade1(item.getPosition());
					player.upgradeMaxHealth(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "ATTACKUPGRADE1", to increase player's attack power
				 */
				if (item.getTypeEnt().equals(Entities.ATTACKUPGRADE1)) {
					ModifiersImpl mod = new AttackUpgrade1(item.getPosition());
					player.upgradeDamage(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "ATTACKSPEED1", to increase player's attack speed
				 */
				if (item.getTypeEnt().equals(Entities.ATTACKSPEED1)) {
					ModifiersImpl mod = new AttackSpeed1(item.getPosition());
					if (player.getRateOfFire() > 400) {
						player.upgradeRateOfFire(mod.getModQty());
						System.out.println("rate : " +player.getRateOfFire());
					}
					modPickup.play(1.0f, 0.2f);
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "MOVEMENTSPEED1", to increase player's movement speed 
				 */
				if (item.getTypeEnt().equals(Entities.MOVEMENTSPEED1)) {
					ModifiersImpl mod = new MovementSpeed1(item.getPosition());
					player.upgradePlayerSpeed(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					room.getPickupablesSet().remove(item);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method used to check if the player is above the coin and can pick it up
	 * The coin appears only at each level and it represents only a collectible to the player
	 * 
	 * @param pos, player's current position
	 * @param level, player's current level
	 * @return true if the player is above the coin and can collect it 
	 */
	private boolean checkCoin(Pair<Integer, Integer> pos, Level level) {
		boolean checkX, checkY;
		if( level.getLevel().get(level.getRoomID()).getRoom().getCoin().isPresent() && !level.isGotLevelCoin() ){
			Coin item = level.getLevel().get(level.getRoomID()).getRoom().getCoin().get();
			checkX = pos.getX() + player.getDimension().getLeft() < item.getPosition().getX() + GameSettings.TILESIZE && 
					pos.getX() + player.getDimension().getRight() > item.getPosition().getX();
			checkY = pos.getY() < item.getPosition().getY() + (TILESIZE - player.getDimension().getRight()) && 
					pos.getY() + player.getDimension().getDown() > item.getPosition().getY();
			if(checkX && checkY) {
				if(!coinPickup.playing()) {
					coinPickup.play(1.0f, 0.35f);
				}
				level.setGotLevelCoin(true);
				player.getInventory().addCoin();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method used to check if the player is above the key and can pick it up
	 * The key appears in each room in order to open the doors and let the player move into the dungeon and explore it
	 * 
	 * @param pos, player's current position
	 * @param level, player's current level 
	 * @return true if the player is above the key and can collect it 
	 */
	private boolean checkKey(Pair<Integer, Integer> pos, Level level) {
		boolean checkX, checkY;
		Key item = level.getLevel().get(level.getRoomID()).getRoom().getKey();
		checkX = pos.getX() + player.getDimension().getLeft() < item.getPosition().getX() + GameSettings.TILESIZE &&
				pos.getX() + player.getDimension().getRight() > item.getPosition().getX();
		checkY = pos.getY() < item.getPosition().getY() + (TILESIZE - player.getDimension().getRight()) && 
				pos.getY() + player.getDimension().getDown() > item.getPosition().getY();
		if( (checkX && checkY) && !level.getLevel().get(level.getRoomID()).isGotRoomKey() ) {
			if(!keyPickup.playing()) {
				keyPickup.play(1.0f, 0.15f);	
			}
			level.getLevel().get(level.getRoomID()).setGotRoomKey(true);
			return true;
		}
		return false;
	}
	
}
