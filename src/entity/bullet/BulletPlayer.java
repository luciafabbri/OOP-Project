package entity.bullet;

/**
 * An interface that extends the interface Bullet in order to add new specific methods regarding player's bullet  
 */

public interface BulletPlayer extends Bullet {
	
	/**
	 * Method used to update player bullet's position with respect to all the entities that can be found in the dungeon
	 */
	public void updatePos();

}
