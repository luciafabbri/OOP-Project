package utility.health;

public interface Health {
		
	public int getCurrentHealth();
	
	public void takeDmg(int dmg);
	
	public boolean isAlive();

	public int getMaxHealth();
	
	public int upgradeHealth(int upgrade);

}
