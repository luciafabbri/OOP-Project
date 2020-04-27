package utility.health;

public class HealthImpl implements Health {
	
	private int totalHealth;
	private int currentHealth;
	
	public HealthImpl(int health) {
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
	public void setCurrentHealth(int health) {
		this.currentHealth = health;
	}
	
	@Override
	public void takeDmg(int damage) {
		this.currentHealth = this.currentHealth - damage;
	}
	
	@Override
	public boolean isAlive() {
		return this.currentHealth > 0;
	}

	@Override
	public void upgradeHealth(int upgrade) {
		this.currentHealth = this.currentHealth + upgrade;
	}

}
