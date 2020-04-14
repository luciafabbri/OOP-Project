package player;

import design.RoomDesign;
import design.utilities.Pair;
import utility.health.HealthImpl;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 * 
 * Interface that presents all the methods needed or that can be used with regards to the player 
 * 
 */

public interface Player extends DefaultPlayer {
	
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
	 * Methods used to get Player's health
	 *  
	 */
	public HealthImpl getHealth();
	

	/**
	 * 
	 * Methods used to get Player's current room
	 *  
	 */
	public RoomDesign getRoom();

	/**
	 * 
	 * Methods used to set Player's current room
	 *  
	 */
	public void setCurrentRoom(RoomDesign room);

	//public Debuff setDebuff();
	//public Buff setBuff();
	//public Debuff getDebuff();
	//public Buff getBuff();

}
