package design;

import java.io.IOException;

public interface LevelDesignGenerator {

	LevelDesign generateLevel(Integer levelNumber) throws IOException;
	
}
