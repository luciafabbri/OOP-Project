package gameEntities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public class Stairs extends Insurmountable {

	public Stairs(final Pair<Integer, Integer> position) throws SlickException {
		super(position, new Image("./res/floor/stairs.png"), Entities.STAIR);
	}

}
