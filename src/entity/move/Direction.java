package entity.move;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import entity.character.enemy.CircularList;

public enum Direction {

	NORTH_WEST(-1, -1),
	NORTH(0, -1),
	NORTH_EAST(1, -1),
	EAST(1, 0),
	SOUTH_EAST(1, 1),	
	SOUTH(0, 1),
	SOUTH_WEST(-1, 1),
	WEST(-1, 0);	
	
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
	
	/*public static Direction getRandomDir() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}*/
	
	public static Direction getRandomDir() {
		Random random = new Random();
		return values()[(random.nextInt(4))*2+1];
	}
	
	public static List<Direction> getNearDistance(Direction dir, int distance) {
		CircularList<Direction> directions = new CircularList<Direction>();
		Collections.addAll(directions, Direction.values());
		
		List<Direction> dirAndNear = new ArrayList<>();
		int index = directions.indexOf(dir);
		
		dirAndNear.add(directions.get((index+distance) % directions.size()));
		dirAndNear.add(directions.get((index-distance) % directions.size()));
		
		return dirAndNear;
	}
}
