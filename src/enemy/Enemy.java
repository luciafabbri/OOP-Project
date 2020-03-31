package enemy;

import org.newdawn.slick.Image;

import utility.Direction;

public interface Enemy {
	
	public String getName();
	
	public Pair<Integer,Integer> getPos();
	
	public void updatePos();
	
	public String getTypeLevel();
		
	public int getLevel();
	
	public int getMaxLife();
	
	public int getActualLife();
	
	public int getDmg();
	
	public TypeAttack getAttack();
	
	public void setDirection(Direction dir);
	
	public Image getImage();
	
	//public setBuff();
	
	
}
