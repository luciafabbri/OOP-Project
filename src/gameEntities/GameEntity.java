package gameEntities;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public abstract class GameEntity {
	
	private Pair<Integer, Integer> position;
	private Image texture;
	private Entities typeEnt;
	
	public GameEntity(final Pair<Integer, Integer> position, final Image texture, final Entities typeEnt) {
		this.position = position;
		this.texture = texture;
		this.typeEnt = typeEnt;
	}

	
	public Pair<Integer, Integer> getPosition() {
		return position;
	}


	public void setPosition(Pair<Integer, Integer> position) {
		this.position = position;
	}


	public Image getTexture() {
		return texture;
	}


	public void setTexture(Image texture) {
		this.texture = texture;
	}


	public Entities getTypeEnt() {
		return typeEnt;
	}


	public void setTypeEnt(Entities typeEnt) {
		this.typeEnt = typeEnt;
	}

}
