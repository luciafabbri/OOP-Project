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
	
	private Player player;
	private Image keyImage;
	private Image coinImage;
	private Image healthImage;
	private Graphics graphics;
	private Font font;
	private TrueTypeFont tmp;
	private Color color;
	
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
