package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Entities;
import design.utilities.Pair;
import utility.Stats;

public class HealthUpgrade1 extends ModifiersImpl{

	public HealthUpgrade1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.HEALTH, 10, "Health Upgrade", Entities.HEALTHUPGRADE1);
		this.setTexture(new Image("./res/items/mod/healthMod1.png"));
	}
}
