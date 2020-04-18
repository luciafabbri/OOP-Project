package gameEntities.items;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import gameEntities.GameEntity;

public class ItemImpl extends GameEntity{
	
	private Image texture;
		
	public ItemImpl(final Pair<Integer, Integer> position, final Image texture) {
		super(position);
		this.texture = texture;
	}
	
	public Image getTexture() {
		return texture;
	}
	

 
}
