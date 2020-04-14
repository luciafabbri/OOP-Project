package enemy;

import org.newdawn.slick.Image;

import enemy.move.ImmobilizedMove;
import enemy.move.MovePosMonster;
import enemy.move.RandomMove;
import enemy.move.StraightMove;
import enemy.move.TeleportMove;
import utility.Direction;
import design.RoomDesignImpl;
import design.utilities.Pair;

public class Monster implements Enemy {
	
	private Image texture; 
	private String name;
	private Pair<Integer,Integer> position;
	private String typeLevel;
	private int level;
	private int maxHealth;
	private int currHealth;
	private MovePosMonster move;
	private Direction direct;

	public Monster(String name, Pair<Integer, Integer> pos, String typeLevel, int lvl, int life, TypeMove move, Direction dir, TypeAttack att, RoomDesignImpl room) {
		this.name=name;
		this.position=pos;
		this.typeLevel=typeLevel;
		this.level=lvl;
		this.maxHealth=life;
		this.currHealth=life;
		this.move=selectMove(move, room);
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

	@Override
	public String getName() {
		return this.name;
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
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getMaxLife() {
		return maxHealth;
	}

	@Override
	public int getCurrentLife() {
		return currHealth;
	}

	@Override
	public int getDmg() {
		return 0;
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
