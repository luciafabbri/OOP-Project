package gameEntities;


import java.util.Optional;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public class Obstacle extends GameEntity{
	
	public Obstacle(Pair<Integer, Integer> position, Optional<Entities> typeEnt) {
		super(position, Optional.empty(), typeEnt);
	}

}
