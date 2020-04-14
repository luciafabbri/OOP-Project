package player.movement;

import design.utilities.Pair;
import enemy.Enemy;
import gameEntities.Obstacle;
import player.Player;
import utility.CheckPos;
import design.utilities.GameSettings;
import java.util.HashSet;
import java.util.Iterator;
import design.RoomDesign;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */

public class CheckPositionPlayerImpl implements CheckPos, GameSettings{
		
	/** 
	 * 
	 * This method needs the coordinates of the player and checks if he's not going out of bounds.
	 * If the coordinates are above these limits, the method will return FALSE value otherwise it will return TRUE.
	 *  SE SOPRA LIMITI --> return FALSE
	 *  SE VANNO BENE --> return TRUE 
	 *   
	 *	Se OBSTACLE --> non posso andare sopra
	 *  Se ITEM --> posso andare sopra 
	 *  
	 */
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean obstacle = this.checkObstaclesRoom(room, pos);
		if(obstacle == false) {
			return false;
		}
   /*   boolean item = this.checkItemsRoom(room, pos);
		if(item) {
			return true;
		} */
		return !( (pos.getX() < LIMITLEFT || pos.getX() + Player.DIMENSION >= LIMITRIGHT) 			|| 
				(pos.getY() < LIMITUP || pos.getY() + Player.DIMENSION >= LIMITDOWN) );		
	}


	/**se dentro al set di ostacoli ci sono coordinate che corrispondono a quelle del personaggio, 
	 * allora quest'ultimo non si deve muovere perchè quella posizione è già occupata
	 */
	private boolean checkObstaclesRoom(RoomDesign room,Pair<Integer, Integer> pos) {
		HashSet<gameEntities.Obstacle> obstacleSet = room.getObstacleSet();	
		for (gameEntities.Obstacle obst : obstacleSet) {
			if (obst.getPosition().getX() == pos.getX() && obst.getPosition().getY() == pos.getY()) {
				return false;
			}
		}
		return true;
	}
	
	/*
	
	/**se dentro al set di item ci sono coordinate che corrispondono a quelle del personaggio, 
	 * allora quest'ultimo si deve muovere anche in quella posizione per poter raccogliere l'item e aggiungerlo alla 
	 * lista delle cose che possiede
	 *	
	private boolean checkItemsRoom(RoomDesign room,Pair<Integer, Integer> pos) {
		HashSet<design.tokens.WorldObject> itemSet = room.getWorldObjectsSet();
		for (design.tokens.WorldObject item : itemSet) {
			if (item.getPosition().getX() == pos.getX() && item.getPosition().getY() == pos.getY()) {
				//aggiungi item alla lista di qualcosa 
				return true;
			}
		}
		return true;
	} */
	
}
