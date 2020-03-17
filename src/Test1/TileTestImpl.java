package Test1;

import org.newdawn.slick.Image;

public class TileTestImpl {
	
	private Image texture;
//	private boolean passable;  // Not useful now
	
	public TileTestImpl (final Image tex, final boolean pass) {
		this.texture = tex;
//		this.passable = pass;  // Not useful now
	}

	public Image getTexture() {
		return texture;
	}
	
	
	
	
	
}
