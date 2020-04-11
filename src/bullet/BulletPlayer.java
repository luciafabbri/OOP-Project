package bullet;

import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import design.utilities.Pair;
import org.newdawn.slick.Image;
import bullet.move.CheckMonsBull;
import enemy.TypeMove;

public class BulletPlayer extends BulletImpl {

	private CheckPos check = new CheckMonsBull();

	public BulletPlayer(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, TypeMove typeMove, Image image) {
		super(position, damage, debuff, direction, typeMove, image);
	}
	
	public BulletPlayer(Pair<Integer, Integer> position, int damage, Direction direction, Image image) {
		this(position, damage, Debuff.NO_ONE, direction, TypeMove.STRAIGHT, image);
	}
	
	public void updatePos() {
		super.updatePos(check);
	}

}