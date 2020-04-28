package entity.character;

import design.utilities.Pair;
import entity.Entity;
import entity.character.health.Health;
import entity.move.Direction;

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
