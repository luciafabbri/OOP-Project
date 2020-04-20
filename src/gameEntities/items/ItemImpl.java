package gameEntities.items;

import java.util.Optional;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;
import gameEntities.GameEntity;
import gameEntities.Pickupable;

public class ItemImpl extends Pickupable{
		
	public ItemImpl(final Pair<Integer, Integer> position) {
		super(position);
	}
 
}
