package gameEntities.items;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import gameEntities.Pickupable;

public class ItemImpl extends Pickupable{
		
	/**
	 * Constructor for ItemImpl, to create items to pickup
	 * @param position, to associate every Item with a position to be placed
	 * @param texture, to associate a texture with the Item
	 * @param typeEnt, to denote which type of item it is
	 */
	public ItemImpl(final Pair<Integer, Integer> position, final Image texture, final Entities typeEnt) {
		super(position, texture, typeEnt);
	}
 
}
