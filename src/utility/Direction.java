package utility;

import java.util.Random;

public enum Direction {

	NORTH(0, -1),
	SOUTH(0, 1),
	EAST(1, 0),
	WEST(-1, 0),
	NORTH_EAST(1, -1),	
	NORTH_WEST(-1, -1),
	SOUTH_EAST(1, 1),	
	SOUTH_WEST(-1, 1);	
	
	private int abscissa;
	private int ordinate;
	
	Direction(final int x, final int y) {
		this.abscissa = x;
		this.ordinate = y;
	}
	
	public int getAbscissa() {
		return this.abscissa;
	}
	
	public int getOrdinate() {
		return this.ordinate;
	}
	
	public static Direction getRandomDir() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}
