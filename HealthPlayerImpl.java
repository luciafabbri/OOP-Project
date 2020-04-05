package player;

import utility.Health;

public class HealthPlayerImpl implements Health {
	
	private int totalHealth;
	private int currentHealth;
	
	public HealthPlayerImpl(int health) {
		this.totalHealth = health;
		this.currentHealth = health;
	}
	
	@Override
	public int getMaxHealth() {
		return this.totalHealth;
	}
	
	@Override
	public int getCurrentHealth() {
		return this.currentHealth;
	}
	
	@Override
	public void takeDmg(int dmg) {
		this.currentHealth = this.currentHealth - dmg;
	}
	
	@Override
	public boolean isAlive(int currentHealth) {
		return (this.currentHealth > 0);
	}
	
}
