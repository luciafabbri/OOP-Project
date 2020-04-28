package entity.bullet;

import org.newdawn.slick.Image;

import design.RoomDesign;
import design.utilities.Pair;
import entity.Entity;
import entity.character.Debuff;
import entity.move.Direction;

/**
 * Interface
 */

public interface Bullet extends Entity {
	
	public final static int DIMENSION = 48;
		
	public boolean isAlive();
	
	public Pair<Integer,Integer> getPos();
	
	public void updatePos();
	
	public Debuff getDebuff();	
	
	public Direction getDirection();

	public Image getTexture();

	public void setTexture(Image texture);
	
	public RoomDesign getRoom();
}
