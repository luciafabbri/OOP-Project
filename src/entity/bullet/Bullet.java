package entity.bullet;

import org.newdawn.slick.Image;

import design.RoomDesign;
import design.utilities.Pair;
import entity.Entity;
import entity.move.Direction;

/**
 * An interface that defines all the main methods concerning bullets
 */

public interface Bullet extends Entity {
	
	public final static int DIMENSION = 48;
		
	/**
	 * @return true if the bullet is alive
	 */
	public boolean isAlive();
	
	/** 
	 * @return bullet's position
	 */
	public Pair<Integer,Integer> getPos();
	

	/**
	 * 
	 */
	public void updatePos();
	
	/**
	 * @return
	 */
	public Direction getDirection();

	/**
	 * @return
	 */
	public Image getTexture();

	/**
	 * @param texture
	 */
	public void setTexture(Image texture);
	
	/**
	 * @return
	 */
	public RoomDesign getRoom();
	
}
