package main.coordination;

import java.net.MalformedURLException;
import java.net.URL;
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
	 * @see SlickException
	 */
	public Sound getSound() throws SlickException {	
		try {
			return new Sound(new URL("file:///" + sound));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
