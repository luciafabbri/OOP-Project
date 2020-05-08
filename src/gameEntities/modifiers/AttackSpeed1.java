package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import dynamicBody.character.Stats;

public class AttackSpeed1 extends ModifiersImpl{

	public AttackSpeed1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.PROJ_SPEED, 100, "ROF Upgrade", new Image("./res/items/mod/attackMod1.png"), Entities.ATTACKSPEED1);
	}
}
