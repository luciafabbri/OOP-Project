package dynamicBody.character.enemy;

import dynamicBody.bullet.Bullet;

/**
 * Interface that presents all the methods needed or that can be used with
 * regards to the enemy
 */
public interface Enemy extends dynamicBody.character.Character {

	/**
	 * Update the position of the enemy
	 */
	public void updatePos();

	/**
	 * Method use by Enemy.attack to put the bullet in the Set<Bullet>
	 * 
	 * @param bullet, the Bullet to add
	 */
	public void addBullet(Bullet bullet);

	/*
	 * Method use attack with the enemy
	 */
	public void attack();
	
	public TypeEnemy getType();

}
