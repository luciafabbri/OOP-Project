package gameEntities.modifiers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import dynamicBody.character.Stats;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class MovementSpeed1 extends ModifiersImpl{

	public MovementSpeed1(Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Stats.MOV_SPEED, 1, "Movemnet Speed Upgrade", new Image("./res/items/mod/MovementSpeedMod1.png"), Entities.MOVEMENTSPEED1);
	}
}
