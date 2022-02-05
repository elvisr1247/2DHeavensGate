package gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;
//used to load all images at ounce
public class Assets {

	public static BufferedImage grass00,grass01,brick,tree,rupee;
	public static BufferedImage background;
	public static Font TimesNewRoman24,Ariel64,Ariel32;
	
	public static void init() {
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
	}
}
