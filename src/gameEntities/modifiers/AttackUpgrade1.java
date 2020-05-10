package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dynamicBody.character.Stats;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class AttackUpgrade1 extends ModifiersImpl{

	public AttackUpgrade1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.ATTACK, 10, "Ebony Bow", new Image("./res/items/mod/AttackSpeedMod1.png"), Entities.ATTACKUPGRADE1);
	}
}
