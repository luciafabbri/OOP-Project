package player;

import design.utilities.Door;
import design.utilities.Pair;
import gameEntities.modifiers.ModifiersImpl;
import levels.Level;
import utility.Direction;
import utility.Stats;
import utility.UpDownLeftRight;
import utility.health.HealthImpl;

import java.util.Map;
import java.util.Optional;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tests.xml.Inventory;

import player.movement.CheckPlayer;
import player.movement.CheckPlayerImpl;

import player.movement.MovementImpl;
import design.RoomDesign;


/**
 * 
 * Class that implements all the methods of Interface Player and create an object PlayerImpl
 * 
 */

public class PlayerImpl implements Player {

	private Pair<Integer,Integer> position;
	private int level;
	private Animation front;
	private Animation back;
	private Animation left;
	private Animation right;
	
	private Direction direction;
	private MovementImpl move = new MovementImpl();
	private CheckPlayer check = new CheckPlayerImpl(this);

	private HealthImpl health = new HealthImpl(HEALTH);
	private RoomDesign currentRoom;
	private InventoryImpl inventory = new InventoryImpl(this);

	private ModifiersImpl modifiers;
	
	public PlayerImpl(Pair<Integer,Integer> pos, Direction dir, int level) {	
		this.position = pos;
		this.level = level;
		this.direction = dir;
	}
	
	public PlayerImpl(int level, Image texture) throws SlickException {	
		this(POSITION, DIRECTION, level);
	}
	
	public void loadAnimations() throws SlickException {
		
		front = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_front.png"), 64, 64), 100);
		back = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_back.png"), 64, 64), 100);
		left = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_left.png"), 64, 64), 100);
		right = new Animation(new SpriteSheet(new Image("./res/chars/mainChar6_right.png"), 64, 64), 100);
		
	}
	
	@Override 
	public void setPosition(Input input, Level level) {
		Pair<Integer,Integer> newPos;
		Map<Door, Optional<RoomDesign>> map = level.getLevel().get(level.getRoomID()).getDoorAccess();
		newPos = move.movePlayer(input, this.position, this.direction); 

		if( check.possiblePos(this.currentRoom, newPos) || check.checkDoors(newPos, map) || 
					check.checkItemsRoom(this.currentRoom,newPos) || check.checkModifiersRoom(this.currentRoom, newPos)) {
			this.position = newPos;  
		}
		this.direction = move.getDirection();   /** direction changes even if the player can't actually go in that position */
	}
	
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
	
	public HealthImpl getHealth() {
		return this.health;
	}
	
	public void setCurrentRoom(RoomDesign room) {
		this.currentRoom = room;
	}
	
	public RoomDesign getRoom() {
		return this.currentRoom;
	}

	public Direction getDirection() {
		return direction;
	}

	public Animation getFront() {
		return front;
	}

	public Animation getBack() {
		return back;
	}

	public Animation getLeft() {
		return left;
	}

	public Animation getRight() {
		return right;
	}
	
	public MovementImpl getMove() {
		return move;
	}
	
	// SISTEMARE
	public InventoryImpl getInventory() {
		return this.inventory;
	}
	
	// SISTEMARE
	public void setStats(Stats statsValue) {
		for (Stats s : Stats.values()) {
			if(s.equals(statsValue)) {
				s.toString();
			}
		}
	}

	@Override
	public UpDownLeftRight getDimension() {
		if(direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
			return VERTICAL;
		}  else if(direction.equals(Direction.WEST) || direction.equals(Direction.EAST)) {
			return ORIZONTAL;
		}
		return new UpDownLeftRight(0, 0, 0, 0);
	}
	
}