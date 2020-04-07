package tiles;

import org.newdawn.slick.Image;

import genTest.GameSettings;

public class Tile implements GameSettings {
	
	private Image texture;
	
	public Tile (final Image tex) {
		this.texture = tex;
	}

	public Image getTexture() {
		return texture;
	}

	
	
	
}
