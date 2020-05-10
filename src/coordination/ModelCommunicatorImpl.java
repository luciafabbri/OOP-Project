package coordination;

import java.util.Iterator;
import java.util.Set;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import dynamicBody.bullet.Bullet;
import dynamicBody.character.DoorCheck;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.player.Player;
import levels.Level;
import levels.Room;
import worldModel.utilities.GameSettings;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Door;

public class ModelCommunicatorImpl implements ModelCommunicator {

	/**
	 * Variable containing the current Level environment
	 */
	private Level level;
	/**
	 * Variable containing the current Player environment
	 */
	private Player player;
	/**
	 * Variable containing the current RoomImpl environment
	 */
	private Room currentRoom;
	/**
	 * Variable used to decide when to play the sound regarding the opening of the doors
	 */
	private boolean playSound;
	
	/**
	 * Variable containing the data to play the "opening doors" sound
	 */
	private Sound doorOpen;

	/**
	 * Constructor for LogicImpl
	 * @param level, to let LogicImpl keep track of the current state of the level layout
	 * @param player, to let LogicImpl keep track of the current state of the Player
	 * @throws SlickException
	 * @see SlickException
	 */
	public ModelCommunicatorImpl(final Level level, final Player player) throws SlickException {
		this.level = level;
		this.player = player;
		this.currentRoom = level.getLevel().get(level.getRoomID());
		this.doorOpen = new Sound("./res/audio/doors/door_open.wav");
		this.playSound = true;
	}

	@Override
	public void switchRooms(final Input input) {
		DoorCheck check = new DoorCheck();

		if ((check.transEast(player.getPosition()) || input.isKeyPressed(Input.KEY_RIGHT)) && checkEmpty(Door.EAST)) {
			level.setRoomID(getRoomID(Door.EAST));
			player.transitionPos(
					new Pair<>(GameSettings.TILESIZE, GameSettings.TILESIZE * 5 - GameSettings.TILESIZE / 2));
		} else if ((check.transWest(player.getPosition()) || input.isKeyPressed(Input.KEY_LEFT))
				&& checkEmpty(Door.WEST)) {
			level.setRoomID(getRoomID(Door.WEST));
			player.transitionPos(new Pair<>(GameSettings.LIMITRIGHT - GameSettings.TILESIZE,
					GameSettings.TILESIZE * 5 - GameSettings.TILESIZE / 2));
		} else if ((check.transNorth(player.getPosition()) || input.isKeyPressed(Input.KEY_UP))
				&& checkEmpty(Door.NORTH)) {
			level.setRoomID(getRoomID(Door.NORTH));
			player.transitionPos(new Pair<>(GameSettings.TILESIZE * 9, GameSettings.LIMITDOWN - GameSettings.TILESIZE));
		} else if ((check.transSouth(player.getPosition()) || input.isKeyPressed(Input.KEY_DOWN))
				&& checkEmpty(Door.SOUTH)) {
			level.setRoomID(getRoomID(Door.SOUTH));
			player.transitionPos(new Pair<>(GameSettings.TILESIZE * 9, GameSettings.TILESIZE));
		}
		player.setCurrentRoom(level.getLevel().get(level.getRoomID()).getRoom());

		currentRoom = level.getLevel().get(level.getRoomID());
		if(!currentRoom.isGotRoomKey())
			playSound = true;
	}

	@Override
	public void setRoomCleared() {
		player.setClearRoom(currentRoom.isGotRoomKey());
		
		if(currentRoom.isGotRoomKey() && !doorOpen.playing() && playSound) {
			doorOpen.play(1.0f, 0.10f);
			playSound = false;
		}
	}

	@Override
	public void moveMain(final Input input) throws SlickException {
		player.setPosition(input, level);

	}

	@Override
	public void shootMain(final Input input) {
		player.getBullet().checkShooting(input);

		this.moveMainProj();
	}

	/**
	 * Method called by shootMain so that the movement of the Player bullets it's consequential to their creation
	 */
	private void moveMainProj() {
		Iterator<Bullet> it = player.getRoomBullets().iterator();
		

		while (it.hasNext()) {
			it.next().updatePos();
		}

		this.eliminateMainProj();
	}

	/**
	 * Method called by moveMainProj so that after moving each bullet, it also checks if the bullet needs to be destroyed
	 */
	private void eliminateMainProj() {
		Iterator<Bullet> it = player.getRoomBullets().iterator();

		while (it.hasNext()) {
			if (!it.next().isAlive())
				it.remove();
		}

	}

	@Override
	public void moveEnemies() {
		level.getLevel().get(level.getRoomID()).getRoom().getEnemySet().forEach(s -> s.updatePos());

		this.eliminateEnemies();
	}

	@Override
	public  void shootEnemies() {
		level.getLevel().get(level.getRoomID()).getRoom().getEnemySet().forEach(s -> s.attack());

		this.moveEnemyProj();
	}
	
	/**
	 * Method called by shootMain so that the movement of each of the Enemy bullets it's consequential to their creation
	 */
	private void moveEnemyProj() {
		Set<Enemy> enemy = level.getLevel().get(level.getRoomID()).getRoom().getEnemySet();
		
		enemy.forEach(e -> {
			Iterator<Bullet> enemyIt = e.getRoomBullets().iterator();
			while (enemyIt.hasNext()) {
				enemyIt.next().updatePos();

			}
		});

		this.eliminateEnemyProj();
	}

	/**
	 * Method called by moveEnemyProj so that after moving each bullet, it also checks if the bullet needs to be destroyed
	 */
	private void eliminateEnemyProj() {
		Set<Enemy> enemy = level.getLevel().get(level.getRoomID()).getRoom().getEnemySet();

		enemy.forEach(e -> {
			Iterator<Bullet> enemyIt = e.getRoomBullets().iterator();
			while (enemyIt.hasNext()) {
				if (!enemyIt.next().isAlive())
					enemyIt.remove();
			}
		});

	}

	/**
	 * Method called by moveEnemies, so each time a Enemy is moved it also checks if the Enemy is alive or not
	 */
	private void eliminateEnemies() {
		Iterator<Enemy> it = level.getLevel().get(level.getRoomID()).getRoom().getEnemySet().iterator();

		while (it.hasNext()) {
			if (!it.next().isAlive())
				it.remove();
		}
	}

	/**
	 * Method called by switchRooms, to check if a Door in a certain cardinal directions is present or not
	 * @param door, to filter the appropriate value in the map
	 * @return true if the RoomModel paired with the Door used as a filter is present, otherwise false
	 */
	private boolean checkEmpty(final Door door) {
		return level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream()
				.filter(s -> s.getKey().equals(door)).findFirst().get().getValue().isPresent();
	}

	/**
	 * Method called by switchRooms, to get the roomId that belongs to the right Door the player has stepped into
	 * @param door, to filter the appropriate RoomModel paired with the Door, to get the right roomID
	 * @return an int, which is the roomID filtered
	 */
	private int getRoomID(final Door door) {
		return level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream()
				.filter(s -> s.getKey().equals(door)).findFirst().get().getValue().get().getRoomID();
	}

}
