package coordination;

import java.awt.Font;
import java.math.BigDecimal;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.font.effects.OutlineEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import dynamicBody.character.player.Player;
import levels.LevelComp;
import worldModel.utilities.GameSettings;

public class UI {

	/**
	 * Variable containing data of current Player environment
	 */
	private Player player;
	/**
	 * Variable containing data of the Coins
	 */
	private Image coinImage;
	/**
	 * Variabile containing data regarding the Level
	 */
	private LevelComp level;
	/**
	 * Variable containing data of the HealthUpgrade modifier
	 */
	private Image healthImage;
	/**
	 * Variable containing data of current Graphics environment
	 */
	private Graphics graphics;
	/**
	 * Variable containing data of the Font used for the UI
	 */
	private Font font;
	/**
	 * Variable containing data of TrueTypeFont to build Font
	 */
	private TrueTypeFont tmp;
	/**
	 * Variable containing data to choose Color (in this case white)
	 */
	private Color color;

	private long timeNow;
	private long timeEnd;

	private boolean gotCoin;
	private boolean gotCoin2;
	private boolean gotCoin3;

	private int index;
	private Color tmp2;
	private Color pauseBackground;

	/**
	 * Constructor for UI
	 * 
	 * @param level
	 * @param player,   containing data of current Player
	 * @param graphics, containing data of current Graphics
	 * @throws SlickException
	 * @see SlickException
	 */
	public UI(final Player player, final Graphics graphics, final LevelComp level) throws SlickException {
		this.player = player;
		this.level = level;
		this.graphics = graphics;
		
		this.timeEnd = 0;
		this.index = 0;
		
		this.coinImage = new Image("./res/UI/CoinUI.png");
		this.healthImage = new Image("./res/UI/healthUI.png");
		
		this.font = new Font("Default", Font.ROMAN_BASELINE, 30);
		this.tmp = new TrueTypeFont(font, false);
		
		this.tmp2 = new Color(255, 255, 255, 0);
		this.color = new Color(72, 59, 58, 75);
		this.pauseBackground = new Color(0, 0, 0, 150);

		this.gotCoin = true;
		this.gotCoin2 = false;
		this.gotCoin3 = false;

	}

	/**
	 * Method used to draw each element of the UI
	 */
	public void drawUI() {
		graphics.setColor(color);
		
		graphics.fillRect(0, 0, GameSettings.TILESIZE, GameSettings.TILESIZE * 3);
		
		
		coinImage.draw(-5, GameSettings.TILESIZE, 40, 40);
		tmp.drawString(30, GameSettings.TILESIZE + 2, Integer.toString(player.getInventory().getCoin()), Color.white);
		
		this.healthUpdate();
		
		this.pauseMenu();
		
		graphics.setColor(Color.white);
		
		if(level.isGotLevelCoin()) {
			if(player.getInventory().getCoin() == GameSettings.TOTCOINS) {
				this.congratsTextFinal();
			} else {
				this.congratsTextEachCoin();
			}
		}
			
	}
	
	private void pauseMenu() {
		if(this.level.isPauseMenu()) {
			
			graphics.setColor(pauseBackground);
			
			graphics.fillRect(0, 0, GameSettings.WIDTH, GameSettings.HEIGHT);
			
			graphics.scale(2, 2);
			
			graphics.setColor(Color.white);
			
			graphics.drawString("Pause Menu", GameSettings.TILESIZE * 4, GameSettings.TILESIZE * 2);
			
			graphics.scale(1, 1);
			
		}
	}
	
	private void healthUpdate() {
		float healthPer = (((3f * (float) GameSettings.TILESIZE) / 4f * 6f) - 8f) / (float) player.getMaxHealth();
		
		float remainingHealth = ((float) player.getMaxHealth() - (float) player.getCurrentHealth()) * healthPer;
		
		graphics.setColor(Color.lightGray);
		graphics.fillRect(GameSettings.TILESIZE / 2, GameSettings.TILESIZE / 6, (3 * GameSettings.TILESIZE) / 4 * 6, (3 * GameSettings.TILESIZE) / 4);
		
		graphics.setColor(Color.black);
		graphics.fillRect(GameSettings.TILESIZE / 2 + 4, GameSettings.TILESIZE / 6 + 4, ((3 * GameSettings.TILESIZE) / 4 * 6) - 8, (3 * GameSettings.TILESIZE) / 4 - 8);
		
		graphics.setColor(Color.red);
		graphics.fillRect(GameSettings.TILESIZE / 2 + 4, GameSettings.TILESIZE / 6 + 4, (((3 * GameSettings.TILESIZE) / 4 * 6) - 8) - remainingHealth, (3 * GameSettings.TILESIZE) / 4 - 8);
	}

	private void congratsTextEachCoin() {
		timeNow = System.currentTimeMillis();

		if (this.gotCoin) {

			if (timeNow - timeEnd > 4) {
				tmp2 = new Color(255, 255, 255, index);

				index++;
				timeEnd = System.currentTimeMillis();

				if (tmp2.getAlpha() >= 255) {
					this.gotCoin = false;
					this.gotCoin2 = true;
				}

			}
		} else if (this.gotCoin2) {

			if (timeNow - timeEnd > 2000) {
				this.gotCoin2 = false;
				this.gotCoin3 = true;
				timeEnd = System.currentTimeMillis();
			}

		} else if (this.gotCoin3) {

			if (timeNow - timeEnd > 4) {
				tmp2 = new Color(255, 255, 255, index);

				index--;
				timeEnd = System.currentTimeMillis();

				if (tmp2.getAlpha() <= 0) {
					this.gotCoin3 = false;
				}

			}
		}
		tmp.drawString(GameSettings.TILESIZE * 10 + GameSettings.TILESIZE / 2, GameSettings.TILESIZE / 4, "Bravo! Monete rimanenti da collezionare: "
				+ Integer.toString(GameSettings.TOTCOINS - player.getInventory().getCoin()), tmp2);
	}
	
	private void congratsTextFinal() {
		timeNow = System.currentTimeMillis();

		if (this.gotCoin) {

			if (timeNow - timeEnd > 4) {
				tmp2 = new Color(255, 255, 255, index);

				index++;
				timeEnd = System.currentTimeMillis();

				if (tmp2.getAlpha() >= 255) {
					this.gotCoin = false;
					this.gotCoin2 = true;
				}

			}
		} else if (this.gotCoin2) {

			if (timeNow - timeEnd > 2000) {
				this.gotCoin2 = false;
				this.gotCoin3 = true;
				timeEnd = System.currentTimeMillis();
			}

		} else if (this.gotCoin3) {

			if (timeNow - timeEnd > 4) {
				tmp2 = new Color(255, 255, 255, index);

				index--;
				timeEnd = System.currentTimeMillis();

				if (tmp2.getAlpha() <= 0) {
					this.gotCoin3 = false;
				}

			}
		}
		tmp.drawString(GameSettings.TILESIZE * 10 + GameSettings.TILESIZE / 2, GameSettings.TILESIZE / 4, "Complimenti! Hai trovato tutte le monete!"
				+ Integer.toString(GameSettings.TOTCOINS - player.getInventory().getCoin()), tmp2);
	}
	
	
	
	
}
