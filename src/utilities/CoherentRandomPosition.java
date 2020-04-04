package utilities;

import java.util.Random;

public class CoherentRandomPosition implements RandomPosition{
	
	Random random = new Random();
	

	public Pair<Integer, Integer> generateRandomPosition() {
		
		Integer xPos = GameSettings.TILESIZE + random.nextInt(GameSettings.WIDTH - (GameSettings.TILESIZE*2));
		Integer yPos = GameSettings.TILESIZE + random.nextInt(GameSettings.HEIGHT - (GameSettings.TILESIZE*2));
		
		return new Pair<Integer, Integer>(xPos, yPos);
	}

}
