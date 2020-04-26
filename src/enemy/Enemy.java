package enemy;

import java.util.Set;

import org.newdawn.slick.Animation;

import bullet.BulletMonster;
import design.utilities.GameSettings;
import enemy.attack.TypeAttack;

public interface Enemy extends utility.Character {
	
	
	public final static int DIMENSION = GameSettings.TILESIZE;
	
	public void updatePos();
	
	public int getDamage();

	public void takeDmg(int damage);
	
	public TypeAttack getAttack();
	
	public TypeEnemy getTypeEnemy();
	
	public void addBullet(BulletMonster bullet);
	
	public Set<BulletMonster> getBullets();
	
	public Animation getAnimation();
	
	public boolean isAlive();
	
	//public setBuff();
	
	
}
