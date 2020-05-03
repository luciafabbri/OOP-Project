package dynamicBody.character.player;

import design.utilities.Pair;
import design.utilities.enums.Door;
import dynamicBody.UpDownLeftRight;
import dynamicBody.bullet.Bullet;
import dynamicBody.character.health.*;
import dynamicBody.character.player.inventory.*;
import dynamicBody.character.player.movement.*;
import dynamicBody.character.player.movement.check.*;
import dynamicBody.character.player.shoot.*;
import dynamicBody.move.Direction;
import levels.Level;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import design.RoomDesign;

/**
 * Class that implements interface Player used to define all the aspects concerning the player 
 */

public class PlayerImpl implements Player {

	private int level;
	private boolean clearRoom;
	private int playerSpeed;
	private int damage;
	private int rateOfFire;
	private Pair<Integer,Integer> position;
	private Direction direction;
	private Movement move;
	private CheckPlayer check;
	private Health health;
	private RoomDesign currentRoom;
	private Inventory inventory;
	
	private UpDownLeftRight<Animation> textures;
	private Pair<PlayerDimensions, PlayerDimensions> dimensions;

	private Sound bowShoot;
	private Sound hurtSound;
	
	private BulletMovement bullet ;
	private Set<Bullet> roomBullets = new HashSet<>();

	/**
	 * Default constructor
	 * @param pos, player's position
	 * @param dir, player's direction
	 * @param level, player's starting level
	 */
	public PlayerImpl(Pair<Integer,Integer> pos, Direction dir, int level) {	
		this.position = pos;
		this.level = level;
		this.direction = dir;
		this.playerSpeed = 1;
		this.rateOfFire = 1000;
		this.damage = 10;
		this.inventory = new InventoryImpl(this);
		this.health = new HealthImpl(100);
		this.move = new MovementImpl();
		this.check = new CheckPlayerImpl(this,this);
		this.bullet = new BulletMovementImpl(this);
		this.dimensions = PlayerDimensions.getPlayerDimensions(this);
		this.clearRoom = false;
		
		try {
			bowShoot = new Sound("./res/audio/bow/bow_fired.wav");
			hurtSound = new Sound("./res/audio/mainChar/hurtSound.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override 
	public void setPosition(Input input, Level level) throws SlickException {
		Pair<Integer,Integer> newPos;
		Map<Door, Optional<RoomDesign>> map = level.getLevel().get(level.getRoomID()).getDoorAccess();
		newPos = move.movePlayer(input, this.position, this.direction, this.playerSpeed); 

		if( check.checkEntityRoom(this.currentRoom,newPos) || check.checkEnemyRoom(this.currentRoom, newPos) || 
				check.possiblePos(this.currentRoom, newPos) || (check.checkDoors(newPos, map) && clearRoom)) {
			this.position = newPos;  
		}
		/**
		 *  direction changes even if the player can't actually go in that position
		 */
		this.direction = move.getDirection();   
	}
	
	@Override
	public void transitionPos(Pair<Integer, Integer> position) {
		this.position = position;
	}

	@Override
	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}
	
	@Override
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public int getLevel() {
		return this.level;
	}
	
	@Override
	public Health getHealth() {
		return this.health;
	}
	
	@Override
	public void setCurrentRoom(RoomDesign room) {
		this.currentRoom = room;
	}
	
	@Override
	public RoomDesign getRoom() {
		return this.currentRoom;
	}
	
	@Override
	public int getRateOfFire() {
		return this.rateOfFire;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public Movement getMove() {
		return this.move;
	}
	
	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

	@Override
	public Animation getAnimation() {
		switch (this.direction) {
		case NORTH:
			return textures.getUp();
		case SOUTH:
			return textures.getDown();
		case WEST:
			return textures.getLeft();
		case EAST:
			return textures.getRight();
		default:
			throw new IllegalArgumentException();

		}
	}
	
	@Override
	public UpDownLeftRight<Integer> getDimension() {
		if(direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
			return dimensions.getX().getDimensions();
		} else if(direction.equals(Direction.WEST) || direction.equals(Direction.EAST)) {
			return dimensions.getY().getDimensions();
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public int getPlayerSpeed() {
		return this.playerSpeed;
	}
	
	@Override
	public void upgradePlayerSpeed(int upgrade) {
		this.playerSpeed = this.playerSpeed + upgrade;
	}
	
	@Override
	public void upgradeDamage(int upgrade) {
		this.damage = this.damage + upgrade;
	} 
	
	@Override
	public void upgradeRateOfFire(int upgrade) {
		this.rateOfFire = this.rateOfFire - upgrade;
	} 
	
	@Override
	public void upgradeMaxHealth(int upgrade) {
		this.health.upgradeMaxHealth(upgrade);
	}
	
	@Override
	public void heal(int heal) {
		this.health.heal(heal);
	}
	
	@Override
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public void takeDamage(int damage) {
		if(!hurtSound.playing())
			hurtSound.play(1.0f, 0.4f);
		this.health.takeDmg(damage);
	}
	
	@Override
	public boolean isAlive() {
		return this.getHealth().isAlive() ;
	}
	
	/**
	 * used in class LogicImpl 
	 */
	@Override
	public BulletMovement getBullet() {
		return this.bullet;
	} 
	
	/**
	 * used in class LevelsPlay
	 */
	@Override    
	public CheckPlayer getCheck() {
		return this.check;
	}

	@Override
	public Set<Bullet> getRoomBullets() {
		return this.roomBullets;
	}

	@Override
	public Sound getBowShoot() {
		return this.bowShoot;
	}
	
	@Override
	public void loadAnimations() throws SlickException {
		this.textures = PlayerImages.getTexture(this);
	}

	@Override
	public void setClearRoom(boolean clearRoom) {
		this.clearRoom = clearRoom;
	}

}