package entity.character.enemy;

import java.util.Set;

import org.newdawn.slick.Animation;

import design.utilities.GameSettings;
import entity.bullet.Bullet;

public interface Enemy extends entity.character.Character {
	
	
	public final static int DIMENSION = GameSettings.TILESIZE;
	
	public void updatePos();

	public void takeDmg(int damage);
	
	public TypeEnemy getTypeEnemy();
	
	public void addBullet(Bullet bullet);
	
	public Set<Bullet> getBullets();
	
	public Animation getAnimation();
	
	public boolean isAlive();
	
	public void attack();
	
	//public setBuff();
	
	
}
