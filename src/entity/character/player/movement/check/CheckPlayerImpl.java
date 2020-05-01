package entity.character.player.movement.check;

import design.utilities.Pair;
import design.utilities.enums.Door;
import design.utilities.enums.Entities;
import entity.Entity;
import entity.character.enemy.Enemy;
import entity.character.player.DoorCheck;
import entity.character.player.PlayerImpl;
import entity.move.CheckPosImpl;
import gameEntities.GameEntity;
import gameEntities.Pickupable;
import gameEntities.modifiers.AttackSpeed1;
import gameEntities.modifiers.AttackUpgrade1;
import gameEntities.modifiers.HealthUpgrade1;
import gameEntities.modifiers.ModifiersImpl;
import gameEntities.modifiers.MovementSpeed1;
import design.utilities.GameSettings;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import design.RoomDesign;

public class CheckPlayerImpl extends CheckPosImpl implements CheckPlayer, GameSettings{
				
	private PlayerImpl player;
	private long startMillis = 0; 
	private long stopMillis;
	
	private Sound keyPickup;
	private Sound coinPickup;
	private Sound modPickup;
	
	public CheckPlayerImpl(Entity entity, PlayerImpl player) {
		super(entity);
		this.player = player;
		
		try {
			keyPickup = new Sound("./res/audio/pickups/keyPickup.wav");
			coinPickup = new Sound("./res/audio/pickups/coinPickup.wav");
			modPickup = new Sound("./res/audio/pickups/modifierPickup.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	//FINISCI DI SISTEMARE LA ROCCOLTA ITEM 
	@Override
	public boolean checkEntityRoom(RoomDesign room, Pair<Integer, Integer> pos) throws SlickException {
		boolean checkX, checkY;
		Set<Pickupable> itemSet = room.getPickupablesSet();
		for (GameEntity item : itemSet) {
			checkX = pos.getX() + leftPix < item.getPosition().getX() + GameSettings.TILESIZE && pos.getX() + rightPix > item.getPosition().getX();
			checkY = pos.getY() < item.getPosition().getY() + (TILESIZE - rightPix) && pos.getY() + downPix > item.getPosition().getY();
			stopMillis = System.currentTimeMillis();
			if (checkX && checkY) {
				/**
				 * check item "COIN"
				 */
				if (item.getTypeEnt().equals(Entities.COIN)) {
					player.getInventory().addCoin();
					coinPickup.play(1.0f, 0.35f);
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check item "KEY"
				 */
				if (item.getTypeEnt().equals(Entities.KEY)) {
					player.getInventory().addKey();
					keyPickup.play(1.0f, 0.15f);
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "HEALTHUPGRADE1", to increase player's health
				 */
				if (item.getTypeEnt().equals(Entities.HEALTHUPGRADE1)) {
					ModifiersImpl mod = new HealthUpgrade1(item.getPosition());
					player.getHealth().upgradeHealth(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					System.out.println("vita: "+ player.getHealth().getCurrentHealth());
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "ATTACKUPGRADE1", to increase player's attack power
				 */
				if (item.getTypeEnt().equals(Entities.ATTACKUPGRADE1)) {
					ModifiersImpl mod = new AttackUpgrade1(item.getPosition());
					player.upgradeDamage(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					System.out.println("attacco: "+ player.getDamage());
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "ATTACKSPEED1", to increase player's attack speed
				 */
				if (item.getTypeEnt().equals(Entities.ATTACKSPEED1)) {
					ModifiersImpl mod = new AttackSpeed1(item.getPosition());
					player.upgradeRof(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					System.out.println("rof : "+ player.getRof());
					room.getPickupablesSet().remove(item);
				}
				/**
				 * check modifier "MOVEMENTSPEED1", to increase player's movement speed 
				 */
				if ( (item.getTypeEnt().equals(Entities.MOVEMENTSPEED1))  && (stopMillis - startMillis > 10000) ) {
					ModifiersImpl mod = new MovementSpeed1(item.getPosition());
					player.upgradePlayerSpeed(mod.getModQty());
					modPickup.play(1.0f, 0.2f);
					System.out.println("speed : "+ player.getPlayerSpeed());
					room.getPickupablesSet().remove(item);
					startMillis = System.currentTimeMillis();
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

	//DA CONTROLLARE SE POSIZIONE NEMICO VA BENE
	@Override
	public boolean checkEnemyRoom(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		Set<Enemy> enemySet = room.getEnemySet();
		for (Enemy enemy : enemySet) {
			checkX = pos.getX() + enemy.getDimension().getLeft() < enemy.getPosition().getX() + GameSettings.TILESIZE && pos.getX() + enemy.getDimension().getRight() > enemy.getPosition().getX();
			checkY = pos.getY() < enemy.getPosition().getY() + (TILESIZE - enemy.getDimension().getRight()) && pos.getY() + enemy.getDimension().getDown() > enemy.getPosition().getY();
			stopMillis = System.currentTimeMillis();
			if ( (checkX && checkY) && (stopMillis - startMillis > 1000) ){ 
				player.getHealth().takeDmg(enemy.getDamage());
				System.out.println("danno dal nemico preso\n");
				System.out.println("vita: "+ player.getHealth().getCurrentHealth());
				if(!player.getHealth().isAlive()) {
					System.out.println("PLAYER MORTO");
				}
				startMillis = System.currentTimeMillis();
				return true;
			}
		}
    	return false;
    }
}
