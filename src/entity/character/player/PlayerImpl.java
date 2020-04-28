package entity.character.player;

import design.utilities.Pair;
import design.utilities.enums.Door;
import entity.UpDownLeftRight;
import entity.character.health.Health;
import entity.character.health.HealthImpl;
import entity.character.player.inventory.Inventory;
import entity.character.player.inventory.InventoryImpl;
import entity.character.player.movement.Movement;
import entity.character.player.movement.MovementImpl;
import entity.character.player.movement.check.CheckPlayer;
import entity.character.player.movement.check.CheckPlayerImpl;
import entity.character.player.shoot.BulletMovement;
import entity.character.player.shoot.BulletMovementImpl;
import entity.move.Direction;
import levels.Level;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

import bullet.Bullet;
import bullet.BulletPlayer;
import design.RoomDesign;

public class PlayerImpl implements Player {

	private Pair<Integer,Integer> position;
	private int level;
	private Animation front;
	private Animation back;
	private Animation left;
	private Animation right;

	private Sound bowShoot;
	
	private Direction direction;
	private Movement move = new MovementImpl();
	private CheckPlayer check = new CheckPlayerImpl(this,this);

	private Health health = new HealthImpl(HEALTH);
	private RoomDesign currentRoom;
	private Inventory inventory = new InventoryImpl(this);
	private BulletMovement bullet = new BulletMovementImpl(this);
	private Set<BulletPlayer> roomBullets = new HashSet<>();
	
	private int playerSpeed;
	private int bulletSpeed;
	private int dmg;
	private int rof;
	
	public PlayerImpl(Pair<Integer,Integer> pos, Direction dir, int level) {	
		this.position = pos;
		this.level = level;
		this.direction = dir;
		this.playerSpeed = 1;
		this.bulletSpeed = 1;
		this.rof = 1000;
		this.dmg = 10;
		
		try {
			bowShoot = new Sound("./res/audio/bow/bow_fired.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PlayerImpl(int level, Image texture) throws SlickException {	
		this(POSITION, DIRECTION, level);
	}
	
	@Override
	public void loadAnimations() throws SlickException {
		
		front = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_front.png"), 64, 64), 100);
		back = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_back.png"), 64, 64), 100);
		left = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_left.png"), 64, 64), 100);
		right = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_right.png"), 64, 64), 100);
		
	}
	
	@Override 
	public void setPosition(Input input, Level level) throws SlickException {
		Pair<Integer,Integer> newPos;
		Map<Door, Optional<RoomDesign>> map = level.getLevel().get(level.getRoomID()).getDoorAccess();
		newPos = move.movePlayer(input, this.position, this.direction, this.playerSpeed); 

		if( check.checkEntityRoom(this.currentRoom,newPos) || check.checkEnemyRoom(this.currentRoom, newPos) || 
				check.possiblePos(this.currentRoom, newPos) || check.checkDoors(newPos, map) ) {
			this.position = newPos;  
		}
		this.direction = move.getDirection();   /** direction changes even if the player can't actually go in that position */
	}
	
	@Override
	public void setPosition(Pair<Integer, Integer> position) {
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
	public int getRof() {
		return this.rof;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public Animation getFront() {
		return front;
	}

	@Override
	public Animation getBack() {
		return back;
	}

	@Override
	public Animation getLeft() {
		return left;
	}

	@Override
	public Animation getRight() {
		return right;
	}
	
	@Override
	public Movement getMove() {
		return move;
	}
	
	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

	@Override
	public UpDownLeftRight<Integer> getDimension() {
		if(direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
			return VERTICAL;
		}  else if(direction.equals(Direction.WEST) || direction.equals(Direction.EAST)) {
			return ORIZONTAL;
		}
		return new UpDownLeftRight<Integer>(0, 0, 0, 0);
	}
	
	@Override
	public int getPlayerSpeed() {
		return this.playerSpeed;
	}
	
	@Override
	public void upgradePlayerSpeed(int speedPlayer) {
		this.playerSpeed = this.playerSpeed + speedPlayer;
	}
	
	@Override
	public int getBulletSpeed() {
		return this.bulletSpeed;
	}
	
	@Override
	public void upgradeBulletSpeed(int speedBullet) {
		this.bulletSpeed = this.bulletSpeed + speedBullet;
	}
	
	public int getDmg() {
		return dmg;
	}
	
	@Override
	public void upgradeDmg(int damage) {
		this.dmg = this.dmg + damage;
	}
	
	@Override
	public void takeDmg(int damage) {
		this.health.takeDmg(damage);
	}
	
	@Override
	public BulletMovement getBullet() {
		return this.bullet;
	}
	
	@Override
	public CheckPlayer getCheck() {
		return this.check;
	}

	@Override
	public Set<BulletPlayer> getRoomBullets() {
		return roomBullets;
	}

	public Sound getBowShoot() {
		return bowShoot;
	}
}