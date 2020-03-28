package items;

import org.newdawn.slick.Image;

import genTest.Pair;

public class ItemImpl {
	
	 private Image texture;
	 private Pair<Integer, Integer> coord;
		
	 public ItemImpl(final Image texture, final Pair<Integer, Integer> coord){
		 this.texture = texture;
		 this.coord = coord;
	}

	public Image getTexture() {
		return texture;
	}
	
	public Pair<Integer, Integer> getCoord() {
		return coord;
	}

	public void setCoord(Pair<Integer, Integer> coord) {
		this.coord = coord;
	}
 
}
