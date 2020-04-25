package bullet;

import design.utilities.Pair;
import utility.UpDownLeftRight;

public enum DimensionBullet {
	
	VERTICAL_PLAYER(30, 33, 20, 51),
	ORIZONTAL_PLAYER(13, 47, 28, 37);
	
	
	private UpDownLeftRight<Integer> dim;
	
	DimensionBullet(int up, int down, int left, int right) {
		this.dim = new UpDownLeftRight<>(up, down, left, right);
	}
	
	public UpDownLeftRight<Integer> getDimension() {
		return dim;
	}
	
	public static Pair<DimensionBullet, DimensionBullet> getDimensionBullet(TypeBullet mon) {
		switch(mon) {
			case PLAYER:
			case MONSTER:
				return new Pair<>(ORIZONTAL_PLAYER, VERTICAL_PLAYER);
				
			default:
				throw new IllegalArgumentException();
		}
		
	}

}
