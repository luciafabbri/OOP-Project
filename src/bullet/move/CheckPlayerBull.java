package bullet.move;

import java.util.Set;

import bullet.Bullet;
import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import utility.CheckPos;
import utility.CheckPosImpl;
import utility.Entity;

public class CheckPlayerBull extends CheckPosImpl implements GameSettings {
	
	public CheckPlayerBull(Entity entity) {
		super(entity);
	}


	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !(super.possiblePos(room, pos) || checkCharacters(room, pos));
	}
	
	
	private boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		return false;
	}
}