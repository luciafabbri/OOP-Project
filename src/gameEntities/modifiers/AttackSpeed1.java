package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dynamicBody.character.Stats;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class AttackSpeed1 extends ModifiersImpl{

	public AttackSpeed1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.PROJ_SPEED, 15, "ROF Upgrade", new Image("./res/items/mod/attackMod1.png"), Entities.ATTACKSPEED1);
	}
}
