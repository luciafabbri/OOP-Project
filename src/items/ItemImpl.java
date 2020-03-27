package items;

import org.newdawn.slick.Image;

import genTest.Pair;

public class ItemImpl {
	
	 private Image texture;
	 private Pair<Integer, Integer> coords;
	
	 public ItemImpl(final Image texture, final Pair<Integer, Integer> coords){
		 this.texture = texture;
		 this.coords = coords;
	 }

	public Image getTexture() {
		return texture;
	}

	public Pair<Integer, Integer> getCoords() {
		return coords;
	}
	
}
