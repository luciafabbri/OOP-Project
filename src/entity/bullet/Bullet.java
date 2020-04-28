package entity.bullet;

import org.newdawn.slick.Image;

import design.RoomDesign;
import design.utilities.Pair;
import entity.Entity;
import entity.character.Debuff;
import entity.move.CheckPos;
import entity.move.Direction;

/**
 * An interface that defines all the main methods concerning bullets
 */

public interface Bullet extends Entity {
	
	public final static int DIMENSION = 48;
		
	/**
	 * @return
	 */
	public boolean isAlive();
	
	/** 
	 * @return
	 */
	public Pair<Integer,Integer> getPos();
	
	/**
	 * @param check
	 */
	public void updatePos(CheckPos check);
	
	/**
	 * @return
	 */
	public Debuff getDebuff();	
	
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
