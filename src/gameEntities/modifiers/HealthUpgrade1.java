package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dynamicBody.character.Stats;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class HealthUpgrade1 extends ModifiersImpl{

	public HealthUpgrade1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.HEALTH, 10, "Health Upgrade", new Image("./res/items/mod/healthMod1.png"), Entities.HEALTHUPGRADE1);
	}
}
