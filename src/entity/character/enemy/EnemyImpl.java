package entity.character.enemy;

import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import entity.UpDownLeftRight;
import entity.bullet.Bullet;
import entity.character.enemy.attack.FourSideAtt;
import entity.character.enemy.attack.MonsterAttack;
import entity.character.enemy.attack.OneSideAtt;
import entity.character.enemy.attack.TripleAtt;
import entity.character.enemy.attack.TwoSideAtt;
import entity.character.enemy.attack.TypeAttack;
import entity.character.enemy.move.ImmobilizedMove;
import entity.character.enemy.move.MovePosMonster;
import entity.character.enemy.move.RandomMove;
import entity.character.enemy.move.StraightMove;
import entity.character.enemy.move.TeleportMove;
import entity.character.enemy.move.TypeMove;
import entity.character.health.Health;
import entity.character.health.HealthImpl;
import entity.move.Direction;
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
	private Set<Bullet> bullets = new HashSet<>();
	
	private int sleepTime = 2000;
	private long stopMillis;
	private long startMillis;

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
			e.printStackTrace();
		}

	}

	public EnemyImpl(Pair<Integer, Integer> pos, int damage, int health, TypeMove move, TypeAttack att, RoomDesign room,
			TypeEnemy mon) {
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
			return new OneSideAtt(room, this);

		case TWO_SIDE:
			return new TwoSideAtt(room, this);

		case FOUR_SIDE:
			return new FourSideAtt(room, this);

		case TRIPLE:
			return new TripleAtt(room, this);

		default:
			throw new IllegalArgumentException();

		}
	}

	@Override
	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}

	@Override
	public Health getHealth() {
		return this.health;
	}

	@Override
	public void updatePos() {
		this.position = move.nextPos(this.position, speed, this.direction);
		this.direction = move.getDirection();
	}

	@Override
	public void takeDmg(int damage) {
		health.takeDmg(damage);
	}

	@Override
	public TypeEnemy getTypeEnemy() {
		return this.typeEnemy;
	}

	@Override
	public Animation getAnimation() {
		switch (this.direction) {
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
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean isAlive() {
		return health.isAlive();
	}

	@Override
	public void attack() {
		stopMillis = System.currentTimeMillis();
		if(stopMillis - startMillis > sleepTime) {
			this.attack.createBullets(position, direction, damage);
			startMillis = System.currentTimeMillis();
		}	
	}

	@Override
	public void addBullet(Bullet bullet) {
		this.bullets.add(bullet);		
	}

	@Override
	public Set<Bullet> getBullets() {
		return this.bullets;
	}

	@Override
	public int getDmg() {
		return this.damage;
	}

}
