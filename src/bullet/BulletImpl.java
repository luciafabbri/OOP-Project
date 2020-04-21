package bullet;

import org.newdawn.slick.Image;

import bullet.move.MoveBull;
import bullet.move.MoveBullImpl;
import design.RoomDesign;
import design.RoomDesignImpl;
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
	private Direction dir;
	private MoveBull move;
	private Image image;
	
	public BulletImpl(Pair<Integer, Integer> position, int damage, int speed, Debuff debuff, Direction direction, RoomDesign room){
		this.pos = position;
		this.dmg = damage;
		this.speed = speed;
		this.debuff = debuff;
		this.dir = direction;	
		this.move = new MoveBullImpl(room);	
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
		this.pos = move.nextPos(this.pos, dir, check, speed);	
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
		return this.dir;
	}

	@Override
	public Image getImage() {
		return this.image;
	}


	@Override
	public UpDownLeftRight<Integer> getDimension() {
		return new UpDownLeftRight<>(26, DIMENSION, 0, DIMENSION);
	}
}
