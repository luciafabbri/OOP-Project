package enemy;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import enemy.attack.FourSideAtt;
import enemy.attack.MonsterAttack;
import enemy.attack.OneSideAtt;
import enemy.attack.TripleAtt;
import enemy.attack.TwoSideAtt;
import enemy.attack.TypeAttack;
import enemy.move.ImmobilizedMove;
import enemy.move.MovePosMonster;
import enemy.move.RandomMove;
import enemy.move.StraightMove;
import enemy.move.TeleportMove;
import enemy.move.TypeMove;
import utility.Direction;
import utility.UpDownLeftRight;
import utility.health.Health;
import utility.health.HealthImpl;
import design.RoomDesign;
import design.utilities.Pair;

public class EnemyImpl implements Enemy {

	private Pair<Integer, Integer> position;
	private int damage;
	private int speed;
	private Health health;
	private MovePosMonster move;
	private MonsterAttack attack;
	private Direction direction;
	private Pair<DimensionMonster, DimensionMonster> dimensions;
	private TypeEnemy typeEnemy;
	private UpDownLeftRight<Animation> textures;

	public EnemyImpl(Pair<Integer, Integer> pos, int damage, int speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomDesign room, TypeEnemy mon) {
		this.position = pos;
		this.damage = damage;
		this.speed = speed;
		this.health = new HealthImpl(health);
		this.move = selectMove(move, room);
		this.attack = selectAttack(att, room);
		this.direction = dir;
		this.dimensions = DimensionMonster.getDimensionMoster(mon);
		this.typeEnemy = mon;
		try {
			this.textures = EnemyImage.getTexture(mon);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public EnemyImpl(Pair<Integer, Integer> pos, int damage, int health, TypeMove move, TypeAttack att, RoomDesign room,
			TypeEnemy mon){
		this(pos, damage, 1, health, move, Direction.getRandomDir(), att, room, mon);
	}

	private MovePosMonster selectMove(TypeMove typeMove, RoomDesign room) {
		switch (typeMove) {
		case STRAIGHT:
			return new StraightMove(room, this);

		case TELEPORT:
			return new TeleportMove(room, this);

		case RANDOM:
			return new RandomMove(room, this);

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
	public int getDamage() {
		return this.damage;
	}

	@Override
	public Health getHealth() {
		return this.health;
	}

	@Override
	public void updatePos() {
		this.position = move.nextPos(this.position, this.speed, this.direction);
		this.direction = move.getDirection();
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
	public TypeEnemy getTypeEnemy() {
		return this.typeEnemy;
	}

	@Override
	public Animation getAnimation() {
		switch(this.direction) {
		case NORTH:
			return textures.getUp();
		case SOUTH:
			return textures.getDown();
		case WEST:
			return textures.getLeft();
		case EAST:
			return textures.getRight();
		default:
			throw new IllegalArgumentException();
			
		}
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public UpDownLeftRight<Integer> getDimension() {
		if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
			return dimensions.getX().getDimension();
		} else if (direction.equals(Direction.WEST) || direction.equals(Direction.EAST)) {
			return dimensions.getY().getDimension();
		}
		return new UpDownLeftRight<Integer>(0, 0, 0, 0);
	}

	@Override
	public boolean isAlive() {
		return health.isAlive();
	}

}
