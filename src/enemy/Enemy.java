package enemy;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.GameSettings;
import enemy.attack.TypeAttack;

public interface Enemy extends utility.Character {
	
	
	public final static int DIMENSION = GameSettings.TILESIZE;
	
	public void updatePos();
	
	public int getDamage();

	public void takeDmg(int damage);
	
	public TypeAttack getAttack();
	
	public TypeEnemy getTypeEnemy();
	
	public Image getImage() throws SlickException;
	
	public boolean isAlive();
	
	//public setBuff();
	
	
}
