package enemy;

import org.newdawn.slick.Image;

import enemy.attack.FourSideAtt;
import enemy.attack.MonsterAttack;
import enemy.attack.OneSideAtt;
import enemy.attack.TripleAtt;
import enemy.attack.TwoSideAtt;
import enemy.move.ImmobilizedMove;
import enemy.move.MovePosMonster;
import enemy.move.RandomMove;
import enemy.move.StraightMove;
import enemy.move.TeleportMove;
import utility.Direction;
import utility.health.Health;
import utility.health.HealthImpl;
import design.RoomDesignImpl;
import design.utilities.Pair;

public class Monster implements Enemy {
	
	private Image texture;
	private Pair<Integer,Integer> position;
	private String typeLevel;
	private Health health;
	private MovePosMonster move;
	private MonsterAttack attack;
	private Direction direct;

	public Monster(Pair<Integer, Integer> pos, String typeLevel, int health, TypeMove move, Direction dir, TypeAttack att, RoomDesignImpl room) {
		this.position = pos;
		this.typeLevel = typeLevel;
		this.health = new HealthImpl(health);
		this.move = selectMove(move, room);
		this.attack = selectAttack(att, room);
		this.direct=dir;
	}
	
	private MovePosMonster selectMove(TypeMove typeMove, RoomDesignImpl room) {
		switch (typeMove) {
			case STRAIGHT:
				return new StraightMove(room);
				
			case TELEPORT:
				return new TeleportMove(room);
				
			case RANDOM:
				return new RandomMove(room);
				
			case IMMOBILIZED:
				return new ImmobilizedMove();
			
			default: 
				throw new IllegalArgumentException();
			
		}
	}
	
	private MonsterAttack selectAttack(TypeAttack typeAttack, RoomDesignImpl room) {
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
	public Pair<Integer,Integer> getPos() {
		return this.position;
	}
	
	@Override
	public void updatePos() {		
		this.position=move.nextPos(this.position, this.direct);
		this.direct=move.getDirection();
	}

	@Override
	public String getTypeLevel() {
		return typeLevel;
	}
	
	@Override
	public int getMaxLife() {
		return health.getMaxHealth();
	}

	@Override
	public int getCurrentLife() {
		return health.getCurrentHealth();
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
	public Image getImage() {
		return texture;
	}

	@Override
	public Direction getDirection() {
		return this.direct;
	}




}
