package enemy.attack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;
import enemy.Enemy;

public class FourSideAtt implements MonsterAttack {

	private RoomDesign currentRoom;
	private Enemy enemy;
	
	public FourSideAtt(RoomDesign room, Enemy enemy) {
		currentRoom = room;
		this.enemy = enemy;
	}
	
	private static List<Direction> normalDir = getDirectionList(true);
	
	private static List<Direction> mixedDir = getDirectionList(false);
	
	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		MonsterAttack attack = new OneSideAtt(currentRoom, enemy);
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
