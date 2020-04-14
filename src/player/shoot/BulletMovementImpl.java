package player.shoot;

import org.newdawn.slick.Input;
import bullet.BulletImpl;
import bullet.BulletPlayer;
import design.RoomDesign;
import design.utilities.Pair;
import utility.Debuff;
import utility.Direction;

public class BulletMovementImpl implements BulletMovement {
	
	private RoomDesign currentRoom;
	
	public BulletMovementImpl(RoomDesign room) {
		this.currentRoom = room;
	}
		
		@Override
		public void checkShooting(Input input, Pair<Integer,Integer> pos, int dmg, Direction dir) {
			
			if(input.isKeyDown(Input.KEY_SPACE)) {
				this.shoot(pos, dir, dmg);
			}
			
		}
		
		public void shoot(Pair<Integer,Integer> pos, int dmg, Direction dir){
			System.out.println("PREMUTO!");
		BulletImpl bullet = new BulletPlayer(pos, dmg, dir, currentRoom);  	
		}
}
