package dynamicBody.bullet.move;

import coordination.StateCoord;
import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import dynamicBody.DynamicBody;
import dynamicBody.character.player.Player;
import dynamicBody.move.CheckPos;
import dynamicBody.move.CheckPosImpl;

public class CheckMonsBull extends CheckPosImpl implements GameSettings, CheckPos {
	
	private DynamicBody entity;
	
	private Player player = StateCoord.getPlayer();
	
	public CheckMonsBull(DynamicBody entity) {
		super(entity);
		this.entity = entity;
	}

	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return super.possiblePos(room, pos) && checkCharacters(room, pos) ;
	}
	
	public boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		checkX = pos.getX() + entity.getDimension().getLeft() < player.getPosition().getX() + player.getDimension().getRight() &&
				pos.getX() + entity.getDimension().getRight() > player.getPosition().getX() + player.getDimension().getLeft();
		checkY = pos.getY() + entity.getDimension().getUp() < player.getPosition().getY() + player.getDimension().getDown() &&
				pos.getY() + entity.getDimension().getDown() > player.getPosition().getY();
		if (checkX && checkY) {
			player.takeDamage(entity.getDamage());
			return false;
		}
		return true;
	}
}
