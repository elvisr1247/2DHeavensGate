package gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;
//used to load all images at ounce
public class Assets {

	public static BufferedImage grass00,grass01,brick,treeTile,rupee,tree;
	public static BufferedImage Moonbackground,GateBackground;

	public static BufferedImage[] skeleton,player,attackPlayer;
	
	public static Font font64,font24,font16;
	public static BufferedImage[] button;
	
	public static void init() {
		
		//Font 
	    font64 = FontLoader.loadFont("res/fonts/HomeChristmas.otf", 64);
	    font24 = FontLoader.loadFont("res/fonts/HomeChristmas.otf", 24);
	    font16 = FontLoader.loadFont("res/fonts/HomeChristmas.otf", 16);
		
		SpriteSheet skeletonSheet 
		= new SpriteSheet(ImageLoader.loadImage("/spritesheets/skeletonSheet.png"));
		
		SpriteSheet playerSheet 
		= new SpriteSheet(ImageLoader.loadImage("/spritesheets/player.png"));
		
		SpriteSheet buttonSheet
		= new SpriteSheet(ImageLoader.loadImage("/img/sheet2.0.png"));
		
		button = new BufferedImage[2];
		button[0] = buttonSheet.crop(32*6, 32*4, 64, 32);
		button[1] = buttonSheet.crop(32*6, 32*5, 64, 32);
		
		
		skeleton = new BufferedImage[2];
		skeleton[0] = skeletonSheet.crop(0, 0, 32, 32);
		
		player = new BufferedImage[2];
		
		player[0] = playerSheet.crop(0, 0, 64, 64);
		
	    attackPlayer = new BufferedImage[3];
	    attackPlayer[0] = playerSheet.crop(64, 0, 64, 64);
	    attackPlayer[1] = playerSheet.crop(64*2, 0, 64, 64);
	    attackPlayer[2] = playerSheet.crop(64*3, 0, 64, 64);
		
		//title screen
	    Moonbackground= ImageLoader.loadImage("/img/bluemoon.png");
		GateBackground = ImageLoader.loadImage("/img/heaven-gate-wallpaper-preview.jpg");
		//tiles
		grass00 = ImageLoader.loadImage("/img/tiles/grass00.png");
		grass01 = ImageLoader.loadImage("/img/tiles/grass01.png");
		brick = ImageLoader.loadImage("/img/tiles/brick.png");
		treeTile = ImageLoader.loadImage("/img/tiles/tree2.png");
		rupee = ImageLoader.loadImage("/img/rupee.png");
		tree = buttonSheet.crop(0, 0, 32, 32*2);
	}
	
	
}
