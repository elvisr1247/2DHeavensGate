package gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;
//used to load all images at ounce
public class Assets {

	public static BufferedImage grass00,grass01,brick,tree,rupee,tree2;
	public static BufferedImage background;
	public static Font TimesNewRoman24,Ariel64,Ariel32;
	public static BufferedImage[] skeleton,player,attackPlayer;
	
	public static void init() {
		
		SpriteSheet skeletonSheet 
		= new SpriteSheet(ImageLoader.loadImage("/spritesheets/skeletonSheet.png"));
		
		SpriteSheet playerSheet 
		= new SpriteSheet(ImageLoader.loadImage("/spritesheets/player.png"));
		
		
		
		skeleton = new BufferedImage[2];
		skeleton[0] = skeletonSheet.crop(0, 0, 32, 32);
		
		player = new BufferedImage[2];
		
		player[0] = playerSheet.crop(0, 0, 64, 64);
		
	    attackPlayer = new BufferedImage[3];
	    attackPlayer[0] = playerSheet.crop(64, 0, 64, 64);
	    attackPlayer[1] = playerSheet.crop(64*2, 0, 64, 64);
	    attackPlayer[2] = playerSheet.crop(64*3, 0, 64, 64);
		//Font 
		Ariel64 = new Font("Arial",Font.PLAIN,64);
		Ariel32 = new Font("Arial",Font.PLAIN,16);
	    TimesNewRoman24 = new Font("TimesNewRoman",Font.PLAIN,24);
		//title screen
		background = ImageLoader.loadImage("/img/bluemoon.png");
		
		//tiles
		grass00 = ImageLoader.loadImage("/img/tiles/grass00.png");
		grass01 = ImageLoader.loadImage("/img/tiles/grass01.png");
		brick = ImageLoader.loadImage("/img/tiles/brick.png");
		tree = ImageLoader.loadImage("/img/tiles/tree2.png");
		rupee = ImageLoader.loadImage("/img/rupee.png");
		tree2 = ImageLoader.loadImage("/img/tree2.png");
	}
}
