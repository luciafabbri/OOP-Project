package utility;

import design.utilities.GameSettings;
import design.utilities.Pair;

public class DoorCheck {
	
	public boolean doorNorth(final Pair<Integer, Integer> pos) {
		 return (pos.getX() > (GameSettings.TILESIZE * 9) - 11 && pos.getX() < (GameSettings.TILESIZE * 9 ) + 11) && (pos.getY() < GameSettings.TILESIZE);
	}
	
	public boolean transNorth(final Pair<Integer, Integer> pos) {
		 return (pos.getX() > (GameSettings.TILESIZE * 9) - 11 && pos.getX() < (GameSettings.TILESIZE * 9 ) + 11) && (pos.getY() > -5 && pos.getY() < -2);
	}
	
	
	public boolean doorWest(final Pair<Integer, Integer> pos) {
		 return (pos.getX() > 0 && pos.getX() < GameSettings.TILESIZE) && (pos.getY() + 48 > (GameSettings.TILESIZE * 5) && pos.getY() + 48 < (GameSettings.TILESIZE * 5 + 44));
	}

	public boolean transWest(final Pair<Integer, Integer> pos) {
		 return (pos.getX() > 0 && pos.getX() < GameSettings.TILESIZE / 4) && (pos.getY() + 48 > (GameSettings.TILESIZE * 5) && pos.getY() + 48 < (GameSettings.TILESIZE * 5 + 44));
	}
	
	
	public boolean doorEast(final Pair<Integer, Integer> pos) {
		 return (pos.getX() > GameSettings.WIDTH - GameSettings.TILESIZE * 3 && pos.getX() < GameSettings.LIMITRIGHT) && (pos.getY() + 48 > (GameSettings.TILESIZE * 5) && pos.getY() + 48 < (GameSettings.TILESIZE * 5 + 44));
	}
	
	public boolean transEast(final Pair<Integer, Integer> pos) {
		 return (pos.getX() > GameSettings.WIDTH - (GameSettings.TILESIZE * 3) / 2 + 15 && pos.getX() < GameSettings.LIMITRIGHT) && (pos.getY() + 48 > (GameSettings.TILESIZE * 5) && pos.getY() + 48 < (GameSettings.TILESIZE * 5 + 44));
	}
	
	
	public boolean doorSouth(final Pair<Integer, Integer> pos) {
		return (pos.getX() > (GameSettings.TILESIZE * 9) - 11 && pos.getX() < (GameSettings.TILESIZE * 9 ) + 11) && (pos.getY() > GameSettings.HEIGHT - GameSettings.TILESIZE * 3 && pos.getY() < GameSettings.LIMITDOWN);
	}
	
	public boolean transSouth(final Pair<Integer, Integer> pos) {
		return (pos.getX() > (GameSettings.TILESIZE * 9) - 11 && pos.getX() < (GameSettings.TILESIZE * 9 ) + 11) && (pos.getY() > GameSettings.HEIGHT - (GameSettings.TILESIZE * 3) / 2 + 20);
	}
}
