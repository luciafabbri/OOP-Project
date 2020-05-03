package dynamicBody.character.enemy;

import design.utilities.GameSettings;
import dynamicBody.bullet.Bullet;

public interface Enemy extends dynamicBody.character.Character {
	
	public final static int DIMENSION = GameSettings.TILESIZE;
	
	public void updatePos();
	
	public TypeEnemy getTypeEnemy();
	
	public void addBullet(Bullet bullet);
				
	public void attack();
	
	//public setBuff();
	
	
}
