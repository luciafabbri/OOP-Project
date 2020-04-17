package utility;

import java.util.List;

import design.utilities.Pair;
import utility.health.Health;

public interface Character {
	
	/**
	 * 
	 * Methods used to get Character's position
	 *  
	 */	
	public Pair<Integer, Integer> getPosition();	
	
	/**
	 * 
	 * Methods used to know in which level the character is 
	 *  
	*/ 
	public int getLevel();
	
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
	
	/**
	 * 
	 * Methods used to get Character's Dimensions
	 *  
	 
	public List<Integer> getDimension();*/
}
