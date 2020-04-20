package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import utility.Stats;

public class AttackUpgrade1 extends ModifiersImpl{

	public AttackUpgrade1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.ATTACK, 10, "Ebony Bow", new Image("./res/items/mod/attackMod1.png"), Entities.ATTACKUPGRADE1);
	}
}
