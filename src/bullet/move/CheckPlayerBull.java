package bullet.move;

import java.util.Set;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import utility.CheckPosImpl;
import utility.Entity;

public class CheckPlayerBull extends CheckPosImpl implements GameSettings {
	
	public CheckPlayerBull(Entity entity) {
		super(entity);
	}


	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		//return (super.possiblePos(room, pos) || checkCharacters(room, pos)
		return (super.possiblePos(room, pos));
	}
	
	// true se ha preso mostro, false altrimenti
	private boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		Set<design.tokens.Enemy> enemySet = room.getEnemySet();
		for (design.tokens.Enemy enemy : enemySet) {
			return true;
		}
		return false;
	}
	
	
}