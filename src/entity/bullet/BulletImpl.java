package entity.bullet;

import org.newdawn.slick.Image;
import design.RoomDesign;
import design.utilities.Pair;
import entity.UpDownLeftRight;
import entity.bullet.move.CheckMonsBull;
import entity.bullet.move.CheckPlayerBull;
import entity.bullet.move.MoveBull;
import entity.bullet.move.MoveBullImpl;
import entity.move.CheckPos;
import entity.move.Direction;

public class BulletImpl implements Bullet {
	
	private Pair<Integer, Integer> pos;
	private int dmg;
	private Direction direction;
	private MoveBull move;
	private Image texture;
	private RoomDesign room;
	private Pair<DimensionBullet, DimensionBullet> dimensions;
	private CheckPos check;
	
	public BulletImpl(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room, TypeBullet type){
		this.pos = position;
		this.dmg = damage;
		this.direction = direction;	
		this.room = room;
		this.move = new MoveBullImpl(room);	
		this.dimensions = DimensionBullet.getDimensionBullet(type);
		this.check = findCheck(type);
	}	
	
	private CheckPos findCheck(TypeBullet type) {
		switch(type) {
			case MONSTER:
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
