package player;

import utility.Pair;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import player.movement.Direction;
/**
 * 
 * Interface that presents all the methods needed or that can be used with regards to the player 
 * 
 */

public interface Player {
	
	/**
	 * 
	 * Methods used to set Player's position
	 *  
	 */
	public void setPosition(Input input);

	
	/**
	 * 
	 * Methods used to get Player's position
	 *  
	 */
	public Pair<Integer, Integer> getPosition();
	
	
	/**
	 * 
	 * Methods used to set Player's direction
	 *  
	 */
	public void setDirection(Direction direction);
	
	
	/**
	 * 
	 * Methods used to get Player's actual life
	 *  
	 */
	public int getCurrentHealth();
	
	
	/**
	 * 
	 * Methods used to set the level in which the player should go
	 *  
	 */
	public void setLevel(int level);
	
	
	/**
	 * 
	 * Methods used to know in which level the player is 
	 *  
	 */
	public int getLevel();
	
	
	/**
	 * 
	 * Methods used to get Player's image
	 *  
	 */
	public Image getImage();

	
	/**
	 * 
	 * Methods used to know the damage of an event
	 *  
	 */
	public int getDamage();
	
	
	/**
	 * 
	 * Methods used to tell the player to start shooting enemies
	 *  
	 */
	public void shoot(); 
	
	
	/**
	 * 
	 * Methods used to check if the player is still alive
	 *  
	 */
	public int isAlive(int currentHealth);
	
	//public Debuff setDebuff();
	//public Buff setBuff();
	//public Debuff getDebuff();
	//public Buff getBuff();

}
