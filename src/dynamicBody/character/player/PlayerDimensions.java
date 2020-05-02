package dynamicBody.character.player;

import design.utilities.Pair;
import dynamicBody.UpDownLeftRight;

/**
 * Enumeration used to get player's dimensions based on his current direction
 */

public enum PlayerDimensions {
	
	VERTICAL (48, 64, 17, 46),
	ORIZONTAL (48, 64, 15, 48);
	
	private UpDownLeftRight<Integer> dimensions;
	
	/**
	 * Default constructor
	 * @param up, player's up dimension
	 * @param down, player's down dimension
	 * @param left, player's left dimension
	 * @param right, player's right dimension
	 */
	PlayerDimensions(int up, int down, int left, int right) {
		this.dimensions = new UpDownLeftRight<>(up, down, left, right);
	}
	
	public static Pair<PlayerDimensions, PlayerDimensions> getPlayerDimensions(PlayerImpl player) {
		return new Pair<>(ORIZONTAL,VERTICAL);		
	}
	
	public UpDownLeftRight<Integer> getDimensions() {
		return this.dimensions;
	}
	
}
