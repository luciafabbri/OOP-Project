package gameEntities;

import design.utilities.Pair;

public abstract class GameEntity {
	
private Pair<Integer, Integer> position;
	
	
	public GameEntity(Pair<Integer, Integer> position) {
		this.position = position;
	}


	public Pair<Integer, Integer> getPosition() {
		return position;
	}


	public void setPosition(Pair<Integer, Integer> position) {
		this.position = position;
	}
}
