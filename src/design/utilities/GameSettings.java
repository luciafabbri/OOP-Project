package design.utilities;

public interface GameSettings {
	
	final static int WIDTH = 1280;
	final static int HEIGHT = 768;
	final static int TILESIZE = 64;
	final static int TOTALTILES = ((WIDTH-TILESIZE)*(HEIGHT-TILESIZE))/(TILESIZE*TILESIZE);
	
	final static int MINDOORS = 1;
	final static int MAXDOORS = 4;
	
	final static int LIMITRIGHT = WIDTH - TILESIZE;
	final static int LIMITLEFT = TILESIZE - 1;
	final static int LIMITUP = TILESIZE - 1;
	final static int LIMITDOWN = HEIGHT - TILESIZE;
	
	
}