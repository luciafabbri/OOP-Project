package gameEntities.items;

import java.util.Optional;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;
import gameEntities.GameEntity;

public class ItemImpl extends GameEntity{
		
	public ItemImpl(final Pair<Integer, Integer> position, final Optional<Pickupables> typeEnt) {
		super(position, typeEnt, Optional.empty());
	}
 
}
