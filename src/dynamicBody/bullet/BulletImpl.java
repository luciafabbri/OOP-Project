package dynamicBody.bullet;

import org.newdawn.slick.Image;
import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.UpDownLeftRight;
import dynamicBody.bullet.move.CheckMonsBull;
import dynamicBody.bullet.move.CheckPlayerBull;
import dynamicBody.bullet.move.MoveBull;
import dynamicBody.bullet.move.MoveBullImpl;
import dynamicBody.move.CheckPos;
import dynamicBody.move.Direction;

/**
 * Class that implements interface Bullet used to represent a character's
 * generic bullet in the dungeon
 */

public class BulletImpl implements Bullet {

	private Pair<Integer, Integer> pos;
	private int dmg;
	private Direction direction;
	private MoveBull move;
	private Image texture;
	private RoomDesign room;
	private Pair<DimensionBullet, DimensionBullet> dimensions;
	private CheckPos check;

	/**
	 * Default constructor
	 * 
	 * @param position,  bullet's position
	 * @param damage,    bullet's damage power
	 * @param direction, bullet's direction
	 * @param room,      bullet's current room
	 * @param type,      bullet's type (player type or enemy type)
	 */
	public BulletImpl(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room,
			TypeBullet type) {
		this.pos = position;
		this.dmg = damage;
		this.direction = direction;
		this.room = room;
		this.move = new MoveBullImpl(room);
		this.dimensions = DimensionBullet.getDimensionBullet(type);
		this.check = findCheck(type);
	}

	/**
	 * Method used to check which control type the bullet should used according to
	 * his type
	 * 
	 * @param type, bullet's type
	 * @return type of check that the bullet will use while shooting in the dungeon
	 */
	private CheckPos findCheck(TypeBullet type) {
		switch (type) {
		case ENEMY:
			return new CheckMonsBull(this);
		case PLAYER:
			return new CheckPlayerBull(this);
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean isAlive() {
		return move.isAlive();
	}

	@Override
	public Pair<Integer, Integer> getPos() {
		return this.pos;
	}

	@Override
	public void updatePos() {
		this.pos = move.nextPos(this.pos, direction, check);
	}

	@Override
	public int getDamage() {
		return this.dmg;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public Image getTexture() {
		return this.texture;
	}

	@Override
	public UpDownLeftRight<Integer> getDimension() {
		if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
			return dimensions.getX().getDimension();
		} else {
			return dimensions.getY().getDimension();
		}
	}

	@Override
	public void setTexture(Image texture) {
		this.texture = texture;
	}

	@Override
	public RoomDesign getRoom() {
		return room;
	}

}
