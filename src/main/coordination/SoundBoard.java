package main.coordination;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import main.worldModel.utilities.GameSettings;

		

/**
 * Enum listing the texture for each GameEntity object
 *
 */
public enum SoundBoard {
	
	mainCharacterHurt("." + GameSettings.SEP + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "mainChar" + GameSettings.SEP + "hurtSound.wav"), 
	mainCharacterShoot("." + GameSettings.SEP + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "bow" + GameSettings.SEP + "bow_fired.wav"),
	enemyDamageHurt("." + GameSettings.SEP + "res"  + GameSettings.SEP + "audio"  + GameSettings.SEP + "enemy"  + GameSettings.SEP + "takeDamage.wav"),
	mainCharacterFootsteps("." + GameSettings.SEP + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "footsteps" + GameSettings.SEP + "footsteps.wav"), 
	keyPickUp("." + GameSettings.SEP + "res"  + GameSettings.SEP + "audio" + GameSettings.SEP + "pickups"  + GameSettings.SEP + "keyPickup.wav"), 
	coinPickUp("." + GameSettings.SEP + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "pickups" + GameSettings.SEP + "coinPickup.wav"), 
	modPickUp("." + GameSettings.SEP + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "pickups" + GameSettings.SEP + "modifierPickup.wav"),
	doorOpen("." + GameSettings.SEP + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "doors"  + GameSettings.SEP + "door_open.wav");
	
	String sound;
	
	SoundBoard(String image) {
		this.sound = image;
	}
	
	/**
	 * Method used to get the chosen sound
	 * @return Sound
	 * @throws SlickException
	 * @see SlickException
	 */
	public Sound getSound() throws SlickException {
		return new Sound(sound);
	}

}
