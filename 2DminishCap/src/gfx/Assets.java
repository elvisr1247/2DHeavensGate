package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage grass00,grass01,brick,tree;
	public static BufferedImage background;
	
	public static void init() {
		//title screen
		background = ImageLoader.loadImage("/img/bluemoon.png");
		
		//tiles
		grass00 = ImageLoader.loadImage("/img/tiles/grass00.png");
		grass01 = ImageLoader.loadImage("/img/tiles/grass01.png");
		brick = ImageLoader.loadImage("/img/tiles/brick.png");
		tree = ImageLoader.loadImage("/img/tiles/tree2.png");
	}
}
