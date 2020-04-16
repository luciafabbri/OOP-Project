package player;

import design.utilities.Pair;
import utility.Direction;
import utility.health.HealthImpl;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import player.movement.CheckPositionPlayerImpl;
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
	private Image texture;
	private Direction direction;
	private MovementImpl move = new MovementImpl();
	private CheckPositionPlayerImpl check = new CheckPositionPlayerImpl();
	private HealthImpl health = new HealthImpl(HEALTH);
	private RoomDesign currentRoom;
	
	public PlayerImpl(Pair<Integer,Integer> pos, Direction dir, int level, Image texture, RoomDesign room) {	
		this.position = pos;
		this.level = level;
		this.texture = texture;
		this.direction = dir;
		this.currentRoom = room;
	}
	
	public PlayerImpl(int level, Image texture, RoomDesign room) {	
		this(POSITION, DIRECTION, level, texture, room);
	}
	
	@Override 
	public void setPosition(Input input) {
		Pair<Integer,Integer> newPos;
		newPos = move.movePlayer(input, this.position, this.direction);  
		if(check.possiblePos(this.currentRoom, newPos, direction)) {
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
	
	@Override
	public Image getImage() {
		return this.texture;
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
	
}