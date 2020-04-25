package bullet.move;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import utility.CheckPosImpl;
import utility.Entity;

public class CheckMonsBull extends CheckPosImpl implements GameSettings {
	
	public CheckMonsBull(Entity entity) {
		super(entity);
	}


	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return super.possiblePos(room, pos) || checkCharacters(room, pos) ;
	}
	
	private boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		return false;
	}
}
