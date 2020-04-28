package entity.bullet.move;

import coordination.TestState;
import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import entity.Entity;
import entity.character.player.Player;
import entity.move.CheckPosImpl;

public class CheckMonsBull extends CheckPosImpl implements GameSettings {
	
	private Entity entity;
	
	public CheckMonsBull(Entity entity) {
		super(entity);
		this.entity = entity;
	}


	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return super.possiblePos(room, pos) && checkCharacters(room, pos) ;
	}
	
	public boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		Player player = TestState.getPlayer();
		boolean checkX, checkY;
		checkX = pos.getX() + entity.getDimension().getLeft() < player.getPosition().getX() + player.getDimension().getRight() &&
				pos.getX() + entity.getDimension().getRight() > player.getPosition().getX() + player.getDimension().getLeft();
		checkY = pos.getY() + entity.getDimension().getUp() < player.getPosition().getY() + player.getDimension().getDown() &&
				pos.getY() + entity.getDimension().getDown() > player.getPosition().getY();
		if (checkX && checkY) {
			player.takeDmg(entity.getDmg());
			return false;
		}
		return true;
	}
}
