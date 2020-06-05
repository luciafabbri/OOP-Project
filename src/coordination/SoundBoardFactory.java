package coordination;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import worldModel.utilities.enums.Entities;

public class SoundBoardFactory {
	
	public void storeSound() {
		
	}
	
	public static void getEntitySound(final SoundBoard sound) {
		Sound tmpEnt = null;
		switch (sound) {		
		case mainCharacterHurt:
			try {
				tmpEnt = SoundBoard.mainCharacterHurt.getSound();
			} catch (SlickException e) {
				Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
			}
			break;
		case mainCharacterShoot:
			try {
				tmpEnt = SoundBoard.mainCharacterShoot.getSound();
			} catch (SlickException e) {
				Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
			}
			break;	
		case enemyDamageHurt:
			try {
				tmpEnt = SoundBoard.enemyDamageHurt.getSound();
			} catch (SlickException e) {
				Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
			}
			break;
		case keyPickUp:
			try {
				tmpEnt = SoundBoard.keyPickUp.getSound();
			} catch (SlickException e) {
				Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
			}
			break;
		case coinPickUp:
			try {
				tmpEnt = SoundBoard.coinPickUp.getSound();
			} catch (SlickException e) {
				Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
			}
			break;
		case modPickUp:
			try {
				tmpEnt = SoundBoard.modPickUp.getSound();
			} catch (SlickException e) {
				Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
			}
			break;
		case doorOpen:
			try {
				tmpEnt = SoundBoard.doorOpen.getSound();
			} catch (SlickException e) {
				Logger.getLogger(SoundBoard.class.getName()).log(Level.WARNING, null, e);
			}
			break;	
//		case mainCharacterFootsteps:
//			try {
//				tmpEnt = SoundBoard.mainCharacterFootsteps.getSound();
//			} catch (SlickException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break; 
		default:
			throw new IllegalArgumentException("Sound is missing");
		}

		playSound(tmpEnt);
	}

	private static void playSound(final Sound tmp) {
		if(!tmp.playing())
			tmp.play(1.0f, 0.4f);
	}
	
	private static void playLoop(final Sound tmp) {
		if(!tmp.playing())
			tmp.loop(1.0f, 0.4f);
	}
	
}
