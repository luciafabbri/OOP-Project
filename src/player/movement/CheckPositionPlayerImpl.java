package player.movement;

import design.utilities.Pair;
import design.utilities.GameSettings;
import java.util.HashSet;
import java.util.Iterator;
import design.RoomDesign;
import design.RoomDesignImpl;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */

public class CheckPositionPlayerImpl implements CheckPositionPlayer, GameSettings{
		
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
	public boolean possiblePos(RoomDesignImpl room, Pair<Integer, Integer> pos) {
		boolean obstacle = this.checkObstaclesRoom(room, pos);
		if(obstacle == false) {
			return false;
		}
   /*   boolean item = this.checkItemsRoom(room, pos);
		if(item) {
			return true;
		} */
		return !( (pos.getX() < TILESIZE || pos.getX() >= WIDTH-TILESIZE*2) 			|| 
				(pos.getY() < TILESIZE || pos.getY() >= HEIGHT-TILESIZE*2) );		
	}


	/**se dentro al set di ostacoli ci sono coordinate che corrispondono a quelle del personaggio, 
	 * allora quest'ultimo non si deve muovere perchè quella posizione è già occupata
	 */
	private boolean checkObstaclesRoom(RoomDesign room,Pair<Integer, Integer> pos) {
		HashSet<gameEntities.Obstacle> obstacleSet = room.getObstacleSet();	
		Iterator<gameEntities.Obstacle> iterObstacles = obstacleSet.iterator();
		while(iterObstacles.hasNext()) {
			Pair<Integer, Integer> obstaclePosition = iterObstacles.next().getPosition();
			if ( obstaclePosition.getX() == pos.getX()	&&	obstaclePosition.getY() == pos.getY() ) {
				return false;
			}
		}
		return true;
	}
	
	/*
	/**se dentro al set di item ci sono coordinate che corrispondono a quelle del personaggio, 
	 * allora quest'ultimo si deve muovere anche in quella posizione per poter raccogliere l'item
	 *	
	private boolean checkItemsRoom(RoomDesign room,Pair<Integer, Integer> pos) {
		HashSet<design.tokens.WorldObject> itemSet = room.getWorldObjectsSet();
		Iterator<design.tokens.WorldObject> iterItems = itemSet.iterator();
		while(iterItems.hasNext()) {
			Pair<Integer, Integer> itemPosition = iterItems.next().getPosition();
			if ( itemPosition.getX() == pos.getX()	&&	itemPosition.getY() == pos.getY()) {
				return true;
			}
		}
		return true;
	} */
	
	// SENTI CON MARCO  
	@Override
	public boolean possiblePos(Pair<Integer, Integer> pos) {
		return !( (pos.getX() < TILESIZE || pos.getX() >= WIDTH-TILESIZE*2) 			|| 
				(pos.getY() < TILESIZE || pos.getY() >= HEIGHT-TILESIZE*2) );	
	}

	
}
