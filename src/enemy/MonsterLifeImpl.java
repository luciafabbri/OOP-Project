package enemy;

import utility.Life;

public class MonsterLifeImpl implements Life {
	
	private int maxLife = 0;
	private int actualLife = 0;
	
	public MonsterLifeImpl(int health) {
		this.maxLife = health;
		this.actualLife = health;
	}

	@Override
	public int getMaxLife() {
		return this.maxLife;
	}

	@Override
	public int getActualLife() {
		return this.actualLife;
	}

	@Override
	public void takeDmg(int dmg) {
		this.actualLife= this.actualLife - dmg;
	}

}
