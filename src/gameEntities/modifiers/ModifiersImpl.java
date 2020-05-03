package gameEntities.modifiers;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import dynamicBody.character.Stats;
import gameEntities.Pickupable;

public class ModifiersImpl extends Pickupable{
	
	/**
	 * Variable containing which Stat the Modifier changes
	 */
	private Stats stat;
	/**
	 * Variable containing how much the Modifier changes
	 */
	private int modQty;
	/**
	 * Variable containing the name of the Modifier
	 */
	private String name;
	
	/**
	 * Constructor for ModifiersImpl, to create Modifiers to pickup
	 * @param position, to associate every Modifier with a position to be placed
	 * @param stat, to associate which statistic is supposed to change in the Player
	 * @param qty, to know how much the Modifier is supposed to increment or decrement
	 * @param name, to associate a name with the Modifier
	 * @param texture, to associate a texture with the Modifier
	 * @param typeEnt to denote which type of Modifier it is
	 */
	public ModifiersImpl(final Pair<Integer, Integer> position, final Stats stat, final int qty, final String name, final Image texture, final Entities typeEnt) {
		super(position, texture, typeEnt);
		this.stat = stat;
		this.modQty = qty;
		this.name = name;
	}

	/**
	 * Method that returns the Stat of the Modfier
	 * @return Stats
	 */
	public Stats getStat() {
		return stat;
	}

	/**
	 * Method that returns how much the Modifier changes
	 * @return int, the quantity
	 */
	public int getModQty() {
		return modQty;
	}
}
