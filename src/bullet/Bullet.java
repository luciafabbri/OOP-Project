package bullet;

import org.newdawn.slick.Image;

import utility.Pair;
import utility.CheckPos;
import utility.Debuff;
import utility.Direction;

public interface Bullet {
	
	public boolean isAlive();
	
	public Pair<Integer,Integer> getPos();
	
	public void updatePos(CheckPos check);
	
	public int getDmg();
	
	public Debuff getDebuff();	
	
	public Direction getDirection();

	public Image getImage();
}
