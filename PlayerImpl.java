package player;

import utility.Pair;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import player.movement.CheckPositionPlayerImpl;
import player.movement.MovementImpl;
import player.movement.Direction;

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
		this.position = pos;
		this.level = level;
		this.totalHealth = health;
		this.currentHealth = health;
		this.texture = texture;
		this.direction = dir;
	}
	
	@Override 
	public void setPosition(Input input) {
		Pair<Integer,Integer> newPos;
		newPos = move.movePlayer(input, this.position);  
		if(check.checkLimitsPosition(newPos) == null) {
			this.position = move.movePlayer(input, this.position);  
		}
		this.position = position;
	}

	@Override
	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}
	
	@Override
	//DA SISTEMARE E METTERE DENTRO SET POSITION
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
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
	public void startShooting() {
		// TODO Auto-generated method stub
	}

	@Override
	public int isAlive(int currentHealth) {
		if(this.currentHealth <= 0);
		return 0;
	}

}