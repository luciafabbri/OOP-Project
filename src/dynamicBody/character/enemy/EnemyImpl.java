package dynamicBody.character.enemy;

import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.UpDownLeftRight;
import dynamicBody.bullet.Bullet;
import dynamicBody.character.enemy.attack.FourSideAtt;
import dynamicBody.character.enemy.attack.MonsterAttack;
import dynamicBody.character.enemy.attack.OneSideAtt;
import dynamicBody.character.enemy.attack.TripleAtt;
import dynamicBody.character.enemy.attack.TwoSideAtt;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.move.ImmobilizedMove;
import dynamicBody.character.enemy.move.MovePosMonster;
import dynamicBody.character.enemy.move.RandomMove;
import dynamicBody.character.enemy.move.StraightMove;
import dynamicBody.character.enemy.move.TeleportMove;
import dynamicBody.character.enemy.move.ToPlayerMove;
import dynamicBody.character.enemy.move.TypeMove;
import dynamicBody.character.health.Health;
import dynamicBody.character.health.HealthImpl;
import dynamicBody.move.Direction;

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
	
	private int sleepTime = EnemyDefault.ROF.getValue();
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
			
		case TO_PLAYER:
			return new ToPlayerMove(room, this);

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
	public void takeDamage(int damage) {
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
	public Set<Bullet> getRoomBullets() {
		return this.bullets;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}

}
