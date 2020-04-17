package gameEntities.modifiers;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import utility.Stats;

public class ModifiersImpl{
	
	private Image texture;
	private Pair<Integer, Integer> pos;
	private Stats stat;
	private int modQty;
	private String name;
	
	public ModifiersImpl(final Image texture, final Pair<Integer, Integer> coord, final Stats stat, final int qty, final String name) {
		this.texture = texture;
		this.pos = coord;
		this.stat = stat;
		this.modQty = qty;
		this.name = name;
	}

	public Image getTexture() {
		return texture;
	}

	public Pair<Integer, Integer> getPos() {
		return pos;
	}

	public Stats getStat() {
		return stat;
	}

	public int getModQty() {
		return modQty;
	}
}
