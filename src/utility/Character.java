package utility;

import design.utilities.Pair;
import utility.health.Health;

public interface Character extends Entity {
	
	/**
	 * 
	 * Methods used to get Character's position
	 *  
	 */	
	public Pair<Integer, Integer> getPosition();	
	
	/**
	 * 
	 * Methods used to get Character's health
	 *  
	 */
	public Health getHealth();
	
	/**
	 * 
	 * Methods used to set Character's direction
	 *  
	 */
	public Direction getDirection();
}
