package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import entity.character.Stats;

public class AttackSpeed1 extends ModifiersImpl{

	public AttackSpeed1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.HEALTH, 10, "Health Upgrade", new Image("./res/items/mod/AttackSpeedMod1.png"), Entities.HEALTHUPGRADE1);
	}
}
