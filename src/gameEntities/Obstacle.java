package gameEntities;


import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public class Obstacle extends GameEntity{
	
	
	public Obstacle(Pair<Integer, Integer> position, Entities typeEnt) {
		super(position, typeEnt);
	}

}
