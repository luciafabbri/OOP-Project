package entity.character.enemy;

import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import coordination.TestState;
import entity.UpDownLeftRight;
import entity.bullet.BulletMonster;
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
import entity.character.player.Player;
import entity.move.Direction;
import entity.move.Speed;
import design.RoomDesign;
import design.utilities.Pair;

public class EnemyImpl implements Enemy {

	private Pair<Integer, Integer> position;
	private int damage;
	private Speed speed;
	private Health health;
	private MovePosMonster move;
	private MonsterAttack attack;
	private Direction direction;
	private Pair<DimensionMonster, DimensionMonster> dimensions;
	private TypeEnemy typeEnemy;
	private UpDownLeftRight<Animation> textures;
	private RoomDesign room;
	private Set<BulletMonster> bullets = new HashSet<>();
	
	private int sleepTime = 100;

	public EnemyImpl(Pair<Integer, Integer> pos, int damage, Speed speed, int health, TypeMove move, Direction dir,
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
		this.room = room;
		try {
			this.textures = EnemyImage.getTexture(mon);
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	public EnemyImpl(Pair<Integer, Integer> pos, int damage, int health, TypeMove move, TypeAttack att, RoomDesign room,
			TypeEnemy mon) {
		this(pos, damage, Speed.SLOW, health, move, Direction.getRandomDir(), att, room, mon);
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
		this.position = move.nextPos(this.position, Speed.getSpeed(speed), this.direction);
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
		/*while (this.isAlive()) {
			while (this.room.equals(player.getRoom())) {
				if (sleepTime == 0) {
					sleepTime = 240;
					System.out.println("ATTACCO");
					this.attack.createBullets(position, direction, damage);
				} else {
					sleepTime--;
				}
			}
		}*/
		
		if(this.sleepTime == 0) {
			this.attack.createBullets(position, direction, damage);
			sleepTime = 1000;
		} else {
			sleepTime --;
		}
	}

	@Override
	public void addBullet(BulletMonster bullet) {
		this.bullets.add(bullet);		
	}

	@Override
	public Set<BulletMonster> getBullets() {
		return this.bullets;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}

}
