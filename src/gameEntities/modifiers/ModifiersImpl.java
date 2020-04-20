package gameEntities.modifiers;

import java.util.Optional;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;
import gameEntities.GameEntity;
import gameEntities.Pickupable;
import utility.Stats;

public class ModifiersImpl extends Pickupable{
	
	private Stats stat;
	private int modQty;
	private String name;
	
	public ModifiersImpl(final Pair<Integer, Integer> position, final Stats stat, final int qty, final String name) {
		super(position);
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
