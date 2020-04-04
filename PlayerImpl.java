package player;

import utility.Pair;
import utility.Direction;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import player.movement.CheckPositionPlayerImpl;
import player.movement.MovementImpl;

/**
 * 
 * Class that implements all the methods of Interface Player  
 * 
 */

public class PlayerImpl implements Player {

	private Pair<Integer,Integer> position;
	private int level;
	private int totalHealth;
	private int currentHealth;
	private Image texture;
	private Direction direction;
	private MovementImpl move = new MovementImpl();
	private CheckPositionPlayerImpl check = new CheckPositionPlayerImpl();
	
	public PlayerImpl(Pair<Integer,Integer> pos, Direction dir, int level, int health, Image texture) {	
		this.position = POSITION;
		this.level = level;
		this.totalHealth = HEALTH;
		this.currentHealth = HEALTH;
		this.texture = texture;
		this.direction = DIRECTION;
	}
	
	public PlayerImpl(int level, Image texture) {	
		this(POSITION, DIRECTION, level, HEALTH, texture);
	}
	
	@Override 
	public void setPosition(Input input) {
		Pair<Integer,Integer> newPos;
		newPos = move.movePlayer(input, this.position, this.direction);  
		if(check.isEnd(newPos) == true) {
			this.position = newPos;  
		}
		this.direction = move.getDirection();   // perchè la direzione cambia anche se non posso muovervi nella posizione
	}

	@Override
	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}
	
	@Override
	public int getCurrentHealth() {
		return this.currentHealth;
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
	
	@Override
	public int getDamage() {
		return 0;
	}
	
	@Override
	public void shoot() {
	}

	@Override
	public int isAlive(int currentHealth) {
		if(this.currentHealth <= 0);
		return 0;
	}

}