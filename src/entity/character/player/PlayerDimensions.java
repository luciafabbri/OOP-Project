package entity.character.player;

import design.utilities.Pair;
import entity.UpDownLeftRight;

/**
 * Enumeration used to get player's dimensions based on his current direction
 */

public enum PlayerDimensions {

	VERTICAL (48, 64, 17, 46),
	ORIZONTAL (48, 64, 15, 48);
	
	private UpDownLeftRight<Integer> dimensions;
	
	PlayerDimensions(int up, int down, int left, int right) {
		this.dimensions = new UpDownLeftRight<>(up, down, left, right);
	}
	
	public UpDownLeftRight<Integer> getDimensions() {
		return this.dimensions;
	}
	
	public static Pair<PlayerDimensions, PlayerDimensions> getPlayerDimensions(PlayerImpl player) {
		return new Pair<>(ORIZONTAL,VERTICAL);		
	}
	
}
