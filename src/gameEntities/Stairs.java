package gameEntities;

import java.util.Optional;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public class Stairs extends GameEntity {

	public Stairs(Pair<Integer, Integer> position) throws SlickException {
		//IMMAGINE TEMPORANEA
		super(position, Optional.empty(), Optional.of(Entities.STAIR));
		this.setTexture(new Image("./res/floor/stairs.png"));
	}

}
