package gameEntities;

import org.newdawn.slick.Image;

import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class Insurmountable extends GameEntity{

	public Insurmountable(final Pair<Integer, Integer> position, final Image texture, final Entities typeEnt) {
		super(position, texture, typeEnt);
	}

}
