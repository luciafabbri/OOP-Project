package utility;

public interface Health {
		
	public int getCurrentHealth();
	
	public void takeDmg(int dmg);
	
	public boolean isAlive(int currentHealth);

	public int getMaxHealth();

}
