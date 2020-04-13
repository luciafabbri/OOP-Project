package enemy.attack;

import design.utilities.Pair;
import utility.Direction;

public class TripleAtt implements MonsterAttack {

	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		OneSideAtt attOne = new OneSideAtt();
		TwoSideAtt attTwo = new TwoSideAtt();
		
		attOne.createBullets(pos, dir, dmg);
		attTwo.createBullets(pos, dir, dmg);
		
	}

}
