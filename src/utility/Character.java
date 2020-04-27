package utility;

import design.utilities.Pair;
import utility.health.Health;

/**
 * Interface that extends interface Entity in order to add new methods and get information about characters 
 */

public interface Character extends Entity {
	
	/**
	 * @return character's coordinates 
	 */	
	public Pair<Integer, Integer> getPosition();	
	
	/**
	 * @return character's health
	 */
	public Health getHealth();
	
	/**
	 * @return character's direction 
	 */
	public Direction getDirection();
	
}
