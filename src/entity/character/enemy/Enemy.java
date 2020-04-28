package entity.character.enemy;

import java.util.Set;

import org.newdawn.slick.Animation;

import design.utilities.GameSettings;
import entity.bullet.BulletMonster;
import entity.character.enemy.attack.TypeAttack;

public interface Enemy extends entity.character.Character {
	
	
	public final static int DIMENSION = GameSettings.TILESIZE;
	
	public void updatePos();

	public void takeDmg(int damage);
	
	public TypeAttack getAttack();
	
	public TypeEnemy getTypeEnemy();
	
	public void addBullet(BulletMonster bullet);
	
	public Set<BulletMonster> getBullets();
	
	public Animation getAnimation();
	
	public boolean isAlive();
	
	public void attack();
	
	//public setBuff();
	
	
}
