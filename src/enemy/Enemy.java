package enemy;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import utility.Direction;
import design.utilities.Pair;

public interface Enemy extends utility.Character {
	
	
	public final static int DIMENSION = 64;
	
	public void updatePos();

	public void takeDmg(int damage);
	
	public TypeAttack getAttack();
	
	public Image getImage() throws SlickException;
	
	//public setBuff();
	
	
}
