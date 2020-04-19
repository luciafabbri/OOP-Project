package gameEntities.modifiers;

import java.util.Optional;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;
import utility.Stats;

public class HealthUpgrade1 extends ModifiersImpl{

	public HealthUpgrade1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.HEALTH, 10, "Health Upgrade", Optional.of(Pickupables.HEALTHUPGRADE1));
		this.setTexture(new Image("./res/items/mod/healthMod1.png"));
	}
}
