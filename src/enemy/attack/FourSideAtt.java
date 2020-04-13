package enemy.attack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utility.Direction;
import design.utilities.Pair;

public class FourSideAtt implements MonsterAttack {

	private static List<Direction> normalDir = getDirectionList(true);
	
	private static List<Direction> mixedDir = getDirectionList(false);
	
	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		MonsterAttack attack = new OneSideAtt();
		if(normalDir.contains(dir)) {
			normalDir.forEach(d -> attack.createBullets(pos, dir, dmg));
		} else {
			mixedDir.forEach(d -> attack.createBullets(pos, dir, dmg));
		}
	}
	
	private static List<Direction> getDirectionList(boolean i) {
		return Arrays.asList(Direction.values()).stream()
				.filter(x->(x.getAbscissa() * x.getOrdinate() == 0 ) == i )
				.collect(Collectors.toList());
	}


}
