package main.tiles;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

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

	public static InputStream returnURL(final String res) {
		try {
			return new URL("file:///" + res).openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
