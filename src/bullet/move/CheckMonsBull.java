package bullet.move;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import utility.CheckPosImpl;

public class CheckMonsBull extends CheckPosImpl implements GameSettings {
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !(super.possiblePos(room, pos) || checkCharacters(room, pos));
	}
	
	
	private boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		return false;
	}
}
