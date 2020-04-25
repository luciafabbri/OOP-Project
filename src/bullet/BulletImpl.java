package bullet;

import org.newdawn.slick.Image;

import bullet.move.MoveBull;
import bullet.move.MoveBullImpl;
import design.RoomDesign;
import design.utilities.Pair;
import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import utility.UpDownLeftRight;


public class BulletImpl implements Bullet {
	
	private Pair<Integer, Integer> pos;
	private int dmg;
	private int speed;
	private Debuff debuff;
	private Direction direction;
	private MoveBull move;
	private Image texture;
	private RoomDesign room;
	private Pair<DimensionBullet, DimensionBullet> dimensions;
	
	public BulletImpl(Pair<Integer, Integer> position, int damage, int speed, Debuff debuff, Direction direction, RoomDesign room, TypeBullet type){
		this.pos = position;
		this.dmg = damage;
		this.speed = speed;
		this.debuff = debuff;
		this.direction = direction;	
		this.room = room;
		this.move = new MoveBullImpl(room);	
		this.dimensions = DimensionBullet.getDimensionBullet(type);
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
	public void updatePos(CheckPos check) {
		this.pos = move.nextPos(this.pos, direction, check, speed);	
	}

	@Override
	public int getDmg() {
		return this.dmg;
	}

	@Override
	public Debuff getDebuff() {
		return this.debuff;
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
		} else if (direction.equals(Direction.WEST) || direction.equals(Direction.EAST)) {
			return dimensions.getY().getDimension();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}


	public RoomDesign getRoom() {
		return room;
	}
}
