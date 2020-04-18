package player;

public interface Inventory {
	
	public int getCoin();

	public int getKey();
	
	public void addCoin(int coin);

	public void addKey(int key);

	public void printInventoryState();

}
