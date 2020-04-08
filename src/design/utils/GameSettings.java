package design.utils;

public interface GameSettings {
	
	final static int WIDTH = 1280;
	final static int HEIGHT = 768;
	final static int TILESIZE = 64;
	final static int TOTALTILES = ((WIDTH-TILESIZE)*(HEIGHT-TILESIZE))/(TILESIZE*TILESIZE);
	
	final static int MINDOORS = 1;
	final static int MAXDOORS = 4;
	
	
}