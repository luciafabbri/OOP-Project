package dynamicBody.character.enemy;

import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import dynamicBody.UpDownLeftRight;
import dynamicBody.bullet.Bullet;
import dynamicBody.character.enemy.attack.AttackFactory;
import dynamicBody.character.enemy.attack.EnemyAttack;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.character.enemy.move.MoveFactory;
import dynamicBody.character.enemy.move.EnemyMovement;
import dynamicBody.character.enemy.move.TypeMove;
import dynamicBody.character.health.Health;
import dynamicBody.character.health.HealthImpl;
import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * Class that implements interface Enemy used to define all the aspects
 * concerning the enemy
 */
public class EnemyImpl implements Enemy {

	private Pair<Integer, Integer> position;
	private int damage;
	private int speed;
	private Health health;
	private EnemyMovement move;
	private EnemyAttack attack;
	private Direction direction;
	private EnemyDimension dimensions;
	private TypeEnemy typeEnemy;
	private Set<Bullet> bullets = new HashSet<>();
	
	private MoveFactory moveFactory = new MoveFactory();
	private AttackFactory attackFactory = new AttackFactory();

	private int sleepTime = EnemyDefault.ROF.getValue();
	private long stopMillis;
	private long startMillis;

	private Sound enemyDamage;
	
	/**
	 * Default constructor
	 * 
	 * @param pos,    position of the monster
	 * @param damage, damage of the monster
	 * @param speed,  speed of the monster
	 * @param health, max health of the monster
	 * @param move,   TypeMove of monster
	 * @param dir,    Direction of monster
	 * @param att,    TypeAttack of monster
	 * @param room,   RoomModel where monster spawn
	 * @param mon,    TypeEnemy of monster
	 */
	public EnemyImpl(Pair<Integer, Integer> pos, int damage, int speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomModel room, TypeEnemy mon) {
		this.position = pos;
		this.damage = damage;
		this.speed = speed;
		this.health = new HealthImpl(health);
		this.move = moveFactory.selectMove(move, room, this);
		this.attack = attackFactory.selectAttack(att, room, this);
		this.direction = dir;
		this.dimensions = EnemyDimension.getDimensionMoster(mon);
		this.typeEnemy = mon;
		try {
			this.enemyDamage = new Sound("./res/audio/enemy/takeDamage.wav");
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	public EnemyImpl(Pair<Integer, Integer> pos, int damage, int health, TypeMove move, TypeAttack att, RoomModel room,
			TypeEnemy mon) {
		this(pos, damage, EnemyDefault.SPEED.getValue(), health, move, Direction.getRandomDir(), att, room, mon);
	}

	@Override
	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}

	@Override
	public void updatePos() {
		this.position = move.nextPos(this.position, speed, this.direction);
		this.direction = move.getDirection();
	}

	@Override
	public void takeDamage(int damage) {
		enemyDamage.play(1.0f, 0.2f);
		health.takeDmg(damage);
	}

	@Override
	public TypeEnemy getTypeEnemy() {
		return this.typeEnemy;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public UpDownLeftRight<Integer> getDimension() {
		return this.dimensions.getDimension();
	}

	@Override
	public boolean isAlive() {
		return health.isAlive();
	}

	@Override
	public void attack() {
		stopMillis = System.currentTimeMillis();
		if (stopMillis - startMillis > sleepTime) {
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
