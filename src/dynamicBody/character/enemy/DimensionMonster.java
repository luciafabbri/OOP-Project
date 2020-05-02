package dynamicBody.character.enemy;

import design.utilities.Pair;
import dynamicBody.UpDownLeftRight;

public enum DimensionMonster {
	
	VERTICAL_MON1(48, 64, 17, 46),
	ORIZONTAL_MON1(48, 64, 15, 48);
	
	
	private UpDownLeftRight<Integer> dim;
	
	DimensionMonster(int up, int down, int left, int right) {
		this.dim = new UpDownLeftRight<>(up, down, left, right);
	}
	
	public UpDownLeftRight<Integer> getDimension() {
		return dim;
	}
	
	public static Pair<DimensionMonster, DimensionMonster> getDimensionMoster(TypeEnemy mon) {
		switch(mon) {
			case MONSTER1:
			case MONSTER2:
			case MONSTER3:
			case PLANT:
			case BOSS:
				return new Pair<>(ORIZONTAL_MON1, VERTICAL_MON1);
				
			default:
				throw new IllegalArgumentException();
		}
		
	}

}
