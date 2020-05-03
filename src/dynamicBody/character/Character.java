package dynamicBody.character;

import java.util.Set;

import org.newdawn.slick.Animation;

import design.utilities.Pair;
import dynamicBody.DynamicBody;
import dynamicBody.bullet.Bullet;
import dynamicBody.character.health.Health;
import dynamicBody.move.Direction;

/**
 * An interface that extends interface DynamicBody in order to add new methods and get information about characters 
 */

public interface Character extends DynamicBody {
	
	/**
	 * @return character's coordinates 
	 */	
	Pair<Integer, Integer> getPosition();	
	
	/**
	 * @return character's health
	 */
	Health getHealth();
	
	/**
	 * @return character's direction 
	 */
	Direction getDirection();
	
	/**
	 * Method used to take character's damage from any other entity
	 * @param damage, an int value to subtract to character's current health
	 */
	void takeDamage(int damage);
	
	/**
	 * @return character's Animation
	 */
	Animation getAnimation();
	
	/**
	 * @return character's bullet set 
	 */
	Set<Bullet> getRoomBullets();
	
}
