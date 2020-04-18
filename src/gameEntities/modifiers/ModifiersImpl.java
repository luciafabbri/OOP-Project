package gameEntities.modifiers;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import gameEntities.GameEntity;
import utility.Stats;

public class ModifiersImpl extends GameEntity{
	
	

	private Image texture;
	private Stats stat;
	private int modQty;
	private String name;
	
	public ModifiersImpl(final Image texture, final Pair<Integer, Integer> position, final Stats stat, final int qty, final String name) {
		super(position);
		this.texture = texture;
		this.stat = stat;
		this.modQty = qty;
		this.name = name;
	}

	public Image getTexture() {
		return texture;
	}


	public Stats getStat() {
		return stat;
	}

	public int getModQty() {
		return modQty;
	}
}
