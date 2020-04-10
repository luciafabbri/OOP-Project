package player.movement;

import utility.Pair;
import design.utilities.GameSettings;
import levels.Level;
import java.util.HashSet;
import java.util.Iterator;
import design.RoomDesign;
import design.RoomDesignImpl;
import genTest.GameSettings;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */

public class CheckPositionPlayerImpl implements CheckPositionPlayer, GameSettings{

	private RoomDesign room = new RoomDesignImpl(0);
	
	private HashSet<gameEntities.Obstacle> obstacleSet = room.getObstacleSet();
	private Iterator<gameEntities.Obstacle> iterObstacles = obstacleSet.iterator();

	private HashSet<design.tokens.WorldObject> itemSet = room.getWorldObjectsSet();
	private Iterator<design.tokens.WorldObject> iterItems = itemSet.iterator();
		
	/** 
	 * 
	 * This method needs the coordinates of the player and checks if he's not going out of bounds.
	 * If the coordinates are above these limits, the method will return FALSE value otherwise it will return TRUE.
	 *  SE SOPRA LIMITI --> return FALSE
	 *  SE VANNO BENE --> return TRUE  
	 *  
	 *  Se ITEM --> posso andare sopra 
	 *	Se OBSTACLE --> non posso andare sopra
	 *  
	 */

	@Override
	public boolean possiblePos(Pair<Integer, Integer> pos) {
		while(iterObstacles.hasNext()) {
			/**se dentro al set di ostacoli ci sono coordinate che corrispondono a quelle del personaggio, 
			 * allora quest'ultimo non si deve muovere perchè quella posizione è già occupata
			 */
			Pair<Integer, Integer> obstaclePosition = iterObstacles.next().getPosition();
			if ( obstaclePosition.getX() == pos.getX()	&&	obstaclePosition.getY() == pos.getY()) {
				return false;
			}
		}
		/*while(iterItems.hasNext()) {
			/**se dentro al set di items ci sono coordinate che corrispondo a quelle del personaggio, 
			 * allora quest'ultimo può spostarsi e raccogliere l'item
			 *
			Pair<Integer,Integer> itemPosition = iterItems.next().getPosition();
			if ( itemPosition.getX()==pos.getX()  &&  itemPosition.getY() == pos.getY()) {
				return true;
			}
		}*/
		return !( (pos.getX() < TILESIZE || pos.getX() >= WIDTH-TILESIZE*2) 			|| 
				(pos.getY() < TILESIZE || pos.getY() >= HEIGHT-TILESIZE*2) );		
	}

	
}
