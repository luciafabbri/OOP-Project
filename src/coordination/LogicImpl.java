package coordination;

import java.util.Iterator;
import java.util.Set;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import design.utilities.GameSettings;
import design.utilities.Pair;
import design.utilities.enums.Door;
import entity.bullet.Bullet;
import entity.character.enemy.Enemy;
import entity.character.player.DoorCheck;
import entity.character.player.Player;
import levels.Level;

public class LogicImpl {
	
	private Level level;
	private Player player;
	private boolean playerBull;
	
	public LogicImpl(final Level level, final Player player) {
		this.level = level;
		this.player = player;
		this.playerBull = true;
	}
	
	public void switchRooms(final Input input) {
		DoorCheck check = new DoorCheck();
		
		if( (check.transEast(player.getPosition()) || input.isKeyPressed(Input.KEY_RIGHT)) && checkEmpty(Door.EAST)) {
			level.setRoomID(getRoomID(Door.EAST));
			player.setPosition(new Pair<>(GameSettings.TILESIZE, GameSettings.TILESIZE * 5 - GameSettings.TILESIZE / 2));
		} else if((check.transWest(player.getPosition()) || input.isKeyPressed(Input.KEY_LEFT)) && checkEmpty(Door.WEST)) {
			level.setRoomID(getRoomID(Door.WEST));
			player.setPosition(new Pair<>(GameSettings.LIMITRIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE * 5 - GameSettings.TILESIZE / 2));
		} else if((check.transNorth(player.getPosition()) || input.isKeyPressed(Input.KEY_UP)) && checkEmpty(Door.NORTH)) {
			level.setRoomID(getRoomID(Door.NORTH));
			player.setPosition(new Pair<>(GameSettings.TILESIZE * 9, GameSettings.LIMITDOWN - GameSettings.TILESIZE));
		} else if((check.transSouth(player.getPosition()) || input.isKeyPressed(Input.KEY_DOWN)) && checkEmpty(Door.SOUTH)) {
			level.setRoomID(getRoomID(Door.SOUTH));
			player.setPosition(new Pair<>(GameSettings.TILESIZE * 9, GameSettings.TILESIZE));
		}
		player.setCurrentRoom(level.getLevel().get(level.getRoomID()).getRoom());
	}
	
	public void moveMain(final Input input) throws SlickException {
		player.setPosition(input, level);
	}
	
	public void moveEnemies() {
		level.getLevel().get(level.getRoomID()).getRoom().getEnemySet().forEach(s -> s.updatePos());
		level.getLevel().get(level.getRoomID()).getRoom().getEnemySet().forEach(s -> s.attack());
	}
	
	public void shootMain(final Input input) {
		player.getBullet().checkShooting(input);
	}
	
	public void moveMainProj(final Input input) {
		Iterator<Bullet> it = player.getRoomBullets().iterator();
		Set<Enemy> enemy = level.getLevel().get(level.getRoomID()).getRoom().getEnemySet();
		
		while(it.hasNext()) {
			it.next().updatePos(); 
		}
		
		enemy.forEach(e-> {
			Iterator<Bullet> enemyIt = e.getBullets().iterator();
			while(enemyIt.hasNext() ) {
				enemyIt.next().updatePos();
				
			}
		});
		
	}
	
	public void eliminateMainProj() {
		Iterator<Bullet> it = player.getRoomBullets().iterator();
		Set<Enemy> enemy = level.getLevel().get(level.getRoomID()).getRoom().getEnemySet();
		
		while(it.hasNext()) {
			if(!it.next().isAlive())
				it.remove();
		}
		
		enemy.forEach(e-> {
			Iterator<Bullet> enemyIt = e.getBullets().iterator();
			while(enemyIt.hasNext()) {
				if(!enemyIt.next().isAlive())
					enemyIt.remove();
			}
		});
		
		
	}
	
	private boolean checkEmpty(final Door door) {
		return level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(door)).findFirst().get().getValue().isPresent();
	}
	
	private int getRoomID(final Door door) {
		return level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(door)).findFirst().get().getValue().get().getRoomID();
	}
	
}

