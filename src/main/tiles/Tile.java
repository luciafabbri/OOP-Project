package main.tiles;

import org.newdawn.slick.Image;

public class Tile {
	
	/**
	 * Variable containing the texture of the tile
	 */
	private Image texture;
	
	/**
	 * Constructor for Tile
	 * @param tex, to associate with the texture
	 */
	public Tile (final Image tex) {
		this.texture = tex;
	}

	/**
	 * Method that returns the texture of the Tile
	 * @return Image, the texture of the Tile
	 */
	public Image getTexture() {
		return texture;
	}

	
	
	
}
