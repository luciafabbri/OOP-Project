package player.shoot;

import org.newdawn.slick.Input;
import bullet.BulletImpl;
import bullet.BulletPlayer;
import design.RoomDesign;
import design.utilities.Pair;
import player.PlayerImpl;
import utility.Direction;

public class BulletMovementImpl implements BulletMovement {
	
	private PlayerImpl player;
	
	public BulletMovementImpl(PlayerImpl player) {
		this.player = player;
	}
		
		@Override
		public void checkShooting(Input input) {
			
			if(input.isKeyDown(Input.KEY_SPACE)) {
				this.shoot(player.getPosition(), player.getDmg(), player.getDirection());
			}
			
		}
		
		
		//AGGIUNGERE LA SPEED
		public void shoot(Pair<Integer,Integer> pos, int dmg, Direction dir){
			BulletImpl bullet = new BulletPlayer(pos, dmg, dir, player.getRoom());  	
			if (bullet.isAlive()) {
				//aggiugerlo ad una lista di proiettili?? 
			}
			System.out.println("SPARATO!");
		}
}
