package gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;
//used to load all images at ounce
public class Assets {

	public static BufferedImage grass00,grass01,water00,water01,water02,water03,water04,
	water05,water06,water07,water08,water09,water10,water11,water12,water13,brick,treeTile;

	public static BufferedImage Moonbackground,abc,axe,potion,sword,rupee,
	tree,grassSword,oldMan,fullHeart,halfHeart,emptyHeart,grass;

	public static BufferedImage[] playerUp,playerDown,playerLeft,playerRight;
	public static BufferedImage[] attackPlayerUp,attackPlayerDown,attackPlayerLeft,attackPlayerRight;
	public static BufferedImage[] skeleton,oldman,slime;
	
	
	public static Font font64,font24,font16;
	public static BufferedImage key;
	
	public static void init(){
		
		//Font 
	    font64 = FontLoader.loadFont("/fonts/HomeChristmas.otf", 64);
	    font24 = FontLoader.loadFont("/fonts/HomeChristmas.otf", 24);
	    font16 = FontLoader.loadFont("/fonts/HomeChristmas.otf", 16);
		
		SpriteSheet skeletonSheet 
		   = new SpriteSheet(ImageLoader.loadImage("/spritesheets/skeletonSheet.png"));
		
		SpriteSheet buttonSheet
		   = new SpriteSheet(ImageLoader.loadImage("/img/sheet2.0.png"));
		
		SpriteSheet blueBoy = 
				new SpriteSheet(ImageLoader.loadImage("/img/blueboy.png"));
		
		abc = blueBoy.crop(16, 16*41, 16, 16);
		
		playerUp = new BufferedImage[2];
		playerLeft = new BufferedImage[2];
		playerDown = new BufferedImage[2];
		playerRight = new BufferedImage[2];
		
		playerUp[0] = blueBoy.crop(0, 16*20, 16, 16);
		playerUp[1] = blueBoy.crop(16, 16*20, 16, 16);
		
		playerDown[0] = blueBoy.crop(0, 16*17, 16, 16);
		playerDown[1] = blueBoy.crop(16, 16*17, 16, 16);
		
		playerLeft[0] = blueBoy.crop(0, 16*18, 16, 16);
		playerLeft[1] = blueBoy.crop(16, 16*18, 16, 16);
		
		playerRight[0] = blueBoy.crop(0, 16*19, 16, 16);
		playerRight[1] = blueBoy.crop(16, 16*19, 16, 16);
		
//		attackPlayerUp = new BufferedImage[2];
//		attackPlayerDown = new BufferedImage[2];
//		attackPlayerLeft = new BufferedImage[2];
//		attackPlayerRight = new BufferedImage[2];
//		
//		attackPlayerUp[0] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_up_1.png");
//		attackPlayerUp[1] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_up_2.png");
//		
//		attackPlayerDown[0] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_down_1.png");
//		attackPlayerDown[1] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_down_2.png");
//		
//		attackPlayerLeft[0] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_left_1.png");
//		attackPlayerLeft[1] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_left_2.png");
//		
//		attackPlayerRight[0] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_Right_1.png");
//		attackPlayerRight[1] = ImageLoader.loadImage("/spritesheets/playersheet/boy_axe_Right_2.png");
		
		skeleton = new BufferedImage[2];
		skeleton[0] = skeletonSheet.crop(0, 0, 32, 32);
		
		slime = new BufferedImage[2];
		slime[0] = blueBoy.crop(16, 16*23, 16, 16);
		slime[1] = blueBoy.crop(0, 16*24, 16, 16);
	 
		
		//title screen
	    Moonbackground= ImageLoader.loadImage("/img/bluemoon.png");
		//tiles
		grass00 = blueBoy.crop(16, 16*22, 16, 16);
		grass01 = blueBoy.crop(0, 16*23, 16, 16);
		water00 = blueBoy.crop(0, 16*39, 16, 16);
		water01 = blueBoy.crop(16, 16*39, 16, 16);
		water02 = blueBoy.crop(0, 16*40, 16, 16);
		water03 = blueBoy.crop(16, 16*40, 16, 16);
		water04 = blueBoy.crop(0, 16*41, 16, 16);
		water05 = blueBoy.crop(16, 16*41, 16, 16);
		water06 = blueBoy.crop(0, 16*42, 16, 16);
		water07 = blueBoy.crop(16, 16*42, 16, 16);
		water08 = blueBoy.crop(0, 16*43, 16, 16);
		water09 = blueBoy.crop(16, 16*43, 16, 16);
		water10 = blueBoy.crop(0, 16*44, 16, 16);
		water11 = blueBoy.crop(16, 16*44, 16, 16);
		water12 = blueBoy.crop(0, 16*45, 16, 16);
		water13 = blueBoy.crop(16, 16*45, 16, 16);
		brick = blueBoy.crop(16, 16*38, 16, 16);
		treeTile = blueBoy.crop(0, 16*38, 16, 16);
		rupee = ImageLoader.loadImage("/img/rupees.png");
		key = blueBoy.crop(0, 16*26, 16, 16);
		tree = buttonSheet.crop(0, 0, 32, 32*2);
		grassSword = ImageLoader.loadImage("/img/grassSword.png");
		axe = blueBoy.crop(0, 0, 16, 16);
		potion = blueBoy.crop(16, 16*30, 16, 16);
		sword = blueBoy.crop(16, 16*37, 16, 16);
		oldMan = blueBoy.crop(16, 16*26, 16, 16);
		
		fullHeart = blueBoy.crop(0, 16*25, 16, 16);
		halfHeart = blueBoy.crop(16, 16*25, 16, 16);
		emptyHeart = blueBoy.crop(16, 16*24, 16, 16);
		
		grass = ImageLoader.loadImage("/img/grass_tile.png");
	}
	
	
}
