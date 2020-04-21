package gameEntities.items;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import gameEntities.Pickupable;

public class ItemImpl extends Pickupable{
		
	public ItemImpl(final Pair<Integer, Integer> position, final Image texture, final Entities typeEnt) {
		super(position, texture, typeEnt);
	}
 
}
