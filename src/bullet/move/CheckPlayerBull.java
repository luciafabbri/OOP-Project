package bullet.move;

import java.util.Set;

import bullet.BulletPlayerImpl;
import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import enemy.Enemy;
import utility.CheckPosImpl;
import utility.Entity;

public class CheckPlayerBull extends CheckPosImpl implements GameSettings {
	
	private BulletPlayerImpl bullet;
	
	public CheckPlayerBull(Entity entity, BulletPlayerImpl bulletPlayer) {
		super(entity);
		this.bullet = bulletPlayer;
	}


	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return ( checkCharacters(room, pos) || super.possiblePos(room, pos) );
	}
	
	// DA CONTROLLARE
	private boolean checkCharacters(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		Set<Enemy> enemySet = room.getEnemySet();
		for (Enemy enemy : enemySet) {
			checkX = pos.getX() + leftPix < enemy.getPosition().getX() + GameSettings.TILESIZE && pos.getX() + rightPix > enemy.getPosition().getX();
			checkY = pos.getY() < enemy.getPosition().getY() + (TILESIZE - rightPix) && pos.getY() + downPix > enemy.getPosition().getY();
			if (checkX && checkY) {
				//fintanto che il nemico resta all'interno della traiettoria gli do danno ? thread.sleep()
				System.out.println("nemico preso");
				enemy.takeDmg(this.bullet.getDmg());
				return true;
			}
		}
		return false;
	}

}