package dynamicBody.character.enemy;

import dynamicBody.bullet.Bullet;

public interface Enemy extends dynamicBody.character.Character {
	
	public void updatePos();
	
	public TypeEnemy getTypeEnemy();
	
	public void addBullet(Bullet bullet);
				
	public void attack();
	
	//public setBuff();
	
	
}
