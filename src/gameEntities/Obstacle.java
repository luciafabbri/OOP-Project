package gameEntities;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public class Obstacle extends Insurmountable{
	
	public Obstacle(final Pair<Integer, Integer> position) throws SlickException {
		super(position, new Image("./res/obstacles/obstacle_stone1.png"), Entities.BOULDER);
	}

}
