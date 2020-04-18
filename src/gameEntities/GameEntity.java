package gameEntities;

import org.newdawn.slick.Image;

import design.utilities.Entities;
import design.utilities.Pair;

public abstract class GameEntity {
	
	private Pair<Integer, Integer> position;
	private Image texture;
	private Entities typeEnt;
	
	public GameEntity(Pair<Integer, Integer> position, Entities typeEnt) {
		this.typeEnt = typeEnt;
		this.position = position;
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
}
