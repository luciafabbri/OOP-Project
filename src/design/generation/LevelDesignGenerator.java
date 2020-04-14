package design.generation;

import java.io.IOException;

import design.LevelDesign;

public interface LevelDesignGenerator {

	LevelDesign generateLevel(Integer levelNumber) throws IOException;
	
}
