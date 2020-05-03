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

public class UI {
	
	/**
	 * Variable containing data of current Player environment
	 */
	private Player player;
	/**
	 * Variable containing data of the Keys
	 */
	private Image keyImage;
	/**
	 * Variable containing data of the Coins
	 */
	private Image coinImage;
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
	
	/**
	 * Constructor for UI
	 * @param player, containing data of current Player
	 * @param graphics, containing data of current Graphics
	 * @throws SlickException
	 * @see SlickException
	 */
	public UI(final Player player, final Graphics graphics) throws SlickException {
		this.player = player;
		this.keyImage = new Image("./res/UI/KeyUI.png");
		this.coinImage = new Image("./res/UI/CoinUI.png");
		this.healthImage = new Image("./res/UI/healthUI.png");
		this.graphics = graphics;
		this.font = new Font("Default", Font.ROMAN_BASELINE, 30);
		this.tmp = new TrueTypeFont(font, false);
		
		this.color = new Color(72, 59, 58, 75);
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
		
		keyImage.draw(-5, (GameSettings.TILESIZE * 2) - 16, 40, 40);
		tmp.drawString(30, (GameSettings.TILESIZE * 2) - 16 + 2, Integer.toString(player.getInventory().getKey()), Color.white);
		
		
		
		graphics.setColor(Color.white);
	}
	
	
}
