package main.tiles;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.coordination.CharacterImage;
import main.coordination.init.LoadNatives;

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
	 * @throws SlickException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @see SlickException
	 * @see MalformedURLException
	 * @see IOException
	 */
	public Image getTexture() {
		try {
			if(!LoadNatives.isJar(CharacterImage.class.getResource("CharacterImage.class").toString())) {
				return new Image(new URL("file:///" + texture.getResourceReference()).openStream(), texture.getResourceReference(), false);
			} else {
				return texture;
			}
		} catch (MalformedURLException e) {
			Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, e);
		} catch (SlickException e) {
			Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, e);
		}
		return texture;
	}
}
