package coordination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Optional;
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import dynamicBody.ImageFactory;
import dynamicBody.bullet.Bullet;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.character.player.Player;
import dynamicBody.move.Direction;
import gameEntities.EntityImageFactory;
import gameEntities.Stairs;
import levels.LevelComp;
import levels.Room;
import tiles.AnimatedTile;
import worldModel.RoomModel;
import worldModel.utilities.GameSettings;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Door;
import worldModel.utilities.enums.Entities;

public class GameViewImpl implements GameView {

	/**
	 * Variable containing data of current Level
	 */
	private LevelComp level;
	/**
	 * Variable containing data of current Player
	 */
	private Player player;
	/**
	 * Variable containing data of current RoomImpl
	 */
	private Room currentRoom;

	private Map<Bullet, Image> bulletsPlayer = new HashMap<>();
	private Map<TypeEnemy, Set<Pair<Direction, Animation>>> enemyAnimation;
	private Set<Pair<Direction, Animation>> playerAnimation;

	/**
	 * Constructor for RenderingImpl
	 * 
	 * @param level,  to keep track of current Level
	 * @param player, to keep track of current Player
	 * @throws SlickException
	 */
	public GameViewImpl(final LevelComp level, final Player player) throws SlickException {
		this.level = level;
		this.player = player;
		this.currentRoom = level.getLevel().get(level.getRoomID());
		this.playerAnimation = new HashSet<>();

		this.loadMainAnimations();
		this.enemyAnimation = level.checkAnimations();
	}

	public void render(Input input) throws SlickException {

		this.drawFloor();
		this.drawWalls();

		this.drawItems();
		this.drawMod();
		this.drawObstacles();

		this.drawDoors();

		this.drawEnemies();

		try {
			this.drawMain(input);
			this.drawDoorTop();
		} catch (SlickException e) {
			Logger.getLogger(GameView.class.getName()).log(Level.WARNING, null, e);
			Logger.getLogger(GameView.class.getName()).log(Level.WARNING, null, e);
		}

	}

	private void loadMainAnimations() throws SlickException {

		playerAnimation.add(
				new Pair<>(Direction.NORTH, ImageFactory.getAnimation(ImageFactory.getPlayerImage(Direction.NORTH))));
		playerAnimation.add(
				new Pair<>(Direction.EAST, ImageFactory.getAnimation(ImageFactory.getPlayerImage(Direction.EAST))));
		playerAnimation.add(
				new Pair<>(Direction.WEST, ImageFactory.getAnimation(ImageFactory.getPlayerImage(Direction.WEST))));
		playerAnimation.add(
				new Pair<>(Direction.SOUTH, ImageFactory.getAnimation(ImageFactory.getPlayerImage(Direction.SOUTH))));

	}

	private void drawMain(final Input input) throws SlickException {
		this.currentRoom = level.getLevel().get(level.getRoomID());

		Animation tmpPlayer = playerAnimation.stream().filter(s -> s.getX().equals(player.getDirection())).findFirst()
				.get().getY();

		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_A)
				|| input.isKeyDown(Input.KEY_D)) {
			tmpPlayer.draw(player.getPosition().getX(), player.getPosition().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
		} else {
			tmpPlayer.setCurrentFrame(0);
			tmpPlayer.getCurrentFrame().draw(player.getPosition().getX(), player.getPosition().getY(),
					GameSettings.TILESIZE, GameSettings.TILESIZE);
		}

		this.drawMainProj();
	}

	/**
	 * Method called by drawMain, so it renders the bullets while also rendering the
	 * Player
	 */
	private void drawMainProj() {
		Set<Bullet> bullets = player.getRoomBullets();

		bullets.forEach(b -> {
			if (!bulletsPlayer.containsKey(b)) {
				try {
					bulletsPlayer.put(b, ImageFactory.getPlayerBull());
				} catch (SlickException e) {
					Logger.getLogger(Bullet.class.getName()).log(Level.WARNING, null, e);
				}
			}
		});

		if (!bullets.isEmpty()) {
			bullets.forEach(s -> {
				if (s.getRoom().getRoomID() == player.getRoom().getRoomID()) {
					rotateMainProj(s);
				}
			});
		}

	}

	/**
	 * Method called by drawMainProj for each projectile, to draw it appropriately
	 * based on direction
	 * 
	 * @param bullet, to check the stored direction of each bullet
	 * @throws SlickException
	 */
	private void rotateMainProj(final Bullet bullet) {
		if (bullet.getDirection().equals(Direction.NORTH)) {
			bulletsPlayer.get(bullet).draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
		} else if (bullet.getDirection().equals(Direction.EAST)) {
			bulletsPlayer.get(bullet).rotate(90);
			bulletsPlayer.get(bullet).draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
			bulletsPlayer.get(bullet).rotate(270);
		} else if (bullet.getDirection().equals(Direction.SOUTH)) {
			bulletsPlayer.get(bullet).rotate(180);
			bulletsPlayer.get(bullet).draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
			bulletsPlayer.get(bullet).rotate(180);
		} else if (bullet.getDirection().equals(Direction.WEST)) {
			bulletsPlayer.get(bullet).rotate(270);
			bulletsPlayer.get(bullet).draw(bullet.getPos().getX(), bullet.getPos().getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
			bulletsPlayer.get(bullet).rotate(90);
		}
	}

	private void drawEnemies() {

		currentRoom.getRoom().getEnemySet().forEach(s -> {			
			
			Animation tmp = enemyAnimation.get(s.getTypeEnemy()).stream().filter(p -> p.getX().equals(s.getDirection()))
					.findFirst().get().getY();
			
			if (s.getTypeEnemy().equals(TypeEnemy.MAGE)) {

				tmp.setCurrentFrame(0);
				tmp.getCurrentFrame().draw(s.getPosition().getX(), s.getPosition().getY(), GameSettings.TILESIZE,
						GameSettings.TILESIZE);
			} else {
				tmp.draw(s.getPosition().getX(), s.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		});

		this.drawEnemyProj();
	}

	/**
	 * Method called by drawEnemies, to draw the appropriate bullet according to
	 * each enemy
	 */
	private void drawEnemyProj() {
		Set<Enemy> enemys = currentRoom.getRoom().getEnemySet();

		enemys.forEach(e -> {
			Set<Bullet> bulletMon = e.getRoomBullets();

			if (!bulletMon.isEmpty()) {
				bulletMon.forEach(s -> {
					try {
						ImageFactory.getEnemyBull().draw(s.getPos().getX(), s.getPos().getY(), GameSettings.TILESIZE,
								GameSettings.TILESIZE);
					} catch (SlickException e1) {
						Logger.getLogger(ImageFactory.class.getName()).log(Level.WARNING, null, e);
					}
				});
			}
		});
	}

	private void drawObstacles() throws SlickException {
		currentRoom.getRoom().getObstacleSet().forEach(s -> {
			try {
				EntityImageFactory.getEntityTexture(s.getTypeEnt()).draw(s.getPosition().getX(), s.getPosition().getY(),
						GameSettings.TILESIZE, GameSettings.TILESIZE);
			} catch (SlickException e) {
				Logger.getLogger(EntityImageFactory.class.getName()).log(Level.WARNING, null, e);
			}
		});
	}

	private void drawItems() throws SlickException {
		Pair<Integer, Integer> tmp = currentRoom.getRoom().getKey().getPosition();
		if (!currentRoom.isGotRoomKey())
			EntityImageFactory.getEntityTexture(Entities.KEY).draw(tmp.getX(), tmp.getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);

		if (currentRoom.getRoom().getCoin().isPresent() && !level.isGotLevelCoin()) {
			tmp = currentRoom.getRoom().getCoin().get().getPosition();
			EntityImageFactory.getEntityTexture(Entities.COIN).draw(tmp.getX(), tmp.getY(), GameSettings.TILESIZE,
					GameSettings.TILESIZE);
		}
	}

	private void drawMod() throws SlickException {
		currentRoom.getRoom().getPickupablesSet().stream().filter(s -> s.getTypeEnt().equals(Entities.ATTACKUPGRADE1)
				|| s.getTypeEnt().equals(Entities.HEALTHUPGRADE1) || s.getTypeEnt().equals(Entities.MOVEMENTSPEED1)
				|| s.getTypeEnt().equals(Entities.ATTACKSPEED1) || s.getTypeEnt().equals(Entities.RECOVERHEALTH))
				.forEach(s -> {
					try {
						EntityImageFactory.getEntityTexture(s.getTypeEnt()).draw(s.getPosition().getX(),
								s.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
					} catch (SlickException e) {
						Logger.getLogger(EntityImageFactory.class.getName()).log(Level.WARNING, null, e);
					}
				});

	}

	private void drawFloor() throws SlickException {
		for (int x = 0; x < GameSettings.WIDTH; x += GameSettings.TILESIZE) {
			for (int y = 0; y < GameSettings.HEIGHT; y += GameSettings.TILESIZE) {
				currentRoom.getFloor().getTexture().draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		}
		if (currentRoom.getRoom().areStairsPresent()) {
			this.drawStairs();
		}
	}

	/**
	 * Method called by drawFloor, to draw the Stairs in the room if present
	 */
	private void drawStairs() throws SlickException {
		Stairs tmp = currentRoom.getRoom().getStairs();
		EntityImageFactory.getEntityTexture(Entities.STAIR).draw(tmp.getPosition().getX(), tmp.getPosition().getY(),
				GameSettings.TILESIZE, GameSettings.TILESIZE);
	}

	private void drawWalls() {
		for (int x = 0; x < GameSettings.WIDTH; x += GameSettings.TILESIZE) {
			for (int y = 0; y < GameSettings.HEIGHT; y += GameSettings.TILESIZE) {
				if (x == 0 && y > 0 && y < GameSettings.HEIGHT - GameSettings.TILESIZE) {
					currentRoom.getWallVert().getTexture().draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if (x == GameSettings.WIDTH - GameSettings.TILESIZE && y > 0
						&& y < GameSettings.HEIGHT - GameSettings.TILESIZE) {
					currentRoom.getWallVert().getTexture().getFlippedCopy(true, false).draw(x, y, GameSettings.TILESIZE,
							GameSettings.TILESIZE);
				} else if (y == 0 && x > 0 && x < GameSettings.WIDTH - GameSettings.TILESIZE) {
					currentRoom.getWallHor().getTexture().getFlippedCopy(false, true).draw(x, y, GameSettings.TILESIZE,
							GameSettings.TILESIZE);
				} else if (y == GameSettings.HEIGHT - GameSettings.TILESIZE && x > 0
						&& x < GameSettings.WIDTH - GameSettings.TILESIZE) {
					currentRoom.getWallHor().getTexture().draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
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

	private void drawDoors() {
		Map<Door, Optional<RoomModel>> doors = currentRoom.getDoorAccess();

		for (Entry<Door, Optional<RoomModel>> entry : doors.entrySet()) {
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
	 * Method called by drawDoors, to draw the right animation based on the Door
	 * cardinality, and if the room has been cleared
	 * 
	 * @param animation, the right animation based on the Door cardinality
	 * @param door,      the according Door Cardinality
	 */
	private void renderDoor(final AnimatedTile animation, Door door) {
		if (currentRoom.isGotRoomKey()) {
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

	private void drawDoorTop() throws SlickException {
		Map<Door, Optional<RoomModel>> doors = level.getLevel().get(level.getRoomID()).getDoorAccess();

		for (Entry<Door, Optional<RoomModel>> entry : doors.entrySet()) {
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
