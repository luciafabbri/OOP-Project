package enemy;

import org.newdawn.slick.Image;

import enemy.move.MovePosMonster;
import enemy.move.straightMove;
import enemy.move.teleportMove;
import utility.Direction;
import utility.Pair;

public class monster implements Enemy {
	
	private Image texture; 
	private String name;
	private Pair<Integer,Integer> position;
	private String typeLevel;
	private int level;
	private int maxLife;
	private int actLife;
	private MovePosMonster move;
	private Direction direct;

	public monster(String name, Pair<Integer, Integer> pos, String typeLevel, int lvl, int life, TypeMove move, Direction dir) {
		this.name=name;
		this.position=pos;
		this.typeLevel=typeLevel;
		this.level=lvl;
		this.maxLife=life;
		this.actLife=life;
		this.move=selectMove(move);
		this.direct=dir;
	}
	
	private MovePosMonster selectMove(TypeMove typeMove) {
		switch (typeMove) {
			case STRAIGHT:
				return new straightMove();
				
			case TELEPORT:
				return new teleportMove();
			
			default: 
				throw new IllegalArgumentException();
			
		}
	}

	public monster(String name, Pair<Integer,Integer> pos, String typeLevel, int life, TypeMove move, Direction dir) {
		this(name, pos, typeLevel, 1, life, move, dir);
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
		return maxLife;
	}

	@Override
	public int getActualLife() {
		return actLife;
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
	public void setDirection(Direction dir) {
		this.direct=dir;
	}




}
