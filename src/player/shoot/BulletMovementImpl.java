package player.shoot;

import org.newdawn.slick.Input;
import bullet.BulletImpl;
import bullet.BulletPlayer;
import design.RoomDesign;
import design.utilities.Pair;
import utility.Direction;

public class BulletMovementImpl implements BulletMovement {
	
	private RoomDesign currentRoom;
	
	public BulletMovementImpl(RoomDesign room) {
		this.currentRoom = room;
	}
		
		@Override
		public void checkShooting(Input input, Pair<Integer,Integer> pos, int dmg, Direction dir) {
			
			if(input.isKeyDown(Input.KEY_SPACE)) {
				this.shoot(pos, dmg, dir);
			}
			
		}
		
		public void shoot(Pair<Integer,Integer> pos, int dmg, Direction dir){
			BulletImpl bullet = new BulletPlayer(pos, dmg, dir, currentRoom);  	
			if (bullet.isAlive()) {
				//aggiugerlo ad una lista di proiettili?? 
			}
			System.out.println("SPARATO!");
		}
}
