package player;

import utility.Pair;
import utility.Direction;
import utility.Health;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import player.movement.CheckPositionPlayerImpl;
import player.movement.MovementImpl;

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
	private HealthPlayerImpl health = new HealthPlayerImpl(HEALTH);
	
	public PlayerImpl(Pair<Integer,Integer> pos, Direction dir, int level, Image texture) {	
		this.position = pos;
		this.level = level;
		this.texture = texture;
		this.direction = dir;
	}
	
	public PlayerImpl(int level, Image texture) {	
		this(POSITION, DIRECTION, level, texture);
	}
	
	@Override 
	public void setPosition(Input input) {
		Pair<Integer,Integer> newPos;
		newPos = move.movePlayer(input, this.position, this.direction);  
		if(check.possiblePos(newPos) == true) {
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

	public HealthPlayerImpl getHealth() {
		return health;
	}
	
}