package Test1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Room1 {

	private List<Image> textures;
	private Map<Image, List<Pair<Integer, Integer>>> room = new LinkedHashMap<>();
	
	private int cols;
	private int rows;
	private int tilesize;
	
	public Room1(final int rows, final int cols, final int tilesize) {
		this.cols = cols;
		this.rows = rows;
		this.tilesize = tilesize;
		this.setBackground();
		this.setItems();
	}

	public void newResolution(final int cols, final int rows, final int tilesize) {
		this.cols = cols;
		this.rows = rows;
		this.tilesize = tilesize;
		this.setBackground();
		this.setItems();
	}
	
	public void setBackground() {
		this.loadFloorWallTextures();
		this.setFloor();
		this.setWalls();	
	}
	private void setFloor() {
		List<Pair<Integer, Integer>> tmp = new ArrayList<>();	
		
		for(int i = 0; i < cols; i = i + tilesize) {
			for(int j = 0; j < rows; j = j + tilesize) {
				tmp.add(new Pair<>(j, i));
			}
		}
		room.put(textures.get(0), tmp);
	}
	
	private void setWalls() {
		List<Pair<Integer, Integer>> wallLeft = new ArrayList<>();	
		List<Pair<Integer, Integer>> wallRight = new ArrayList<>();	
		List<Pair<Integer, Integer>> wallUp = new ArrayList<>();	
		List<Pair<Integer, Integer>> wallDown = new ArrayList<>();	
		List<Pair<Integer, Integer>> topLeft = new ArrayList<>();
		List<Pair<Integer, Integer>> topRight = new ArrayList<>();
		List<Pair<Integer, Integer>> bottomLeft = new ArrayList<>();
		List<Pair<Integer, Integer>> bottomRight = new ArrayList<>();
		
		
		for(int i = 0; i < cols; i = i + tilesize) {
			for(int j = 0; j < rows; j = j + tilesize) {
				if(j == 0 && i < cols - tilesize && i > 0) {
					wallLeft.add(new Pair<>(j, i));
				} else if(j == rows - tilesize && i < cols - tilesize && i > 0) {
					wallRight.add(new Pair<>(j, i));
				} else if(i == 0 && j > 0 && j < rows - tilesize) {
					wallUp.add(new Pair<>(j,i));
				} else if(i == cols - tilesize && j > 0 && j < rows - tilesize) {
					wallDown.add(new Pair<>(j, i));
				} else if(i == cols - tilesize & j == 0) {
					bottomLeft.add(new Pair<>(j, i));
				} else if(i == cols - tilesize & j == rows - tilesize) {
					bottomRight.add(new Pair<>(j, i));
				} else if(i == 0 & j == 0) {
					topLeft.add(new Pair<>(j, i));
				} else if(i == 0 & j == rows - tilesize) {
					topRight.add(new Pair<>(j, i));
				}
			}
		}
		
		room.put(textures.get(1), wallLeft);
		room.put(textures.get(2), wallRight);
		room.put(textures.get(3), wallUp);
		room.put(textures.get(4), wallDown);
		
		room.put(textures.get(5), bottomLeft);
		room.put(textures.get(6), bottomRight);
		room.put(textures.get(7), topLeft);
		room.put(textures.get(8), topRight);
	}
	
	private void loadFloorWallTextures() {
		List<Image> tmp2 = new ArrayList<>();
		
		try {
			tmp2.add(new Image("./res/floor_1.png"));
			tmp2.add(new Image("./res/wall_inner_corner_mid_left.png"));
			tmp2.add(new Image("./res/wall_inner_corner_mid_rigth.png"));
			tmp2.add(new Image("./res/wall_inner_corner_mid_up.png"));
			tmp2.add(new Image("./res/wall_inner_corner_mid_down.png"));
			
			tmp2.add(new Image("./res/wall_inner_corner_mid_bottom_left.png"));
			tmp2.add(new Image("./res/wall_inner_corner_mid_bottom_right.png"));
			tmp2.add(new Image("./res/wall_inner_corner_mid_top_left.png"));
			tmp2.add(new Image("./res/wall_inner_corner_mid_top_right.png"));
	
		} catch(SlickException e) {
			Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, e);
		}
		
		textures = tmp2;
	}
	
	public void setItems() {
		List<Pair<Integer, Integer>> items = new ArrayList<>();	
		
		try {
			textures.add(new Image("./res/key.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		items.add(new Pair<>(tilesize * 5, tilesize * 6));
		
		room.put(textures.get(9), items);
	}
	
	
	public Map<Image, List<Pair<Integer, Integer>>> getRoom() {
		return room;
	}
	
	
	

	
}
