package entity.character.health;

/**
 * An interface that defines all the aspects of the class Health, used to get information about player's and enemies's lives
 */

public interface Health {
		
	/**
	 * @return the value of the entity's current life 
	 */
	public int getCurrentHealth();
	
	/**
	 * @param dmg, an int value to be subtracted to the entity's current life
	 */
	public void takeDmg(int damage);
	
	/**
	 * @return true if entity's life value is greater than 0
	 */
	public boolean isAlive();

	/**
	 * @return the value of the entity's max life 
	 */
	public int getMaxHealth();
	
	/**
	 * @param upgrade, an int value to be added to the entity's current life
	 */
	public void upgradeHealth(int upgrade);

	/**
	 * @param health, an int value to be subtracted to the entity's current life
	 */
	public void setCurrentHealth(int health);

}
