package entity.character.player;

import java.util.Set;

import design.RoomDesign;
import design.utilities.Pair;
import entity.bullet.BulletPlayer;
import entity.character.player.inventory.Inventory;
import entity.character.player.movement.Movement;
import entity.character.player.movement.check.CheckPlayer;
import entity.character.player.shoot.BulletMovement;
import levels.Level;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Interface that presents all the methods needed or that can be used with regards to the player 
 */

public interface Player extends DefaultPlayer, entity.character.Character {
	
	/**
	 * Method used to set player's position
	 * @param input, received from the keyboard
	 * @param level, player's current level 
	 * @throws SlickException 
	 */
	public void setPosition(Input input, Level level) throws SlickException;
	
	/**
	 * Method used to set the level in which the player should go
	 * @param level, to set the new player's level
	 */
	public void setLevel(int level);
	
	/**
	 * Method used to know in which level the player is 
	 */ 
	public int getLevel();
	
	/**
	 *  Method used to get player's bullet
	 *  @return the 
	 */
	public BulletMovement getBullet();

	/**
	 * Methods used to get player's current room 
	 */
	public RoomDesign getRoom();

	/**
	 * Methods used to set player's current room 
	 * @param room
	 */
	public void setCurrentRoom(RoomDesign room);
	
	/**
	 * Method used to set player's updated position
	 * @param position, the coordinates of the player to be set 
	 */
	public void setPosition(Pair<Integer, Integer> position);
	
	/**
	 * Method used to load player's animations
	 * @throws SlickException 
	 */
	public void loadAnimations() throws SlickException;
	
	/**
	 * Method used to set player's front animation
	 */
	public Animation getFront();

	/**
	 * Method used to set player's back animation
	 */
	public Animation getBack();
	
	/**
	 * Method used to set player's left animation
	 */
	public Animation getLeft();
	
	/**
	 * Method used to set player's right animation 
	 */
	public Animation getRight();

	/**
	 * Method used to get player's speed 
	 */
	public int getPlayerSpeed();
	
	/**
	 * Method used to get bullet's speed 
	 */
	public int getBulletSpeed();

	/**
	 * Method used to get player's check 
	 */
	public CheckPlayer getCheck();
	
	/**
	 * Method used to upgrade player's damage 
	 * @param damage, an int value to add to player's current damage
	 */
	public void upgradeDmg(int damage);
	
	/**
	 * Method used to take player's damage from enemies or entities
	 * @param damage, an int value to subtract to player's current health
	 */
	public void takeDmg(int damage);
	
	/**
	 * Method used to get player's inventory 
	 */
	public Inventory getInventory();
	
	/**
	 * Method used to get player's bullet set 
	 */
	public Set<BulletPlayer> getRoomBullets();

	/**
	 * Method used to upgrade player's speed 
	 * @param speedPlayer, an int value to be added to player's speed in order to move faster in the environment
	 */
	public void upgradePlayerSpeed(int speedPlayer);

	/**
	 * Method used to upgrade bullet's speed 
	 * @param speedBullet, an int value to be added to bullet's speed in order to move faster in the environment
	 */
	void upgradeBulletSpeed(int speedBullet);

	/**
	 * Method used to get player's movement 
	 */
	public Movement getMove();

	/**
	 * Method used to get player's rof 
	 * @return player's rof 
	 */
	public int getRof();
}
