package gameEntities.modifiers;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import gameEntities.GameEntity;
import utility.Stats;

public class ModifiersImpl extends GameEntity{
	
	private Stats stat;
	private int modQty;
	private String name;
	
	public ModifiersImpl(final Pair<Integer, Integer> position, final Stats stat, final int qty, final String name, final Entities typeEnt) {
		super(position, typeEnt);
		this.stat = stat;
		this.modQty = qty;
		this.name = name;
	}

	public Stats getStat() {
		return stat;
	}

	public int getModQty() {
		return modQty;
	}
}
