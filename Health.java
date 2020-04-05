package utility;

public interface Health {
	
	public int getMaxHealth();
	
	public int getCurrentHealth();
	
	public void takeDmg(int dmg);
	
	public int isAlive(int currentHealth);

}
