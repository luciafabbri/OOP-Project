package gameEntities.items;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import gameEntities.GameEntity;

public class ItemImpl extends GameEntity{
		
	public ItemImpl(final Pair<Integer, Integer> position, final Entities typeEnt) {
		super(position, typeEnt);
	}
 
}
