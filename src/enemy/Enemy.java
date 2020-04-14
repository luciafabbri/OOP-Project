package enemy;

import org.newdawn.slick.Image;

import utility.Direction;
import design.utilities.Pair;

public interface Enemy {
	
	public final static int DIMENSION = 64;
	
	public Pair<Integer,Integer> getPos();
	
	public void updatePos();
	
	public String getTypeLevel();
	
	public int getMaxLife();
	
	public int getCurrentLife();
	
	public void takeDmg(int damage);
	
	public TypeAttack getAttack();
	
	public Direction getDirection();
	
	public Image getImage();
	
	//public setBuff();
	
	
}
