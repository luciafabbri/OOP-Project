package items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import genTest.Pair;

public class Key extends ItemImpl{
	
	public Key(final Pair<Integer, Integer> coord) throws SlickException {
		super(new Image("./res/chars/mainChar5_back.png"), coord);
}

}
