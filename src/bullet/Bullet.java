package bullet;

import org.newdawn.slick.Image;

import design.RoomDesign;
import design.utilities.Pair;
import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import utility.Entity;

public interface Bullet extends Entity {
	
	public final static int DIMENSION = 48;
		
	public boolean isAlive();
	
	public Pair<Integer,Integer> getPos();
	
	public void updatePos(CheckPos check);
	
	public int getDmg();
	
	public Debuff getDebuff();	
	
	public Direction getDirection();

	public Image getTexture();

	public void setTexture(Image texture);
	
	public RoomDesign getRoom();
}
