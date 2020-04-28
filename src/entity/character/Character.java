package entity.character;

import design.utilities.Pair;
import entity.Entity;
import entity.character.health.Health;
import entity.move.Direction;

/**
 * An interface that extends interface Entity in order to add new methods and get information about characters 
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
	
	/**
	 * Method used to take player's damage from enemies or entities
	 * @param damage, an int value to subtract to player's current health
	 */
	public void takeDmg(int damage);
	
}
