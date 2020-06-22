package main.coordination;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import main.worldModel.utilities.GameSettings;
import main.worldModel.utilities.enums.Entities;
		

/**
 * Enum listing the texture for each GameEntity object
 *
 */
public enum SoundBoard {
	
	mainCharacterHurt("." + GameSettings.SEP + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "mainChar" + GameSettings.SEP + "hurtSound.wav"), mainCharacterShoot("./res/audio/bow/bow_fired.wav"),
	enemyDamageHurt("./res/audio/enemy/takeDamage.wav"),
	mainCharacterFootsteps("./res/audio/footsteps/footsteps.wav"), 
	keyPickUp("./res/audio/pickups/keyPickup.wav"), coinPickUp("./res/audio/pickups/coinPickup.wav"), modPickUp("./res/audio/pickups/modifierPickup.wav"),
	doorOpen("./res/audio/doors/door_open.wav");
	
	String sound;
	
	SoundBoard(String image) {
		this.sound = image;
	}
	
	public Sound getSound() throws SlickException {
		return new Sound(sound);
	}

}
