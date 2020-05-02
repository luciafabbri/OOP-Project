package entity.bullet.move;

import java.util.Set;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import entity.Entity;
import entity.character.enemy.Enemy;
import entity.move.CheckPos;
import entity.move.CheckPosImpl;

/**
 * Class used to represent all the specific checks for a bullet of type player 
 */

public class CheckPlayerBull extends CheckPosImpl implements GameSettings, CheckPos {
	
	private Entity entity;
	
	/**
	 * Default constructor
	 * @param entity, the type of entity associated with this type of bullet's check
	 */
	public CheckPlayerBull(Entity entity) {
		super(entity);
		this.entity = entity;
	}

	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return ( !checkCharacters(room, pos) && super.possiblePos(room, pos) );
	}
	
	// DA CONTROLLARE SE POSIZIONE NEMICO VA BENE
	/**
	 * Method used to check if player's bullet is in collision with any enemy in the current room
	 * @param room, bullet's current room 
	 * @param pos, bullet's current coordinates
	 * @return true if the bullet had a collision with an enemy, otherwise return false
	 */
	private boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		Set<Enemy> enemySet = room.getEnemySet();
		for (Enemy enemy : enemySet) {
			checkX = pos.getX() + enemy.getDimension().getLeft() < enemy.getPosition().getX() + GameSettings.TILESIZE && pos.getX() + enemy.getDimension().getRight() > enemy.getPosition().getX();
			checkY = pos.getY() < enemy.getPosition().getY() + (TILESIZE - enemy.getDimension().getRight()) && pos.getY() + enemy.getDimension().getDown() > enemy.getPosition().getY();
			if (checkX && checkY) {
				enemy.takeDmg(this.entity.getDamage());
				return true;
			}
		}
		return false;
	}

}