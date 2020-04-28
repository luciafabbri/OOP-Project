package entity.character.player.inventory;

/**
 * Interface used to store objects that the player can pick up by walking into the environment
 */

public interface Inventory {
	
	/**
	 * @return player's coins stored in the inventory
	 */
	public int getCoin();

	/**
	 * @return player's keys stored in the inventory
	 */
	public int getKey();
	
	/**
	 * Method used to add a new coin in the inventory 
	 */
	public void addCoin();

	/**
	 * Method used to add a new key in the inventory
	 */
	public void addKey();

}
