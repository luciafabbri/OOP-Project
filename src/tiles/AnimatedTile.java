package tiles;

import org.newdawn.slick.Animation;

public class AnimatedTile {

	private Animation animaton;

	public AnimatedTile(final Animation animation) {
		this.animaton = animation;
	}

	public Animation getAnimaton() {
		return animaton;
	}
}
