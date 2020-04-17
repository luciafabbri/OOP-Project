package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import utility.Stats;

public class HealthUpgrade1 extends ModifiersImpl{

	public HealthUpgrade1(Pair<Integer, Integer> coord) throws SlickException {
		super(new Image("./res/items/mod/healthMod1.png"), coord, Stats.HEALTH, 10, "Health Upgrade");
	}
}
