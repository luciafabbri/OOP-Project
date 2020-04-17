package enemy;

import java.util.Collections;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import enemy.attack.FourSideAtt;
import enemy.attack.MonsterAttack;
import enemy.attack.OneSideAtt;
import enemy.attack.TripleAtt;
import enemy.attack.TwoSideAtt;
import enemy.move.ImmobilizedMove;
import enemy.move.MovePosMonster;
import enemy.move.RandomMove;
import enemy.move.StraightMove;
import enemy.move.TeleportMove;
import utility.Direction;
import utility.health.Health;
import utility.health.HealthImpl;
import design.RoomDesign;
import design.utilities.Pair;

public class Monster implements Enemy {
	
	private Image texture;
	private Pair<Integer, Integer> position;
	private int level;
	private Health health;
	private MovePosMonster move;
	private MonsterAttack attack;
	private Direction direct;

	public Monster(Pair<Integer, Integer> pos, int level, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomDesign room) {
		this.position = pos;
		this.level = level;
		this.health = new HealthImpl(health);
		this.move = selectMove(move, room);
		this.attack = selectAttack(att, room);
		this.direct = dir;
	}

	private MovePosMonster selectMove(TypeMove typeMove, RoomDesign room) {
		switch (typeMove) {
		case STRAIGHT:
			return new StraightMove(room);

		case TELEPORT:
			return new TeleportMove(room);

		case RANDOM:
			return new RandomMove(room);

		case IMMOBILIZED:
			return new ImmobilizedMove(room);

		default:
			throw new IllegalArgumentException();

		}
	}

	private MonsterAttack selectAttack(TypeAttack typeAttack, RoomDesign room) {
		switch (typeAttack) {
		case ONE_SIDE:
			return new OneSideAtt(room);

		case TWO_SIDE:
			return new TwoSideAtt(room);

		case FOUR_SIDE:
			return new FourSideAtt(room);

		case TRIPLE:
			return new TripleAtt(room);

		default:
			throw new IllegalArgumentException();

		}
	}

	@Override
	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}
	
	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public Health getHealth() {
		return this.health;
	}

	@Override
	public void updatePos() {
		this.position = move.nextPos(this.position, this.direct);
		this.direct = move.getDirection();
	}

	@Override
	public void takeDmg(int damage) {
		health.takeDmg(damage);
	}

	@Override
	public TypeAttack getAttack() {
		return null;
	}

	@Override
	public Image getImage() throws SlickException {
		return new Image("./res/chars/mainChar6_front.png");
	}

	@Override
	public Direction getDirection() {
		return this.direct;
	}

	

	

}
