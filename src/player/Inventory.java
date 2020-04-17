package player;

public class Inventory {
	
	private int coin;
	private int key;
	
	public Inventory() {
		this.coin = 0;
		this.key = 0;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
