package player.inventory;

import player.Player;

public class InventoryImpl implements Inventory {
	
	private int coin;
	private int key;
	
	public InventoryImpl(Player player) {
		this.coin = 0;
		this.key = 0;
	}

	@Override
	public int getCoin() {
		return this.coin;
	}

	@Override
	public int getKey() {
		return this.key;
	}
	
	@Override
	public void addCoin() {
		this.coin += 1;
	}

	@Override
	public void addKey() {
		this.key += 1;
	}

	@Override
	public void printInventoryState() {
		System.out.println("coin: " +this.getCoin() + "\nkey: " +this.getKey());
	}
}
