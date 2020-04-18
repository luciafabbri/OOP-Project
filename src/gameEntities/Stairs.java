package gameEntities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Entities;
import design.utilities.Pair;

public class Stairs extends GameEntity {

	public Stairs(Pair<Integer, Integer> position) throws SlickException {
		//IMMAGINE TEMPORANEA
		super(position, Entities.STAIR);
		this.setTexture(new Image("./res/walls/old/Old_Hor_Wall.png"));
	}

}
