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
import org.newdawn.slick.Sound;

/**
 * An interface that presents all the methods needed or that can be used with regards to the player 
 */

public interface Player extends entity.character.Character {
	
	final static int DIMENSION = 64;

	/**
	 * Method used to set player's position
	 * @param input, received from the keyboard
	 * @param level, player's current level 
	 * @throws SlickException 
	 */
	void setPosition(Input input, Level level) throws SlickException;
	
	/**
	 * Method used to set the level in which the player should go
	 * @param level, to set the new player's level
	 */
	void setLevel(int level);
	
	/**
	 * @return the player's current level 
	 */ 
	int getLevel();
	
	/**
	 *  @return player's bullet 
	 */
	BulletMovement getBullet();

	/**
	 * @return player's current room 
	 */
	RoomDesign getRoom();

	/**
	 * Methods used to set player's current room 
	 * @param room, the room where the player would be moved
	 */
	void setCurrentRoom(RoomDesign room);
	
	/**
	 * Method used to set player's updated position
	 * @param position, the coordinates of the player to be set 
	 */
	void setPosition(Pair<Integer, Integer> position);

	/**
	 * @return player's speed 
	 */
	int getPlayerSpeed();

	/**
	 * @return player's check 
	 */
	CheckPlayer getCheck();
	
	/**
	 * Method used to upgrade player's damage 
	 * @param upgrade, an int value to add to player's current damage
	 */
	void upgradeDamage(int upgrade);
	
	/**
	 * @return player's inventory 
	 */
	Inventory getInventory();
	
	/**
	 * @return player's bullet set 
	 */
	Set<Bullet> getRoomBullets();

	/**
	 * Method used to upgrade player's speed 
	 * @param upgrade, an int value to be added to player's speed in order to move faster in the dungeon
	 */
	void upgradePlayerSpeed(int upgrade);

	/**
	 * @return player's movement 
	 */
	Movement getMove();

	/**
	 * @return player's rof 
	 */
	int getRof();
	
	/**
	 * @return player's Animation
	 */
	Animation getAnimation();
	
	/**
	 * Method used to load all player's animations 
	 * @throws SlickException
	 */
	void loadAnimations() throws SlickException;
	
	/**
	 * Method used to  
	 * @param clearRoom, 
	 */
	void setClearRoom(boolean clearRoom);
	
	/**
	 * @return player's sound walking into the dungeon 
	 */
	Sound getBowShoot();

	/**
	 * Method used to upgrade player's rof 
	 * @param upgrade, an int value used to change player's current rof in order to shoot faster 
	 */
	void upgradeRof(int upgrade);
}
