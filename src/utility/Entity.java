package utility;

/**
 * Interface 
 */

public interface Entity {
	
	/**
	 * @return character's dimension 
	 */
	public UpDownLeftRight<Integer> getDimension();
	
	/**
	 * @return character's damage 
	 */
	public int getDmg();

}
