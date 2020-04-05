package enemy;

import utility.Health;

public class monsterLifeImpl implements Health {
	
	private int maxHealth = 0;
	private int currentHealth = 0;
	
	public monsterLifeImpl(int health) {
		this.maxHealth = health;
		this.currentHealth = health;
	}


	@Override
	public int getCurrentHealth() {
		return this.currentHealth;
	}

	@Override
	public void takeDmg(int dmg) {
		this.currentHealth= this.currentHealth - dmg;
	}

	@Override
	public int getMaxHealth() {
		return this.maxHealth;
	}

	@Override
	public int isAlive(int currentHealth) {
		return 0;
	}

}
