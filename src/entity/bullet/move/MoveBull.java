package entity.bullet.move;

import design.utilities.Pair;
import entity.move.CheckPos;
import entity.move.Direction;
import entity.move.Speed;

public interface MoveBull {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir, CheckPos check, int speed);
	
	public boolean isAlive();

}
