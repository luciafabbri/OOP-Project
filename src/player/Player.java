package player;

import design.RoomDesign;
import design.utilities.Pair;
import levels.Level;
import player.movement.CheckPlayer;
import player.shoot.BulletMovement;

import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import bullet.Bullet;
import bullet.BulletPlayer;

/**
 * 
 * Interface that presents all the methods needed or that can be used with regards to the player 
 * 
 */

public interface Player extends DefaultPlayer, utility.Character {
	
	/**
	 * 
	 * Methods used to set Player's position
	 * @throws SlickException 
	 *  
	 */
	public void setPosition(Input input, Level level) throws SlickException;

	
	/**
	 * 
	 * Methods used to set the level in which the player should go
	 *  
	 */
	public void setLevel(int level);
	
	/**
	 * 
	 * Methods used to know in which level the character is 
	 *  
	*/ 
	public int getLevel();
	
	/**
	 *  Methods used to get Player's bullet
	 * 
	 */
	public BulletMovement getBullet();

	/**
	 * 
	 * Methods used to get Player's current room
	 *  
	 */
	public RoomDesign getRoom();

	/**
	 * 
	 * Methods used to set Player's current room
	 *  
	 */
	public void setCurrentRoom(RoomDesign room);
	
	/**
	 * 
	 * Methods used to set Player's updated position
	 *  
	 */
	public void setPosition(Pair<Integer, Integer> position);
	
	/**
	 * 
	 * Methods used to load Player's animations
	 * @throws SlickException 
	 *  
	 */
	public void loadAnimations() throws SlickException;
	
	
	/**
	 * 
	 * Methods used to set Player's front animation
	 *  
	 */
	public Animation getFront();

	
	/**
	 * 
	 * Methods used to set Player's back animation
	 *  
	 */
	public Animation getBack();
	
	
	/**
	 * 
	 * Methods used to set Player's left animation
	 *  
	 */
	public Animation getLeft();
	
	
	/**
	 * 
	 * Methods used to set Player's right animation
	 *  
	 */
	public Animation getRight();

	/**
	 * 
	 * Methods used to get Player's speed 
	 *  
	 */
	public int getPlayerSpeed();
	public int getBulletSpeed();

	public CheckPlayer getCheck();

	public int getDmg();
	public void upgradeDmg(int damage);
	public void takeDmg(int damage);
	
	public Inventory getInventory();
	
	public Set<BulletPlayer> getRoomBullets();
}
