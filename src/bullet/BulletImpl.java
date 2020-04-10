package bullet;

import org.newdawn.slick.Image;

import bullet.move.MovePosBull;
import bullet.move.MoveBull;
import design.utilities.Pair;
import enemy.TypeMove;
import utility.CheckPos;
import utility.Debuff;
import utility.Direction;


public class BulletImpl implements Bullet {
	
	private Pair<Integer, Integer> pos;
	private int dmg;
	private Debuff debuff;
	private Direction dir;
	private MovePosBull move;
	
	public BulletImpl(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, TypeMove typeMove){
		this.pos=position;
		this.dmg=damage;
		this.debuff=debuff;
		this.dir=direction;	
		this.move=selectMove(typeMove);		
	}
	
	private MovePosBull selectMove(TypeMove typeMove) {
		
		switch (typeMove) {
			case STRAIGHT: return new MoveBull();
			
			default: throw new IllegalArgumentException();			
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
	public void updatePos(CheckPos check) {
		this.pos = move.nextPos(this.pos, dir, check);	
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
		return null;
	}

}
