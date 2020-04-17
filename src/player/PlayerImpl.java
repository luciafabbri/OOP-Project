package player;

import design.utilities.Door;
import design.utilities.Pair;
import levels.Level;
import utility.Direction;
import utility.health.HealthImpl;

import java.util.Map;
import java.util.Optional;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

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

		if( check.possiblePos(this.currentRoom, newPos) || check.checkDoors(newPos, map)) {
			this.position = newPos;  
		}
		this.direction = move.getDirection();   /** direction changes even if the player can't actually go in that position */
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
	
	public RoomDesign getRoom() {
		return this.currentRoom;
	}
	
	public void setCurrentRoom(RoomDesign room) {
		this.currentRoom = room;
	}

	public void setPosition(Pair<Integer, Integer> position) {
		this.position = position;
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

	public MovementImpl getMove() {
		return move;
	}

	public Animation getRight() {
		return right;
	}
	
}