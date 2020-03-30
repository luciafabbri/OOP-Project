package design;

public interface LevelDesignGenerator {

	LevelDesign levelGenerator(Integer levelNumber);
	
	RoomDesign roomGenerator(Integer levelNumber);
}
