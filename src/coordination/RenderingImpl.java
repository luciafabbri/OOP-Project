package coordination;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.enums.Door;
import design.utilities.enums.Entities;
import dynamicBody.bullet.Bullet;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.TypeEnemy;
import dynamicBody.character.player.Player;
import dynamicBody.move.Direction;
import gameEntities.Stairs;
import levels.Level;
import levels.Room;
import tiles.AnimatedTile;

public class RenderingImpl implements Rendering {

	/**
	 * Variable containing data of current Level
	 */
	private Level level;
	/**
	 * Variable containing data of current Player
	 */
	private Player player;
	/**
	 * Variable containing data of current RoomImpl
	 */
	private Room currentRoom;

	/**
	 * Constructor for RenderingImpl
	 * @param level, to keep track of current Level
	 * @param player, to keep track of current Player
	 */
	public RenderingImpl(final Level level, final Player player) {
		this.level = level;
		this.player = player;
		this.currentRoom = level.getLevel().get(level.getRoomID());
	}

	public void drawMain(final Input input) {
		this.currentRoom = level.getLevel().get(level.getRoomID());

		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_A)
				|| input.isKeyDown(Input.KEY_D)) {
			player.getAnimation().draw(player.getPosition().getX(), player.getPosition().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
		} else {
			player.getAnimation().setCurrentFrame(0);
			player.getAnimation().getCurrentFrame().draw(player.getPosition().getX(), player.getPosition().getY(),
					GameSettings.TILESIZE, GameSettings.TILESIZE);
		}

		this.drawMainProj();
	}

	/**
	 * Method called by drawMain, so it renders the bullets while also rendering the Player
	 */
	private void drawMainProj() {
		Set<Bullet> bullets = player.getRoomBullets();

		if (!bullets.isEmpty()) {
			bullets.forEach(s -> {
				if (s.getRoom().getRoomID() == player.getRoom().getRoomID()) {
					this.rotateMainProj(s);
				}
			});
		}

	}

	/**
	 * Method called by drawMainProj for each projectile, to draw it appropriately based on direction
	 * @param bullet, to check the stored direction of each bullet
	 */
	private void rotateMainProj(final Bullet bullet) {
		if (bullet.getDirection().equals(Direction.NORTH)) {
			bullet.getTexture().draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
		} else if (bullet.getDirection().equals(Direction.EAST)) {
			bullet.getTexture().rotate(90);
			bullet.getTexture().draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
			bullet.getTexture().rotate(270);
		} else if (bullet.getDirection().equals(Direction.SOUTH)) {
			bullet.getTexture().rotate(180);
			bullet.getTexture().draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
			bullet.getTexture().rotate(180);
		} else if (bullet.getDirection().equals(Direction.WEST)) {
			bullet.getTexture().rotate(270);
			bullet.getTexture().draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
			bullet.getTexture().rotate(90);
		}
	}

	public void drawEnemies() {
		currentRoom.getRoom().getEnemySet().forEach(s -> {
			
			if(s.getTypeEnemy().equals(TypeEnemy.MONSTER3)) {
				s.getAnimation().setCurrentFrame(0);
				s.getAnimation().getCurrentFrame().draw(s.getPosition().getX(), s.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
			s.getAnimation().draw(s.getPosition().getX(), s.getPosition().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
		});

		this.drawEnemyProj();
	}

	/**
	 * Method called by drawEnemies, to draw the appropriate bullet according to each enemy
	 */
	private void drawEnemyProj() {
		Set<Enemy> enemys = currentRoom.getRoom().getEnemySet();

		enemys.forEach(e -> {
			Set<Bullet> bulletMon = e.getRoomBullets();

			if (!bulletMon.isEmpty()) {
				bulletMon.forEach(s -> {
					s.getTexture().draw(s.getPos().getX(), s.getPos().getY(), GameSettings.TILESIZE,
							GameSettings.TILESIZE);
				});
			}
		});
	}

	public void drawObstacles() {
		currentRoom.getRoom().getObstacleSet().forEach(s -> {
			s.getTexture().draw(s.getPosition().getX(), s.getPosition().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
		});
	}

	@Override
	public void drawItems() {
		level.getLevel().get(level.getRoomID()).getRoom().getPickupablesSet().stream()
				.filter(s -> s.getTypeEnt().equals(Entities.COIN) || s.getTypeEnt().equals(Entities.KEY))
				.forEach(s -> s.getTexture().draw(s.getPosition().getX(), s.getPosition().getY(), GameSettings.TILESIZE,
						GameSettings.TILESIZE));
	}

	public void drawMod() {
		level.getLevel().get(level.getRoomID()).getRoom().getPickupablesSet().stream().filter(
				s -> s.getTypeEnt().equals(Entities.ATTACKUPGRADE1) || s.getTypeEnt().equals(Entities.HEALTHUPGRADE1))
				.forEach(s -> s.getTexture().draw(s.getPosition().getX(), s.getPosition().getY(), GameSettings.TILESIZE,
						GameSettings.TILESIZE));

	}

	public void drawFloor() {
		for (int x = 0; x < GameSettings.WIDTH; x += GameSettings.TILESIZE) {
			for (int y = 0; y < GameSettings.HEIGHT; y += GameSettings.TILESIZE) {
				level.getLevel().get(level.getRoomID()).getFloor().getTexture().draw(x, y, GameSettings.TILESIZE,
						GameSettings.TILESIZE);
			}
		}
		if (level.getLevel().get(level.getRoomID()).getRoom().areStairsPresent()) {
			this.drawStairs();
		}
	}

	/**
	 * Method called by drawFloor, to draw the Stairs in the room if present
	 */
	private void drawStairs() {
		Stairs tmp = level.getLevel().get(level.getRoomID()).getRoom().getStairs();
		tmp.getTexture().draw(tmp.getPosition().getX(), tmp.getPosition().getY(), GameSettings.TILESIZE,
				GameSettings.TILESIZE);
	}

	public void drawWalls() {
		for (int x = 0; x < GameSettings.WIDTH; x += GameSettings.TILESIZE) {
			for (int y = 0; y < GameSettings.HEIGHT; y += GameSettings.TILESIZE) {
				if (x == 0 && y > 0 && y < GameSettings.HEIGHT - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallVert().getTexture().draw(x, y, GameSettings.TILESIZE,
							GameSettings.TILESIZE);
				} else if (x == GameSettings.WIDTH - GameSettings.TILESIZE && y > 0
						&& y < GameSettings.HEIGHT - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallVert().getTexture().getFlippedCopy(true, false)
							.draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if (y == 0 && x > 0 && x < GameSettings.WIDTH - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallHor().getTexture().getFlippedCopy(false, true)
							.draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if (y == GameSettings.HEIGHT - GameSettings.TILESIZE && x > 0
						&& x < GameSettings.WIDTH - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallHor().getTexture().draw(x, y, GameSettings.TILESIZE,
							GameSettings.TILESIZE);
				}
			}
		}

		// Here a draw the corners, since they're always in the same position (the
		// corners), I don't need to draw the dinamically
		currentRoom.getCorners().getTexture().draw(0, 0, GameSettings.TILESIZE, GameSettings.TILESIZE);
		currentRoom.getCorners().getTexture().getFlippedCopy(false, true).draw(0,
				GameSettings.HEIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
		currentRoom.getCorners().getTexture().getFlippedCopy(true, false)
				.draw(GameSettings.WIDTH - GameSettings.TILESIZE, 0, GameSettings.TILESIZE, GameSettings.TILESIZE);
		currentRoom.getCorners().getTexture().getFlippedCopy(true, true).draw(
				GameSettings.WIDTH - GameSettings.TILESIZE, GameSettings.HEIGHT - GameSettings.TILESIZE,
				GameSettings.TILESIZE, GameSettings.TILESIZE);
	}

	public void drawDoors() {
		Map<Door, Optional<RoomDesign>> doors = level.getLevel().get(level.getRoomID()).getDoorAccess();

		for (Entry<Door, Optional<RoomDesign>> entry : doors.entrySet()) {
			if (entry.getValue().isPresent()) {
				if (entry.getKey().equals(Door.NORTH)) {
					this.renderDoor(currentRoom.getDoorNorth(), Door.NORTH);
				} else if (entry.getKey().equals(Door.SOUTH)) {
					this.renderDoor(currentRoom.getDoorSouth(), Door.SOUTH);
				} else if (entry.getKey().equals(Door.WEST)) {
					this.renderDoor(currentRoom.getDoorWest(), Door.WEST);
				} else {
					this.renderDoor(currentRoom.getDoorEast(), Door.EAST);
				}

			}
		}
	}

	/**
	 * Method called by drawDoors, to draw the right animation based on the Door cardinality, and if the room has been cleared
	 * @param animation, the right animation based on the Door cardinality
	 * @param door, the according Door Cardinality
	 */
	private void renderDoor(final AnimatedTile animation, Door door) {
		if (currentRoom.getRoom().getEnemySet().isEmpty()) {
			if (door.equals(Door.NORTH)) {
				animation.getAnimaton().stopAt(7);
				animation.getAnimaton().draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, 0, GameSettings.TILESIZE,
						GameSettings.TILESIZE);
			} else if (door.equals(Door.EAST)) {
				animation.getAnimaton().stopAt(7);
				animation.getAnimaton().draw(GameSettings.LIMITRIGHT, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE,
						GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else if (door.equals(Door.SOUTH)) {
				animation.getAnimaton().stopAt(7);
				animation.getAnimaton().draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE,
						GameSettings.HEIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else if (door.equals(Door.WEST)) {
				animation.getAnimaton().stopAt(7);
				animation.getAnimaton().draw(0, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, GameSettings.TILESIZE,
						GameSettings.TILESIZE);
			}
		} else {
			if (door.equals(Door.NORTH)) {
				animation.getAnimaton().setCurrentFrame(0);
				animation.getAnimaton().getCurrentFrame().draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, 0,
						GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else if (door.equals(Door.EAST)) {
				animation.getAnimaton().setCurrentFrame(0);
				animation.getAnimaton().getCurrentFrame().draw(GameSettings.LIMITRIGHT,
						GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else if (door.equals(Door.SOUTH)) {
				animation.getAnimaton().setCurrentFrame(0);
				animation.getAnimaton().getCurrentFrame().draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE,
						GameSettings.HEIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else if (door.equals(Door.WEST)) {
				animation.getAnimaton().setCurrentFrame(0);
				animation.getAnimaton().getCurrentFrame().draw(0, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE,
						GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		}
	}

	public void drawDoorTop() throws SlickException {
		Map<Door, Optional<RoomDesign>> doors = level.getLevel().get(level.getRoomID()).getDoorAccess();

		for (Entry<Door, Optional<RoomDesign>> entry : doors.entrySet()) {
			if (entry.getValue().isPresent()) {
				if (entry.getKey().equals(Door.NORTH)) {
					currentRoom.getTopDoorHor().getTexture().getFlippedCopy(true, false)
							.draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, 0, 64, 14);
				} else if (entry.getKey().equals(Door.SOUTH)) {
					currentRoom.getTopDoorHor().getTexture().getFlippedCopy(true, true)
							.draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, GameSettings.HEIGHT - 14, 64, 14);
				} else if (entry.getKey().equals(Door.EAST)) {
					currentRoom.getTopDoorVert().getTexture().getFlippedCopy(true, false).draw(GameSettings.WIDTH - 14,
							GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, 14, 64);
				} else {
					currentRoom.getTopDoorVert().getTexture().getFlippedCopy(false, false).draw(0,
							GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, 14, 64);
				}
			}
		}
	}

}
