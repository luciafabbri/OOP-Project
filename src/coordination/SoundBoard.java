package coordination;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import worldModel.utilities.enums.Entities;

/**
 * Enum listing the texture for each GameEntity object
 *
 */
public enum SoundBoard {
	
	mainCharacterHurt("./res/audio/mainChar/hurtSound.wav"), mainCharacterShoot("./res/audio/bow/bow_fired.wav"),
	enemyDamageHurt("./res/audio/enemy/takeDamage.wav"),
	
	keyPickUp("./res/audio/pickups/keyPickup.wav"), coinPickUp("./res/audio/pickups/coinPickup.wav"), modPickUp("./res/audio/pickups/modifierPickup.wav");
	
	String image;
	
	SoundBoard(String image) {
		this.image = image;
	}
	
	public Sound getSound() throws SlickException {
		return new Sound(image);
	}

}
