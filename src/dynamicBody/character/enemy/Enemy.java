package dynamicBody.character.enemy;

import dynamicBody.bullet.Bullet;
import dynamicBody.character.enemy.creator.TypeEnemy;

public interface Enemy extends dynamicBody.character.Character {
	
	public void updatePos();
	
	public TypeEnemy getTypeEnemy();
	
	public void addBullet(Bullet bullet);
				
	public void attack();
	
	
}
