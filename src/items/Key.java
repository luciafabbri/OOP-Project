package items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import utility.Pair;

public class Key extends ItemImpl{
	
	public Key(final Pair<Integer, Integer> coord) throws SlickException {
		super(new Image("./res/chars/mainChar4.png"), coord);
//		super(new Image("./res/chars/mainChar2.png"), coord);
	}

}
