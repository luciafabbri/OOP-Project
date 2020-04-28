package entity;

/**
 * An interface used to represent all the methods that are in common with all the dynamic entities in the dungeon
 */

public interface Entity {
	
	/**
	 * @return character's dimension of type UpDownLeftRight, which means that for each entity have been checked
	 * their exacts pixel in order to be displayed in the dungeon as real as possible
	 */
	public UpDownLeftRight<Integer> getDimension();
	
	/**
	 * @return character's damage 
	 */
	public int getDamage();

}
