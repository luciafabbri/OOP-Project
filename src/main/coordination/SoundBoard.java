package main.coordination;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import main.worldModel.utilities.GameSettings;	

/**
 * Enum listing the texture for each GameEntity object
 *
 */
public enum SoundBoard {
	
	mainCharacterHurt(GameSettings.RESPATH + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "mainChar" + GameSettings.SEP + "hurtSound.wav"), 
	mainCharacterShoot(GameSettings.RESPATH + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "bow" + GameSettings.SEP + "bow_fired.wav"),
	enemyDamageHurt(GameSettings.RESPATH + "res"  + GameSettings.SEP + "audio"  + GameSettings.SEP + "enemy"  + GameSettings.SEP + "takeDamage.wav"),
	mainCharacterFootsteps(GameSettings.RESPATH + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "footsteps" + GameSettings.SEP + "footsteps.wav"), 
	keyPickUp(GameSettings.RESPATH + "res"  + GameSettings.SEP + "audio" + GameSettings.SEP + "pickups"  + GameSettings.SEP + "keyPickup.wav"), 
	coinPickUp(GameSettings.RESPATH + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "pickups" + GameSettings.SEP + "coinPickup.wav"), 
	modPickUp(GameSettings.RESPATH + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "pickups" + GameSettings.SEP + "modifierPickup.wav"),
	doorOpen(GameSettings.RESPATH + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "doors"  + GameSettings.SEP + "door_open.wav"),
	ominousMusic(GameSettings.RESPATH + "res" + GameSettings.SEP + "audio" + GameSettings.SEP + "music"  + GameSettings.SEP + "Ominous_Music.wav");
	
	String sound;
	
	SoundBoard(String image) {
		this.sound = image;
	}
	
	/**
	 * Method used to get the chosen sound
	 * @return Sound
	 * @throws SlickException
	 * @throws MalformedURLException
	 * @see SlickException
	 * @see MalformedURLException
	 */
	public Sound getSound() throws SlickException {	
		try {
			if(!LoadNatives.isJar(SoundBoard.class.getResource("SoundBoard.class").toString())) {
				return new Sound(new URL("file:///" + sound));
			} else {
				return new Sound(sound);
			}
		} catch (MalformedURLException e) {
			Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
		} catch (SlickException e) {
			Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
		}
		return null;
	}

}
