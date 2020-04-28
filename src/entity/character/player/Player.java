package entity.character.player;

import java.util.Set;

import design.RoomDesign;
import design.utilities.Pair;
import entity.bullet.Bullet;
import entity.character.player.inventory.Inventory;
import entity.character.player.movement.Movement;
import entity.character.player.movement.check.CheckPlayer;
import entity.character.player.shoot.BulletMovement;
import levels.Level;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * An interface that presents all the methods needed or that can be used with regards to the player 
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
	 * @return the player's current level 
	 */ 
	public int getLevel();
	
	/**
	 *  @return player's bullet 
	 */
	public BulletMovement getBullet();

	/**
	 * @return player's current room 
	 */
	public RoomDesign getRoom();

	/**
	 * Methods used to set player's current room 
	 * @param room, the room where the player would be moved
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
	 * @return player's front animation
	 */
	public Animation getFront();

	/**
	 * @return player's back animation
	 */
	public Animation getBack();
	
	/**
	 * @return player's left animation
	 */
	public Animation getLeft();
	
	/**
	 * @return player's right animation 
	 */
	public Animation getRight();

	/**
	 * @return player's speed 
	 */
	public int getPlayerSpeed();

	/**
	 * @return player's check 
	 */
	public CheckPlayer getCheck();
	
	/**
	 * Method used to upgrade player's damage 
	 * @param damage, an int value to add to player's current damage
	 */
	public void upgradeDmg(int damage);
	
	/**
	 * @return player's inventory 
	 */
	public Inventory getInventory();
	
	/**
	 * @return player's bullet set 
	 */
	public Set<Bullet> getRoomBullets();

	/**
	 * Method used to upgrade player's speed 
	 * @param speedPlayer, an int value to be added to player's speed in order to move faster in the dungeon
	 */
	public void upgradePlayerSpeed(int speedPlayer);

	/**
	 * @return player's movement 
	 */
	public Movement getMove();

	/**
	 * @return player's rof 
	 */
	public int getRof();
}
