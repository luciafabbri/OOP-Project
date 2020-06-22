package main.tiles;

import org.newdawn.slick.Animation;

public class AnimatedTile {

	/**
	 * Variable containing the animation of the Tile
	 */
	private Animation animaton;

	/**
	 * Constructor for AnimatedTile
	 * @param animation, the animation of the Tile
	 */
	public AnimatedTile(final Animation animation) {
		this.animaton = animation;
	}

	/**
	 * Method that returns the animation of the Tile
	 * @return Animation
	 */
	public Animation getAnimaton() {
		return animaton;
	}
}
