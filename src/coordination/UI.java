package coordination;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.font.effects.OutlineEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import design.utilities.GameSettings;
import dynamicBody.character.player.Player;
import levels.Level;

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
	private Level level;
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
	private long timeEnd = 0;

	private boolean gotCoin;
	private boolean gotCoin2;
	private boolean gotCoin3;

	private int i = 0;
	private Color tmp2;

	/**
	 * Constructor for UI
	 * 
	 * @param level
	 * @param player,   containing data of current Player
	 * @param graphics, containing data of current Graphics
	 * @throws SlickException
	 * @see SlickException
	 */
	public UI(final Player player, final Graphics graphics, final Level level) throws SlickException {
		this.player = player;
		this.level = level;
		this.coinImage = new Image("./res/UI/CoinUI.png");
		this.healthImage = new Image("./res/UI/healthUI.png");
		this.graphics = graphics;
		this.font = new Font("Default", Font.ROMAN_BASELINE, 30);
		this.tmp = new TrueTypeFont(font, false);
		this.tmp2 = new Color(255, 255, 255, 0);
		this.color = new Color(72, 59, 58, 75);

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
		
		healthImage.draw(16, 8, 48, 48);
		
		coinImage.draw(-5, GameSettings.TILESIZE, 40, 40);
		tmp.drawString(30, GameSettings.TILESIZE + 2, Integer.toString(player.getInventory().getCoin()), Color.white);
		
		if(level.isGotLevelCoin()) {
			if(player.getInventory().getCoin() == GameSettings.TOTCOINS) {
				this.congratsTextFinal();
			} else {
				this.congratsTextEachCoin();
			}
		}
			
		graphics.setColor(Color.white);
	}

	private void congratsTextEachCoin() {
		timeNow = System.currentTimeMillis();

		if (this.gotCoin) {

			if (timeNow - timeEnd > 4) {
				tmp2 = new Color(255, 255, 255, i);

				i++;
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
				tmp2 = new Color(255, 255, 255, i);

				i--;
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
				tmp2 = new Color(255, 255, 255, i);

				i++;
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
				tmp2 = new Color(255, 255, 255, i);

				i--;
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
