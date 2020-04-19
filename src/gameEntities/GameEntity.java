package gameEntities;

import java.util.Optional;

import org.newdawn.slick.Image;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;

public abstract class GameEntity {
	
	private Pair<Integer, Integer> position;
	private Image texture;
	private Optional<Pickupables> pickUps;
	private Optional<Entities> typeEnt;
	
	
	public GameEntity(Pair<Integer, Integer> position, Optional<Pickupables> pickUps, Optional<Entities> typeEnt) {
		this.pickUps = pickUps;
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


	public Optional<Pickupables> getPickUps() {
		return pickUps;
	}


	public Optional<Entities> getTypeEnt() {
		return typeEnt;
	}



}
