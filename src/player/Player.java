package player;

import design.RoomDesign;
import design.utilities.Pair;
import levels.Level;
import player.inventory.Inventory;
import player.movement.Movement;
import player.movement.check.CheckPlayer;
import player.shoot.BulletMovement;

import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import bullet.Bullet;
import bullet.BulletPlayer;

/**
 * Interface that presents all the methods needed or that can be used with regards to the player 
 */

public interface Player extends DefaultPlayer, utility.Character {
	
	/**
	 * Methods used to set player's position
	 * @param
	 * @throws SlickException 
	 */
	public void setPosition(Input input, Level level) throws SlickException;

	
	/**
	 * Methods used to set the level in which the player should go
	 * @param
	 */
	public void setLevel(int level);
	
	/**
	 * Methods used to know in which level the character is 
	 */ 
	public int getLevel();
	
	/**
	 *  Methods used to get player's bullet
	 */
	public BulletMovement getBullet();

	/**
	 * Methods used to get player's current room 
	 */
	public RoomDesign getRoom();

	/**
	 * Methods used to set player's current room 
	 * @param
	 */
	public void setCurrentRoom(RoomDesign room);
	
	/**
	 * Methods used to set player's updated position
	 * @param
	 */
	public void setPosition(Pair<Integer, Integer> position);
	
	/**
	 * Methods used to load player's animations
	 * @throws SlickException 
	 */
	public void loadAnimations() throws SlickException;
	
	
	/**
	 * Methods used to set player's front animation
	 */
	public Animation getFront();

	
	/**
	 * Methods used to set player's back animation
	 */
	public Animation getBack();
	
	
	/**
	 * Methods used to set player's left animation
	 */
	public Animation getLeft();
	
	
	/**
	 * Methods used to set player's right animation 
	 */
	public Animation getRight();

	/**
	 * Methods used to get player's speed 
	 */
	public int getPlayerSpeed();
	
	/**
	 * Methods used to get bullet's speed 
	 */
	public int getBulletSpeed();

	/**
	 * Methods used to get player's check 
	 */
	public CheckPlayer getCheck();
	
	/**
	 * Methods used to upgrade player's damage 
	 * @param 
	 */
	public void upgradeDmg(int damage);
	
	/**
	 * Methods used to take player's damage from enemies or entities
	 * @param
	 */
	public void takeDmg(int damage);
	
	/**
	 * Methods used to get player's inventory 
	 */
	public Inventory getInventory();
	
	/**
	 * Methods used to get player's bullet set 
	 */
	public Set<BulletPlayer> getRoomBullets();

	/**
	 * Methods used to upgrade player's speed 
	 * @param
	 */
	public void upgradePlayerSpeed(int speedPlayer);

	/**
	 * Methods used to upgrade bullet's speed 
	 * @param 
	 */
	void upgradeBulletSpeed(int speedBullet);

	/**
	 * Methods used to get player's movement 
	 */
	public Movement getMove();

	/**
	 * @return
	 */
	public int getRof();
}
