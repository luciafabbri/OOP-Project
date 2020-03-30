package design;
import java.util.Random;

public class LevelDesignGeneratorImpl implements LevelDesignGenerator {
	
	Random random = new Random();

	@Override
	public LevelDesign levelGenerator(Integer levelNumber) {
		LevelDesign level = new LevelDesignImpl();
		return level;
	}

	@Override
	public RoomDesign roomGenerator(Integer levelNumber) {
		RoomDesign room = new RoomDesignImpl();
		return room;
	}

}
