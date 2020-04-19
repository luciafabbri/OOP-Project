package utility.health;

/**
 * 
 * Class that implements Interface Health and create an object HealthPlayerImpl
 * 
 */


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
	
	public void setCurrentHealth(int health) {
		this.currentHealth = health;
	}
	
	@Override
	public void takeDmg(int dmg) {
		this.currentHealth = this.currentHealth - dmg;
	}
	
	@Override
	public boolean isAlive() {
		return this.currentHealth > 0;
	}

	@Override
	public int upgradeHealth(int upgrade) {
		return this.currentHealth = this.currentHealth + upgrade;
	}

}
